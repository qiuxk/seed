package com.qiuxk.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qiuxk.model.po.Account;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;

/**
 * 账户信息DAO
 *
 * @author zhichunzhang
 */
@Mapper
public interface AccountMapper extends BaseMapper<Account> {

    /**
     * 根据公司的clientId  查询员工的 股票总数量
     *
     * @param clientId
     * @return
     */
    @Select("select IFNULL(sum(quantity),0) from position_account where client_id in ( SELECT " +
            " client_id " +
            "  FROM " +
            "  account " +
            "  WHERE " +
            "  ib_account_id IN ( SELECT DISTINCT ( ib_account_id ) FROM account WHERE client_id = #{clientId}) " +
            "  AND account_type = 'EMPLOYEE'" +
            "  AND is_valid = 1)")
    BigDecimal queryUserTotalPosition(Integer clientId);


    @Select(" select id from account WHERE is_vaild = #{valid})")
    //IPage<Account> selectListByPage(Page<Account> page , @Param(Constants.WRAPPER)Wrapper<Account> wrapper);
    IPage<Account> selectListByPage(Page<Account> page , Integer valid);
}