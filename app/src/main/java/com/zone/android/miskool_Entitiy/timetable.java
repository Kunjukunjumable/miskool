package com.zone.android.miskool_Entitiy;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;



@Entity
public class timetable {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "date_id")
    private String dateId;

    @ColumnInfo(name = "time")
    private String time;

    public String getSub() {
        return sub;
    }

    public void setSub(String sub) {
        this.sub = sub;
    }

    @ColumnInfo(name = "sub")
    private String sub;


    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }



    public String getDateId() {
        return dateId;
    }

    public void setDateId(String dateId) {
        this.dateId = dateId;
    }




}
