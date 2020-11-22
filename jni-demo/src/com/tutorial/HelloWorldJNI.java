package com.tutorial;

public class HelloWorldJNI {

  public long count = 0;

  static {
    System.loadLibrary("libcpp-for-java");
  }

  public static void main(String[] args) {
    HelloWorldJNI helloWorldJNI = new HelloWorldJNI();
    helloWorldJNI.sayHello();
    System.out.println("Count: " + helloWorldJNI.count);
    System.out.println(helloWorldJNI.sumIntegers(1, 2));
    System.out.println(helloWorldJNI.sayHelloToMe("ThanhVt", false));
    UserData tam = helloWorldJNI.createUser("ThanhVt", 5000000);
    System.out.println(helloWorldJNI.printUserData(tam));
  }

  // Declare a native method sayHello() that receives no arguments and returns void
  private native void sayHello();

  private native long sumIntegers(int first, int second);

  private native String sayHelloToMe(String name, boolean isFemale);

  public native UserData createUser(String name, double balance);

  public native String printUserData(UserData user);

}
