package com.zone.android.miskool_Entitiy;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity
public class Token_det {

    @PrimaryKey()
    @ColumnInfo(name = "token_id")
    private int tokenId;


    @ColumnInfo(name = "token")
    private String token;

    @ColumnInfo(name = "token_inc")
    private int tokenInc;




    public int getTokenId() {
        return tokenId;
    }

    public void setTokenId(int tokenId) {
        this.tokenId = tokenId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getTokenInc() {
        return tokenInc;
    }

    public void setTokenInc(int tokenInc) {
        this.tokenInc = tokenInc;
    }


}
