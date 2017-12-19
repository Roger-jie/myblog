package com.roger.blog.util;

/**
 * @author  Roger
 *
 */
public class StringUtil {

    /**
     * 判断对象是否为空
     */
    public static boolean isNotEmpty(Object str) {
        boolean flag = true;
        if (str != null && !str.equals("")) {
            if (str.toString().length() > 0) {
                flag = true;
            }
        } else {
            flag = false;
        }
        return flag;
    }

    /**
     * 判断是否是空字符串 null和"" 都返回 true
     */
    public static boolean isEmpty(String s) {
        if (s != null && !s.equals("")) {
            return false;
        }
        return true;
    }
}
