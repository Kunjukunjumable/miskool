package com.zone.android.miskool_Model;

import android.content.Context;

import com.zone.android.miskool_Presenter.loginPresInterface;

import org.json.JSONObject;


public interface loginModelInterface {

    void getToken(String userName, String passWord,String uud, loginPresInterface loginPresInterface, Context context);

    void getLogin(String userName, String passWord, loginPresInterface loginPresInterface, Context context);

    void getAccessToken(String userName, String passWord, loginPresInterface loginPresInterface, Context context);

    void getServices(String userName, String passWord, loginPresInterface loginPresInterface, Context context);

    void getTestServices(String userName, String passWord, loginPresInterface loginPresInterface, Context context);
    void postLogin( String userName, String passWord, String url );

    void createUser(Context context, JSONObject jsonObject, loginPresInterface loginPresInterface);

}
