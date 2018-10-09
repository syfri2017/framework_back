package com.syfri.exhibition.controller.prediction;

import com.syfri.baseapi.model.ResultVO;
import com.syfri.baseapi.utils.EConstants;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import com.syfri.exhibition.utils.Base64ImageUtil;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import com.syfri.exhibition.model.prediction.QyjbxxVO;
import com.syfri.exhibition.service.prediction.QyjbxxService;
import com.syfri.baseapi.controller.BaseController;

@RestController
@RequestMapping("qyjbxx")
public class QyjbxxController  extends BaseController<QyjbxxVO>{

	@Autowired
	private QyjbxxService qyjbxxService;

	@Override
	public QyjbxxService getBaseService() {
		return this.qyjbxxService;
	}

	/**
	 * @Description: 根据企业id获取营业执照
	 * @Author: rliu
	 * @Date: 2018/10/9 10:35
	 */
	@ApiOperation(value="",notes="")
	@GetMapping("/doFindYyzzById/{qyid}")
	public @ResponseBody ResultVO getDetail(@PathVariable String qyid){
		ResultVO resultVO = ResultVO.build();
		try{
			QyjbxxVO result = qyjbxxService.doFindById(qyid);
			//将二进制转为Base64格式字符串
			String photo64 = Base64ImageUtil.byteArr2String(result.getYyzz());
			result.setYyzzBase64(photo64);
			resultVO.setResult(result);
		}catch(Exception e){
			logger.error("{}",e.getMessage());
			resultVO.setCode(EConstants.CODE.FAILURE);
		}
		return resultVO;
	}

    /**
     * @Description: 根据用户信息、公司名称获取企业基本信息
     * @Author: li.xue
	 * @Date: 2018/10/9 11:05
	 */
    @ApiOperation(value="根据企业查询企业信息",notes="列表")
    @ApiImplicitParam(name="vo",value="企业对象")
    @PostMapping("/doFindZsxxByQyjbxx")
    public @ResponseBody ResultVO doFindZsxxByQyjbxx(@RequestBody QyjbxxVO qyjbxxVO){
        ResultVO resultVO = ResultVO.build();
        try{
            resultVO.setResult(qyjbxxService.doFindZsxxByQyjbxx(qyjbxxVO));
        }catch(Exception e){
            logger.error("{}",e.getMessage());
            resultVO.setCode(EConstants.CODE.FAILURE);
        }
        return resultVO;
    }
}
