package com.syfri.userservice.controller.prediction;

import com.syfri.baseapi.model.ResultVO;
import com.syfri.baseapi.utils.EConstants;
import com.syfri.userservice.utils.ExcelUtil;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import com.syfri.userservice.model.prediction.QyzwyxVO;
import com.syfri.userservice.service.prediction.QyzwyxService;
import com.syfri.baseapi.controller.BaseController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.List;

@RestController
@RequestMapping("qyzwyx")
public class QyzwyxController extends BaseController<QyzwyxVO> {

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

    @ApiOperation(value = "统计分析图表数据", notes = "统计分析图表数据")
    @ApiImplicitParam(name = "vo", value = "统计分析图表数据")
    @PostMapping("/dofindtjfx")
    public @ResponseBody
    ResultVO dofindtjfx(@RequestBody QyzwyxVO qyzwyxVO) {
        ResultVO resultVO = ResultVO.build();
        try {
            resultVO.setResult(qyzwyxService.dofindtjfx(qyzwyxVO));
        } catch (Exception e) {
            logger.error("{}", e.getMessage());
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
    @ApiOperation(value = "统计分析图表数据", notes = "统计分析图表数据")
    @ApiImplicitParam(name = "vo", value = "统计分析图表数据")
    @PostMapping("/dofindtjfxsj")
    public @ResponseBody
    ResultVO dofindtjfxsj(@RequestBody QyzwyxVO qyzwyxVO) {
        ResultVO resultVO = ResultVO.build();
        try {
            resultVO.setResult(qyzwyxService.dofindtjfxsj(qyzwyxVO));
        } catch (Exception e) {
            logger.error("{}", e.getMessage());
            resultVO.setCode(EConstants.CODE.FAILURE);
        }
        return resultVO;
    }

    //add by yushch 20181010
    @ApiOperation(value = "根据VO保存", notes = "保存")
    @PostMapping("/doInsertByVo")
    public @ResponseBody
    ResultVO save(@RequestBody QyzwyxVO vo) throws Exception {
        ResultVO resultVO = ResultVO.build();
        try {
            resultVO.setResult(qyzwyxService.doInsertByVO(vo));
        } catch (Exception e) {
            logger.error("{}", e.getMessage());
            resultVO.setCode(EConstants.CODE.FAILURE);
        }
        return resultVO;
    }

    @ApiOperation(value = "根据id更新基本信息", notes = "修改")
    @PostMapping("/doUpdateByVO")
    public @ResponseBody
    ResultVO doUpdateByVO(@RequestBody QyzwyxVO vo) {
        ResultVO resultVO = ResultVO.build();
        try {
            resultVO.setResult(qyzwyxService.doUpdateByVO(vo));
        } catch (Exception e) {
            logger.error("{}", e.getMessage());
            resultVO.setCode(EConstants.CODE.FAILURE);
        }
        return resultVO;
    }

    @ApiOperation(value = "按产品类型统计分析图表数据导出", notes = "修改")
    @RequestMapping(value = "/doExportTjfx/{type}", method = RequestMethod.GET)
    public void download(HttpServletRequest request, HttpServletResponse response, @PathVariable String type) {
        //excel标题
        String[] title = {};
        //excel文件名
        String fileName = "";
        //sheet名
        String sheetName = "";
        //数据内容
        String[][] content = null;

        //获取数据
        QyzwyxVO vo = new QyzwyxVO();
        List<QyzwyxVO> list = null;
        if (type.equals("cplx")) {
            list = qyzwyxService.dofindtjfx(vo);
            String[] str = {"产品类型","参展企业数量","标准展位数量","光地展位面积(m²)"};
            title=str;
            fileName = "统计分析-按产品类型统计" + System.currentTimeMillis() + ".xls";
            sheetName = "按产品类型统计";
            content = new String[7][4];
            for (int i = 0; i < list.size(); i++) {
                content[i] = new String[title.length];
                QyzwyxVO obj = list.get(i);
                content[i][0] = obj.getCplxmc();
                content[i][1] = obj.getCzqysl();
                content[i][2] = obj.getBwzwgssl();
                content[i][3] = obj.getGdzwmj();
            }
        } else if (type.equals("gdzwmj")) {
            list = qyzwyxService.dofindtjfxsj(vo);
            String[] str = {"展位面积范围","展位数量"};
            title=str;
            fileName = "统计分析-按光地展位面积统计" + System.currentTimeMillis() + ".xls";
            sheetName = "按光地展位面积统计";
            content = new String[5][2];
            for (int i = 0; i < list.size(); i++) {
                content[i] = new String[title.length];
                QyzwyxVO obj = list.get(i);
                content[i][0] = obj.getZwmjfwmc();
                content[i][1] = obj.getSl();
            }
        }

        //创建HSSFWorkbook
        HSSFWorkbook wb = ExcelUtil.getHSSFWorkbook(sheetName, title, content, null);

        BufferedInputStream bis = null;
        try {
            wb.write(response.getOutputStream());
            response.addHeader("Cache-Control", "no-cache");
            //response.setCharacterEncoding("UTF-8");
            response.setContentType("application/vnd.ms-excel;charset=UTF-8");
            String ua = request.getHeader("user-agent");
            ua = ua == null ? null : ua.toLowerCase();
            if (ua != null && (ua.indexOf("firefox") > 0 || ua.indexOf("safari") > 0)) {
                try {
                    fileName = new String(fileName.getBytes(), "ISO8859-1");
                    response.addHeader("Content-Disposition", "attachment;filename=" + fileName);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                try {
                    fileName = URLEncoder.encode(fileName, "utf-8");
                    response.addHeader("Content-Disposition", "attachment;filename=" + fileName);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
