package org.example;

public class PrimitiveDataTypes {
    public static void main(String[] args) {
        int num111 = 0x6F;
        System.out.println(num111);
        int num8 = 010;
        System.out.println(num8);
        int num13 = 0b1101;
        System.out.println(num13);
        int x = 123_456;
        System.out.println(x);
        char ch = 102;
        System.out.println(ch);
        char ch2 = '\u0066';
        System.out.println(ch2);
        long l = 2L;
        System.out.println(Long.toBinaryString((long) l));
        printBit(l);
    }
    public static void printBit(long l){
        for (int i =10; i >=0; i--) {
            long thirdBit=(l>>i)&1;
            System.out.print(thirdBit);
        }
    }
}
