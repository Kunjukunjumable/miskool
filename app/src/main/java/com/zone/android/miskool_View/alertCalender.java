package com.zone.android.miskool_View;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.CalendarView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.zone.android.miskool.R;
import com.zone.android.miskool_Entitiy.Alerts;
import com.zone.android.miskool_Presenter.alertPresClass;
import com.zone.android.miskool_Util.Constants;

import java.util.ArrayList;
import java.util.List;

public class alertCalender extends AppCompatActivity implements alertViewInterface {

    CalendarView calendarView;
    com.zone.android.miskool_Presenter.alertPresInterface alertPresInterface;
    SharedPreferences studentPreference;
    String StudenId;
    private List<Alerts> alertsList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_calender);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Alerts");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        calendarView=(CalendarView)findViewById(R.id.calendarView);

        alertsList = new ArrayList<>();

        alertPresInterface=new alertPresClass(this);

        studentPreference = getApplicationContext().getSharedPreferences(Constants.STUDENT_SELECTION_PREFERENCE, Context.MODE_PRIVATE);
        StudenId = studentPreference.getString("studentid", "");


        alertPresInterface.getAlerts(StudenId,this);





    }

    @Override
    public void deleteTableMessageResp(int errorcode) {

    }

    @Override
    public void setMessagesServer(int errorCode) {

    }

    @Override
    public void setMessages(List<Alerts> alertList) {

       // calendarView.add
    }
}
