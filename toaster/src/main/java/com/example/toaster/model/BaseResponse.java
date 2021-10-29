package com.example.toaster.model;

import androidx.annotation.Keep;

import com.google.gson.annotations.SerializedName;


@Keep
public class BaseResponse {
    @SerializedName("status")
    private int status;

    @SerializedName("messageCode")
    private String mMessageCode;

    @SerializedName("message")
    private String message;

//    @SerializedName("description")
//    private String mDescription;

    @SerializedName("timezone")
    private String timeZone;

    @SerializedName("error")
    private Boolean error;

    public String getMessageCode() {
        return mMessageCode;
    }

    public void setMessageCode(String messageCode) {
        this.mMessageCode = messageCode;
    }

//    public String getDescription() {
//        return mDescription;
//    }
//
//    public void setDescription(String description) {
//        this.mDescription = description;
//    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Boolean getError() {
        return error;
    }

    public void setError(Boolean error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
