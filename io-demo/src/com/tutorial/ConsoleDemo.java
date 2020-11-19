package com.tutorial;

import java.io.Console;

public class ConsoleDemo {
    public static void consoleExample1() {
        // try to run java in cmd, not in IDEA, otherwise the Console instance will be null
        /*
        in CMD, type
        > set CLASSPATH=path/to/root/of/class/file
        example CLASSPATH=E:\Projects\input-ouput-demo\out\production\input-ouput-demo
        then run
        > java com.tutorial.Main
        * */
        Console c = System.console();
        System.out.println("Enter your name: ");
        String n = c.readLine();
        System.out.println("Welcome " + n);
    }
}
