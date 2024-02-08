package com.zone.android.miskool_View;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import com.zone.android.miskool.R;
import com.zone.android.miskool_Entitiy.Message_In;
import com.zone.android.miskool_Entitiy.Message_Out;
import com.zone.android.miskool_Presenter.maiPresClass;
import com.zone.android.miskool_Presenter.mailPresInterface;
import com.zone.android.miskool_Util.Constants;
import com.zone.android.miskool_Util.ContentFragment;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;



public class mailViewClass extends AppCompatActivity implements mailViewInterface,OnMenuItemClickListener {

    ActionBar actionBar;
    // SharedPreferences messagesharedPrefrence = getSharedPreferences(Constants.MESSAGEPREFERENCE, Context.MODE_PRIVATE);
    String messageId;
    mailPresInterface mailPresInterface;
    public static BottomSheetDialog mBottomSheetDialog;

    SharedPreferences studentPreference;
    String StudenId;
    EditText editContent;
    View bottomSheet;

    CoordinatorLayout coordinatorLayout;
    View bottomSheetLayout;

    BottomSheetBehavior sheetBehavior;

    LinearLayout layoutBottomSheet;
    FloatingActionButton fab;
    CoordinatorLayout coordinatorlayout;
    RecyclerView recyclerView;
    private ContentFragment contentFragment;
    private FragmentManager fragmentManager;
    private ContextMenuDialogFragment mMenuDialogFragment;

     SharedPreferences masterPreference;
   public static ProgressDialog progressBar;

   public static ArrayList<String> contactssList;

   public static  HashMap<String, String> contactHashMap;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AndroidThreeTen.init(getApplication());
        setContentView(R.layout.activity_mail);
        fragmentManager = getSupportFragmentManager();
        //initToolbar();
        initMenuFragment();
        invalidateOptionsMenu();



        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        // Sets the Toolbar to act as the ActionBar for this Activity window.
        // Make sure the toolbar exists in the activity and is not null
        setSupportActionBar(toolbar);

      /*  actionBar = getSupportActionBar();
        actionBar.setHomeAsUpIndicator(R.mipmap.homenew);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("Inbox");*/

        getSupportActionBar().setTitle("Inbox");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        masterPreference= getApplicationContext().getSharedPreferences(Constants.MASTER_USER_PREFERENCE,Context.MODE_PRIVATE);

        studentPreference = getApplicationContext().getSharedPreferences(Constants.STUDENT_SELECTION_PREFERENCE, Context.MODE_PRIVATE);

        layoutBottomSheet = (LinearLayout) findViewById(R.id.bottom_sheet);

       coordinatorlayout=(CoordinatorLayout)findViewById(R.id.coordinatorlayout);

        //studentId
       /* List<Person_det>stList=Methods.getDefaultStudent(getApplicationContext());
        Person_det person_det=new Person_det();
        person_det=stList.get(0);

        String studenId=person_det.getStudentId();
        String studentname=person_det.getFirstName();
        StudenId = studentPreference.getString("studentId", studenId);*/
///////////////////////////////////

        sheetBehavior = BottomSheetBehavior.from(layoutBottomSheet);

         fab = (FloatingActionButton) findViewById(R.id.fab);



        //getting mailinterface

        messageId = "STD123";

        mailPresInterface = new maiPresClass(this);

        StudenId = studentPreference.getString("studentid", "");

        /*String studentname= studentPreference.getString("studentname", "");
        mailPresInterface.deleteTablesMessage(studentname, getApplicationContext());*/

        bottomSheetLayout = getLayoutInflater().inflate(R.layout.bottom_sheet_dialog, null);

        //showbottomsheet();


        String mastername = masterPreference.getString("mastername", "");
        String studentname= studentPreference.getString("studentname", "");

