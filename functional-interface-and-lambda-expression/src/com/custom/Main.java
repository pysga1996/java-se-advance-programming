package com.custom;

public class Main {
    // Traditional Way
    private static final Factorial<Integer> factorial1 = new Factorial<Integer>() {
        @Override
        public Integer produce(Integer x) {
            if (x == 1) {
                return 1;
            } else {
                return x * Main.factorial1.produce(x - 1);
            }
        }
    };

    // lambda with functional interface
    private static final Factorial<Integer> factorial2 = x -> {
        if (x == 1) {
            return 1;
        } else {
            return x * Main.factorial2.produce(x - 1);
        }
    };

    public static void main(String[] args) {
	// write your code here
        int a = 10;
        int result1 = factorial1.produce(a);
        System.out.println(result1);
        int result2 = factorial2.produce(a);
        System.out.println(result2);
        System.out.println("Same result!!!");
    }
}
