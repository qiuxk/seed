package com.qiuxk.support.util;

import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.qiuxk.config.ExcelListen;
import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.util.List;

/**
 * excel工具类（读取，导出）
 *
 * @author qiuxk
 * @classes com.qiuxk.support.util.ExcelUtil
 * @date 2020-06-28 14:11
 */
@Slf4j
public class ExcelUtil {

    /**
     * 解析excel内容
     * @param fileName excel的路径
     * @return
     */
    public  static  List<List<Object>> readExcel(String  fileName){
        File file = new File(fileName);
        InputStream inputStream = null;

        try {
            inputStream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ExcelListen excelListen = new ExcelListen();
        ExcelReader excelReader = new ExcelReader(inputStream, ExcelTypeEnum.XLSX, null, excelListen);
        excelReader.read();
        List<List<Object>> datas = excelListen.getDatas();
        return datas;


    }

    /**
     * 导出方法，生成excel
     * @param filePath  绝对路径
     * @param data   数据
     * @param sheet excel页面样式
     */
    public static  void writeExcel(String filePath, List<List<Object>> data, Sheet sheet){
        OutputStream outputStream = null;
        ExcelWriter excelWriter  = null;
        try {
            outputStream = new FileOutputStream(filePath);
            excelWriter = EasyExcelFactory.getWriter(outputStream);
            excelWriter.write1(data,sheet);
        } catch (FileNotFoundException e) {
            log.error("文件路径错误: {} ",e);
        }finally {
            try {
                if(excelWriter != null){
                    excelWriter.finish();
                }
                if(outputStream!= null){
                    outputStream.close();
                }
            } catch (IOException e) {
                log.error("excel文件导出失败：{}",e);
            }
        }
    }
}
