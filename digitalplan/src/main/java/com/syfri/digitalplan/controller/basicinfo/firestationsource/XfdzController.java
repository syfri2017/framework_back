package com.syfri.digitalplan.controller.basicinfo.firestationsource;

import com.syfri.baseapi.model.ResultVO;
import com.syfri.baseapi.utils.EConstants;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import com.syfri.digitalplan.model.basicinfo.firestationsource.XfdzVO;
import com.syfri.digitalplan.service.basicinfo.firestationsource.XfdzService;
import com.syfri.baseapi.controller.BaseController;

import java.util.List;

@RestController
@RequestMapping("xfdz")
public class XfdzController extends BaseController<XfdzVO> {

    @Autowired
    private XfdzService xfdzService;

    @Override
    public XfdzService getBaseService() {
        return this.xfdzService;
    }

    /**
     * 通过队站vo获取队站详细信息
     * by yushch 20180531
     */
    @ApiOperation(value = "通过队站vo获取队站详细信息", notes = "查询一条信息")
    @ApiImplicitParam(name = "vo", value = "队站对象")
    @PostMapping("/findDzDetailByVo")
    public @ResponseBody ResultVO findById(@RequestBody XfdzVO xfdzVO) {
        ResultVO resultVO = ResultVO.build();
        try {
            resultVO.setResult(xfdzService.doFindDzDetailByVo(xfdzVO));
        } catch (Exception e) {
            logger.error("{}", e.getMessage());
            resultVO.setCode(EConstants.CODE.FAILURE);
        }
        return resultVO;
    }

    /***
     * @Description: 查询行政区划所在省的所有队站
     * @Param: [xfdzVO]
     * @Return: com.syfri.baseapi.model.ResultVO
     * @Author: liurui
     * @Modified By:
     * @Date: 2018/6/7 16:23
     */
    @ApiOperation(value = "查询行政区划所在省的所有队站", notes = "查询list")
    @ApiImplicitParam(name = "vo", value = "队站对象")
    @RequestMapping("/doSearchProvinceList")
    public @ResponseBody
    ResultVO doSearchProvinceList(@RequestBody XfdzVO xfdzVO) {
        ResultVO resultVO = ResultVO.build();
        try {
            resultVO.setResult(xfdzService.doSearchProvinceList(xfdzVO));
        } catch (Exception e) {
            logger.error("{}", e.getMessage());
            resultVO.setCode(EConstants.CODE.FAILURE);
        }
        return resultVO;
    }

    /**
     * 通过登录用户获取队站树
     * by li.xue 20180725
     */
    @ApiOperation(value = "通过队站vo获取队站详细信息", notes = "查询一条信息")
    @ApiImplicitParam(name = "vo", value = "队站对象")
    @PostMapping("/findSjdzByUser")
    public @ResponseBody ResultVO findSjdzByUser(@RequestBody XfdzVO xfdzVO) {
        ResultVO resultVO = ResultVO.build();
        try {
            resultVO.setResult(xfdzService.doFindDzTreeByUser(xfdzVO));
        } catch (Exception e) {
            logger.error("{}", e.getMessage());
            resultVO.setCode(EConstants.CODE.FAILURE);
        }
        return resultVO;
    }

    @ApiOperation(value="判断队站名称是否已存在",notes="列表信息")
    @ApiImplicitParam(name="vo",value="消防队站")
    @GetMapping("/doCheckName/{dzmc}")
    public @ResponseBody ResultVO doCheckName(@PathVariable String dzmc) {
        ResultVO resultVO = ResultVO.build();
        try{
            resultVO.setResult(xfdzService.doCheckName(dzmc));
        }catch(Exception e){
            logger.error("{}",e.getMessage());
            resultVO.setCode(EConstants.CODE.FAILURE);
        }
        return resultVO;
    }

    /**
     * 新增队站
     * by li.xue 20180725
     */
    @ApiOperation(value = "通过队站vo获取队站详细信息", notes = "查询一条信息")
    @ApiImplicitParam(name = "vo", value = "队站对象")
    @PostMapping("/insertByXfdzVO")
    public @ResponseBody ResultVO insertByXfdzVO(@RequestBody XfdzVO xfdzVO) {
        ResultVO resultVO = ResultVO.build();
        try {
            resultVO.setResult(xfdzService.doInsertByXfdzVO(xfdzVO));
        } catch (Exception e) {
            logger.error("{}", e.getMessage());
            resultVO.setCode(EConstants.CODE.FAILURE);
        }
        return resultVO;
    }

    /**
     * 修改队站
     * by li.xue 20180725
     */
    @ApiOperation(value = "通过队站vo获取队站详细信息", notes = "查询一条信息")
    @ApiImplicitParam(name = "vo", value = "队站对象")
    @PostMapping("/updateByXfdzVO")
    public @ResponseBody ResultVO updateByXfdzVO(@RequestBody XfdzVO xfdzVO) {
        ResultVO resultVO = ResultVO.build();
        try {
            resultVO.setResult(xfdzService.doUpdateByXfdzVO(xfdzVO));
        } catch (Exception e) {
            logger.error("{}", e.getMessage());
            resultVO.setCode(EConstants.CODE.FAILURE);
        }
        return resultVO;
    }

    /**
     * 批量删除队站
     * by li.xue 20180725
     */
    @ApiOperation(value = "通过队站vo获取队站详细信息", notes = "查询一条信息")
    @ApiImplicitParam(name = "vo", value = "队站对象")
    @PostMapping("/doDeleteBatch")
    public @ResponseBody ResultVO doDeleteBatch(@RequestBody List<XfdzVO> list) {
        ResultVO resultVO = ResultVO.build();
        try {
            resultVO.setResult(xfdzService.doDeleteBatch(list));
        } catch (Exception e) {
            logger.error("{}", e.getMessage());
            resultVO.setCode(EConstants.CODE.FAILURE);
        }
        return resultVO;
    }
}
