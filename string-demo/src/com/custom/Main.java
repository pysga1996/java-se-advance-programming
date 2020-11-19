package com.custom;

import java.sql.Date;

public class Main {

    public static void main(String[] args) {
	// write your code here
//        String a = "hello" + "world";
//        String b = "world";
//        String c = "hello" + b;
//        System.out.println(a == c);
//        System.out.println(c.hashCode());
//        System.out.println(true);
//        A a = new A();
//        a.runA();
        String phoneNumber = "037225982";
        StringBuilder sb = new StringBuilder(phoneNumber);
        int indexToReplace = (int) Math.ceil((phoneNumber.length() - 3.0) / 2.0);
        sb.replace(indexToReplace, indexToReplace + 3, "xxx");
        System.out.println(sb.toString());
    }
}
