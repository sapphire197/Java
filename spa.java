import gnu.io.*;
import javax.swing.*;
import java.awt.*;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;

public class SmartPlantWatering extends JFrame {
    private static final String PORT_NAME = "COM3"; // Change to your Arduino's port
    private static final int BAUD_RATE = 9600;

    private SerialPort serialPort;
    private InputStream input;
    private OutputStream output;

    private JLabel moistureLabel;
    private JButton waterButton;

    public SmartPlantWatering() {
        setTitle("Smart Plant Watering System");
        setLayout(new FlowLayout());

        moistureLabel = new JLabel("Soil Moisture: --");
        add(moistureLabel);

        waterButton = new JButton("Water Now");
        add(waterButton);
        waterButton.addActionListener(e -> waterPlant());

        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        initializeSerialConnection();
        new ReadMoistureThread().start();
    }

    private void initializeSerialConnection() {
        try {
            CommPortIdentifier portId = CommPortIdentifier.getPortIdentifier(PORT_NAME);
            serialPort = (SerialPort) portId.open("SmartPlantWatering", 2000);
            serialPort.setSerialPortParams(BAUD_RATE, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
            input = serialPort.getInputStream();
            output = serialPort.getOutputStream();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: Could not connect to Arduino", "Connection Error", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
    }

    private void waterPlant() {
        try {
            output.write('1'); // Send a signal to water the plant
            JOptionPane.showMessageDialog(this, "Watering the plant...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private class ReadMoistureThread extends Thread {
        public void run() {
            while (true) {
                try {
                    if (input.available() > 0) {
                        byte[] buffer = new byte[1024];
                        int len = input.read(buffer);
                        if (len > 0) {
                            String moistureValue = new String(buffer, 0, len).trim();
                            SwingUtilities.invokeLater(() -> moistureLabel.setText("Soil Moisture: " + moistureValue));

                            // Automatically water the plant if moisture is too low
                            if (Integer.parseInt(moistureValue) < 400) {
                                waterPlant();
                            }
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(SmartPlantWatering::new);
    }
}