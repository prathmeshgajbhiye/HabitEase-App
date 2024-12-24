package com.example.habitease;

import android.content.Intent;  // Import Intent class
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import java.text.SimpleDateFormat;  // Import the SimpleDateFormat class
import java.util.Calendar;         // Import the Calendar class

public class MainActivity extends AppCompatActivity {

    private Button buttonViewHabits;
    private Button buttonAddHabit;
    private TextView dateTextView;
    private HabitViewModel habitViewModel;  // ViewModel instance for managing data

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize UI components
        buttonViewHabits = findViewById(R.id.button_view_habits);
        buttonAddHabit = findViewById(R.id.button_add_habit);
        dateTextView = findViewById(R.id.text_view_date);

        // Initialize ViewModel using ViewModelProvider (No need for Kotlin-specific viewModels)
        habitViewModel = new ViewModelProvider(this).get(HabitViewModel.class);

        // Set today's date (you can use your existing method)
        dateTextView.setText(getCurrentDate());

        // Observe LiveData from ViewModel
        habitViewModel.getAllHabits().observe(this, habits -> {
            // Update the UI with the list of habits when it changes
            // You can add your logic here for displaying the list of habits
        });

        // Set onClickListeners for buttons
        buttonViewHabits.setOnClickListener(v -> navigateToActivity(HabitViewerActivity.class));
        buttonAddHabit.setOnClickListener(v -> navigateToActivity(HabitAdderActivity.class));
    }

    private String getCurrentDate() {
        // Method to get today's date (same as your existing method)
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");  // Initialize SimpleDateFormat
        return sdf.format(Calendar.getInstance().getTime());  // Get and format current date
    }

    private void navigateToActivity(Class<?> activityClass) {
        try {
            Intent intent = new Intent(MainActivity.this, activityClass);  // Intent initialization
            startActivity(intent);  // Start the activity
        } catch (Exception e) {
            // Handle exception (if any)
            Toast.makeText(MainActivity.this, "Error opening activity", Toast.LENGTH_SHORT).show();
        }
    }
}
