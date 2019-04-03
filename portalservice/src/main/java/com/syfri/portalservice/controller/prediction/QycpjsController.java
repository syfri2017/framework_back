package com.syfri.portalservice.controller.prediction;

import com.syfri.baseapi.model.ResultVO;
import com.syfri.portalservice.config.properties.CpjsProperties;
import com.syfri.portalservice.controller.base.BaseController;
import com.syfri.portalservice.model.prediction.QycpjsVO;
import com.syfri.portalservice.model.venue.ZwjbxxVO;
import com.syfri.portalservice.service.prediction.QycpjsService;
import com.syfri.portalservice.service.venue.ZwjbxxService;
import com.syfri.portalservice.utils.StringUtil;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("qycpjs")
public class QycpjsController extends BaseController<QycpjsVO> {

    @Autowired
    private QycpjsService qycpjsService;
    @Autowired
    private ZwjbxxService zwjbxxService;

    @Override
    public QycpjsService getBaseService() {
        return this.qycpjsService;
    }

    @Autowired
    private CpjsProperties cpjsProperties;


    @GetMapping(value="doFindById",produces="text/html;charset=UTF-8")
    public @ResponseBody
    String doFindById(String uuid, String callback){
        ResultVO resultVO = ResultVO.build();
        try{
            QycpjsVO v=qycpjsService.doFindById(uuid);
            if(v.getQyid()!=null&&!v.getQyid().isEmpty()){
                ZwjbxxVO zwvo=new ZwjbxxVO();
                zwvo.setQyid(v.getQyid());
                List<ZwjbxxVO> dvo=zwjbxxService.doSearchListByVO(zwvo);
                v.setZwjbxxVOs(dvo);
            }
            resultVO.setResult(v);
        }catch(Exception e){
            logger.error("{}",e.getMessage());
        }
        return StringUtil.callbackString(callback,resultVO);
    }

}
