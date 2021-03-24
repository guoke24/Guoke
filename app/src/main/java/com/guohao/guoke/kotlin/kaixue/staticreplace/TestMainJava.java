package com.guohao.guoke.kotlin.kaixue.staticreplace;

public class TestMainJava {

    public static void main(String[] args) {
        TestObject.INSTANCE.cry();
        TestObject.INSTANCE.getName();

        TestObject2.Inner.INSTANCE.getName();
        TestObject2.Inner.INSTANCE.innerFun();

        //TestCompanion.Companion.getSname();
        TestCompanion.Companion.companionFun();

    }

}
