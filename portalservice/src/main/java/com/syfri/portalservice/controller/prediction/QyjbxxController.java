package com.syfri.portalservice.controller.prediction;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.syfri.baseapi.model.ResultVO;
import com.syfri.baseapi.utils.EConstants;
import com.syfri.portalservice.config.properties.CpjsProperties;
import com.syfri.portalservice.controller.base.BaseController;
import com.syfri.portalservice.model.prediction.QyjbjsVO;
import com.syfri.portalservice.model.prediction.QyjbxxVO;
import com.syfri.portalservice.service.prediction.QyjbxxService;
import com.syfri.portalservice.utils.StringUtil;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.poi.hssf.record.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("qyjbxx")
public class QyjbxxController extends BaseController<QyjbxxVO> {

    @Autowired
    private QyjbxxService qyjbxxService;

    @Override
    public QyjbxxService getBaseService() {
        return this.qyjbxxService;
    }

    @Autowired
    private CpjsProperties cpjsProperties;

    @GetMapping(value="listQyjbjsVO",produces="text/html;charset=UTF-8")
    public @ResponseBody String listQyjbjsVO(QyjbjsVO vo , String callback) {
        ResultVO resultVO = ResultVO.build();
        try {
            resultVO.setResult(qyjbxxService.doSearchListQyjbjsByVO(vo));
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("{}",e.getMessage());
        }
        return StringUtil.callbackString(callback,resultVO);
    }
    @GetMapping(value="pageQyjbjsVO",produces="text/html;charset=UTF-8")
    public @ResponseBody String pageQyjbjsVO( QyjbjsVO vo , String callback) {
        ResultVO resultVO = ResultVO.build();
        try {
            PageHelper.startPage(vo.getPageNum(), vo.getPageSize());
            List<QyjbjsVO> list = qyjbxxService.doSearchListQyjbjsByVO(vo);
            PageInfo<QyjbjsVO> page = new PageInfo<QyjbjsVO>(list);
            resultVO.setResult(page);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("{}",e.getMessage());
        }
        return StringUtil.callbackString(callback,resultVO);
    }
    @GetMapping(value="findQyjbjsVO",produces="text/html;charset=UTF-8")
    public @ResponseBody String findQyjbjsVO( QyjbjsVO vo , String callback) {
        ResultVO resultVO = ResultVO.build();
        try {
            QyjbjsVO v = qyjbxxService.doFindQyjbjsByVO(vo);
            resultVO.setResult(v);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("{}",e.getMessage());
        }
        return StringUtil.callbackString(callback,resultVO);
    }



    /**
     * @Description: 根据用户信息、公司名称获取企业基本信息
     * @Author: li.xue
     * @Date: 2018/10/9 11:05
     */
    @ApiOperation(value = "根据企业查询企业信息", notes = "列表")
    @ApiImplicitParam(name = "vo", value = "企业对象")
    @PostMapping("/doFindZsxxByQyjbxx")
    public @ResponseBody
    ResultVO doFindZsxxByQyjbxx(@RequestBody QyjbxxVO qyjbxxVO) {
        ResultVO resultVO = ResultVO.build();
        try {
            PageHelper.startPage(qyjbxxVO.getPageNum(), qyjbxxVO.getPageSize());
            List<QyjbxxVO> list = qyjbxxService.doFindZsxxByQyjbxx(qyjbxxVO);
            PageInfo<QyjbxxVO> pageInfo = new PageInfo<>(list);
            resultVO.setResult(pageInfo);
        } catch (Exception e) {
            logger.error("{}", e.getMessage());
            resultVO.setCode(EConstants.CODE.FAILURE);
        }
        return resultVO;
    }

}
