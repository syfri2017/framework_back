//package com.syfri.userservice.controller.venue;
//
//import com.syfri.baseapi.model.ResultVO;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import org.springframework.web.bind.annotation.*;
//
//import com.syfri.userservice.model.venue.ZwlogVO;
//import com.syfri.userservice.service.venue.ZwlogService;
//import com.syfri.baseapi.controller.BaseController;
//
//@RestController
//@RequestMapping("zwlog")
//public class ZwlogController extends BaseController<ZwlogVO> {
//
//    @Autowired
//    private ZwlogService zwlogService;
//
//    @Override
//    public ZwlogService getBaseService() {
//        return this.zwlogService;
//    }
//
//    @PostMapping("doDeleteByRzsj")
//    public @ResponseBody
//    ResultVO doDeleteByRzsj(@RequestBody ZwlogVO vo) {
//        ResultVO resultVO = ResultVO.build();
//        try {
//            resultVO.setResult(zwlogService.doDeleteByRzsj(vo));
//        } catch (Exception e) {
//            logger.error("{}", e.getMessage());
//        }
//        return resultVO;
//    }
//}
