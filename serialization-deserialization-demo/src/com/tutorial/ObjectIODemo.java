package com.tutorial;

import java.io.*;

public class ObjectIODemo {
    public static void writeObject(Object object, String destinationFilePath) {
        ObjectOutputStream oo;
        FileOutputStream fout;
        try {
            fout = new FileOutputStream(destinationFilePath);
            oo = new ObjectOutputStream(fout);
            // write student
            oo.writeObject(object);
            System.out.println("Success...");
            oo.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void readObject(String inputFile) {
        File file = new File(inputFile);
        if (!file.exists()) {
            try {
                if (file.createNewFile()) {
                    System.out.println("File " + inputFile + " created successfully");
                } else {
                    System.out.println("File " + inputFile + " created failed");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        ObjectInputStream oi;
        FileInputStream fin;
        try {
            fin = new FileInputStream(inputFile);
            oi = new ObjectInputStream(fin);
            Student student = (Student) oi.readObject();
            System.out.print(student.toString());
            oi.close();
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }

    }
}
