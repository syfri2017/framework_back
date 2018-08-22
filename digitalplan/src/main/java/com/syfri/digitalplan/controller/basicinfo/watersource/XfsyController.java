package com.syfri.digitalplan.controller.basicinfo.watersource;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.syfri.baseapi.model.ResultVO;
import com.syfri.baseapi.utils.EConstants;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.syfri.digitalplan.model.basicinfo.watersource.XfsyVO;
import com.syfri.digitalplan.service.basicinfo.watersource.XfsyService;
import com.syfri.baseapi.controller.BaseController;

import java.util.List;

@RestController
@RequestMapping("xfsy")
public class XfsyController  extends BaseController<XfsyVO>{

	@Autowired
	private XfsyService xfsyService;

	@Override
	public XfsyService getBaseService() {
		return this.xfsyService;
	}

	/**
	 * 获取水源信息及水源类型属性信息
	 * by yushch 20180418
	 */
	@ApiOperation(value="通过id获取水源信息及水源类型属性信息",notes="查询一条信息")
	@ApiImplicitParam(name="vo",value="水源对象")
	@PostMapping("/findSyAndSxByVo")
	public @ResponseBody ResultVO findById(@RequestBody XfsyVO xfsyVO){
		ResultVO resultVO = ResultVO.build();
		try{
			resultVO.setResult(xfsyService.doFindSyAndSxByVo(xfsyVO));
		}catch(Exception e){
			logger.error("{}",e.getMessage());
			resultVO.setCode(EConstants.CODE.FAILURE);
		}
		return resultVO;
	}

	/**
	 * 获取水源列表 关联不同从表
	 * by lixue 20180625
	 */
	@ApiOperation(value="查询列表",notes="列表信息")
	@ApiImplicitParam(name="vo",value = "水源对象")
	@PostMapping("findlistPage")
	public @ResponseBody ResultVO listPage(@RequestBody XfsyVO xfsyVO) {
		ResultVO resultVO = ResultVO.build();
		try {
			PageHelper.startPage(xfsyVO.getPageNum(),xfsyVO.getPageSize());
			List<XfsyVO> list = xfsyService.doFindListByVO(xfsyVO);
			PageInfo<XfsyVO> pageInfo = new PageInfo<>(list);
			resultVO.setResult(pageInfo);
		} catch (Exception e) {
			logger.error("{}",e.getMessage());
		}
		return resultVO;
	}

	/**
	 * 获取水源列表 关联不同从表
	 * by yushch 20180419
	 */
	@ApiOperation(value="查询列表",notes="列表信息")
	@ApiImplicitParam(name="vo",value = "水源对象")
	@PostMapping("findlist")
	public @ResponseBody ResultVO list(@RequestBody XfsyVO xfsyVO) {
		ResultVO resultVO = ResultVO.build();
		try {
			List<XfsyVO> list = xfsyService.doFindListByVO(xfsyVO);
			resultVO.setResult(list);
		} catch (Exception e) {
			logger.error("{}",e.getMessage());
		}
		return resultVO;
	}

	/**
	 * 新增水源
	 * by yushch 20180802
	 */
	@ApiOperation(value = "通过vo新增水源", notes = "查询一条信息")
	@ApiImplicitParam(name = "vo", value = "水源对象")
	@RequiresPermissions("basicinfo/firewater:add")
	@PostMapping("/insertByXfsyVO")
	public @ResponseBody ResultVO insertByXfsyVO(@RequestBody XfsyVO xfsyVO) {
		ResultVO resultVO = ResultVO.build();
		try {
			resultVO.setResult(xfsyService.doInsertByXfdzVO(xfsyVO));
		} catch (Exception e) {
			logger.error("{}", e.getMessage());
			resultVO.setCode(EConstants.CODE.FAILURE);
		}
		return resultVO;
	}

	/**
	 * 水源修改
	 * by yushch 20180803
	 */
	@ApiOperation(value = "通过vo修改队站", notes = "查询一条信息")
	@ApiImplicitParam(name = "vo", value = "水源对象")
	@RequiresPermissions("basicinfo/firewater:edit")
	@PostMapping("/updateByXfsyVO")
	public @ResponseBody ResultVO updateByXfsyVO(@RequestBody XfsyVO xfsyVO) {
		ResultVO resultVO = ResultVO.build();
		try {
			resultVO.setResult(xfsyService.doUpdateByXfsyVO(xfsyVO));
		} catch (Exception e) {
			logger.error("{}", e.getMessage());
			resultVO.setCode(EConstants.CODE.FAILURE);
		}
		return resultVO;
	}

