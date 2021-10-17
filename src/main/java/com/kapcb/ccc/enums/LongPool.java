package com.kapcb.ccc.enums;

/**
 * <a>Title: LongPool </a>
 * <a>Author: Kapcb <a>
 * <a>Description: LongPool <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/7/3 13:40
 */
public enum LongPool {

    DEFAULT_SUPER_ADMIN(1000000001L, "default super admin"),
    ZERO(0L, "number 0"),
    ONE(1L, "number 1"),
    FIVE(5L, "number 5"),
    TEN(10L, "number 10");

    private Long value;
    private String description;

    LongPool(Long value, String description) {
        this.value = value;
        this.description = description;
    }

    public Long value() {
        return this.value;
    }

}