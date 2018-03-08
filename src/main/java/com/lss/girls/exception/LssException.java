package com.lss.girls.exception;

/**
 * @author Magic
 * @date 17:29 2018/2/11
 * @description
 */
public class LssException extends RuntimeException {
    private Integer code;
    private String message;

    public LssException(){
    }
    public LssException(Integer code,String message){
        super(message);
        this.message = message;
        this.code = code;
    }
}
