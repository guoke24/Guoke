package com.guoke.algorithmlib.numtest;

import java.math.BigInteger;

public class BigNumTest {

    public static void main(String args[]){


    }

    /**
     * BigInteger是java包提供的一个大数类型，它的原理就是将大数拆分成一个int[]表示，
     * 理论上该int[]数组的长度可以无限增大（大数规定int[]长度不超过1^26），
     * 该类提供了普通整型具有的所有运算方法，包括加减乘除，与或非等。本文介绍大数的构造和基本计算原理。
     */
    public static void BigIntegerTest(){
        BigInteger bi1 = new BigInteger("123456789") ;	// 声明BigInteger对象
        BigInteger bi2 = new BigInteger("987654321") ;	// 声明BigInteger对象
        System.out.println("加法操作：" + bi2.add(bi1)) ;	// 加法操作
        System.out.println("减法操作：" + bi2.subtract(bi1)) ;	// 减法操作
        System.out.println("乘法操作：" + bi2.multiply(bi1)) ;	// 乘法操作
        System.out.println("除法操作：" + bi2.divide(bi1)) ;	// 除法操作
        System.out.println("最大数：" + bi2.max(bi1)) ;	 // 求出最大数
        System.out.println("最小数：" + bi2.min(bi1)) ;	 // 求出最小数
        BigInteger result[] = bi2.divideAndRemainder(bi1) ;	// 求出余数的除法操作
        System.out.println("商是：" + result[0] +
                "；余数是：" + result[1]) ;
    }

}
