package com.nchu.countryside.hander;

import com.nchu.countryside.domain.entity.JsonResult;
import com.nchu.countryside.exception.BusinessErrorException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Potter
 * @program: nongcun
 * @author: Xing guo ning
 * @description：
 * @Date: 2021-01-12 15:38
 * 全局异常处理类 拦截器
 * @ResponseBody 注解是为了异常处理完之后给调用方输出一个 json 格式的封装数据。
 *
 */
@ControllerAdvice
@ResponseBody
@Slf4j
public class GlobalExceptionHandler {

    /**
     * 业务异常
     * @param ex
     * @return
     */
    @ExceptionHandler(BusinessErrorException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public JsonResult handleBusinessError(BusinessErrorException ex) {
        String code = ex.getCode();
        String message = ex.getMessage();
        return new JsonResult(code, message);
    }

    /**
     * 空指针异常
     * @param ex NullPointerException
     * @return
     */
    @ExceptionHandler(NullPointerException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public JsonResult handleTypeMismatchException(NullPointerException ex) {
        log.error("空指针异常", ex);
        return new JsonResult("500", "空指针异常了");
    }

    /**
     * 缺少请求参数异常
     * @param ex
     * @return
     */
    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public JsonResult handleHttpMessageNotReadableException(
            MissingServletRequestParameterException ex) {
        log.error("缺少请求参数，{}", ex.getMessage());
        return new JsonResult("400", "缺少必要的请求参数");
    }


     /**
     * 系统异常 预期以外异常
     * @param ex
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public JsonResult handleUnexpectedServer(Exception ex) {
        log.error("系统异常：", ex);
        return new JsonResult("500", "系统发生异常，请联系管理员");
    }


}
