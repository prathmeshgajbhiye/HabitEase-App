package com.example.habitease;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class HabitViewModel extends AndroidViewModel {

    private HabitRepository habitRepository;
    private LiveData<List<Habit>> allHabits;

    // Constructor
    public HabitViewModel(Application application) {
        super(application);
        habitRepository = new HabitRepository(application); // Initialize repository with application context
        allHabits = habitRepository.getAllHabits(); // Fetch all habits from the repository
    }

    // Getter method for LiveData to observe habits
    public LiveData<List<Habit>> getAllHabits() {
        return allHabits;
    }

    // Method to insert a habit into the database
    public void insert(Habit habit) {
        habitRepository.insert(habit);
    }

    // Method to update a habit in the database
    public void update(Habit habit) {
        habitRepository.update(habit);
    }

    // Method to delete a habit from the database
    public void delete(Habit habit) {
        habitRepository.delete(habit);
    }

    // Method to delete a habit by its ID
    public void deleteById(int habitId) {
        habitRepository.deleteById(habitId);  // Delete by habit ID
    }
}
