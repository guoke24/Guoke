package com.guoke.baselib.singleinstance;

public class UseTest {

    public static void main(String[] args) {

        DLCInstance.getInstance();
        //new DLCInstance(); // 报错


        StaticInstance.Holder.getInstance();
        //new StaticInstance(); // 报错
    }

}
