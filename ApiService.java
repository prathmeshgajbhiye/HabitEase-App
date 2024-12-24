package com.example.habitease;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import java.util.List;

// Interface for defining Retrofit API calls
public interface ApiService {

    // Endpoint for fetching habits for a specific user
    @GET("getHabits")
    Call<List<Habit>> getHabits(@Query("userId") String userId);
}
