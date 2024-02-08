package com.zone.android.miskool_View;

import com.zone.android.miskool_Entitiy.Alerts;

import java.util.List;



public interface alertViewInterface {

    void deleteTableMessageResp(int errorcode);
    void setMessagesServer(int errorCode);
    void setMessages(List<Alerts> alertList);

}
