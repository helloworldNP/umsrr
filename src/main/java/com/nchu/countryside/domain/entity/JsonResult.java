package com.nchu.countryside.domain.entity;

import lombok.Data;

/**
 * @program: countryside
 * @author: Xing guo ning
 * @description：
 * @Date: 2021-01-18 17:21
 * 统一数据封装
 */
@Data
public class JsonResult<T> {

    /**
     * 返回数据
     */
    private T data;

    /**
     * 响应状态码
     */
    private String code;

    /**
     * 响应信息
     */
    private String msg;

    public JsonResult() {
    }

    /**
     * 若没有数据返回，可以人为指定状态码和提示信息
     * @param code  状态码
     * @param msg
     */
    public JsonResult(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * 满参构造
     * @param code
     * @param msg
     * @param data
     */
    public JsonResult(String code,String msg,T data){
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

    /**
     * 操作成功，没有返回数据
     * @return
     */
    public JsonResult ok(){
        JsonResult resultMsg = new JsonResult();
        resultMsg.setCode("0");
        resultMsg.setMsg("操作成功");
        return resultMsg;
    }

    /**
     * 自定义响应信息，没有返回数据
     * @param msg
     * @return
     */
    public JsonResult ok(String msg){
        JsonResult resultMsg = new JsonResult();
        resultMsg.setCode("0");
        resultMsg.setMsg(msg);
        return resultMsg;
    }

    /**
     * 自定义状态码，指定义状态信息
     * @param code
     * @param msg
     * @return
     */
    public JsonResult ok(String code , String msg){
        JsonResult resultMsg = new JsonResult();
        resultMsg.setCode(code);
        resultMsg.setMsg(msg);
        return resultMsg;
    }

    /**
     * 写入返回数据
     * @param data
     * @return
     */
    public JsonResult ok(T data){
        JsonResult resultMsg = new JsonResult();
        resultMsg.setCode("0");
        resultMsg.setMsg("操作成功" );
        resultMsg.setData(data);
        return resultMsg;
    }



}
