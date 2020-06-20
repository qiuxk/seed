package com.qiuxk.support;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.qiuxk.exception.ServiceException;
import lombok.Data;
import org.springframework.util.Assert;

import java.io.Serializable;

/**
 * 封装统一的返回值
 *
 * @author qiuxk
 * @classes com.qiuxk.support.CommonResult
 * @date 2020-06-20 16:10
 */
@Data
public class CommonResult<T> implements Serializable {
    private static final long serialVersionUID = 1L;


    public static Integer CODE_SUCCESS = 0;
    private Integer code;

    private String message;

    private T data;

    /**
     * 错误方法的入口
     * @param result
     * @param <T>
     * @return
     */
    public static <T> CommonResult<T> error(CommonResult<?> result){
        return  error(result.getCode(),result.getMessage());
    }

    public static <T> CommonResult<T> error(ServiceException se){
        return  error(se.getCode(),se.getMsg());
    }


    public static <T> CommonResult<T> error(Integer code,String message){
        Assert.isTrue(!CODE_SUCCESS.equals(code) ,"code 必须是错误的");
        CommonResult<T> result = new CommonResult<>();
        result.code = code;
        result.message = message;
        return  result;
    }

    public  static <T> CommonResult<T> success(T data){
        CommonResult<T> result = new CommonResult<>();
        result.code = CODE_SUCCESS;
        result.message ="成功";
        result.data= data;
        return  result;
    }

    @JsonIgnore   //避免被序列化了   也可用在熟悉上
    public  boolean isSuccess(){
        return CODE_SUCCESS.equals(code);
    }

}
