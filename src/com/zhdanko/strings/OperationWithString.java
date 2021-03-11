package com.zhdanko.strings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OperationWithString {
    public static void concatString(String str) {
        String strDefault = "";
        for (int i = 0; i < 1000; i++) {
            strDefault += str;
        }
    }

    public static void concatStringBuilder(String str) {
        StringBuilder strDefault = new StringBuilder();
        for (int i = 0; i < 1000; i++) {
            strDefault.append(str);
        }
    }

    public static void findHex(String str) {
        String pattern = "0[xX]([1-9a-fA-F]|0(?![xX]))+";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(str);
        while (m.find()) {
            System.out.println(m.group());
        }
    }

    public static void findTags(String str) {
        System.out.println(str.contains("<p"));
        System.out.println(str.replaceAll("<p id=p1>", "<p>"));
    }
}
