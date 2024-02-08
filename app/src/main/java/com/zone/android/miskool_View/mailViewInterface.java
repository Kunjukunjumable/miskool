package com.zone.android.miskool_View;

import com.zone.android.miskool_Entitiy.Message_In;

import java.util.HashMap;
import java.util.List;


public interface mailViewInterface {

    void setMailBox();


    void deleteTablesMessageRes(int errorCode);
    void updateReadFlagResponse(Message_In message_in);

    void setMessagesServer(int errorCode);
    void setMessages(List<Message_In> messageList);
    void showMessage(int error);
    void sentContacts(HashMap<String, String> contactList);

}


