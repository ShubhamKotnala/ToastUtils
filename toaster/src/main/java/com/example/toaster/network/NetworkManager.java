package com.example.toaster.network;

import android.content.Context;

import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.CertificatePinner;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * API calls manager for HOMIEZ App. All api calls can get their server client
 */
public class NetworkManager {
    private static APIs sHomiezApi;

    private static OkHttpClient sOkHttpClient;

    private static Retrofit retrofit;

    private NetworkManager() {
    }

    /**
     * Initial setup for network manager
     *
     * @param ctx    App context, Needed for cache initialization
     * @param sslPin
     */
    public static void init(Context ctx, String sslPin, String hostName) {

        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                /*.certificatePinner(certPinner)*/
                /*.cache(new Cache(ctx.getCacheDir(), NetworkConstants.CACHE_SIZE))*/
                /* .addInterceptor(new CacheInterceptor())*/
                /*.addInterceptor(new TimeoutInterceptor())*/
                /*.addInterceptor(new BasicHeaderInterceptor())*/
                /*.addInterceptor(new AuthorizationInterceptor())*/
                .connectTimeout(NetworkConstants.DEFAULT_TIME_OUT, TimeUnit.SECONDS)
                .readTimeout(NetworkConstants.DEFAULT_READ_WRITE_TIME_OUT, TimeUnit.SECONDS)
                .writeTimeout(NetworkConstants.DEFAULT_READ_WRITE_TIME_OUT, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true);

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.level(HttpLoggingInterceptor.Level.BODY);
        builder.addInterceptor(logging);

        sOkHttpClient = builder.build();

    }

    public static Retrofit getRetrofitInstance() {
        if (retrofit == null)
            retrofit = new Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create(new GsonBuilder()
                            .setLenient().create()))
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .baseUrl(NetworkManagerClient.getInstance().getBaseUrl())
                    .client(sOkHttpClient)
                    .build();
        return retrofit;
    }

    /**
     * @return {@link APIs} Retrofit client
     */
    public static APIs getApiClient() {
        if (sHomiezApi == null) {
            sHomiezApi = getRetrofitInstance().create(APIs.class);
        }
        return sHomiezApi;
    }


    /**
     * @return {@link APIs}
     */
    public static <T> T getApiClient(Class<T> tclass) {
        if (tclass == APIs.class)
            return (T) getApiClient();

        return getRetrofitInstance().create(tclass);
    }


}