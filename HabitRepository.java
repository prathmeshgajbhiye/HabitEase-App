package com.example.habitease;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HabitRepository {

    private HabitDao habitDao;
    private LiveData<List<Habit>> allHabits;
    private ApiService apiService;

    public HabitRepository(Application application) {
        HabitDatabase db = HabitDatabase.getInstance(application);  // Get the database instance
        habitDao = db.habitDao();  // Get the DAO
        allHabits = habitDao.getAllHabits();  // Fetch all habits

        // Initialize the Retrofit service
        apiService = ApiClient.getApiClient().create(ApiService.class);
    }

    public LiveData<List<Habit>> getAllHabits() {
        return allHabits;
    }

    public void insert(Habit habit) {
        new Thread(() -> habitDao.insert(habit)).start();
    }

    public void update(Habit habit) {
        new Thread(() -> habitDao.update(habit)).start();
    }

    public void delete(Habit habit) {
        new Thread(() -> habitDao.delete(habit)).start();
    }

    public void deleteById(int habitId) {
        new Thread(() -> habitDao.deleteById(habitId)).start();  // Call the delete method by ID
    }

    // New method to fetch habits from the API and store them in the Room database
    public void fetchHabitsFromApi(String userId) {
        Call<List<Habit>> call = apiService.getHabits(userId);  // Call the Retrofit API

        call.enqueue(new Callback<List<Habit>>() {
            @Override
            public void onResponse(Call<List<Habit>> call, Response<List<Habit>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<Habit> habits = response.body();
                    // Save the fetched habits into the Room database
                    insertAll(habits);
                }
            }

            @Override
            public void onFailure(Call<List<Habit>> call, Throwable t) {
                // Handle API failure (e.g., show a Toast or log the error)
                t.printStackTrace();
            }
        });
    }

    // Helper method to insert a list of habits into the database
    private void insertAll(List<Habit> habits) {
        new InsertHabitsTask(habitDao).execute(habits);
    }

    // AsyncTask for inserting habits into the database in the background
    private static class InsertHabitsTask extends AsyncTask<List<Habit>, Void, Void> {
        private HabitDao habitDao;

        public InsertHabitsTask(HabitDao habitDao) {
            this.habitDao = habitDao;
        }

        @Override
        protected Void doInBackground(List<Habit>... lists) {
            habitDao.insertAll(lists[0]);  // Insert all habits into Room
            return null;
        }
    }
}
