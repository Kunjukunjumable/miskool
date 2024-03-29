package com.zone.android.miskool_Entitiy;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity
public class Person_det {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "student_id")
    private String studentId;

    @ColumnInfo(name = "first_name")
    private String firstName;

    public void setIdentitiy(String identitiy) {
        this.identitiy = identitiy;
    }

    @ColumnInfo(name = "identitiy")
    private String identitiy;


    @ColumnInfo(name = "last_name")
    private String lastName;



    public String getIdentitiy() {
        return identitiy;
    }


    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


}
