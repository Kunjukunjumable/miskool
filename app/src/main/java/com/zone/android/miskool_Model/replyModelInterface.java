package com.zone.android.miskool_Model;

import android.content.Context;

import com.zone.android.miskool_Entitiy.Message_In;
import com.zone.android.miskool_Presenter.replyPresInterface;



public interface replyModelInterface {

    void getMessagesServer(String Student_Id,String thread_id, replyPresInterface replyPresInterface, Context context);
    void getMessages(String Student_Id,String thread_id, replyPresInterface replyPresInterface, Context context);
    void sentReply(Message_In message_in, Context context, replyPresInterface replyPresInterface);


}
