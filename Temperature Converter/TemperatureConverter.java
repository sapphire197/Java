import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TemperatureConverter extends JFrame implements ActionListener {
    private JTextField temperatureInput;
    private JRadioButton celsiusButton, fahrenheitButton;
    private JLabel resultLabel;

    public TemperatureConverter() {
        temperatureInput = new JTextField(10);
        celsiusButton = new JRadioButton("Celsius to Fahrenheit");
        fahrenheitButton = new JRadioButton("Fahrenheit to Celsius");
        ButtonGroup group = new ButtonGroup();
        group.add(celsiusButton);
        group.add(fahrenheitButton);
        JButton convertButton = new JButton("Convert");
        resultLabel = new JLabel("Result: ");

        convertButton.addActionListener(this);

        JPanel panel = new JPanel();
        panel.add(new JLabel("Enter Temperature:"));
        panel.add(temperatureInput);
        panel.add(celsiusButton);
        panel.add(fahrenheitButton);
        panel.add(convertButton);
        panel.add(resultLabel);

        setLayout(new FlowLayout());
        add(panel);

        setTitle("Temperature Converter");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            double temp = Double.parseDouble(temperatureInput.getText());
            if (celsiusButton.isSelected()) {
                temp = temp * 9 / 5 + 32;
                resultLabel.setText("Result: " + temp + " F");
            } else if (fahrenheitButton.isSelected()) {
                temp = (temp - 32) * 5 / 9;
                resultLabel.setText("Result: " + temp + " C");
            }
        } catch (NumberFormatException ex) {
            resultLabel.setText("Invalid input!");
        }
    }

    public static void main(String[] args) {
        new TemperatureConverter();
    }
}