        if(!studentname.equals(mastername)){

            fab.setVisibility(View.INVISIBLE);
        }else{
            fab.setVisibility(View.VISIBLE);
        }


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggleBottomSheet();
            }
        });


        bottomSheetSlide();
        invalidateOptionsMenu();

    }

  /*  @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        Log.e("StudentName","StudentName" +StudentName);
        menu.findItem(R.id.miAccount).setTitle(StudentName);
        return super.onPrepareOptionsMenu(menu);
    }*/

    public void bottomSheetSlide(){

        sheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {

                if (newState == BottomSheetBehavior.STATE_EXPANDED) {
                    Log.e("newstateSTATE_EXPANDED","newstateSTATE_EXPANDED");
                    fab.setVisibility(View.INVISIBLE);

                }
                else if (newState == BottomSheetBehavior.STATE_COLLAPSED) {

                    Log.e("newstateSTATE_COLLAPSED","newstateSTATE_COLLAPSED");
                    fab.setVisibility(View.VISIBLE);



                }
                else if (newState == BottomSheetBehavior.STATE_HIDDEN) {

                    Log.e("newstateSTATE_HIDDEN","newstateSTATE_HIDDEN");
                    fab.setVisibility(View.VISIBLE);

                }
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {

                Log.e("newstateonSlide","newstateonSlide");
            }
        });
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch (id) {

            case R.id.context_menu:
                if (fragmentManager.findFragmentByTag(ContextMenuDialogFragment.TAG) == null) {
                    mMenuDialogFragment.show(fragmentManager, ContextMenuDialogFragment.TAG);
                }
                break;

            case android.R.id.home:
                //   mDrawerLayout.openDrawer(GravityCompat.START);

                mailViewClass.this.finish();
                return true;

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }


    public void setMailBox() {
        new Thread(new Runnable() {
            @Override
            public void run() {



                List<Message_In> message_ins = new ArrayList<Message_In>();
                for (int i = 0; i < 15; i++) {

                    Message_In message_in = new Message_In();
                    message_in.setMessageSub("Assignmentt");
                    message_in.setMessageDateOfCreated("11/03/2018");
                    message_in.setMessages("Assignment due on xxxxx");
                    message_ins.add(message_in);
                }


                RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
                recyclerView.setHasFixedSize(true);
                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
                recyclerView.setLayoutManager(layoutManager);


                //  RecyclerView.Adapter adapter = new mailViewAdapter(messageList,getApplicationContext());





            }

        }).start();

    }

    @Override
    public void deleteTablesMessageRes(int errorCode) {

        if(errorCode==Constants.PASS_VALIDATION) {

            String studentname = studentPreference.getString("studentname", "");
            mailPresInterface.getMessageServer(studentname, getApplicationContext());
        }
    }

    @Override
    public void updateReadFlagResponse(Message_In message_in) {

        setNavigation(message_in);
    }

    @Override
    public void setMessagesServer(int errorCode) {

        if(errorCode==Constants.PASS_SERVICE){

            String studentname= studentPreference.getString("studentname", "");
           mailPresInterface.getMessages(studentname,getApplicationContext());


        }else if(errorCode==Constants.NO_MESSAGE){

            Snackbar snackbar = Snackbar
                    .make(coordinatorlayout, "no new messages", Snackbar.LENGTH_LONG);
            snackbar.show();

            mailPresInterface.getMembersList(getApplicationContext());

        }else if(errorCode==Constants.CONTACTS_UP){

            mailPresInterface.getContactsDb(getApplicationContext());
        }


    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.e("returnOnstart","returnOnstart");
        /*progressBar.setIndeterminate(true);
        progressBar.setVisibility(ProgressBar.VISIBLE);*/

        progressBar = new ProgressDialog(this);
        progressBar.setCancelable(true);//you can cancel it by pressing back button
        progressBar.setMessage("Downloading messages");
        progressBar.setIndeterminate(true);

        progressBar.show();


        String studentname= studentPreference.getString("studentname", "");
        mailPresInterface.deleteTablesMessage(studentname, getApplicationContext());

      //  StudenId = studentPreference.getString("studentid", "");

     //   mailPresInterface.getMessages(StudenId, getApplicationContext());

    }


    @Override
    protected void onResume() {
        super.onResume();

        Log.e("returnOnresume","returnOnresume");

    }

    @Override
    public void setMessages(final List<Message_In> messageList) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {

                String mastername = masterPreference.getString("mastername", "");
                String studentname= studentPreference.getString("studentname", "");

                if(!studentname.equals(mastername)){

                    fab.setVisibility(View.INVISIBLE);
                }else{
                    fab.setVisibility(View.VISIBLE);
                }



                final List<Message_In> message_ins = messageList;


                Log.e("messageListsize ","messageListsize "+message_ins.size());

                recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
                recyclerView.setHasFixedSize(true);
                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
                recyclerView.setLayoutManager(layoutManager);


            }



        });
        mailPresInterface.getMembersList(getApplicationContext());

    }

    @Override
    public void showMessage(int error) {

        progressBar.dismiss();

        if(error==Constants.PASS_SERVICE){

            String studentname= studentPreference.getString("studentname", "");
            mailPresInterface.getMessages(studentname,getApplicationContext());





            Snackbar snackbar = Snackbar
                    .make(coordinatorlayout, "message sent", Snackbar.LENGTH_LONG);
            snackbar.show();
///////////////////////////


            ////////////////////////////////
        }
        else{

            Snackbar snackbar = Snackbar
                    .make(coordinatorlayout, "message not sent", Snackbar.LENGTH_LONG);
            snackbar.show();
        }
    }

    @Override
    public void sentContacts(HashMap<String, String> contactList) {

Log.e("contactList11 ","contactList11 "+contactList.size());
        contactssList=new ArrayList<>();

        contactHashMap=contactList;

        runOnUiThread(new Runnable() {
            @Override
            public void run() {

                for ( String key : contactList.keySet() ) {
                    System.out.println( key );

                    String key1=key;

                    Log.e("key111 ","key111 "+key);
                    //  Toast.makeText(getContext(),key1, Toast.LENGTH_SHORT).show();
                    contactssList.add(key1);

                }
                progressBar.dismiss();

                handleClciks();

            }
        });

    }

    public void showbottomsheet() {

        editContent = bottomSheetLayout.findViewById(R.id.edit_replycontent);
        (bottomSheetLayout.findViewById(R.id.button_close)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mBottomSheetDialog.dismiss();
            }
        });
        (bottomSheetLayout.findViewById(R.id.button_ok)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Ok button clicked", Toast.LENGTH_SHORT).show();

                //  prepareReplyObject(message_in);
            }
        });

        mBottomSheetDialog = new BottomSheetDialog(getApplicationContext());
        mBottomSheetDialog.setContentView(bottomSheetLayout);
        mBottomSheetDialog.show();
    }


    public void callBottomSheet(final Message_In message_in, Context context) {


        editContent = bottomSheetLayout.findViewById(R.id.edit_replycontent);
        (bottomSheetLayout.findViewById(R.id.button_close)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mBottomSheetDialog.dismiss();
            }
        });
        (bottomSheetLayout.findViewById(R.id.button_ok)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Toast.makeText(getApplicationContext(), "Ok button clicked", Toast.LENGTH_SHORT).show();

                prepareReplyObject(message_in);
            }
        });

        mBottomSheetDialog = new BottomSheetDialog(getApplicationContext());
        mBottomSheetDialog.setContentView(bottomSheetLayout);
        mBottomSheetDialog.show();
    }

    Message_Out prepareReplyObject(Message_In message_in) {
        //{ token: _token, touser: _username2, subject: _subject, text: _text, thread_id: _message_id })

        StudenId = studentPreference.getString("studentId", "default student from db");
        DateFormat dateFormatter = new SimpleDateFormat("yyyyMMdd hhmmss");
        dateFormatter.setLenient(false);
        Date today = new Date();
        String datetime = dateFormatter.format(today);

        Message_Out message_out = new Message_Out();
      //  message_out.setMessageOutId(Methods.getLastReplyId(getApplicationContext()) + 1);
      //  message_out.setMessageInId(message_in.getMessageInId());
       // message_out.setThreadId(message_in.getThreadId());

        message_out.setStudentId(StudenId);
        message_out.setMessageDate(datetime);
        message_out.setMessageSub(message_in.getMessageSub());
        message_out.setMessageContent(editContent.getText().toString());
      //  message_out.setMessageSender("ME");
        message_out.setMessageReceiver(message_in.getMessageSender());
       // message_out.setMessageSentFlag("0");


        return message_out;
    }


    public void toggleBottomSheet() {

        Log.e("toggled", "toggled");
        if (sheetBehavior.getState() != BottomSheetBehavior.STATE_EXPANDED) {
            sheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
            fab.setVisibility(View.INVISIBLE);

            Log.e("toggledSTATE_EXPANDED", "toggledSTATE_EXPANDED");
            // btnBottomSheet.setText("Close sheet");

        } else {
            sheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
            fab.setVisibility(View.VISIBLE);

            Log.e("toggledSTATE_COLLAPSED", "toggledSTATE_COLLAPSED");

            // btnBottomSheet.setText("Expand sheet");
        }


    }


    public void handleClciks(){

        Button button_ok=(Button)layoutBottomSheet.findViewById(R.id.button_ok);
        Button button_close=(Button)layoutBottomSheet.findViewById(R.id.button_close) ;
        final AutoCompleteTextView tv_receiver=(AutoCompleteTextView)layoutBottomSheet.findViewById(R.id.tv_receiver);
        final AutoCompleteTextView tv_title=(AutoCompleteTextView)layoutBottomSheet.findViewById(R.id.tv_title);
        final EditText edit_replycontent=(EditText)layoutBottomSheet.findViewById(R.id.edit_replycontent);

        Log.e("contactssList ", "contactssList "+contactssList.size());


        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (this, android.R.layout.select_dialog_item, contactssList);

        tv_receiver.setAdapter(adapter);
        tv_receiver.setThreshold(3);

       tv_receiver.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


               String item = parent.getItemAtPosition(position).toString();

               String courseId = contactHashMap.get(item);

               Log.e("mapkey ", "mapkey " + courseId);


               Log.e("contactssListonItemClick ", "contactssListonItemClick "+courseId);


               tv_receiver.setText(courseId);

           }
       });

        button_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // Toast.makeText(getApplicationContext(),"toggled",Toast.LENGTH_LONG).show();

                //toggleBottomSheet();

                String sub=tv_title.getText().toString();
                String recip=tv_receiver.getText().toString();
                String content=edit_replycontent.getText().toString();
                String datetime=getCurrentDateTime();
                StudenId = studentPreference.getString("studentId", "");

