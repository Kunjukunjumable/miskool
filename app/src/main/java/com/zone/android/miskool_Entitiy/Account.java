package com.zone.android.miskool_Entitiy;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;



@Entity
public class Account {

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "person_id")
    private String personId;

    @ColumnInfo(name = "person_name")
    private String personName;


}
