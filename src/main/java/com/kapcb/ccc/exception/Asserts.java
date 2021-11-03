package com.kapcb.ccc.exception;

import com.kapcb.ccc.common.result.IResultCode;

/**
 * <a>Title: Asserts </a>
 * <a>Author: Kapcb <a>
 * <a>Description: Asserts <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/11/3 21:45
 */
public class Asserts {

    public static void failed(String msg) {
        throw new BusinessException(msg);
    }

    public static void failed(IResultCode resultCode) {
        throw new BusinessException(resultCode);
    }
}
