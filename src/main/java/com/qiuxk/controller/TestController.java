package com.qiuxk.controller;

import com.qiuxk.exception.ServiceException;
import com.qiuxk.support.CommonResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试用的控制器
 *
 * @author qiuxk
 * @classes com.qiuxk.controller.TestController
 * @date 2020-06-20 17:22
 */
@RestController
@RequestMapping("/test")
public class TestController {


    @GetMapping("get")
    public CommonResult get(){
        throw  new NullPointerException("数据库异常");
    }

    @GetMapping("get2")
    public CommonResult get2(){
        throw new ServiceException(999,"天气好热异常");
    }

}
