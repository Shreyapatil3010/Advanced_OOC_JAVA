import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BorderLayoutDemo extends JFrame {
    private final JTextField numberField;
    private final JLabel resultLabel;

    public BorderLayoutDemo() {
        setTitle("BorderLayout Demo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(450, 220);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // North: input prompt and field
        JPanel inputPanel = new JPanel(new BorderLayout(5, 5));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 10));
        inputPanel.add(new JLabel("Enter the number:"), BorderLayout.WEST);
        numberField = new JTextField();
        inputPanel.add(numberField, BorderLayout.CENTER);
        add(inputPanel, BorderLayout.NORTH);

        // Center: result display
        resultLabel = new JLabel("Result will appear here", SwingConstants.CENTER);
        resultLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        resultLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(resultLabel, BorderLayout.CENTER);

        // West: Binary button
        JButton binaryButton = new JButton("Binary");
        binaryButton.addActionListener(createConvertAction("binary"));
        add(binaryButton, BorderLayout.WEST);

        // East: Octal button
        JButton octalButton = new JButton("Octal");
        octalButton.addActionListener(createConvertAction("octal"));
        add(octalButton, BorderLayout.EAST);

        // South: Hex button
        JButton hexButton = new JButton("Hex");
        hexButton.addActionListener(createConvertAction("hex"));
        JPanel southPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        southPanel.add(hexButton);
        southPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
        add(southPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    private ActionListener createConvertAction(String type) {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = numberField.getText().trim();
                if (input.isEmpty()) {
                    showError("Please enter a number.");
                    return;
                }

                try {
                    int value = Integer.parseInt(input);
                    String formatted;
                    switch (type) {
                        case "binary" -> formatted = Integer.toBinaryString(value);
                        case "octal" -> formatted = Integer.toOctalString(value);
                        case "hex" -> formatted = Integer.toHexString(value).toUpperCase();
                        default -> formatted = "";
                    }
                    resultLabel.setText(type.substring(0, 1).toUpperCase() + type.substring(1) + ": " + formatted);
                } catch (NumberFormatException ex) {
                    showError("Enter a valid integer number.");
                }
            }
        };
    }

    private void showError(String message) {
        resultLabel.setText(message);
        resultLabel.setForeground(Color.RED);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new BorderLayoutDemo());
    }
}
