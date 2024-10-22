import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

public class WorkoutPlannerApp extends JFrame implements ActionListener {
    private JComboBox<String> goalComboBox;
    private JTextField equipmentInput;
    private JTextArea equipmentListArea, workoutPlanArea;
    private JButton addEquipmentButton, suggestWorkoutButton;
    private ArrayList<String> equipmentList;
    private HashMap<String, String> workoutPlans;

    public WorkoutPlannerApp() {
        // Initialize the equipment list and workout plans
        equipmentList = new ArrayList<>();
        workoutPlans = new HashMap<>();

        // Predefined workout plans (goal + equipment -> exercises)
        workoutPlans.put("Strength Dumbbells", "Push-ups, Dumbbell Bench Press");
        workoutPlans.put("Strength Bodyweight", "Pull-ups, Squats");
        workoutPlans.put("Endurance Resistance Bands", "Jump Rope, Band Sprints");
        workoutPlans.put("Endurance Bodyweight", "Burpees, Mountain Climbers");
        workoutPlans.put("Flexibility Yoga Mat", "Downward Dog, Seated Forward Bend");
        workoutPlans.put("Flexibility Bodyweight", "Cat-Cow Stretch, Child's Pose");

        // Create components
        String[] goals = { "Strength", "Endurance", "Flexibility" };
        goalComboBox = new JComboBox<>(goals);
        equipmentInput = new JTextField(10);
        equipmentListArea = new JTextArea(5, 20);
        workoutPlanArea = new JTextArea(5, 20);
        addEquipmentButton = new JButton("Add Equipment");
        suggestWorkoutButton = new JButton("Suggest Workout");

        equipmentListArea.setEditable(false);
        workoutPlanArea.setEditable(false);

        // Set up layout and add components
        JPanel panel = new JPanel();
        panel.add(new JLabel("Select Fitness Goal:"));
        panel.add(goalComboBox);
        panel.add(new JLabel("Enter Equipment:"));
        panel.add(equipmentInput);
        panel.add(addEquipmentButton);
        panel.add(new JScrollPane(equipmentListArea));
        panel.add(suggestWorkoutButton);
        panel.add(new JScrollPane(workoutPlanArea));

        addEquipmentButton.addActionListener(this);
        suggestWorkoutButton.addActionListener(this);

        setLayout(new FlowLayout());
        add(panel);

        // Window settings
        setTitle("Personalized Workout Planner");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addEquipmentButton) {
            String equipment = equipmentInput.getText();
            if (!equipment.isEmpty()) {
                equipmentList.add(equipment);
                equipmentListArea.append(equipment + "\n");
                equipmentInput.setText("");
            }
        } else if (e.getSource() == suggestWorkoutButton) {
            String goal = (String) goalComboBox.getSelectedItem();
            StringBuilder matchedPlan = new StringBuilder();
            for (String equipment : equipmentList) {
                String key = goal + " " + equipment;
                if (workoutPlans.containsKey(key)) {
                    matchedPlan.append(workoutPlans.get(key)).append("\n");
                }
            }
            if (matchedPlan.length() == 0) {
                workoutPlanArea.setText("No matching workout plan found.");
            } else {
                workoutPlanArea.setText("Suggested Workout Plan:\n" + matchedPlan.toString());
            }
        }
    }

    public static void main(String[] args) {
        new WorkoutPlannerApp();
    }
}
