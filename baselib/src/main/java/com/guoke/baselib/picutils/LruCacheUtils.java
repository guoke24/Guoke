package com.guoke.baselib.picutils;

import android.graphics.Bitmap;
import android.util.LruCache;

public class LruCacheUtils {

    private static volatile LruCache<String, Bitmap> memoryCache;

    private static void initLruCache(){
        // Get max available VM memory, exceeding this amount will throw an
        // OutOfMemory exception. Stored in kilobytes as LruCache takes an
        // int in its constructor.
        final int maxMemory = (int) (Runtime.getRuntime().maxMemory() / 1024); // 以 kb 为单位

        // Use 1/8th of the available memory for this memory cache.
        final int cacheSize = maxMemory / 8;

        memoryCache = new LruCache<String, Bitmap>(cacheSize) {
            @Override
            protected int sizeOf(String key, Bitmap bitmap) {
                // The cache size will be measured in kilobytes(以 kb 为单位) rather than
                // number of items.
                return bitmap.getByteCount() / 1024;
            }
        };
    }

    /**
     * DLC 的单例模式
     */
    private static LruCache<String, Bitmap> getMemoryCache(){
        if(memoryCache == null){
            synchronized (LruCacheUtils.class){
                if(memoryCache == null){
                    initLruCache();
                }
            }
        }
        return memoryCache;
    }

    /**
     * 存一个 BitMap 到缓存
     * @param key
     * @param bitmap
     */
    public static void addBitmapToMemoryCache(String key, Bitmap bitmap) {
        if (getBitmapFromMemCache(key) == null) {
            getMemoryCache().put(key, bitmap);
        }
    }

    /**
     * 从缓存获取一个 BitMap
     * @param key
     * @return
     */
    public static Bitmap getBitmapFromMemCache(String key) {
        return getMemoryCache().get(key);
    }

}
