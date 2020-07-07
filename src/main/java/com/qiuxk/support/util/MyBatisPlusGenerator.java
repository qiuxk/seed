package com.qiuxk.support.util;


import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @date 2019/12/3 16:03
 */
public class MyBatisPlusGenerator {

    public static void main(String[] args) throws SQLException {
        //1. 全局配置
        GlobalConfig config = new GlobalConfig();
        // 是否支持AR模式
        config.setActiveRecord(true)
                // 作者
                .setAuthor("qiuxk")
                // 生成路径
                .setOutputDir("/Users/Fundusd/Desktop/code")
                // 文件覆盖
                .setFileOverride(true)
                // 主键策略
                .setIdType(IdType.AUTO)
                .setDateType(DateType.ONLY_DATE)
                .setServiceName("%sService")
                //实体类属性 用swagger 注释
                .setSwagger2(true)
                .setBaseResultMap(true)
                .setBaseColumnList(true);
//　　　　　　　　　　// 设置日期格式
//　　　　　　　　　　
              // 设置生成的service接口的名字的首字母是否为I，默认Service是以I开头的

                //生成基本的resultMap

                //生成基本的SQL片段


        //2. 数据源配置
        DataSourceConfig dsConfig = new DataSourceConfig();


        // 设置数据库类型
        dsConfig.setDbType(DbType.MYSQL)
                .setDriverName("com.mysql.cj.jdbc.Driver")
                .setUrl("jdbc:mysql://192.168.100.153:3306/db_esop?useUnicode=true&characterEncoding=UTF-8&autoReconnect=true&useSSL=false&zeroDateTimeBehavior=convertToNull&serverTimezone=Asia/Shanghai")
                .setUsername("java")
                .setPassword("123456");

        //获取所有的表名

        List<String> allTable = new ArrayList<>();

        ResultSet tables = dsConfig.getConn().getMetaData().getTables("", "", "", null);
//        StringBuilder sb = new StringBuilder();
//        while (tables.next()){
//            String  tableName = tables.getString("TABLE_NAME");
//            sb.append(",").append(tableName);
//            allTable.add(tableName);
//        }
        //手动添加表名
        allTable.add("trade_payee_bank_info");
      //  System.out.println(sb.toString());

        //3. 策略配置globalConfiguration中
        StrategyConfig stConfig = new StrategyConfig();
        //全局大写命名
        stConfig.setCapitalMode(true)
                // 数据库表映射到实体的命名策略
                .setNaming(NamingStrategy.underline_to_camel)
                // 生成的表, 支持多表一起生成，以数组形式填写
                .setInclude(allTable.toArray(new String[]{})).setEntityLombokModel(true);
        //4. 包名策略配置
        PackageConfig pkConfig = new PackageConfig();
        pkConfig.setParent("com.fundusd.eshoph5")
                .setMapper("dao")
                //.setService("service")
               // .setController("controller")
                .setEntity("model");
                //.setXml("mapper");

        //5. 整合配置
        AutoGenerator ag = new AutoGenerator();
        ag.setGlobalConfig(config)
                .setDataSource(dsConfig)
                .setStrategy(stConfig)
                .setPackageInfo(pkConfig);

        //6. 执行
        ag.execute();
//　　　　　//System.out.println("======= 代码生成完毕 ========");
        System.out.println("======= 代码生成完毕 ========");
    }
}