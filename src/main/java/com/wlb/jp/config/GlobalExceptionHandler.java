package com.wlb.jp.config;

import com.wlb.jp.utils.ReturnType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.Set;


/**
 * 全局异常处理器
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 用来处理method validation异常
     * @param ex
     * @return
     */
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseBody
    public ReturnType resolveConstraintViolationException(ConstraintViolationException ex){
        String code = "";
        String msg = "";
        Object value = "";
        ReturnType returnType = new ReturnType(code, msg, value);

        Set<ConstraintViolation<?>> constraintViolations = ex.getConstraintViolations();
        if(!CollectionUtils.isEmpty(constraintViolations)) {
            StringBuilder msgBuilder = new StringBuilder();
            for(ConstraintViolation constraintViolation :constraintViolations){
                msgBuilder.append(constraintViolation.getMessage()).append(",");
            }
            String errorMessage = msgBuilder.toString();
            if (errorMessage.length() > 1) {
                errorMessage = errorMessage.substring(0, errorMessage.length() - 1);
            }
            returnType.setMsg(errorMessage);
            return returnType;
        }
        returnType.setMsg(ex.getMessage());
        return returnType;
    }


    /**
     * 用来处理bean validation异常
     * @param ex
     * @return
     */
//    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ExceptionHandler(BindException.class)
    @ResponseBody
    public ReturnType resolveMethodArgumentNotValidException(BindException ex){
        String code = "";
        String msg = "";
        Object value = "";
        ReturnType returnType = new ReturnType(code, msg, value);

        List<ObjectError> objectErrors = ex.getBindingResult().getAllErrors();
        if(!CollectionUtils.isEmpty(objectErrors)) {
            StringBuilder msgBuilder = new StringBuilder();
            for (ObjectError objectError : objectErrors) {
                msgBuilder.append(objectError.getDefaultMessage()).append(",");
            }
            String errorMessage = msgBuilder.toString();
            if (errorMessage.length() > 1) {
                errorMessage = errorMessage.substring(0, errorMessage.length() - 1);
            }
            returnType.setMsg(errorMessage);
            return returnType;
        }
        returnType.setMsg(ex.getMessage());
        return returnType;
    }
    @ExceptionHandler(value =Exception.class)
    @ResponseBody
    public ReturnType exceptionHandler(Exception e){
        String code = "";
        String msg = "";
        Object value = "";
        ReturnType returnType = new ReturnType(code, msg, value);
        String message = e.getMessage();
        returnType.setCode("99999");
        returnType.setMsg("网络异常，请稍后重试");
        returnType.setValue("");
        return returnType;
    }
}