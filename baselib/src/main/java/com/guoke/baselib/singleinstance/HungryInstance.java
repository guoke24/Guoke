package com.guoke.baselib.singleinstance;

/**
 * 饿汉模式，类加载的时候就创建
 *
 * 该方式在类加载时就完成了初始化，所以 类加载较慢，但获取对象的速度快 。
 */
public class HungryInstance {

    // 杠精问题：类加载的哪一步，会创建此对象？
    // 答：发生在类的初始化阶段，该阶段会对静态字段赋值。
    // new + 构造函数，则是在初始化之后执行的。
    private static HungryInstance instance = new HungryInstance();

    public static HungryInstance getInstance(){
        return instance;
    }

}
