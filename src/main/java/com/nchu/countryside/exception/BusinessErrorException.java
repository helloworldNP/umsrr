package com.nchu.countryside.exception;

import com.nchu.countryside.constant.BusinessMsgEnum;
import lombok.Data;

/**
 * @program: countryside
 * @author: Xing guo ning
 * @description：
 * @Date: 2021-01-19 10:16
 * 自定义业务异常类
 */
@Data
public class BusinessErrorException extends RuntimeException{
    private static final long serialVersionUID = -7480022450501760611L;

    /**
     *异常码
     */
    private String code;

    /**
     * 异常提示信息
     */
    private String message;

    public BusinessErrorException(BusinessMsgEnum businessMsgEnum) {
        this.code = businessMsgEnum.getCode();
        this.message = businessMsgEnum.getMsg();
    }

}
