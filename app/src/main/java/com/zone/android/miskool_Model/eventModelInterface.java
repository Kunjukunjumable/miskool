package com.zone.android.miskool_Model;

import android.content.Context;

import com.zone.android.miskool_Entitiy.Schedule;
import com.zone.android.miskool_Presenter.eventPresInterface;



public interface eventModelInterface {
    void sentNewEvent(String Student_Id, Schedule schedule, Context context, eventPresInterface eventPresInterface);
    void sentUpEvent(String Student_Id,Schedule schedule, Context context,eventPresInterface eventPresInterface);
    void sentDelEvent(String Student_Id,Schedule schedule, Context context,eventPresInterface eventPresInterface);
}
