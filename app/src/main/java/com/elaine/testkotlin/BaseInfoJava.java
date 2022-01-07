package com.elaine.testkotlin;

/**
 * @author elaine
 * 2020/7/22.
 */
class BaseInfoJava {
    //用于kotlin调用java方法，破坏kotlin的NULL安全机制
    public static String getMsg() {
        return null;
    }

    int a = 0;
    int c = a > 0 ? a : -2;
}
