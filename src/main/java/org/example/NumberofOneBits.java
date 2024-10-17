package org.example;
/**
 * Write a function that takes the binary representation of a positive integer and returns the number of
 * set bits
 *  it has (also known as the Hamming weight).
 *
 *
 *
 * Example 1:
 *
 * Input: n = 11
 *
 * Output: 3
 *
 * Explanation:
 *
 * The input binary string 1011 has a total of three set bits.
 *
 * Example 2:
 *
 * Input: n = 128
 *
 * Output: 1
 *
 * Explanation:
 *
 * The input binary string 10000000 has a total of one set bit.
 *
 * Example 3:
 *
 * Input: n = 2147483645
 *
 * Output: 30
 * */
public class NumberofOneBits {
    public static void main(String []args){
        int n = 11;
        int a = 128;
        int b = 2147483645;
        System.out.println(new NumberofOneBits().hammingWeight(b));
    }
    public int hammingWeight(int n) {
       int cont =0;
       while(n!=0){
           n = n & (n - 1);
           cont++;
       }

        return cont;
    }
}
