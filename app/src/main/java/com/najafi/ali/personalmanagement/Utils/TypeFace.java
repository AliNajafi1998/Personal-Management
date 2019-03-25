package com.najafi.ali.personalmanagement.Utils;

import android.content.Context;
import android.graphics.Typeface;

public class TypeFace {

    public static Typeface createTypeFaceIransansmobile(Context context){
        return Typeface.createFromAsset(context.getResources().getAssets(), "iransansmobile.ttf");
    }
}
