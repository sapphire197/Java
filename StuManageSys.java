import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

class Student {
    private String name;
    private int rollNumber;
    private String grade;

    public Student(String name, int rollNumber, String grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Roll Number: " + rollNumber + ", Grade: " + grade;
    }
}

class StudentManagementSystem {
    private ArrayList<Student> students;

    public StudentManagementSystem() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudent(int rollNumber) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getRollNumber() == rollNumber) {
                students.remove(i);
                return;
            }
        }
        System.out.println("Student with roll number " + rollNumber + " not found.");
    }

    public Student searchStudent(int rollNumber) {
        for (Student student : students) {
            if (student.getRollNumber() == rollNumber) {
                return student;
            }
        }
        return null;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }
}

public class StuManageSys extends JFrame implements ActionListener {
    private JButton addButton, editButton, searchButton, displayButton, removeButton, exitButton;
    private JLabel nameLabel, rollNumberLabel, gradeLabel;
    private JTextField nameField, rollNumberField, gradeField;
    private StudentManagementSystem sms;

    public StuManageSys() {
        setTitle("Student Management System");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(7, 2));

        sms = new StudentManagementSystem();

        nameLabel = new JLabel("Name:");
        add(nameLabel);
        nameField = new JTextField();
        add(nameField);

        rollNumberLabel = new JLabel("Roll Number:");
        add(rollNumberLabel);
        rollNumberField = new JTextField();
        add(rollNumberField);

        gradeLabel = new JLabel("Grade:");
        add(gradeLabel);
        gradeField = new JTextField();
        add(gradeField);

        addButton = new JButton("Add Student");
        addButton.addActionListener(this);
        add(addButton);

        editButton = new JButton("Edit Student");
        editButton.addActionListener(this);
        add(editButton);

        searchButton = new JButton("Search Student");
        searchButton.addActionListener(this);
        add(searchButton);

        displayButton = new JButton("Display All Students");
        displayButton.addActionListener(this);
        add(displayButton);

        removeButton = new JButton("Remove Student");
        removeButton.addActionListener(this);
        add(removeButton);

        exitButton = new JButton("Exit");
        exitButton.addActionListener(this);
        add(exitButton);

        setVisible(true);
    }

    public static void main(String[] args) {
        new StuManageSys();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            addStudent();
        } else if (e.getSource() == editButton) {
            editStudent();
        } else if (e.getSource() == searchButton) {
            searchStudent();
        } else if (e.getSource() == displayButton) {
            displayAllStudents();
        } else if (e.getSource() == removeButton) {
            removeStudent();
        } else if (e.getSource() == exitButton) {
            System.exit(0);
        }
    }

    private void addStudent() {
        String name = nameField.getText();
        String rollNumberStr = rollNumberField.getText();
        String grade = gradeField.getText();
        if (!name.isEmpty() && !rollNumberStr.isEmpty() && !grade.isEmpty()) {
            try {
                int rollNumber = Integer.parseInt(rollNumberStr);
                sms.addStudent(new Student(name, rollNumber, grade));
                JOptionPane.showMessageDialog(this, "Student added successfully!");
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Invalid Roll Number format!");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Name, Roll Number, and Grade cannot be empty!");
        }
    }

    private void editStudent() {
        String rollNumberStr = JOptionPane.showInputDialog(this, "Enter Roll Number of the student to edit:");
        if (rollNumberStr != null) {
            try {
                int rollNumber = Integer.parseInt(rollNumberStr);
                Student student = sms.searchStudent(rollNumber);
                if (student != null) {
                    String newName = JOptionPane.showInputDialog(this, "Enter new name for the student:");
                    String newGrade = JOptionPane.showInputDialog(this, "Enter new grade for the student:");
                    if (!newName.isEmpty() && !newGrade.isEmpty()) {
                        student.setName(newName);
                        student.setGrade(newGrade);
                        JOptionPane.showMessageDialog(this, "Student information updated successfully!");
                    } else {
                        JOptionPane.showMessageDialog(this, "Name and grade cannot be empty!");
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Student with Roll Number " + rollNumber + " not found!");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Invalid input for Roll Number!");
            }
        }
    }

    private void searchStudent() {
        String rollNumberStr = JOptionPane.showInputDialog(this, "Enter Roll Number of the student to search:");
        if (rollNumberStr != null) {
            try {
                int rollNumber = Integer.parseInt(rollNumberStr);
                Student student = sms.searchStudent(rollNumber);
                if (student != null) {
                    JOptionPane.showMessageDialog(this, "Student found:\n" + student);
                } else {
                    JOptionPane.showMessageDialog(this, "Student with Roll Number " + rollNumber + " not found!");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Invalid input for Roll Number!");
            }
        }
    }

    private void displayAllStudents() {
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        for (Student student : sms.getStudents()) {
            textArea.append(student.toString() + "\n");
        }
        JScrollPane scrollPane = new JScrollPane(textArea);
        JOptionPane.showMessageDialog(this, scrollPane, "All Students", JOptionPane.PLAIN_MESSAGE);
    }

    private void removeStudent() {
        String rollNumberStr = JOptionPane.showInputDialog(this, "Enter Roll Number of the student to remove:");
        if (rollNumberStr != null) {
            try {
                int rollNumber = Integer.parseInt(rollNumberStr);
                sms.removeStudent(rollNumber);
                JOptionPane.showMessageDialog(this, "Student removed successfully!");
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Invalid input for Roll Number!");
            }
        }
    }
}
