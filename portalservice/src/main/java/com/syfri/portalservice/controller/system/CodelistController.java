package com.syfri.portalservice.controller.system;
import com.syfri.baseapi.model.ResultVO;
import com.syfri.portalservice.controller.base.BaseController;
import com.syfri.portalservice.model.system.CodelistDetailVO;
import com.syfri.portalservice.model.system.CodelistVO;
import com.syfri.portalservice.service.system.CodelistService;
import com.syfri.portalservice.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("codelist")
public class CodelistController extends BaseController<CodelistVO> {

	@Autowired
	private CodelistService codelistService;
	@Override
	public CodelistService getBaseService() {
		return this.codelistService;
	}

	@GetMapping(value="listCodeDetail",produces="text/html;charset=UTF-8")
	public @ResponseBody String listCodeDetail(CodelistVO vo , String callback) {
		ResultVO resultVO = ResultVO.build();
		try {
			resultVO.setResult(codelistService.doFindCplxSelect(vo.getCodetype()));
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("{}",e.getMessage());
		}
		return StringUtil.callbackString(callback,resultVO);
	}
	@GetMapping(value="listCplxCodeDetail",produces="text/html;charset=UTF-8")
	public @ResponseBody String listCplxCodeDetail(CodelistDetailVO vo , String callback) {
		ResultVO resultVO = ResultVO.build();
		try {
			String newCplx=vo.getCodeValue().substring(0,1)+"___";
			vo.setCodeValue(newCplx);
			resultVO.setResult(codelistService.doFindDetailCplxSelect(vo));
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("{}",e.getMessage());
		}
		return StringUtil.callbackString(callback,resultVO);
	}

}
