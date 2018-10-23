package com.syfri.userservice.controller.prediction;

import com.syfri.baseapi.model.ResultVO;
import com.syfri.baseapi.utils.EConstants;
import com.syfri.userservice.utils.Base64ImageUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import com.syfri.userservice.model.prediction.QycpjsVO;
import com.syfri.userservice.service.prediction.QycpjsService;
import com.syfri.baseapi.controller.BaseController;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.List;

@RestController
@RequestMapping("qycpjs")
public class QycpjsController extends BaseController<QycpjsVO> {

    @Autowired
    private QycpjsService qycpjsService;

    @Override
    public QycpjsService getBaseService() {
        return this.qycpjsService;
    }

    /**
     * @Description: 根据企业id获取产品信息
     * @Author: rliu
     * @Date: 2018/10/9 10:35
     */
    @ApiOperation(value = "根据企业id获取产品信息", notes = "vo")
    @RequestMapping("/doFindCpxxById")
    public @ResponseBody ResultVO doFindCpxxById(@RequestBody QycpjsVO qycpjsVO) {
        ResultVO resultVO = ResultVO.build();
        try {
            List<QycpjsVO> result = qycpjsService.doSearchListByVO(qycpjsVO);
            for(QycpjsVO vo:result) {
                //将二进制转为Base64格式字符串
                String photo64 = Base64ImageUtil.byteArr2String(vo.getCptp());
                vo.setCptpBase64(photo64);
            }
            resultVO.setResult(result);
        } catch (Exception e) {
            logger.error("{}", e.getMessage());
            resultVO.setCode(EConstants.CODE.FAILURE);
        }
        return resultVO;
    }

    @RequestMapping(value = "/upload")
    public @ResponseBody QycpjsVO uploadAttachment(HttpServletRequest request, QycpjsVO vo)
            throws UnsupportedEncodingException {
        //返回base64位图片
        /*
        try {
            byte[] buffer = null;
            MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
            Iterator<String> iterator = multipartRequest.getFileNames();
            while (iterator.hasNext()) {
                MultipartFile multipartFile = multipartRequest.getFile(iterator.next());
                if ("".equals(multipartFile.getOriginalFilename())) throw new RuntimeException("文件为空");
                InputStream fis = null;
                try {
                    fis = multipartFile.getInputStream();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                byte[] b = new byte[1024];
                int n;
                while ((n = fis.read(b)) != -1)
                {
                    bos.write(b, 0, n);
                }
                fis.close();
                bos.close();
                buffer = bos.toByteArray();
                vo.setCptp(buffer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        */
        return vo;
    }
}
