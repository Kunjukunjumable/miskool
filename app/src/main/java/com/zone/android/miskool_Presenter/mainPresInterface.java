package com.zone.android.miskool_Presenter;

import android.content.Context;

import com.zone.android.miskool_Entitiy.Person_det;
import com.zone.android.miskool_Entitiy.Schedule;

import java.util.List;



public interface mainPresInterface {
    void getStudentList(Context context);
    void getAlertList(Context context, String stdId);

    void setStudentList(List<Person_det> person_dets);
    void setAlerts(List<Schedule> alertList);


}
