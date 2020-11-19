package com.tutorial;

import java.util.*;

public class Main {

  public static void main(String[] args) {
    // Tạo một đối tượng GenericClassDemo
    // Integer: Số điện thoại (K = Integer)
    // String: Tên người dùng. (V = String).
//        GenericClassDemo<Integer, String> entry = new GenericClassDemo<>(12000111, "Tom");
//
//        // Java hiểu kiểu trả về là Integer (K = Integer).
//        Integer phone = entry.getKey();
//
//        // Java hiểu kiểu trả về là String (V = String).
//        String name = entry.getValue();
//
//        System.out.println("Phone = " + phone + " / name = " + name);

//        PhoneNameEntry entry = new PhoneNameEntry(12000111, "Tom");
//
//        // Java hiểu kiểu trả về là Integer.
//        Integer phone = entry.getKey();
//
//        // Java hiểu kiểu trả về là String.
//        String name = entry.getValue();
//
//        System.out.println("Phone = " + phone + " / name = " + name);
//        try {
//            instantiateGenericObject();
//        } catch (InstantiationException | IllegalAccessException e) {
//            e.printStackTrace();
//        }
//        instantiateGenericArray();
    wildCardDemo();
  }

  public static void instantiateGenericObject()
      throws InstantiationException, IllegalAccessException {
    MyGeneric<Bar> mg = new MyGeneric<>(Bar.class);
    Bar bar = mg.getTobject();
    bar.currentDate();
  }

  public static void instantiateGenericArray() {
    // Một mảng các String.
    String[] names = new String[]{"Tom", "Jerry"};
    GenericArrayDemo<String> gNameArray = new GenericArrayDemo<>(names);
    GenericArrayDemo<Integer> gAgeArray = new GenericArrayDemo<>(Integer.class, 5);
    String last = gNameArray.getLastElement();
    System.out.println("Last Element = " + last);
    gAgeArray.getArray()[0] = 5;
    gAgeArray.getArray()[4] = 6;
    System.out.println(gAgeArray.getLastElement());
  }

  public static void wildCardDemo() {
    Collection<?> coll = new ArrayList<String>();

// Một tập hợp chỉ chứa kiểu Number hoặc kiểu con của Number
    List<? extends Number> list = new ArrayList<Long>();

// Một đối tượng có kiểu tham số đại diện.
// (A wildcard parameterized type)

    Bird bird = new Eagle("Bird 1", "Eagle 1");
    System.out.println(bird.name);
    Eagle eagle = (Eagle) bird;
    System.out.println(eagle.name);

    ArrayList<? extends Animal> animals1 = new ArrayList<>();
//        animals1.add(eagle); // Wild card object with extend cannot use generic method
    /*
     * If ? = Eagle then above statement can be treated as
     * ArrayList<Eagle> animals1 = new ArrayList<>();
     * But because it's a generic list you can add a Condor instance (extend from Bird), then an exception will be thrown
     * because Eagle and Condor dont't parent-child relationship
     * */
    animals1.add(null); // but it can use with null argument
    ArrayList<? super Eagle> animals2 = new ArrayList<>();
    animals2.add(eagle); // Wild card object with super can use generic method
    /*
     * If ? = Bird then above statement can be treated as
     * ArrayList<Bird> animals1 = new ArrayList<>();
     * But because it's a generic list you can add a Condor instance (extend from Bird), then it's still legal
     * because as long as ? is super type of Eagle you can add any instance which is a subtype of Eagle
     * */
  }
}
