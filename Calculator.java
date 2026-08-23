import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame implements ActionListener {
    private final JTextField display;
    private String currentOperator = "";
    private double firstValue = 0;
    private boolean startNewNumber = true;

    public Calculator() {
        setTitle("Standard Calculator");
        setSize(340, 420);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        display = new JTextField("0");
        display.setFont(new Font("Arial", Font.BOLD, 26));
        display.setEditable(false);
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setBackground(Color.WHITE);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5, 4, 6, 6));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        String[] buttons = {
            "C", "sqrt", "x^2", "x^3",
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "%", "+"
        };

        for (String label : buttons) {
            JButton button = new JButton(label);
            button.setFont(new Font("Arial", Font.BOLD, 20));
            button.addActionListener(this);
            buttonPanel.add(button);
        }

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        mainPanel.add(display, BorderLayout.NORTH);
        mainPanel.add(buttonPanel, BorderLayout.CENTER);

        add(mainPanel);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        String command = event.getActionCommand();

        if (command.equals("C")) {
            display.setText("0");
            firstValue = 0;
            currentOperator = "";
            startNewNumber = true;
            return;
        }

        if (command.equals("sqrt") || command.equals("x^2") || command.equals("x^3")) {
            performUnaryOperation(command);
            return;
        }

        if (command.equals("+") || command.equals("-") || command.equals("*") || command.equals("/") || command.equals("%")) {
            performBinaryOperation(command);
            return;
        }

        if (command.equals(".")) {
            appendDecimalPoint();
            return;
        }

        appendDigit(command);
    }

    private void performUnaryOperation(String action) {
        try {
            double value = Double.parseDouble(display.getText());
            double result;
            switch (action) {
                case "sqrt" -> result = Math.sqrt(value);
                case "x^2" -> result = value * value;
                case "x^3" -> result = value * value * value;
                default -> result = value;
            }
            display.setText(formatResult(result));
            startNewNumber = true;
        } catch (NumberFormatException e) {
            display.setText("Error");
        }
    }

    private void performBinaryOperation(String action) {
        try {
            double displayedValue = Double.parseDouble(display.getText());
            if (!currentOperator.isEmpty() && !startNewNumber) {
                firstValue = calculate(firstValue, displayedValue, currentOperator);
                display.setText(formatResult(firstValue));
            } else {
                firstValue = displayedValue;
            }
            currentOperator = action;
            startNewNumber = true;
        } catch (NumberFormatException e) {
            display.setText("Error");
        }
    }

    private void appendDecimalPoint() {
        if (startNewNumber) {
            display.setText("0.");
            startNewNumber = false;
            return;
        }
        if (!display.getText().contains(".")) {
            display.setText(display.getText() + ".");
        }
    }

    private void appendDigit(String digit) {
        if (startNewNumber) {
            display.setText(digit);
            startNewNumber = false;
        } else {
            String current = display.getText();
            if (current.equals("0")) {
                display.setText(digit);
            } else {
                display.setText(current + digit);
            }
        }
    }

    private double calculate(double a, double b, String operator) {
        return switch (operator) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            case "/" -> b == 0 ? Double.NaN : a / b;
            case "%" -> a % b;
            default -> b;
        };
    }

    private String formatResult(double value) {
        if (Double.isNaN(value) || Double.isInfinite(value)) {
            return "Error";
        }
        if (value == (long) value) {
            return String.format("%d", (long) value);
        }
        return String.format("%.8f", value).replaceAll("0+$", "").replaceAll("\\.$", "");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Calculator calculator = new Calculator();
            calculator.setVisible(true);
        });
    }
}
