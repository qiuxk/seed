package com.qiuxk.config;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * excel监听器
 *
 * @author qiuxk
 * @classes com.qiuxk.config.ExcelListen
 * @date 2020-06-28 11:33
 */
@Component
public class ExcelListen extends AnalysisEventListener {
    List<List<Object>> datas=  new  ArrayList<>();

    public List<List<Object>> getDatas(){
        return  datas;
    }
    public void setDatas(List<List<Object>> datas){
        this.datas = datas;
    }

    @Override
    public void invoke(Object o, AnalysisContext analysisContext) {
      List<Object> objectList = (List<Object>) o;
      datas.add(objectList);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}