//{ token: _token, touser: _username2, subject: _subject, text: _text, thread_id: _message_id })

                if(SubcheckValidation(sub)){
                    if(SubcheckValidation(recip)){
                        if(SubcheckValidation(content)){

                            Message_In message_in =new Message_In();
                          //  message_out.setMessageDate(datetime);
                            message_in.setMessageReceiver(recip);
                            message_in.setMessageSub(sub);
                            message_in.setMessages(content);
                            message_in.setMessageInId("");

                       //     Methods.sendOutmessages(message_out,getApplicationContext());

                            progressBar = new ProgressDialog(mailViewClass.this);
                            progressBar.setCancelable(true);//you can cancel it by pressing back button
                            progressBar.setMessage("Sending message");
                            progressBar.setIndeterminate(true);

                            progressBar.show();

                            mailPresInterface.sentReply(message_in,getApplicationContext());
                            toggleBottomSheet();

                          //  toastMessage("message sent successfully");


                        }else{
                            toastMessage("Enter content");
                            edit_replycontent.requestFocus();
                        }
                    }else{
                        toastMessage("Enter receiver");
                        tv_receiver.requestFocus();
                    }
                }else{

                    toastMessage("Enter subject");
                    tv_title.requestFocus();
                }

            }
        });


        button_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggleBottomSheet();
            }
        });


    }

    void toastMessage(String message){

        Snackbar snackbar = Snackbar
                .make(coordinatorlayout, message, Snackbar.LENGTH_LONG);
        snackbar.show();

    }

    boolean SubcheckValidation(String content){
     boolean isValid=false;
     try {

         if(content.equals("")||content.equals(" ")){
             isValid=false;
         }else{
             isValid=true;
         }

     }catch (Exception e){
         e.printStackTrace();
         isValid=false;
     }
    return isValid;
    }

    public String getCurrentDateTime(){

        StudenId = studentPreference.getString("studentId", "default student from db");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        dateFormatter.setLenient(false);
        Date today = new Date();
        String datetime = dateFormatter.format(today);

        return datetime;
    }

