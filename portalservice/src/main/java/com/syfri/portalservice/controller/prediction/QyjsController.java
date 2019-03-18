package com.syfri.portalservice.controller.prediction;

import com.syfri.baseapi.model.ResultVO;
import com.syfri.baseapi.utils.EConstants;
import com.syfri.portalservice.config.properties.CpjsProperties;
import com.syfri.portalservice.controller.base.BaseController;
import com.syfri.portalservice.model.prediction.QyjsVO;
import com.syfri.portalservice.service.prediction.QyjsService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("qyjs")
public class QyjsController extends BaseController<QyjsVO> {

    @Autowired
    private QyjsService qyjsService;

    @Override
    public QyjsService getBaseService() {
        return this.qyjsService;
    }

    @Autowired
    private CpjsProperties cpjsProperties;

}
