package com.zone.android.miskool_Presenter;

import android.content.Context;

import com.zone.android.miskool_Entitiy.Message_In;

import java.util.List;



public interface replyPresInterface {

    void getMessageServer(String Student_Id, Context context);

    void getMessages(String Student_Id,String thread_id, Context context);
    void setMessages(List<Message_In> messageList);

    void sentReply(Message_In message_in, Context context);
    void showMessage(int  errorCode);



}
