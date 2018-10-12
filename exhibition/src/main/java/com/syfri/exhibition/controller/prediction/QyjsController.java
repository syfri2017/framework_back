package com.syfri.exhibition.controller.prediction;

import com.syfri.baseapi.model.ResultVO;
import com.syfri.baseapi.utils.EConstants;
import com.syfri.exhibition.utils.Base64ImageUtil;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import com.syfri.exhibition.model.prediction.QyjsVO;
import com.syfri.exhibition.service.prediction.QyjsService;
import com.syfri.baseapi.controller.BaseController;

@RestController
@RequestMapping("qyjs")
public class QyjsController extends BaseController<QyjsVO> {

    @Autowired
    private QyjsService qyjsService;

    @Override
    public QyjsService getBaseService() {
        return this.qyjsService;
    }

    /**
     * @Description: 根据企业id获取产品信息
     * @Author: rliu
     * @Date: 2018/10/9 10:35
     */
    @ApiOperation(value = "根据企业id获取产品信息", notes = "vo")
    @RequestMapping("/doFindQyjsById/{qyid}")
    public @ResponseBody ResultVO doFindQyjsById(@PathVariable String qyid) {
        ResultVO resultVO = ResultVO.build();
        try {
            QyjsVO result = qyjsService.doFindById(qyid);
            if (result != null) {
                //将二进制转为Base64格式字符串
                String photo64 = Base64ImageUtil.byteArr2String(result.getLogo());
                result.setLogoBase64(photo64);
            }
            resultVO.setResult(result);
        } catch (Exception e) {
            logger.error("{}", e.getMessage());
            resultVO.setCode(EConstants.CODE.FAILURE);
        }
        return resultVO;
    }

    //add by yushch 20181011
    @ApiOperation(value="根据VO保存",notes="保存")
    @PostMapping("/doInsertByVo")
    public @ResponseBody ResultVO save(@RequestBody QyjsVO vo) throws Exception{
        ResultVO resultVO = ResultVO.build();
        try {
            resultVO.setResult(qyjsService.doInsertQyAndCpByVO(vo));
        } catch (Exception e) {
            logger.error("{}",e.getMessage());
            resultVO.setCode(EConstants.CODE.FAILURE);
        }

        return 	resultVO;
    }

    @ApiOperation(value="根据VO更新",notes="更新")
    @ApiImplicitParam(name="vo",value = "九小场所")
    @PostMapping("/doUpdateQyCpByVO")
    public @ResponseBody ResultVO doUpdateQyCpByVO(@RequestBody QyjsVO vo) throws Exception{
        ResultVO resultVO = ResultVO.build();
        try {
            resultVO.setResult(qyjsService.doUpdateQyCpByVO(vo));
        } catch (Exception e) {
            logger.error("{}",e.getMessage());
            resultVO.setCode(EConstants.CODE.FAILURE);
        }
        return 	resultVO;
    }
}
