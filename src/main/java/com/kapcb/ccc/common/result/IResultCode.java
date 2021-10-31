package com.kapcb.ccc.common.result;

/**
 * <a>Title: IResultCode </a>
 * <a>Author: Kapcb <a>
 * <a>Description: IResultCode <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/10/30 18:07
 */
public interface IResultCode {

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
