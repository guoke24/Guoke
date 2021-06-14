package com.guohao.guoke;

import android.app.Activity;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class Test {

    public static void main(String[] args){
        Glide.with(new Activity())
                .load("")
                .into(new ImageView(new Activity()));
    }

}
