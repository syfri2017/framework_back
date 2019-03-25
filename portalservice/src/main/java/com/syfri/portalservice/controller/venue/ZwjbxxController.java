package com.syfri.portalservice.controller.venue;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.syfri.baseapi.controller.BaseController;
import com.syfri.baseapi.model.ResultVO;
import com.syfri.portalservice.model.venue.*;
import com.syfri.portalservice.service.venue.ZgjbxxService;
import com.syfri.portalservice.service.venue.ZwjbxxService;
import com.syfri.portalservice.service.venue.ZwmkService;
import com.syfri.portalservice.service.prediction.QyjbxxService;
import com.syfri.portalservice.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("zwjbxx")
public class ZwjbxxController extends BaseController<ZwjbxxVO>{

	@Autowired
	private ZwjbxxService zwjbxxService;
	
	@Autowired
	private QyjbxxService qyjbxxService;
	@Autowired
	private ZgjbxxService zgjbxxService;
	@Autowired
	private ZwmkService zwmkService;
	@Override
	public ZwjbxxService getBaseService() {
		return this.zwjbxxService;
	}
	/**
	 * 获取所有企业信息包含企业名称
	 * @param vo
	 * @return
	 */
	@PostMapping("doSearchListByVO")
	@GetMapping(value="doFindQyZwNumDesc",produces="text/html;charset=UTF-8")
	public @ResponseBody
	String doSearchListByVO(ZwjbxxVO vo  , String callback) {
		ResultVO resultVO = ResultVO.build();
		try {
			resultVO.setResult(zwjbxxService.doSearchListQyByVO(vo));
		} catch (Exception e) {
			logger.error("{}",e.getMessage());
		}
		return StringUtil.callbackString(callback,resultVO);
	}

	/**
	 * 获取带有企业信息的展位信息
	 * 注意：这里通过知否含有zgid判断是否获取真实的展位数据
	 * @param vo
	 * @return
	 */
	@GetMapping(value="doSearchListQyByVO",produces="text/html;charset=UTF-8")
	public @ResponseBody
	String doSearchListQyByVO(HttpServletRequest request, ZwjbxxVO vo , String callback) {
		ResultVO resultVO = ResultVO.build();
		try {
			PageInfo<ZwjbxxVO> pis= zwjbxxService.doSearchQyPage(vo);
			List<ZwjbxxVO> zwjbxxVOs=pis.getList();
			for(ZwjbxxVO zwjbxxVO:zwjbxxVOs){
				//匹配展位状态代码名称
				zwjbxxVO.setZwztmc(zwzt2Mc(zwjbxxVO.getZwzt()));
			}
			resultVO.setResult(pis);
		} catch (Exception e) {
			logger.error("{}",e.getMessage());
		}
		return StringUtil.callbackString(callback,resultVO);
	}

	/**
	 * 状态转换，目前使用写死的方式
	 * @param zhzt
	 * @return
	 */
	private String zwzt2Mc(String zhzt){
		if("normal".equals(zhzt)){  //新建展位
			return "新建展位";
		}if("allotted".equals(zhzt)){//已分配展位
			return "已分配展位";
		}if("bespoke".equals(zhzt)){//已预定展位
			return "已预定展位";
		}if("completed".equals(zhzt)){//已确定展位
			return "已确定展位";
		}
		return null;
	}
	/**
	 * 企业选择的展位数量从大到小进行排序 by li.xue 2018/12/29
	 * @param zwjbxxVO
	 * @return
	 * @throws Exception
	 */
	@GetMapping(value="doFindQyZwNumDesc",produces="text/html;charset=UTF-8")
	public @ResponseBody String doFindQyZwNumDesc(ZwjbxxVO zwjbxxVO , String callback){
		ResultVO resultVO = ResultVO.build();
		try {
			PageHelper.startPage(zwjbxxVO.getPageNum(), zwjbxxVO.getPageSize());
			List<ZwjbxxVO> list= zwjbxxService.doFindQyZwNumDesc(zwjbxxVO);
			PageInfo<ZwjbxxVO> pageInfo = new PageInfo<>(list);
			resultVO.setResult(pageInfo);
		} catch (Exception e) {
			logger.error("{}",e.getMessage());
		}
		return StringUtil.callbackString(callback,resultVO);
	}
	/**
	 * 获取当前企业选择的展位信息及价格信息
	 * by yushch 2019/1/16
	 */
	@GetMapping(value="doFindZwAndJgByVo",produces="text/html;charset=UTF-8")
	public @ResponseBody String doFindZwAndJgByVo( ZwjbxxVO zwjbxxVO , String callback){
		ResultVO resultVO = ResultVO.build();
		try {
			List<ZwjbxxVO> list= zwjbxxService.doFindZwAndJgByVo(zwjbxxVO);
			resultVO.setResult(list);
		} catch (Exception e) {
			logger.error("{}",e.getMessage());
		}
		return StringUtil.callbackString(callback,resultVO);
	}
}
