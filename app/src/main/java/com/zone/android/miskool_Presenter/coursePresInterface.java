package com.zone.android.miskool_Presenter;

import android.content.Context;



public interface coursePresInterface {

    //getting
    void getTimeTable(Context context,String stdId);
    void getAttendance(Context context, String stdId);
    void getHomeWork(Context context, String stdId);
    void getExam(Context context, String stdId);

//setting

    void setTimetable();
    void setAttendance();
    void setHomework();
    void setExam();

}
