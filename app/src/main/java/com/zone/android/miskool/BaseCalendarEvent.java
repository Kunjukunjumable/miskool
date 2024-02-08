package com.zone.android.miskool;

import java.sql.Time;

public class BaseCalendarEvent {

    long mId;
    int mColor;
    boolean mAllDay;
    String mDuration;
    String mTitle;
    String mDescription;
    String mLocation;
    Time mStartTime;
    long mEndTime;

    public BaseCalendarEvent(long id, int color, String title, String description, String location, long dateStart, long dateEnd, int allDay, String duration) {
        this.mId = id;
        this.mColor = color;
        this.mAllDay = (allDay == 1) ? true : false;
        this.mDuration = duration;
        this.mTitle = title;
        this.mDescription = description;
        this.mLocation = location;

      /*  this.mStartTime = Calendar.getInstance();
        this.mStartTime.setTimeInMillis(dateStart);
        this.mEndTime = Calendar.getInstance();
        this.mEndTime.setTimeInMillis(dateEnd);*/
    }
}
