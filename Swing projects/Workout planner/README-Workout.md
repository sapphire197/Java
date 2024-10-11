# Personalized Workout Planner

This is a **Personalized Workout Planner Application** developed using **Java Swing**. The app helps users generate workout routines based on their preferences such as fitness goals (strength, endurance, flexibility), available equipment, and time constraints. 

## Features
1. **Goal Selection**: Users can choose their fitness goal (e.g., Strength, Endurance, or Flexibility).
2. **Equipment Input**: Users can input the available equipment they have (e.g., dumbbells, yoga mat, etc.).
3. **Workout Plan Suggestion**: Based on the goal and equipment, the app suggests workout routines.
4. **Plan Display**: The app displays a list of suggested exercises along with time or repetitions.

## How It Works

1. **Goal Selection**: Users choose one of the three goals: Strength, Endurance, or Flexibility.
2. **Equipment Input**: Users enter the equipment they have access to (e.g., dumbbells, resistance bands).
3. **Workout Plan Suggestion**: The app generates a workout plan based on the selected goal and available equipment.
4. **Plan Display**: A detailed plan is displayed, showing the exercises to perform and the recommended sets or time.

### Predefined Workout Plans:
- **Strength**: 
  - Dumbbells → `Push-ups`, `Dumbbell Bench Press`
  - Bodyweight → `Pull-ups`, `Squats`
- **Endurance**:
  - Resistance Bands → `Jump Rope`, `Band Sprints`
  - Bodyweight → `Burpees`, `Mountain Climbers`
- **Flexibility**:
  - Yoga Mat → `Downward Dog`, `Seated Forward Bend`
  - Bodyweight → `Cat-Cow Stretch`, `Child's Pose`

## Technologies Used
- **Java Swing**: For the user interface.
- **Java AWT**: To manage UI components and events.
- **HashMap**: To store the predefined workout plans as key-value pairs (goal+equipment -> exercises).
- **ArrayList**: To store the list of selected equipment entered by the user.

## Code Overview

### **Main Components**:
1. **JComboBox**: For users to select their fitness goal.
2. **JTextField**: To input the available equipment.
3. **JButton**: For adding equipment and generating workout suggestions.
4. **JTextArea**: Two areas:
   - One for displaying the list of entered equipment.
   - Another for showing the workout plan.
5. **HashMap**: Stores the workout plans, where the key is a combination of fitness goal and equipment, and the value is the workout routine.

### **Workout Plan Matching**:
The app uses string matching to match the selected fitness goal and the entered equipment against predefined workout plans stored in the program. If a match is found, the corresponding workout plan is displayed.

## Enhancements
Here are some ideas for how this project can be enhanced further:
1. **User Profiles**: Allow users to create profiles to track progress and store their workout history.
2. **Custom Workout Input**: Allow users to input their own exercises and create custom plans.
3. **Nutrition Suggestions**: Include a nutrition plan generator based on the user’s fitness goals.
4. **Exercise Categories**: Add categories like bodyweight, equipment-specific, cardio, and flexibility workouts.

## Getting Started

### **Prerequisites**:
- JDK (Java Development Kit) installed on your machine.
- Basic knowledge of Java and Java Swing for further modifications.

### **How to Run the Program**:
1. **Compile the Java file**:
   ```bash
   javac WorkoutPlannerApp.java
   ```

2. **Run the program**:
   ```bash
   java WorkoutPlannerApp
   ```

## Example

### Input:
1. **Select Goal**: Strength
2. **Add Equipment**: Dumbbells

### Output:
```
Suggested Workout Plan:
1. Push-ups
2. Dumbbell Bench Press
```

### If no matching plan is found:
```
No matching workout plan found. Try adding more equipment or changing your goal.
```

## Future Enhancements
- **Database Support**: To store a large number of workout plans and enable customization.
- **User Customization**: Let users input their own workout routines and save them.
- **AI-based Recommendations**: Use AI to suggest personalized workouts based on previous exercises.
