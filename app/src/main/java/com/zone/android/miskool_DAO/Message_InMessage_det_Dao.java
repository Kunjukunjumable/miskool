package com.zone.android.miskool_DAO;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import com.zone.android.miskool_Entitiy.Message_In;
import com.zone.android.miskool_Entitiy.Message_InMessage_det;

import java.util.List;


@Dao
public interface Message_InMessage_det_Dao {
/*@Query("select mi.message_id,mi.message_sub,md.instance_id,md.message_type,message_timeRecent,md.messages,md.message_sender,md.message_receiver " +
        "from Message_In mi left join Message_det md")List<Message_InMessage_det> fetchMessageDetails();*/

@Query("select * from Message_In")List<Message_In> fetchMessageDetails();
}
