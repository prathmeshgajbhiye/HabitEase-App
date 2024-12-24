package com.example.habitease;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Button;

import androidx.lifecycle.ViewModelProvider;

import java.util.List;

public class HabitAdapter extends BaseAdapter {

    private Context context;
    private List<Habit> habits;
    private HabitViewModel habitViewModel;

    public HabitAdapter(Context context, List<Habit> habits, HabitViewModel habitViewModel) {
        this.context = context;
        this.habits = habits;
        this.habitViewModel = habitViewModel;
    }

    @Override
    public int getCount() {
        return habits.size();
    }

    @Override
    public Object getItem(int position) {
        return habits.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.item_habit, parent, false);
        }

        // Correct references to the layout views
        TextView habitNameTextView = convertView.findViewById(R.id.text_view_habit_name);
        CheckBox checkBox = convertView.findViewById(R.id.checkbox_habit_completed);
        Button deleteButton = convertView.findViewById(R.id.button_delete_habit);

        Habit habit = habits.get(position);

        // Set the text for habit name using the correct getter method
        habitNameTextView.setText(habit.getHabitName());

        // Set the checkbox based on the completion status
        checkBox.setChecked(habit.isCompleted());

        // Set up delete button functionality
        deleteButton.setOnClickListener(v -> habitViewModel.delete(habit));

        return convertView;
    }

    // Method to update the list of habits
    public void updateHabits(List<Habit> updatedHabits) {
        this.habits = updatedHabits;
        notifyDataSetChanged();
    }
}
