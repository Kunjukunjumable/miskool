package com.zone.android.miskool_Presenter;

import android.content.Context;

import com.zone.android.miskool_Entitiy.Schedule;


public interface eventPresInterface {
    void sentNewEvent(String Student_Id, Schedule schedule, Context context);
    void sentUpEvent(String Student_Id,Schedule schedule, Context context);
    void sentDelEvent(String Student_Id,Schedule schedule, Context context);

    void sentResponse(int errorCode);



}
