package com.zone.android.miskool_Entitiy;


import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;



@Entity
public class Attributes {

    public String getRowwwid() {
        return rowwwid;
    }

    public void setRowwwid(String rowwwid) {
        this.rowwwid = rowwwid;
    }

    @PrimaryKey
    @NonNull
String rowwwid;

private String studentId;
private String attName;
private String sttValue;

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    private String studentName;

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getAttName() {
        return attName;
    }

    public void setAttName(String attName) {
        this.attName = attName;
    }

    public String getSttValue() {
        return sttValue;
    }

    public void setSttValue(String sttValue) {
        this.sttValue = sttValue;
    }


}
