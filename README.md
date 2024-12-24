# HabitEase  

HabitEase is a simple yet powerful habit tracker app designed to help users develop and maintain productive habits. With its user-friendly interface and essential features, HabitEase empowers individuals to stay on track and improve themselves daily.  

## Features  
- **Habit Viewer**: View your habits in a clean and organized list.  
- **Habit Adder**: Add new habits with ease to keep track of your goals.  
- **Habit Details**: Dive deeper into each habit to check streaks and progress.  
- **Calendar View**: Visualize your habit completion over time.  
- **Reminders and Notifications**: Stay on track with timely reminders.  
- **Offline Support**: Save habits locally using the Room database.  
- **API Integration**: Fetch and log sample habits for testing purposes.  

## Tech Stack  
- **Programming Language**: Java  
- **Frontend Framework**: Android XML layouts  
- **Backend**: Room Database, Retrofit for API calls  
- **Build Tool**: Gradle (Groovy DSL)  

## Color Palette  
The app features a soothing and motivating color scheme:  
- **#4B9CD3**  
- **#9DC08B**  
- **#609966**  
- **#40513B**  

## Project Structure  

```
HabitEase/
│
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/
│   │   │   │   └── com/
│   │   │   │       └── example/
│   │   │   │           └── habitease/
│   │   │   │               ├── MainActivity.java
│   │   │   │               ├── HabitViewerActivity.java
│   │   │   │               ├── HabitAdderActivity.java
│   │   │   │               ├── HabitDetailsActivity.java
│   │   │   │               ├── Habit.java
│   │   │   │               ├── HabitAdapter.java
│   │   │   │               ├── HabitDao.java
│   │   │   │               ├── HabitDatabase.java
│   │   │   │               ├── ApiService.java
│   │   │   │               ├── ApiClient.java
│   │   │   │               └── HabitRepository.java
│   │   │   ├── res/
│   │   │   │   ├── layout/
│   │   │   │   │   ├── activity_main.xml
│   │   │   │   │   ├── activity_habit_viewer.xml
│   │   │   │   │   ├── activity_habit_adder.xml
│   │   │   │   │   ├── activity_habit_details.xml
│   │   │   │   │   └── item_habit.xml
│   │   │   │   └── values/
│   │   │   │       └── colors.xml
│   │   │   ├── AndroidManifest.xml
│   └── build.gradle
└── settings.gradle
```

## Setup  
1. Clone this repository:  
   ```bash
   git clone https://github.com/yourusername/habitease.git
   ```  
2. Open the project in Android Studio.  
3. Sync Gradle to install dependencies.  
4. Run the app on an emulator or physical device.  

## Contributing  
Contributions are welcome! Please fork the repository, make your changes, and create a pull request.  

## License  
This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.  

---

