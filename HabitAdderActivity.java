package com.example.habitease;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

public class HabitAdderActivity extends AppCompatActivity {

    private EditText editTextHabitName;
    private HabitViewModel habitViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_habit_adder);

        // Initialize the EditText and ViewModel
        editTextHabitName = findViewById(R.id.edit_text_habit_name);
        habitViewModel = new ViewModelProvider(this).get(HabitViewModel.class);
    }

    public void addHabit(View view) {
        String habitName = editTextHabitName.getText().toString();

        // Ensure the habit name is not empty before proceeding
        if (!habitName.isEmpty()) {
            Habit habit = new Habit();
            habit.setHabitName(habitName); // Set the habit name
            habit.setCompleted(false); // Mark it as not completed

            // Insert habit through ViewModel
            habitViewModel.insert(habit);
            finish(); // Close the activity after insertion
        }
    }
}
