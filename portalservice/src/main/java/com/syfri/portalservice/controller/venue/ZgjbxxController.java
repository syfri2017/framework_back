package com.syfri.portalservice.controller.venue;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.syfri.baseapi.model.ResultVO;
import com.syfri.portalservice.controller.base.BaseController;
import com.syfri.portalservice.model.venue.ZgjbxxVO;
import com.syfri.portalservice.service.venue.ZgjbxxService;
import com.syfri.portalservice.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Description:
 * @Author: lixiaoyang
 * @Modified By:
 * @Date: 2019/3/21 14:27
 */
public class ZgjbxxController extends BaseController<ZgjbxxVO> {
    @Autowired
    private ZgjbxxService zgjbxxService;

    @Override
    public ZgjbxxService getBaseService() {
        return this.zgjbxxService;
    }
    @GetMapping(value="listZgjbxxVO",produces="text/html;charset=UTF-8")
    public @ResponseBody
    String listZgjbxxVO(ZgjbxxVO vo , String callback) {
        ResultVO resultVO = ResultVO.build();
        try {
            resultVO.setResult(zgjbxxService.doSearchListByVO(vo));
        } catch (Exception e) {
            logger.error("{}",e.getMessage());
        }
        return StringUtil.callbackString(callback,resultVO);
    }
    @GetMapping(value="pageZgjbxxVO",produces="text/html;charset=UTF-8")
    public @ResponseBody String pageZgjbxxVO( ZgjbxxVO vo , String callback) {
        ResultVO resultVO = ResultVO.build();
        try {
            PageHelper.startPage(vo.getPageNum(), vo.getPageSize());
            List<ZgjbxxVO> list = zgjbxxService.doSearchListByVO(vo);
            PageInfo<ZgjbxxVO> page = new PageInfo<ZgjbxxVO>(list);
            resultVO.setResult(page);
        } catch (Exception e) {
            logger.error("{}",e.getMessage());
        }
        return StringUtil.callbackString(callback,resultVO);
    }
}
