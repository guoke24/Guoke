package com.guoke.baselib.singleinstance;

/**
 * 双重检查模式 DLC-double check lock
 */
public class DLCInstance {

    private static DLCInstance instance;

    private DLCInstance(){ }

    public static DLCInstance getInstance(){
        if(instance == null){
            synchronized (DLCInstance.class){
                if(instance == null)
                    instance = new DLCInstance();
            }
        }
        return instance;
    }


}
