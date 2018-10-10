package com.syfri.exhibition.controller.prediction;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.syfri.baseapi.model.ResultVO;
import com.syfri.baseapi.utils.EConstants;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import com.syfri.exhibition.model.prediction.QyzwyxVO;
import com.syfri.exhibition.service.prediction.QyzwyxService;
import com.syfri.baseapi.controller.BaseController;

import java.util.List;

@RestController
@RequestMapping("qyzwyx")
public class QyzwyxController  extends BaseController<QyzwyxVO>{

	@Autowired
	private QyzwyxService qyzwyxService;

	@Override
	public QyzwyxService getBaseService() {
		return this.qyzwyxService;
	}

    /*
     * @Description:统计分析图表数据
     * @Param:
     * @Return:
     * @Author: zhaijianchen
     * @Modified By:
     * @Date: 2018/10/9 13:38
     */

	@ApiOperation(value="统计分析图表数据",notes="统计分析图表数据")
	@ApiImplicitParam(name="vo",value="统计分析图表数据")
	@PostMapping("/dofindtjfx")
	public @ResponseBody ResultVO dofindtjfx(@RequestBody QyzwyxVO qyzwyxVO){
		ResultVO resultVO = ResultVO.build();
		try{
			resultVO.setResult(qyzwyxService.dofindtjfx(qyzwyxVO));
		}catch(Exception e){
			logger.error("{}",e.getMessage());
			resultVO.setCode(EConstants.CODE.FAILURE);
		}
		return resultVO;
	}

	/*
	 * @Description:
	 * @Param:
	 * @Return:
	 * @Author: zhaijianchen
	 * @Modified By:
	 * @Date: 2018/10/10 14:31
	 */
	@ApiOperation(value="统计分析图表数据",notes="统计分析图表数据")
	@ApiImplicitParam(name="vo",value="统计分析图表数据")
	@PostMapping("/dofindtjfxsj")
	public @ResponseBody ResultVO dofindtjfxsj(@RequestBody QyzwyxVO qyzwyxVO){
		ResultVO resultVO = ResultVO.build();
		try{
			resultVO.setResult(qyzwyxService.dofindtjfxsj(qyzwyxVO));
		}catch(Exception e){
			logger.error("{}",e.getMessage());
			resultVO.setCode(EConstants.CODE.FAILURE);
		}
		return resultVO;
	}



}
