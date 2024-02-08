package com.zone.android.miskool_Presenter;

import android.content.Context;

import com.zone.android.miskool_Entitiy.Person_det;
import com.zone.android.miskool_Entitiy.Schedule;
import com.zone.android.miskool_Model.mainModelClass;
import com.zone.android.miskool_Model.mainModelInterface;
import com.zone.android.miskool_View.mainViewInterface;

import java.util.List;


public class mainPresClass implements mainPresInterface {
    mainViewInterface mainViewInterface;
    mainModelInterface mainModelInterface;

    public mainPresClass(mainViewInterface mainViewInterface){
      this.mainViewInterface=mainViewInterface;
      this.mainModelInterface=new mainModelClass();
    }

    @Override
    public void getStudentList(Context context) {

        mainModelInterface.getStudentList(this,context);
    }

    @Override
    public void getAlertList(Context context, String stdId) {
        mainModelInterface.getAlertList(this,context,stdId);
    }

    @Override
    public void setStudentList(List<Person_det> person_detList) {

        mainViewInterface.setStudentList(person_detList);

    }

    @Override
    public void setAlerts(List<Schedule> alertList) {

        mainViewInterface.setAlerts(alertList);
    }
}
