package com.guohao.guoke.algorithm.stringtest;

public class StringTest1 {

    /**
     * 测试 String 的实例，
     * 没有 new 或 不涉及实例拼接的，则直接引用常量池，
     * 使用来 new，或者拼接来实例，则在堆中创建对象
     * 还可以用 intern() 方法来返回常量池中的对象引用
     *
     * "==" 检查两个变量的地址；
     * equals方法检测两个字符串的值是否相等；
     *
     * @param args
     */
    public static void main(String args[]){

        String s1 = "123";
        String s2 = "123";
        // 没有使用 new，则直接指向常量池中的 "123"

        String s3 = new String("123");
        // 使用 new，则在堆中创建一个 String 实例，内部的字段再指向常量池的"123"

        System.out.println("\n常量和堆实例的比较：");
        System.out.println(s1 == s2);// true
        System.out.println(s1 == s3);// false

        // 拼接
        String s4 = "123" + "123";// 被编译器折叠成 "123123"，指向常量池
        String s7 = "123123";
        String s5 = s1 + "123"; // 一个新的 String 实例
        String s6 = s1 + s2;   // 一个新的 String 实例
        // 拼接涉及堆上的 String 实例，采用 StringBuilder 来拼接，并最终 new String 返回

        System.out.println("\n拼接测试：");
        System.out.println(s4 == s7);// true
        System.out.println(s4 == s5);// false
        System.out.println(s4 == s6);// false
        System.out.println(s5 == s6);// false

        // String类提供了 intern() 方法来返回与当前字符串内容相同但已经被包含在常量池中的对象引用
        System.out.println("\nintern() 测试：");
        System.out.println(s4 == s5.intern());// false
        System.out.println(s4 == s6.intern());// false
        System.out.println(s5.intern() == s6.intern());// false

        // hashcode 是一致的，根据 string 的具体指来算的
        System.out.println("\nhashcode 测试：");
        System.out.println(s4.hashCode());
        System.out.println(s5.hashCode());
        System.out.println(s6.hashCode());
        System.out.println(s7.hashCode());
    }

}
