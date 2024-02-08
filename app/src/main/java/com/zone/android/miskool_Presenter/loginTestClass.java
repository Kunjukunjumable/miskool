package com.zone.android.miskool_Presenter;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.zone.android.miskool.R;
import com.zone.android.miskool_Entitiy.Attributes;
import com.zone.android.miskool_Entitiy.Message;
import com.zone.android.miskool_Entitiy.Message_In;
import com.zone.android.miskool_Entitiy.Message_InMessage_det;
import com.zone.android.miskool_Entitiy.Message_det;
import com.zone.android.miskool_db.AppDatabase;

import org.ocpsoft.prettytime.PrettyTime;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.nio.channels.FileChannel;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;



public class loginTestClass extends AppCompatActivity {

    private static final int PERMISSIONS_REQUEST_WRITE_EXTERNAL_STORAGE = 1;
    private boolean mLocationPermissionGranted;
    //REQUEST_CHECK_SETTINGS
    private static final int REQUEST_CHECK_SETTINGS = 2;
    EditText editText;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loxx);

        Button message = (Button)(findViewById(R.id.button2));
        editText=(EditText)findViewById(R.id.editText);

       // getLocationPermission();


        message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
          new Thread(new Runnable() {
              @Override
              public void run() {


                  convertPrettyTime(editText.getText().toString());

                populateWithAtts(AppDatabase.getAppDatabase(loginTestClass.this));

          copyFile();

                //  populateWithTestData(AppDatabase.getAppDatabase(loginTestClass.this));

                 // populateWithMessagedetails(AppDatabase.getAppDatabase(loginTestClass.this));

                //  insertMessages(AppDatabase.getAppDatabase(loginTestClass.this));
                //  insertMessages1(AppDatabase.getAppDatabase(loginTestClass.this));
                 // insertMessages2(AppDatabase.getAppDatabase(loginTestClass.this));



                /*  AppDatabase appdb = AppDatabase.getAppDatabase(getApplicationContext());

                  List<Message_In> listone;*/

                //  listone=appdb.messageIn_dao().getAll();

//                  Log.e("listonedetails  ","listonedetails" +listone.get(0).getMessageSub());

                 // List<Message_InMessage_det> inoutlist;

                //  inoutlist=appdb.inMessage_det_dao().fetchMessageDetails();


                /* copyFile();

                  //Instance 1
                  AppDatabase instance1 = AppDatabase.getAppDatabase(getApplicationContext());

                  //Instance 2
                  AppDatabase instance2 = AppDatabase.getAppDatabase(getApplicationContext());


                  //now lets check the hash key.
                  System.out.println("Instance 1 hash:" + instance1.hashCode());
                  System.out.println("Instance 2 hash:" + instance2.hashCode());*/




              }
          }).start();
            }
        });
    }


    private static Message_In addUser(final AppDatabase db, Message_In msg) {
        db.messageIn_dao().insertAll(msg);
        return msg;
    }

    private static void populateWithTestData(AppDatabase db) {
        Message_In msg = new Message_In();
        msg.setMessageInId("msg1");
        msg.setMessageDateOfCreated(("15/01/18"));
        msg.setMessageSub("Assignment Submission");
       // msg.setMessageCont("Assignment submission due on 10/03/2018");
        addUser(db, msg);
    }


    private static Message_det addUserDEt(final AppDatabase db, Message_det msg) {
        db.messagedet_Dao().insertAll(msg);
        return msg;
    }

    private static Message addMessages(final AppDatabase db, Message msg) {
        db.message_dao().insertAll(msg);
        return msg;
    }

    private static Attributes addAtts(final AppDatabase db, Attributes atts) {
        db.attribute_dao().insertAll(atts);
        return atts;
    }


    public void convertPrettyTime(String date){

       // String dateString="2018-04-23 15:00:47";

        String dateString=date;

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss");

        java.util.Date convertedDate = new java.util.Date();


        try {
            convertedDate = dateFormat.parse(dateString);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        PrettyTime p  = new PrettyTime();

        String datetime= p.format(convertedDate);

        Log.e("loggedDate","loggedDate "+datetime);

    }

    private static void populateWithMessagedetails(AppDatabase db) {
        Message_det msg = new Message_det();
        msg.setInstanceId("msg12");
        msg.setMsgId(("msg1"));
        msg.setMessages("Sir,  \n Please mention on ; \n Where can we find the details on topics \n Thanks \n Mable");
        msg.setMessageSender("Me");
        msg.setMessageReceiver("to Admin");
        msg.setMessageTyp("Out");
        msg.setMessageTimRec("16/01/18");
        addUserDEt(db, msg);
    }

    private static void populateWithAtts(AppDatabase db) {

        Log.e("populateWithAtts","populateWithAtts");
        Attributes atts = new Attributes();


       //adding parent mable

        ArrayList<String> AttsName=new ArrayList<>();
        AttsName.add("Identitiy");
        AttsName.add("NoOfChild");
        AttsName.add("Place");
        AttsName.add("Occupation");
        AttsName.add("Phone No");


        ArrayList<String> AttsVal=new ArrayList<>();
        AttsVal.add("Parent");
        AttsVal.add("2");
        AttsVal.add("Perumbavoor");
        AttsVal.add("Teacher");
        AttsVal.add("0484-2594330");


        for(int i=0;i<AttsName.size();i++){
            atts.setStudentId("94f3137c-a613-47c5-8e14-5528000f38d2");
            atts.setAttName(AttsName.get(i));
            atts.setSttValue(AttsVal.get(i));
            addAtts(db, atts);
        }



        //adding child one amble1
       ArrayList<String> AttsName1=new ArrayList<>();
        AttsName1.add("Identitiy");
        AttsName1.add("Place");
        AttsName1.add("Dept");
        AttsName1.add("DIV");
        AttsName1.add("ClassTeacher");
        AttsName1.add("TeacherPh");


        ArrayList<String> AttsVal1=new ArrayList<>();
        AttsVal1.add("Child");
        AttsVal1.add("Perumbavoor");
        AttsVal1.add("LKG");
        AttsVal1.add("Orchid");
        AttsVal1.add("Renni");
        AttsVal1.add("9745696626");

        for(int i=0;i<AttsName1.size();i++){
            atts.setStudentId("2456a8bd-7573-4122-931e-60c629c4ca7a");
            atts.setAttName(AttsName1.get(i));
            atts.setSttValue(AttsVal1.get(i));
            addAtts(db, atts);
        }



        //adding child 2 anju1

        ArrayList<String> AttsName2=new ArrayList<>();
        AttsName2.add("Identitiy");
        AttsName2.add("Place");
        AttsName2.add("Dept");
        AttsName2.add("DIV");
        AttsName2.add("ClassTeacher");
        AttsName2.add("TeacherPh");

        ArrayList<String> AttsVal2=new ArrayList<>();
        AttsVal2.add("Child");
        AttsVal2.add("Perumbavoor");
        AttsVal2.add("UKG");
        AttsVal2.add("Saphire");
        AttsVal2.add("Pathmini");
        AttsVal2.add("7034696975");



        for(int i=0;i<AttsName2.size();i++){
          atts.setStudentId("08b5e4ff-41b8-45fa-8696-f1bebfa1f80c");
          atts.setAttName(AttsName2.get(i));
          atts.setSttValue(AttsVal2.get(i));
          addAtts(db, atts);
         }



    }





    private static void insertMessages(AppDatabase db) {
        Message msg = new Message();
        msg.setMessageId("1");
        msg.setThreadId("1");
        msg.setStudentId("ST001");
        msg.setMessageCreated("2018:03:01:10:15:30");
        msg.setMessageType("IN");
        msg.setMessageSub("Assignment Submission");
        msg.setMessages("assignment submission due on 2018:03:15");
        msg.setMessageTimRec("2018:03:01:10:15:30");
        msg.setMessageSender("ADMIN");
        msg.setMessageReceiver("ME");

        addMessages(db, msg);
    }

    private static void insertMessages1(AppDatabase db) {
        Message msg = new Message();
        msg.setMessageId("2");
        msg.setThreadId("2");
        msg.setStudentId("ST001");
        msg.setMessageCreated("2018:03:02:10:15:30");
        msg.setMessageType("IN");
        msg.setMessageSub("Fee Due");
        msg.setMessages("Fee due on 2018:03:16");
        msg.setMessageTimRec("2018:03:02:10:15:30");
        msg.setMessageSender("ADMIN");
        msg.setMessageReceiver("ME");

        addMessages(db, msg);
    }

    private static void insertMessages2(AppDatabase db) {
        Message msg = new Message();
        msg.setMessageId("3");
        msg.setThreadId("2");
        msg.setStudentId("ST001");
        msg.setMessageCreated("2018:03:02:10:15:30");
        msg.setMessageType("OUT");
        msg.setMessageSub("Fee Due");
        msg.setMessages("Last date for submission");
        msg.setMessageTimRec("2018:03:03:11:15:30");
        msg.setMessageSender("ME");
        msg.setMessageReceiver("ADMIN");

        addMessages(db, msg);
    }


    public  void copyFile()
    {
        try
        {
            File sd = Environment.getExternalStorageDirectory();
            File data = Environment.getDataDirectory();

            /////////////////////////////////////////////////////////////////////////
            File outDir = new File( sd.getAbsolutePath() + File.separator + "MiSkool" );
            if ( !outDir.isDirectory() )
            {
                outDir.mkdir();
            }


            OutputStreamWriter outStreamWriter = null;
            FileOutputStream outStream = null;

            File out;


            SimpleDateFormat sdf = new SimpleDateFormat( "dd-MM-yyyy" );
            SimpleDateFormat TimeFormat = new SimpleDateFormat( "HH:mm" );
            Calendar cal = Calendar.getInstance();
            String Currentdate = sdf.format( cal.getTime() );
            String CurrentTime = TimeFormat.format( cal.getTime() );

           // out = new File( new File( outDir.getAbsolutePath() ), "miskool_db" + "_" + Currentdate );

            out =  new File( outDir.getAbsolutePath());

            if ( out.exists() == false )
            {
                out.createNewFile();
            }


            if (sd.canWrite())
            {
                String currentDBPath = "//data//"+getPackageName()+"//databases//"+"miskool-database";

                String backupDBPath = "miskool-database";
                File currentDB = new File(data, currentDBPath);
                File backupDB = new File(out, backupDBPath+"_"+Currentdate );

                if (currentDB.exists()) {
                    FileChannel src = new FileInputStream(currentDB).getChannel();
                    FileChannel dst = new FileOutputStream(backupDB).getChannel();
                    dst.transferFrom(src, 0, src.size());
                    src.close();
                    dst.close();
                }

               /* if(bool == true)
                {
                    Toast.makeText(Settings.this, "Backup Complete", Toast.LENGTH_SHORT).show();
                    bool = false;
                }*/
            }
        }
        catch (Exception e) {
            Log.w("Settings Backup", e);

            e.printStackTrace();
        }
    }

    private void getLocationPermission() {
        /*
         * Request location permission, so that we can get the location of the
         * device. The result of the permission request is handled by a callback,
         * onRequestPermissionsResult.
         */
        if (ContextCompat.checkSelfPermission(this.getApplicationContext(),
                Manifest.permission.WRITE_EXTERNAL_STORAGE)
                == PackageManager.PERMISSION_GRANTED) {
            mLocationPermissionGranted = true;
        } else {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                    PERMISSIONS_REQUEST_WRITE_EXTERNAL_STORAGE);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        mLocationPermissionGranted = false;
        switch (requestCode) {
            case PERMISSIONS_REQUEST_WRITE_EXTERNAL_STORAGE: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    mLocationPermissionGranted = true;
                }
            }
        }
    }
}
