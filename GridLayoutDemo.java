import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GridLayoutDemo extends JFrame {
    private JButton[] buttons;
    private int[] numbers;
    private int selectedIndex = -1;
    
    public GridLayoutDemo() {
        // Set up the frame
        setTitle("GridLayout Demo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        
        // Create a panel with GridLayout (2 rows, 3 columns)
        JPanel panel = new JPanel(new GridLayout(2, 3, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        // Initialize numbers array
        numbers = new int[]{1, 2, 3, 4, 5, 6};
        buttons = new JButton[6];
        
        // Create buttons and add to panel
        for (int i = 0; i < 6; i++) {
            buttons[i] = new JButton(String.valueOf(numbers[i]));
            buttons[i].setFont(new Font("Arial", Font.BOLD, 24));
            buttons[i].setFocusPainted(false);
            int index = i;
            buttons[i].addActionListener(e -> handleButtonClick(index));
            panel.add(buttons[i]);
        }
        
        // Add panel to frame
        add(panel);
        setVisible(true);
    }
    
    private void handleButtonClick(int index) {
        if (selectedIndex == -1) {
            // First click - select this button
            selectedIndex = index;
            buttons[index].setBackground(Color.YELLOW);
            buttons[index].setOpaque(true);
            buttons[index].setForeground(Color.BLACK);
        } else if (selectedIndex == index) {
            // Clicking the same button - deselect
            buttons[index].setBackground(UIManager.getColor("Button.background"));
            buttons[index].setOpaque(false);
            selectedIndex = -1;
        } else {
            // Second click - swap numbers
            int temp = numbers[selectedIndex];
            numbers[selectedIndex] = numbers[index];
            numbers[index] = temp;
            
            // Update button displays
            buttons[selectedIndex].setText(String.valueOf(numbers[selectedIndex]));
            buttons[index].setText(String.valueOf(numbers[index]));
            
            // Deselect the first button
            buttons[selectedIndex].setBackground(UIManager.getColor("Button.background"));
            buttons[selectedIndex].setOpaque(false);
            selectedIndex = -1;
        }
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GridLayoutDemo());
    }
}
