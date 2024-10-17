package org.example;

import java.util.*;

public class SumofTwoIntegers {
    public static void main(String []args){
        int a = 2;
        int b = 3;
        System.out.println(new SumofTwoIntegers().getSum(a,b));
    }
    public int getSum(int a, int b) {
        while (b != 0) {
            int carry = a & b;
            a = a ^ b;
            b = carry << 1;
        }

        return a;
    }
}
