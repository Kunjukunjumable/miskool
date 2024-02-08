package com.zone.android.miskool_Presenter;

import android.content.Context;

import com.zone.android.miskool_Entitiy.Person_det;

import java.util.List;



public interface informationPresInterface {

    void getPersonList(Context context);

    void setList(List<Person_det> person_dets);


}
