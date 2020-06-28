package com.qiuxk;

import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.metadata.Sheet;
import com.qiuxk.model.po.RowHeader;
import com.qiuxk.support.util.ExcelUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.test.context.junit4.SpringRunner;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

/**
 * excel工具类的测试
 *
 * @author qiuxk
 * @classes com.qiuxk.ExcelUtilTest
 * @date 2020-06-28 10:40
 */
//@SpringBootTest(classes = SpringbootSeedApplication.class)
@RunWith(SpringRunner.class)
public class ExcelUtilTest {

    @Test
    public void read(){
        FileInputStream file =  null;
        List<Object> list = null;

        try {
            file =   new FileInputStream("/Users/Fundusd/Desktop/学生信息.xlsx");
             list = EasyExcelFactory.read(file, new Sheet(0,1));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Assert.assertNotNull(list);
    }


    @Test
    public  void read2(){
        List<List<Object>> lists = ExcelUtil.readExcel("/Users/Fundusd/Desktop/学生信息.xlsx");
        Assert.assertNotNull(lists);
    }


    @Test
    public void writeExcel(){
        List<List<Object>> lists = ExcelUtil.readExcel("/Users/Fundusd/Desktop/学生信息.xlsx");

        Sheet sheet = new Sheet(1, 0, RowHeader.class);
        //sheet.set
        ExcelUtil.writeExcel("/Users/Fundusd/Desktop/学生信息2.xlsx",lists,sheet);


    }
}
