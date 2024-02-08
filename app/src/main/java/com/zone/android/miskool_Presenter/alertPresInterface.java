package com.zone.android.miskool_Presenter;

import android.content.Context;

import com.zone.android.miskool_Entitiy.Alerts;

import java.util.List;



public interface alertPresInterface {



    void deleteTablesMessage(String Student_Id, Context context);
    void deleteTablesMessageRes(int errorCode);
    void getMessageServer(String Student_Id, Context context);



    void setMessagesServer(int errorCode);
    void getAlerts(String Student_Id, Context context);
    void setMessages(List<Alerts> alertList);

}
