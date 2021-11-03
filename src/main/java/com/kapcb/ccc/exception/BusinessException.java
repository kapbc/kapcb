package com.kapcb.ccc.exception;

import com.kapcb.ccc.common.result.IResultCode;

/**
 * <a>Title: BusinessException </a>
 * <a>Author: Kapcb <a>
 * <a>Description: BusinessException <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/11/3 21:40
 */
public class BusinessException extends RuntimeException {

    private IResultCode resultCode;

    private static final long serialVersionUID = -5389110795723378384L;

    public BusinessException(IResultCode resultCode) {
        super(resultCode.msg());
        this.resultCode = resultCode;
    }

    public BusinessException(String msg) {
        super(msg);
    }

    public BusinessException(Throwable throwable) {
        super(throwable);
    }

    public BusinessException(String msg, Throwable throwable) {
        super(msg, throwable);
    }

    public IResultCode getResultCode() {
        return this.resultCode;
    }
}
