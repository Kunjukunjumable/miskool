package com.zone.android.miskool_Model;

import android.content.Context;

import com.zone.android.miskool_Presenter.alertPresInterface;



public interface alertModelInterface {

    void deleteTableMessage(String Student_Id, alertPresInterface alertPresInterface, Context context);

    void getAlertsSever(String Student_Id, alertPresInterface alertPresInterface, Context context);
    void getAlerts(String Student_Id, alertPresInterface alertPresInterface, Context context);

}
