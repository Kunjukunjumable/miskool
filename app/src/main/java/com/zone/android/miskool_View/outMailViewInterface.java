package com.zone.android.miskool_View;

import com.zone.android.miskool_Entitiy.Message_In;

import java.util.List;



public interface outMailViewInterface {

    void setMessagesServer(int errorCode);
    void deleteTablesMessageRes(int errorCode);
    void setMessages(List<Message_In> messageList);
    void showMessage(String Message);

}
