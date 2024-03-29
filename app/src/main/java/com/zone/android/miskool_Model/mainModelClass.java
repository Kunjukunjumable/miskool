package com.zone.android.miskool_Model;

import android.content.Context;
import android.util.Log;

import com.zone.android.miskool_Entitiy.AlarmModel;
import com.zone.android.miskool_Entitiy.Alerts;
import com.zone.android.miskool_Entitiy.Person_det;
import com.zone.android.miskool_Entitiy.Schedule;
import com.zone.android.miskool_Presenter.mainPresInterface;
import com.zone.android.miskool_Util.Methods;
import com.zone.android.miskool_db.AppDatabase;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;



public class mainModelClass implements mainModelInterface {


    @Override
    public void getStudentList(final mainPresInterface mainPresInterface, final Context context) {

        new Thread(new Runnable() {
            @Override
            public void run() {

                AppDatabase appdb = AppDatabase.getAppDatabase(context);
                List<Person_det> stlist1 =appdb.person_dao().getPersonDetails();

                Log.e("stlist1 ","stlist1 "+stlist1.size());

                //getAlertsForFuture(context);

                mainPresInterface.setStudentList(stlist1);


            }
        }).start();
    }

    @Override
    public void getAlertList(final mainPresInterface mainPresInterface, final Context context, final String stdId) {

        new Thread(new Runnable() {
            @Override
            public void run() {

                Calendar c = Calendar.getInstance();
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String curDateTime = df.format(c.getTime());

                AppDatabase appdb = AppDatabase.getAppDatabase(context);

                List<Schedule> scheduleList=appdb.schedule_dao().getSelEventTime("true","True",stdId,curDateTime);


                Log.e("isSetAlert", "isSetAlert " + scheduleList.size());


               /* for(int i=0;i<scheduleList.size();i++) {
                    try {

                        //     String dateofalarm = "2018-06-28 11:30:20";

                        Schedule schedule = new Schedule();

                        schedule = scheduleList.get(i);


                        String dateofalarm = scheduleList.get(i).getEndtime();


                        //getting date new
                        SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
                        String curDateTime1 = df1.format(c.getTime());


                        Date Curdate = df1.parse(curDateTime1);
                        Date alertDate = df1.parse(dateofalarm);

                        //date time
                        Date CurdateTime = df.parse(curDateTime);
                        Date alertDateTime = df.parse(dateofalarm);

                        Log.e("isSetAlert", "isSetAlert " );

                        boolean isSetAlert = false;

                        if (alertDate.after(Curdate)) {
                            isSetAlert = true;


                        } else if (Curdate == alertDate) {

                            isSetAlert = isDifferent(Curdate, alertDate);
                        } else {
                            isSetAlert = false;
                        }


                        Log.e("isSetAlert", "isSetAlert " + isSetAlert);

                        Log.e("isSetAlert", "isSetAlert " + isSetAlert);



                        if (isSetAlert) {
                            scheduleListNew.add(alerttoadd);
                        }
                    }catch(Exception e){
                        e.printStackTrace();
                    }

                }*/

                mainPresInterface.setAlerts(scheduleList);


            }
        }).start();
    }

    @Override
    public void logout() {

    }

    public void checkdateTest(List<Alerts> alertList, Context context){

        List<Alerts> alertListNew = new ArrayList<>();

        try{

            for(int i=0;i<alertList.size();i++) {

           //     String dateofalarm = "2018-06-28 11:30:20";

                Alerts alerttoadd= new Alerts();

                alerttoadd=alertList.get(i);

                String dateofalarm = alertList.get(i).getAlertDate();
                String alertSub = alertList.get(i).getAlertSub();
                String message = alertList.get(i).getAlertMsg();

                Calendar c = Calendar.getInstance();
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String curDateTime = df.format(c.getTime());

                Date Curdate = df.parse(curDateTime);
                Date alertDate = df.parse(dateofalarm);

                Log.e("isSetAlertCurdate", "isSetAlertCurdate " + Curdate +" "+alertDate);

                boolean isSetAlert = false;

                if (alertDate.after(Curdate)) {
                    isSetAlert = true;
                } else if (Curdate == alertDate) {

                    isSetAlert = isDifferent(Curdate, alertDate);
                } else {
                    isSetAlert = false;
                }


                Log.e("isSetAlert", "isSetAlert " + isSetAlert);

                Log.e("isSetAlert", "isSetAlert " + isSetAlert);


                if(isSetAlert){

                  // alertListNew.add(alerttoadd);
                    AlarmModel alarmobj = Methods.convertTimeStamp(dateofalarm);
                    Methods.scheduleNotification(Methods.getNotification(message, alertSub, context), context, alarmobj);
                }
            //  Thread.sleep(1000);

            }
           // mainPresInterface.setAlerts(alertListNew);

        }catch (Exception e){

            e.printStackTrace();
        }
    }

    public boolean isDifferent(Date startDate, Date endDate) {
        //milliseconds


        boolean isdiff=false;
        long different = endDate.getTime() - startDate.getTime();

        System.out.println("startDate : " + startDate);
        System.out.println("endDate : "+ endDate);
        System.out.println("different : " + different);

        long secondsInMilli = 1000;
        long minutesInMilli = secondsInMilli * 60;
        long hoursInMilli = minutesInMilli * 60;
        long daysInMilli = hoursInMilli * 24;

        long elapsedDays = different / daysInMilli;
        different = different % daysInMilli;

        long elapsedHours = different / hoursInMilli;
        different = different % hoursInMilli;

        long elapsedMinutes = different / minutesInMilli;
        different = different % minutesInMilli;

        long elapsedSeconds = different / secondsInMilli;

        System.out.printf(
                "%d days, %d hours, %d minutes, %d seconds%n",
                elapsedDays, elapsedHours, elapsedMinutes, elapsedSeconds);


        if(elapsedMinutes>5){

            isdiff=true;
        }else{

            isdiff=false;
        }

       return isdiff;
    }


    public static void getAlertsForFuture(Context context){
        try {


            Alerts alerts = new Alerts();
            AppDatabase appdb = AppDatabase.getAppDatabase(context);
            List<Alerts> alertList1 = appdb.alerts_dao().getAlerts();

            for (int i = 0; i < alertList1.size(); i++) {
                String alertId = alertList1.get(i).getAlertId();
                String studentId = alertList1.get(i).getStudentId();
                String dateofalarm = alertList1.get(i).getAlertDate();


          /*  String alertSub=alertList1.get(i).getAlertSub();
            String message=alertList1.get(i).getAlertMsg();
         */

                Calendar c = Calendar.getInstance();
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String curDateTime = df.format(c.getTime());

                Date Curdate = df.parse(curDateTime);
                Date alertDate=df.parse(dateofalarm);


                if (Curdate.after(alertDate)) {
                   // your_date_is_outdated = true;
                }
                else{
                  //  your_date_is_outdated = false;
                }


                String alertSub = "miSkool alerts";
                String message = "Fee due on coming saturday";

                AlarmModel alarmobj = Methods.convertTimeStamp(dateofalarm);

                Methods.scheduleNotification(Methods.getNotification(message, alertSub, context), context, alarmobj);


            }

        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