public void setNavigation(Message_In message_in){

    String studentname= studentPreference.getString("studentname", "");

    Intent replyintent = new Intent(getApplicationContext(),replyViewClass.class);
    replyintent.putExtra("student_id",studentname);
    replyintent.putExtra("thread_id",message_in.getThreadId());
    replyintent.putExtra("messagein_id",message_in.getMessageInId());
    replyintent.putExtra("subject",message_in.getMessageSub());
    replyintent.putExtra("touser",message_in.getMessageSender());
    startActivity(replyintent);
}

    @Override
    public void onMenuItemClick(View view, int position) {
        switch (position){
            case 1:
                Intent intent = new Intent(mailViewClass.this, ouMailViewClass.class);
                startActivity(intent);
                // overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
                break;

            case 2:
                progressBar = new ProgressDialog(this);
                progressBar.setCancelable(true);//you can cancel it by pressing back button
                progressBar.setMessage("Downloading messages");
                progressBar.setIndeterminate(true);

                progressBar.show();


                String studentname= studentPreference.getString("studentname", "");
                mailPresInterface.deleteTablesMessage(studentname, getApplicationContext());
                break;


        }
    }

    private void initMenuFragment() {
        MenuParams menuParams = new MenuParams();
        menuParams.setActionBarSize((int) getResources().getDimension(R.dimen.tool_bar_height));
        menuParams.setMenuObjects(getMenuObjects());
        menuParams.setClosableOutside(false);
        menuParams.setAnimationDuration(2);

        mMenuDialogFragment = ContextMenuDialogFragment.newInstance(menuParams);
        mMenuDialogFragment.setItemClickListener(this);
        // mMenuDialogFragment.setItemLongClickListener(this);
    }

    private List<MenuObject> getMenuObjects() {
        // You can use any [resource, bitmap, drawable, color] as image:
        // item.setResource(...)
        // item.setBitmap(...)
        // item.setDrawable(...)
        // item.setColor(...)
        // You can set image ScaleType:
        // item.setScaleType(ScaleType.FIT_XY)
        // You can use any [resource, drawable, color] as background:
        // item.setBgResource(...)
        // item.setBgDrawable(...)
        // item.setBgColor(...)
        // You can use any [color] as text color:
        // item.setTextColor(...)
        // You can set any [color] as divider color:
        // item.setDividerColor(...)

        List<MenuObject> menuObjects = new ArrayList<>();

        MenuObject close = new MenuObject();
        close.setResource(R.drawable.icn_close);

        MenuObject send = new MenuObject("Sent");
        send.setResource(R.drawable.icn_1);

        MenuObject like = new MenuObject("Refresh");
        Bitmap b = BitmapFactory.decodeResource(getResources(), R.drawable.ic_ref);
        like.setBitmap(b);

        MenuObject addFr = new MenuObject("Switch user");
        BitmapDrawable bd = new BitmapDrawable(getResources(),
                BitmapFactory.decodeResource(getResources(), R.drawable.icn_3));
        addFr.setDrawable(bd);

     /*   MenuObject addFav = new MenuObject("Add to favorites");
        addFav.setResource(R.drawable.icn_4);
*/
        menuObjects.add(close);
        menuObjects.add(send);
        menuObjects.add(like);
        menuObjects.add(addFr);
        //   menuObjects.add(addFav);
        return menuObjects;
    }


}
