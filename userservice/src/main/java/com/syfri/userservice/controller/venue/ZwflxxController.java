package com.syfri.userservice.controller.venue;

import com.syfri.baseapi.model.ResultVO;
import com.syfri.baseapi.utils.EConstants;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import com.syfri.userservice.model.venue.ZwflxxVO;
import com.syfri.userservice.service.venue.ZwflxxService;
import com.syfri.baseapi.controller.BaseController;

import java.util.List;

@RestController
@RequestMapping("zwflxx")
public class ZwflxxController extends BaseController<ZwflxxVO> {

    @Autowired
    private ZwflxxService zwflxxService;

    @Override
    public ZwflxxService getBaseService() {
        return this.zwflxxService;
    }

    /**
     * 分类信息新增
     * add by rliu 2019.1.14
     */
    @ApiOperation(value = "新增", notes = "新增")
    @PostMapping("/insertByVO")
    public @ResponseBody
    ResultVO insertByVO(@RequestBody ZwflxxVO zwflxxVO) {
        ResultVO resultVO = ResultVO.build();
        try {
            resultVO.setResult(zwflxxService.doInsertByVO(zwflxxVO));
        } catch (Exception e) {
            logger.error("{}", e.getMessage());
            resultVO.setCode(EConstants.CODE.FAILURE);
        }
        return resultVO;
    }

    /**
     * 分类信息编辑
     * add by rliu 2019.1.14
     */
    @ApiOperation(value = "编辑", notes = "编辑")
    @PostMapping("/updateByVO")
    public @ResponseBody
    ResultVO updateByVO(@RequestBody ZwflxxVO zwflxxVO) {
        ResultVO resultVO = ResultVO.build();
        try {
            resultVO.setResult(zwflxxService.doUpdateByVO(zwflxxVO));
        } catch (Exception e) {
            logger.error("{}", e.getMessage());
            resultVO.setCode(EConstants.CODE.FAILURE);
        }
        return resultVO;
    }

    @ApiOperation(value = "根据id更新基本信息", notes = "删除")
    @PostMapping("/doDeleteByVolist")
    public @ResponseBody
    ResultVO doDeleteByVolist(@RequestBody List<ZwflxxVO> voList) {
        ResultVO resultVO = ResultVO.build();
        try {
            resultVO.setResult(zwflxxService.doDeleteZwflxx(voList));
        } catch (Exception e) {
            logger.error("{}", e.getMessage());
            resultVO.setCode(EConstants.CODE.FAILURE);
        }
        return resultVO;
    }

}
