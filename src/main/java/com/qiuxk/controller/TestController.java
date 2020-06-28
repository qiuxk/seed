package com.qiuxk.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.qiuxk.mapper.AccountMapper;
import com.qiuxk.exception.ServiceException;
import com.qiuxk.model.po.Account;
import com.qiuxk.support.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private AccountMapper accountMapper;

    @GetMapping("get")
    public CommonResult get(){
        throw  new NullPointerException("数据库异常");
    }

    @GetMapping("get2")
    public CommonResult get2(){
        throw new ServiceException(999,"天气好热异常");
    }

    @GetMapping("get3")
    public CommonResult get3(){
         Account account = accountMapper.selectOne(new QueryWrapper<com.qiuxk.model.po.Account>().lambda().eq(Account::getClientId, 1));
         return  CommonResult.success(account);
    }


}
