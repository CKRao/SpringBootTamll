package com.clarkrao.springboottmall.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: ClarkRao
 * @Date: 2018/11/13 23:23
 * @Description:
 */
@RestController
@ControllerAdvice
public class GloabalExceptionHandler {

    public String defaultErrorHandler(HttpServletRequest request,Exception e) throws Exception{
        e.printStackTrace();
        Class constraintViolationException
                = Class.forName("org.hibernate.exception.ConstraintViolationException");
        if (null != e.getCause() && constraintViolationException == e.getCause().getClass()){
            return "违反了约束，多半是外键约束";
        }
        return e.getMessage();
    }
}
