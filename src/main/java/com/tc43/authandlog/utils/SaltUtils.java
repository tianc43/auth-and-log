package com.tc43.authandlog.utils;

import java.util.Random;

public class SaltUtils {
    public static String getSalt(int n) {
        char[] bases = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()_+~<>?:".toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(bases[new Random().nextInt(bases.length)]);
        }
        return sb.toString();
    }
}
