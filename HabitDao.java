package com.example.habitease;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import androidx.room.Delete;

import java.util.List;

@Dao
public interface HabitDao {

    @Insert
    void insert(Habit habit);

    @Insert  // New method for inserting a list of habits
    void insertAll(List<Habit> habits);

    @Update
    void update(Habit habit);

    @Delete
    void delete(Habit habit);

    // Query to get all habits
    @Query("SELECT * FROM habit_table")
    LiveData<List<Habit>> getAllHabits();  // LiveData ensures that UI is updated when data changes

    // Query to delete habit by id
    @Query("DELETE FROM habit_table WHERE id = :habitId")
    void deleteById(int habitId);  // Delete habit by its ID
}
