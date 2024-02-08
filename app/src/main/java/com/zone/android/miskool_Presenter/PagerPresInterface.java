package com.zone.android.miskool_Presenter;

import android.content.Context;

import com.zone.android.miskool_Entitiy.Attributes;

import java.util.List;



public interface PagerPresInterface {
    void getAttList(Context context, String StdId);
    void setAttList(List<Attributes> attList);
}
