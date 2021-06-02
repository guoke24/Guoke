package com.guoke.baselib.picutils;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.util.LruCache;
import android.widget.ImageView;

import com.guoke.baselib.R;

public class PicTest1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pic_test1);
        loadBitmap(R.drawable.avatar_rengwuxian,findViewById(R.id.img_1));
    }

    public void loadBitmap(int resId, ImageView imageView) {
        final String imageKey = String.valueOf(resId);
        // 先尝试从缓存中获取
        final Bitmap bitmap = LruCacheUtils.getBitmapFromMemCache(imageKey);
        if (bitmap != null) {
            imageView.setImageBitmap(bitmap);
        } else {
            // 缓存没有，再去加载资源
            imageView.setImageResource(R.drawable.cat);
            getWindow().getDecorView().postDelayed(()->{
                new BitmapWorkerTask(imageView).execute(resId);
            },2000);

        }
    }

    class BitmapWorkerTask extends AsyncTask<Integer, Void, Bitmap> {

        private ImageView mImageView;

        public BitmapWorkerTask(ImageView imageView){
            mImageView = imageView;
        }

        // Decode image in background.
        @Override
        protected Bitmap doInBackground(Integer... params) {
            int w = mImageView.getRight() - mImageView.getLeft();
            int h = mImageView.getBottom() - mImageView.getTop();
            Log.i("guohao","w = " + w + " h = " + h);
            Log.i("guohao","mImageView.getWidth() " + mImageView.getWidth() + " mImageView.getHeight() = " + mImageView.getHeight());
            final Bitmap bitmap = BitMapUtils.decodeSampledBitmapFromResource(
                    getResources(), params[0],mImageView.getWidth(), mImageView.getHeight());
            LruCacheUtils.addBitmapToMemoryCache(String.valueOf(params[0]), bitmap);
            return bitmap;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            if(mImageView != null) mImageView.setImageBitmap(bitmap);
        }
    }

}

