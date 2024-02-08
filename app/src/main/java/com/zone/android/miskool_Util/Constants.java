package com.zone.android.miskool_Util;

public final class Constants {

    /// "com.example.android.threadsample.BROADCAST";

    // Defines a custom Intent action
    public static final String BROADCAST_ACTION_BUS = "com.zone.android.miskool.BROADCAST_BUS";

    public static final String BROADCAST_ACTION_MSG = "com.zone.android.miskool.BROADCAST_MSG";

    public static final String EXTENDED_DATA_STATUS_MSG =
            "com.zone.android.msg.STATUS";


    // Defines the key for the status "extra" in an Intent
    public static final String EXTENDED_DATA_STATUS_BUS = "com.example.android.threadsample.STATUS_BUS";

    //declaring ip iddress may be we should keep this as either a db value or in shared preference
    public static  final String IP_ADDRESS_STATIC ="http://**********/services/test/location";

    //declaring a static ip and domain name for the getconfig service

    public static final String DOMAIN_STATIC = "http://**********/ZGlobal/";

    public static final String DOMAIN_STATIC_TRANSPORT="http://**********/ZTransport/";
//http://fjmhss.edu.via.zone/


    public static final String DOMAIN_STATIC_TRANSPORTNEW="http://**********/ZTransport/";

    //getting first login service
    public static final String GENERATE_AUTH_TOKEN = "http://**********/login/loginservice/GenerateAccessToken/?";

    //getting personal details
    public static final String GET_BUSTRACKER_DETAILS = "http://**********/login/loginservice/GetBusTrackerDetails/?";

    //bustrack service
    public static final String GetPersonWithToken = "http://**********/login/loginservice/GetPersonWithToken/?";

    //bus Location service



    public static final String GET_BUS_LOCATION = "https://**********/Services/SchoolApp/Json/GetTrasportWithToken/";

    //all messages
    public static final String GET_MESSAGES = "http://**********/login/loginservice/GetMessages/?";
//all alerts

    public static final String GET_ALERTS = "http://**********/login/loginservice/GetAlerts/?";

//bus details(including driver name and details)

    public static final String GET_BUS_DETAILS = "http://**********/login/loginservice/GetBusDetails/?";

    public static final String PUT_MSG_REPLY_DETAILS = "http://**********/login/loginservice/PutMessageReplyDetails/?";


    public static final String PUT_MSG_SEND_DETAILS = "https://**********/Services/SchoolApp/Json/PutSendMessagess/";


    //getting access token latest


    public static final String GET_LOGIN = DOMAIN_STATIC+"json/login/";

    public static final String GET_LOGOUT = DOMAIN_STATIC+"json/logout/";

    public static final String GET_USERS = DOMAIN_STATIC+"json/user/relatedusers/all/";
    public static  final String GET_MESSAGE_RECEIVE = DOMAIN_STATIC+"json/user/messages/all/receive/";
    //json/user/messages/all/send/

    public static  final String GET_MESSAGE_SEND = DOMAIN_STATIC+"json/user/messages/all/send/";

    public static  final String GET_MESSAGE_ALL = DOMAIN_STATIC+"json/user/messages/all/";

    public static  final String UPDATE_READ_FLAG = DOMAIN_STATIC+"json/user/messages/read/";
    //json/user/messages/create
    public static  final String CREATE_MESSAGE = DOMAIN_STATIC+"json/user/messages/create/";

    public static  final String GET_ALERTS_ALL = DOMAIN_STATIC+"json/user/alerts/all/";

    public static  final String GET_ALERTS_ACTIVE = DOMAIN_STATIC+"json/user/alerts/all/active/";


    public static  final String GET_SCHEDULES_ALL = DOMAIN_STATIC+"json/user/schedules/all/";
    public static  final String GET_SCHEDULES_ACTIVE = DOMAIN_STATIC+"json/user/schedules/all/active/";

    public static  final String GET_SCHEDULES_CURRENT = DOMAIN_STATIC+"json/user/schedules/all/current/";

    public static  final String GET_SCHEDULES_CREATE = DOMAIN_STATIC+"json/user/schedules/create/";

