package com.qiuxk.exception;

import lombok.Data;

/**
 * 封装所有的业务异常
 *
 * @author qiuxk
 * @classes com.qiuxk.exception.ServiceException
 * @date 2020-06-20 17:13
 */
@Data
public class ServiceException extends  RuntimeException {

    public static final ServiceException SYS_ERROR = new ServiceException(001,"系统异常");

    private Integer code;
    private String msg;

    public ServiceException (Integer code,String msg){
        this.code=code;
        this.msg=msg;
    }
}
