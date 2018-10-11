package com.syfri.exhibition.controller.prediction;

import com.syfri.baseapi.model.ResultVO;
import com.syfri.baseapi.utils.EConstants;
import com.syfri.exhibition.utils.Base64ImageUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import com.syfri.exhibition.model.prediction.QycpjsVO;
import com.syfri.exhibition.service.prediction.QycpjsService;
import com.syfri.baseapi.controller.BaseController;

import java.util.List;

@RestController
@RequestMapping("qycpjs")
public class QycpjsController extends BaseController<QycpjsVO> {

    @Autowired
    private QycpjsService qycpjsService;

    @Override
    public QycpjsService getBaseService() {
        return this.qycpjsService;
    }

    /**
     * @Description: 根据企业id获取产品信息
     * @Author: rliu
     * @Date: 2018/10/9 10:35
     */
    @ApiOperation(value = "根据企业id获取产品信息", notes = "vo")
    @RequestMapping("/doFindCpxxById")
    public @ResponseBody ResultVO doFindCpxxById(@RequestBody QycpjsVO qycpjsVO) {
        ResultVO resultVO = ResultVO.build();
        try {
            List<QycpjsVO> result = qycpjsService.doSearchListByVO(qycpjsVO);
            for(QycpjsVO vo:result) {
                //将二进制转为Base64格式字符串
                String photo64 = Base64ImageUtil.byteArr2String(vo.getCptp());
                vo.setCptpBase64(photo64);
            }
            resultVO.setResult(result);
        } catch (Exception e) {
            logger.error("{}", e.getMessage());
            resultVO.setCode(EConstants.CODE.FAILURE);
        }
        return resultVO;
    }

}
