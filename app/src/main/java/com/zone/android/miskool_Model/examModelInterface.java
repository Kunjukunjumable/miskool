package com.zone.android.miskool_Model;

import android.content.Context;

import com.zone.android.miskool.examFragmentInterface;



public interface examModelInterface {
    void getExamDetails(String studentid, Context context, examFragmentInterface examFragmentInterface);
}
