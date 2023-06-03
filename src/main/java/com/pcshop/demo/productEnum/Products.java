package com.pcshop.demo.productEnum;

public enum Products {
    DESKTOP_COMPUTER("desktop"),
    HDD("hdd"),
    LAPTOP("laptop"),
    MONITOR("monitor"),
    ALL("all");

    public final String value;
    Products(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
