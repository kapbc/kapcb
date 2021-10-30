package com.kapcb.ccc.common.result;

/**
 * <a>Title: IErrorCode </a>
 * <a>Author: Kapcb <a>
 * <a>Description: IErrorCode <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/10/30 18:07
 */
public interface IErrorCode {

    /**
     * error message
     *
     * @return String
     */
    String msg();

    /**
     * error code
     *
     * @return int
     */
    int code();
}
