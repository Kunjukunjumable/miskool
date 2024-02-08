package com.zone.android.miskool_Model;

import android.content.Context;

import com.zone.android.miskool_Presenter.coursePresInterface;


public class courseModelClass implements cpurseModelInterface {
    @Override
    public void getTimeTable(coursePresInterface coursePresInterface, Context context, String stdId) {
        coursePresInterface.setTimetable();
    }

    @Override
    public void getAttendance(coursePresInterface coursePresInterface, Context context, String stdId) {

    }

    @Override
    public void getHomeWork(coursePresInterface coursePresInterface, Context context, String stdId) {

    }

    @Override
    public void getExam(coursePresInterface coursePresInterface, Context context, String stdId) {

    }
}
