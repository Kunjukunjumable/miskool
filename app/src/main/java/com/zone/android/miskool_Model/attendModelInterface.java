package com.zone.android.miskool_Model;

import android.content.Context;

import com.zone.android.miskool.attendFragmentInterface;


public interface attendModelInterface  {

    void getAttendanceDetails(String studentId,Context context,attendFragmentInterface attendFragmentInterface);
}
