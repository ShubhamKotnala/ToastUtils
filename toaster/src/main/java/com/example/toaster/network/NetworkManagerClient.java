package com.example.toaster.network;

import android.content.Context;

/**
 * Singleton implementation for Network Manager Initialization
 */
public class NetworkManagerClient {
    private static NetworkManagerClient sInstance;
    private String mBaseUrl;
    private String mApiAccessKey, appVersion, localeCode;


    private NetworkManagerClient() {
    }

    public static NetworkManagerClient getInstance() {
        if (sInstance == null) {
            sInstance = new NetworkManagerClient();
        }
        return sInstance;
    }

    public void init(Context context, String baseUrl, String accessKey,
                     String sslPin, String localeCode, String appVersion, String hostName) {
        mBaseUrl = baseUrl;
        mApiAccessKey = accessKey;
        this.localeCode = localeCode;
        this.appVersion = appVersion;
        NetworkManager.init(context, sslPin, hostName);
    }

    public String getAppVersion() {
        return appVersion;
    }


    public String getBaseUrl() {
        return mBaseUrl;
    }

    public String getLocaleCode() {
        return localeCode;
    }

    public void setLocaleCode(String localeCode) {
        this.localeCode = localeCode;
    }

    public String getApiAccessKey() {
        return mApiAccessKey;
    }

}
