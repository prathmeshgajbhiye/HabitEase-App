package com.example.habitease;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Habit.class}, version = 1, exportSchema = false)
public abstract class HabitDatabase extends RoomDatabase {

    private static volatile HabitDatabase INSTANCE;
    private static final Object LOCK = new Object();

    public abstract HabitDao habitDao();

    public static HabitDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (LOCK) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    HabitDatabase.class, "habit_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}





































