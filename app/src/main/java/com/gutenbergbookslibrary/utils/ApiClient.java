package com.gutenbergbookslibrary.utils;



import java.util.Collections;

import okhttp3.CipherSuite;
import okhttp3.ConnectionSpec;
import okhttp3.OkHttpClient;
import okhttp3.TlsVersion;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private static Retrofit retrofit;
    private static final OkHttpClient client;


    public void ApiClient(){

    }

    public static Retrofit getRetrofitInstance(){

        if(retrofit==null){

            retrofit = new Retrofit.Builder()
                    .baseUrl("http://skunkworks.ignitesol.com:8000")
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client)
                    .build();

        }

        return retrofit;
    }

    static {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BASIC);

        ConnectionSpec spec = new
                ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS)
                .tlsVersions(TlsVersion.TLS_1_2)
                .cipherSuites(
                        CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256,
                        CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256,
                        CipherSuite.TLS_DHE_RSA_WITH_AES_128_GCM_SHA256)
                .build();


        client = new OkHttpClient.Builder()
                .connectionSpecs(Collections.singletonList(spec))
                .addInterceptor(logging)
                .addInterceptor(new AuthInterceptor())
                .build();
    }
}
