package com.qiuxk.support.config;

import com.qiuxk.exception.ServiceException;
import com.qiuxk.support.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 全局处理异常的方法
 *
 * @author qiuxk
 * @classes com.qiuxk.support.config.GlobalExceptionHandler
 * @date 2020-06-20 17:11
 */

@ControllerAdvice(basePackages = "com.qiuxk.controller")
@Slf4j
public class GlobalExceptionHandler {

    /**
     * 处理serviceException
     * @param req
     * @param serviceException
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = ServiceException.class)
    public CommonResult serviceExceptionHandler(HttpServletRequest req, ServiceException serviceException) {
        log.debug("异常信息", serviceException);
        return CommonResult.error(serviceException.getCode(),serviceException.getMsg());
    }

    /**
     * 处理其他Exception异常
     * @param req
     * @param ex
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public CommonResult  otherExceptionHandler(HttpServletRequest req,Exception ex){
        log.error("otherException",ex);
        return  CommonResult.error(ServiceException.SYS_ERROR);
    }


}
