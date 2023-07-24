package com.example.ecommercespringbootthymeleaf.exception;

import com.example.ecommercespringbootthymeleaf.common.constant.RestCommonConstant;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.Collections;

@Setter
@EqualsAndHashCode(callSuper = false)
@Accessors(fluent = true, chain = true)
public class BaseException extends RuntimeException {
    @Getter
    private int code = RestCommonConstant.ErrorCode.DEFAULT;
    @Getter
    private String displayMessage;
    @Getter
    private Object extraData = Collections.EMPTY_MAP;
    public BaseException() {
        super();
    }
    public BaseException(String message) {
        super(message);
    }

}