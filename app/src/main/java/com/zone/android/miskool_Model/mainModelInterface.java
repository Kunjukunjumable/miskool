package com.zone.android.miskool_Model;

import android.content.Context;

import com.zone.android.miskool_Presenter.mainPresInterface;



public interface mainModelInterface {
    void getStudentList(mainPresInterface mainPresInterface, Context context);

    void getAlertList(mainPresInterface mainPresInterface, Context context, String stdId);
    void logout();
}
