package com.tutorial;

public class Main {
    public static void main(String[] args) {
        Student student = new Student(1, "Vu Tat Thanh", "Ha Noi", 17);
        ObjectIODemo.writeObject(student, "E:\\student.txt");
        ObjectIODemo.readObject("E:\\student.txt");
    }
}
