package com.zone.android.miskool_View;

import com.zone.android.miskool_Entitiy.Person_det;
import com.zone.android.miskool_Entitiy.Schedule;

import java.util.List;



public interface mainViewInterface {

    void setStudentList(List<Person_det> person_detList);
    void setAlerts(List<Schedule> alertList);
    void logOut();

}
