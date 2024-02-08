package com.zone.android.miskool_Util;


import org.json.JSONException;

public interface ServiceCallback
{

    public void SuccessCallbak(String resp) throws JSONException;

    public void ErrorCallbak(String resp);


}