package com.qiuxk.model.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * 账户表
 * @author zhichunzhang
 */
@Data
@EqualsAndHashCode()
@ApiModel("账户信息")
public class Account implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 账户ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("冗余的客户id")
    private Integer clientId;

    /**
     * 基础货币类型CNY HKD USD
     */
    @ApiModelProperty(value = "基础货币类型",allowableValues = "CNY,HKD,USD")
    private String baseCurrency = "USD";

    /**
     * 账户类型（企业、个人、其他）
     */
    @ApiModelProperty(value = "账户类型（EMPLOYEE-雇员，COMPANY-企业）",allowableValues ="EMPLOYEE,COMPANY" )
    private String accountType;

    /**
     * IB账户对应的管理表ID
     */
    @JsonIgnore
    @ApiModelProperty("IB账户对应的管理表ID")
    private Integer ibAccountId;
    /**
     * 是否有效
     */
    @TableLogic
    @JsonIgnore
    private Boolean isValid;

    /**
     * 创建时间
     */
    @JsonIgnore
    private Date ctime;

    /**
     * 更新时间
     */
    @JsonIgnore
    private Date utime;

}