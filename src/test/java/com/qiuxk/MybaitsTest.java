package com.qiuxk;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qiuxk.mapper.AccountMapper;
import com.qiuxk.model.po.Account;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

/**
 * mybatis相关测试
 *
 * @author qiuxk
 * @classes com.qiuxk.MybaitsTest
 * @date 2020-06-22 14:54
 */
@SpringBootTest(classes = SpringbootSeedApplication.class)
@RunWith(SpringRunner.class)
@Slf4j
public class MybaitsTest {

    @Autowired
    private AccountMapper accountMapper;


    @Test
    public void query(){
     //   Account account = accountMapper.selectById(1);

        Account account = accountMapper.selectOne(new QueryWrapper<Account>().lambda().eq(Account::getClientId, 1));
        Assert.assertNotNull(account);
    }

    /**
     * 分页查询
     */
    @Test
    public void queryByPage(){
        LambdaQueryWrapper<Account> queryWrapper = new QueryWrapper<Account>().lambda().eq(Account::getIsValid, 1);

        Page<Account> page = new Page<Account>(1, 10);
        IPage<Map<String, Object>> mapIPage = accountMapper.selectMapsPage(page, queryWrapper);
        Assert.assertNotNull(mapIPage);
        //Assert.assertNotNull(mapIPage.getCurrent());
        Assert.assertNotNull(mapIPage.getRecords());
        log.info("当前页 "+mapIPage.getCurrent());
        log.info("查询条数 "+mapIPage.getRecords());

    }

    /**
     * 自定义sql分页查询
     */
    @Test
    public  void queryByPageAndSel(){
        LambdaQueryWrapper<Account> queryWrapper = new QueryWrapper<Account>().lambda().eq(Account::getIsValid, 1);

        Page<Account> page = new Page<Account>(1, 10);

        IPage<Account> accountIPage = accountMapper.selectListByPage(page, 1);
        Assert.assertNotNull(accountIPage);
        log.info("查询条数 "+accountIPage.getRecords().size());

    }

}
