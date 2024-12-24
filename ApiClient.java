package com.example.habitease;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    // Base URL of your API
    private static final String BASE_URL = "https://yourapiurl.com/";

    private static Retrofit retrofit;

    // This method returns the Retrofit instance
    public static Retrofit getApiClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)  // Base URL of your API
                    .addConverterFactory(GsonConverterFactory.create())  // Gson converter for JSON data
                    .build();
        }
        return retrofit;
    }
}