	//批量删除 yushch 20180803
	@ApiOperation(value = "通过队站vo获取队站详细信息", notes = "查询一条信息")
	@ApiImplicitParam(name = "vo", value = "队站对象")
	@RequiresPermissions("basicinfo/firewater:delete")
	@PostMapping("/doDeleteBatch")
	public @ResponseBody ResultVO doDeleteBatch(@RequestBody List<XfsyVO> list) {
		ResultVO resultVO = ResultVO.build();
		try {
			resultVO.setResult(xfsyService.doDeleteBatch(list));
		} catch (Exception e) {
			logger.error("{}", e.getMessage());
			resultVO.setCode(EConstants.CODE.FAILURE);
		}
		return resultVO;
	}

	/**
	 * 获取天然水源列表
	 * by liurui 20180816
	 */
	@ApiOperation(value="查询列表",notes="列表信息")
	@ApiImplicitParam(name="vo",value = "水源对象")
	@PostMapping("doFindTrsyListByVO")
	public @ResponseBody ResultVO doFindTrsyListByVO(@RequestBody XfsyVO xfsyVO) {
		ResultVO resultVO = ResultVO.build();
		try {
			PageHelper.startPage(xfsyVO.getPageNum(),xfsyVO.getPageSize());
			List<XfsyVO> list = xfsyService.doFindTrsyListByVO(xfsyVO);
			PageInfo<XfsyVO> pageInfo = new PageInfo<>(list);
			resultVO.setResult(pageInfo);
		} catch (Exception e) {
			logger.error("{}",e.getMessage());
		}
		return resultVO;
	}

	/**
	 * 天然水源新增
	 * by liurui 20180822
	 */
	@ApiOperation(value = "通过vo新增天然水源", notes = "查询一条信息")
	@ApiImplicitParam(name = "vo", value = "水源对象")
	@RequiresPermissions("basicinfo/firewater:add")
	@PostMapping("/insertTrsyByXfsyVO")
	public @ResponseBody ResultVO insertTrsyByXfsyVO(@RequestBody XfsyVO xfsyVO) {
		ResultVO resultVO = ResultVO.build();
		try {
			resultVO.setResult(xfsyService.insertTrsyByXfsyVO(xfsyVO));
		} catch (Exception e) {
			logger.error("{}", e.getMessage());
			resultVO.setCode(EConstants.CODE.FAILURE);
		}
		return resultVO;
	}

	/**
	 * 天然水源修改
	 * by liurui 20180822
	 */
	@ApiOperation(value = "通过vo修改天然水源", notes = "查询一条信息")
	@ApiImplicitParam(name = "vo", value = "天然水源对象")
	@RequiresPermissions("basicinfo/firewater:edit")
	@PostMapping("/doUpdateTrsyByVO")
	public @ResponseBody ResultVO doUpdateTrsyByVO(@RequestBody XfsyVO xfsyVO) {
		ResultVO resultVO = ResultVO.build();
		try {
			resultVO.setResult(xfsyService.doUpdateTrsyByVO(xfsyVO));
		} catch (Exception e) {
			logger.error("{}", e.getMessage());
			resultVO.setCode(EConstants.CODE.FAILURE);
		}
		return resultVO;
	}

	@ApiOperation(value = "根据UUID查询天然水源", notes = "查询一条记录")
	@ApiImplicitParam(name = "id", value = "业务ID", dataType = "String", paramType = "path")
	@PostMapping("/doFindTrsyByUUId")
	public @ResponseBody ResultVO doFindTrsyByUUId(@RequestBody XfsyVO xfsyVO){
		ResultVO resultVO = ResultVO.build();
		try{
			resultVO.setResult(xfsyService.doFindTrsyByUUId(xfsyVO));
		}catch(Exception e){
			logger.error("{}",e.getMessage());
		}
		return resultVO;
	}

	@ApiOperation(value = "天然水源删除", notes = "")
	@ApiImplicitParam(name = "vo", value = "队站对象")
	@RequiresPermissions("basicinfo/firewater:delete")
	@RequestMapping("/doDeleteTrsyByUUId")
	public @ResponseBody ResultVO doDeleteTrsyByUUId(@RequestBody List<XfsyVO> list) {
		ResultVO resultVO = ResultVO.build();
		try {
			resultVO.setResult(xfsyService.doDeleteTrsyByUUId(list));
		} catch (Exception e) {
			logger.error("{}", e.getMessage());
			resultVO.setCode(EConstants.CODE.FAILURE);
		}
		return resultVO;
	}

}
