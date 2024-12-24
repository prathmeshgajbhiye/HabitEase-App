package com.example.habitease;

import android.os.Bundle;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.Observer;
import java.util.List;

public class HabitViewerActivity extends AppCompatActivity {

    private HabitViewModel habitViewModel;
    private ListView listView;
    private HabitAdapter habitAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_habit_viewer);

        // Initialize ViewModel
        habitViewModel = new ViewModelProvider(this).get(HabitViewModel.class);

        // Set up ListView and its adapter
        listView = findViewById(R.id.list_view_habits);

        // Observe changes to habits list
        habitViewModel.getAllHabits().observe(this, new Observer<List<Habit>>() {
            @Override
            public void onChanged(List<Habit> habits) {
                // Initialize the adapter only when habits data is available
                if (habitAdapter == null) {
                    habitAdapter = new HabitAdapter(HabitViewerActivity.this, habits, habitViewModel);
                    listView.setAdapter(habitAdapter);
                } else {
                    habitAdapter.updateHabits(habits);  // Assuming you have an update method in your adapter
                }
            }
        });
    }
}
