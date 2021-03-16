package com.guohao.guoke.algorithm.numtest;

public class NumTest1 {

    /**
     * 正数、负数的二进制表示
     * 负数用补码，为了二进制计算时，在 0 到 -1，Integer.MAX_VALUE 到 Integer.MIN_VALUE 衔接自然自然
     * @param args
     */
    public static void main(String args[]){
        int a = Integer.MAX_VALUE;

        System.out.println(a);
        System.out.println(Integer.toBinaryString(a ));

        System.out.println(" ");

        System.out.println(a + 1);
        System.out.println(Integer.toBinaryString(a + 1));

        System.out.println(" ");

        System.out.println(a + 2);
        System.out.println(Integer.toBinaryString(a + 2));

        System.out.println(" ");

        System.out.println(a + 3);
        System.out.println(Integer.toBinaryString(a + 3));

        System.out.println(" ");

        System.out.println(-1);
        System.out.println(Integer.toBinaryString(-1));

        System.out.println(" ");

        System.out.println(-2);
        System.out.println(Integer.toBinaryString(-2));

    }

}