    public static final String GET_BACKGROUND_SERVICE=DOMAIN_STATIC+"json/user/msacounts/all/";
    //json/user/schedules/update/

    public static  final String GET_SCHEDULES_UPDATE = DOMAIN_STATIC+"json/user/schedules/update/";

    //new user

    public static  final String CREATE_USER = DOMAIN_STATIC+"json/user/create/";


    public static final String GET_AI=DOMAIN_STATIC+"json/user/ai/ask/";

    public static final String GET_CURR_LOC = DOMAIN_STATIC_TRANSPORT+"json/transport/route/gps/location/";
    public static final String GET_ROUTE_DETAILS= DOMAIN_STATIC_TRANSPORT+"json/transport/route/subscribedroute/list/";

    public static final String GET_CONTACTS= DOMAIN_STATIC+"json/user/contacts/";



    //getting person details

    public static String GET_USER_TOKEN="https://**********/Services/SchoolApp/Json/GetUserWithToken/";


    //declaring login service
    public static  final String LOGIN_URL ="/getCurrent";

    public static final String MESSAGEPREFERENCE = "messagePreference";

    public static final int ERROR_USER_NAME_NULL=1;

    public static final int ERROR_PASS_WORD_NULL=2;

    public static final int ERROR_NETWORK=3;

    public static final int ERROR_USER_NAME=4;

    public static final int ERROR_CREDENTIALS=5;

    public static final int PASS_VALIDATION=6;

    public static final int PASS_NETWORK=7;

    public static final int PASS_SERVICE=8;
    public static final int NO_MESSAGE=20;

    public static final int PASS_NEW=33;
    public static final int PASS_UP=33;


    public static final int ERROR_TOKEN=10;

    public static final int ERROR_PERSON=11;

    public static final int ERROR_MESSAGE=12;

    public static final int ERROR_ALERTS=13;

    public static final int NEW_USER=14;

    public static final int ERROR_SERVICE=15;

    public static final int ERROR_BUS_DETAILS=16;

    public static final int NO_SERVICE=30;

    public static final int SERVICE_UPDATED=32;



    public static final int DB_PERSON=22;
    public static final int DB_MESSAGE=23;
    public static final int DB_ALERT=24;
    public static final int DB_BUS=25;


    public static final int EVENT_NEW = 30;
    public static final int EVENT_UPDATE=31;

    public static final int CONTACTS_UP=55;


    //adding shared preference

    public static String STUDENT_SELECTION_PREFERENCE = "student_selection_preference";

    public static String MASTER_USER_PREFERENCE="master_user_preference";

    public static String SERVICE_STATUS_PREFERENCE = "service_status_preference";

    public static String CREDENTIAL_PREFERENCE = "credential_preference";
    public static String LOGIN_PREFERENCE = "login_preference";

    public static String BUS_LOCATION_PREFERENCE = "bus_location_preference";

    public static String LAST_TOKEN_PREFERENCE= "last_token_preference";

    public static String ALERT_BUILD_PREFERENCE= "alert_build_preference";

    public static String ROUTE_ID_PREFERENCE= "route_id_preference";

    public static String CURR_BUS_LOCATION= "curr_location_preference";

    public static String REG_DETAILS_PREFERENCE= "reg_details_prefrence";



    // Defines a custom Intent action
    public static final String BROADCAST_ACTION =
            "com.zone.android.busLocation.BROADCAST";

    // Defines the key for the status "extra" in an Intent
    public static final String EXTENDED_DATA_STATUS =
            "com.zone.android.busLocation.STATUS";


    //declaring useful methodsss

    //validating username
    public static boolean isUserNameValid( String username){
        boolean validString = true;
        if(username.equals(null)||username.equals("")||username.equals("null")){
            validString = false;
        }else{
            validString = true;
        }

        return validString;
    }

  //validating passowrd

    public static boolean isPassWordValid( String password){
        boolean validString = true;
        if(password.equals(null)||password.equals("")||password.equals("null")){
            validString = false;
        }else{
            validString = true;
        }

        return validString;
    }




}
