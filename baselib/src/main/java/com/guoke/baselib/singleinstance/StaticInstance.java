package com.guoke.baselib.singleinstance;

/**
 * 静态累内部类的单例模式
 *
 * getInstance 函数可以放在内部类，也可放在外部类
 */
public class StaticInstance {

    private StaticInstance(){}

    public static class Holder{

        private static StaticInstance instance = new StaticInstance();

        // 获取单例的方法，放在内部类
        public static StaticInstance getInstance(){
            return instance;
        }

    }

}

// getInstance 函数放在外部类的写法
class StaticInstance2 {

    private StaticInstance2(){}

    // 获取单例的方法，放在外部类
    public static StaticInstance2 getInstance(){
        return Holder.instance;
    }

    private static class Holder{

        private static StaticInstance2 instance = new StaticInstance2();

    }

}