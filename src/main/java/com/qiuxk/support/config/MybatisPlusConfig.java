package com.qiuxk.support.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/**
 * mybatis的配置
 *
 * @author qiuxk
 * @classes com.qiuxk.support.config.MybatisPlusConfig
 * @date 2020-06-22 17:23
 */
@Configuration
public class MybatisPlusConfig {


    @Bean
    public PaginationInterceptor paginationInterceptor(){
            return  new PaginationInterceptor();
    }

}
