package com.example.habitease;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "habit_table")
public class Habit {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "habit_name")
    private String habitName;

    @ColumnInfo(name = "habit_description")
    private String habitDescription;

    @ColumnInfo(name = "is_completed")
    private boolean isCompleted;

    // Default constructor for Room
    public Habit() {
    }

    // Constructor with all fields
    @Ignore
    public Habit(String habitName, String habitDescription, boolean isCompleted) {
        this.habitName = habitName;
        this.habitDescription = habitDescription;
        this.isCompleted = isCompleted;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHabitName() {
        return habitName;
    }

    public void setHabitName(String habitName) {
        this.habitName = habitName;
    }

    public String getHabitDescription() {
        return habitDescription;
    }

    public void setHabitDescription(String habitDescription) {
        this.habitDescription = habitDescription;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean isCompleted) {
        this.isCompleted = isCompleted;
    }
}
