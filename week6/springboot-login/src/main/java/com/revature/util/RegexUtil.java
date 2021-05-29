package com.revature.util;

public class RegexUtil {

    // 8 characters minimum and requires at least 1 character and 1 number
    public static final String PASSWORD_REGEX = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$";
}
