package com.zone.android.miskool_DAO;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.zone.android.miskool_Entitiy.Bus_Route;
import com.zone.android.miskool_Entitiy.Message_In;

import java.util.List;


@Dao
public interface BusRoute_Dao {

    @Query("SELECT * FROM Bus_Route")
    List<Bus_Route> getAll();


    @Query("SELECT * FROM Bus_Route")
    List<Bus_Route> getAllRoutes();

    @Query("SELECT * FROM Bus_Route where student_id = :studentId")
    List<Bus_Route> getRoutesOfStudent(String studentId);

   /* @Query("SELECT stop_no,stop_lat,stop_lon FROM Bus_Route where student_id = :studentId ORDER BY stop_no ASC")
    List<Bus_Route> getBusStopsOfStudent(String studentId);*/



    @Insert
    void insertAll(Bus_Route... routes);
}
