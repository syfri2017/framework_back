package com.syfri.baseapi.utils;

import com.syfri.baseapi.model.ValueObject;
import org.apache.poi.hssf.usermodel.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

/**
 * @Description:
 * @Author: liurui
 * @Modified By:
 * @Date: 2018/10/15 14:25
 */
public class ExcelUtil<T extends ValueObject> {
    /**
     * 导出Excel
     *
     * @param sheetName sheet名称
     * @param title     标题
     * @param list    内容
     * @param wb        HSSFWorkbook对象
     * @return
     */
    public HSSFWorkbook getHSSFWorkbook(String sheetName, String[] title, String[] columns, List<T> list, HSSFWorkbook wb) {

        // 第一步，创建一个HSSFWorkbook，对应一个Excel文件
        if (wb == null) {
            wb = new HSSFWorkbook();
        }

        // 第二步，在workbook中添加一个sheet,对应Excel文件中的sheet
        HSSFSheet sheet = wb.createSheet(sheetName);

        // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制
        HSSFRow row = sheet.createRow(0);

        // 第四步，创建单元格，并设置值表头 设置表头居中
        HSSFCellStyle style = wb.createCellStyle();
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式

        //声明列对象
        HSSFCell cell = null;

        //创建标题样式和字体
        HSSFCellStyle titleStyle = wb.createCellStyle();
        HSSFFont titleFont = wb.createFont();
        titleStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);    //水平居中
        titleStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);//垂直居中
        titleStyle.setBorderTop(HSSFCellStyle.BORDER_THIN); // 实线
        titleStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN); // 实线
        titleStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN); // 实线
        titleStyle.setBorderRight(HSSFCellStyle.BORDER_THIN); // 实线
        titleFont.setFontName("宋体");    //字体
        titleFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD); // 加粗
        titleFont.setFontHeightInPoints((short) 14);//字体大小
        titleStyle.setFont(titleFont); // 绑定关系

        //创建标题
        for (int i = 0; i < title.length; i++) {
            cell = row.createCell(i);
            cell.setCellValue(title[i]);
            cell.setCellStyle(titleStyle);
            sheet.autoSizeColumn((short) i);//自动调整列宽
        }
        //创建内容样式和字体
        HSSFCellStyle curStyle = wb.createCellStyle();
        HSSFFont curFont = wb.createFont();
        curStyle.setAlignment(HSSFCellStyle.ALIGN_RIGHT);//右对齐
        curStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);//垂直居中
        curStyle.setWrapText(true); // 自动换行
        curStyle.setBorderTop(HSSFCellStyle.BORDER_THIN); // 实线
        curStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN); // 实线
        curStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN); // 实线
        curStyle.setBorderRight(HSSFCellStyle.BORDER_THIN); // 实线
        curFont.setFontName("Times New Roman");//字体
        curFont.setFontHeightInPoints((short) 11);//字体大小
        curStyle.setFont(curFont); // 绑定关系

        //创建第一列样式和字体
        HSSFCellStyle curFirstStyle = wb.createCellStyle();
        HSSFFont curFirstFont = wb.createFont();
        curFirstStyle.setAlignment(HSSFCellStyle.ALIGN_LEFT);//右对齐
        curFirstStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);//垂直居中
        curFirstStyle.setWrapText(true); // 自动换行
        curFirstStyle.setBorderTop(HSSFCellStyle.BORDER_THIN); // 实线
        curFirstStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN); // 实线
        curFirstStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN); // 实线
        curFirstStyle.setBorderRight(HSSFCellStyle.BORDER_THIN); // 实线
        curFirstFont.setFontName("Times New Roman");//字体
        curFirstFont.setFontHeightInPoints((short) 11);//字体大小
        curFirstStyle.setFont(curFirstFont); // 绑定关系

        int rowNum = 0;
        for (T t : list) {
            rowNum++;
            row = sheet.createRow(rowNum);
            for (int j = 0; j < columns.length; j++) {
                String getMethodName = "get" + columns[j].substring(0,1).toUpperCase() + columns[j].substring(1);
                //将内容按顺序赋给对应的列对象
                Class clazz = t.getClass();
                Method getMethod;
                try {
                    getMethod = clazz.getMethod(getMethodName, new Class[]{} );
                    Object value = getMethod.invoke(t, new Object[]{});
                    row.createCell(j).setCellValue(null != value ? value.toString() : "");
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }

                if(j == 0){//第一列左对齐
                    row.getCell(j).setCellStyle(curFirstStyle);
                }else{
                    row.getCell(j).setCellStyle(curStyle);
                }
            }
        }

        //自动调整列宽
        for(int k = 0; k < columns.length; k++){
            sheet.autoSizeColumn((short) k);
        }

        return wb;
    }

}
