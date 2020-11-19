package com.tutorial;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileIODemo {
    public static void writeToFile(String filePath, String content, Boolean appendToFile) {
        FileOutputStream fout;
        try {
            fout = new FileOutputStream(filePath, appendToFile);
            fout.write(content.getBytes());
            System.out.println("success...");
            fout.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void readFromFile(String filePath) {
        FileInputStream fin;
        try {
            fin = new FileInputStream(filePath);
            int i = 0;
            while ((i = fin.read()) != -1) {
                System.out.print((char) i);
            }
            fin.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
