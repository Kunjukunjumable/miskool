package com.zone.android.miskool_DAO;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import com.zone.android.miskool_Entitiy.Config_det;
import com.zone.android.miskool_Entitiy.timetable;

import java.util.List;



@Dao
public interface timetable_Dao {

    @Query("SELECT * FROM timetable")
    List<timetable> getAll();


    @Query("SELECT * FROM timetable")
    List<timetable> getAllMessages();
}
