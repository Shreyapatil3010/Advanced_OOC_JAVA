import javax.swing.*;
import java.awt.*;

public class FlowLayoutDemo extends JFrame {
    public FlowLayoutDemo() {
        // Set up the frame
        setTitle("FlowLayout Demo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 200);
        setLocationRelativeTo(null);
        
        // Create a panel with FlowLayout
        // FlowLayout(alignment, horizontalGap, verticalGap)
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 20));
        
        // Add three checkboxes
        panel.add(new JCheckBox("Java"));
        panel.add(new JCheckBox("Python"));
        panel.add(new JCheckBox("C++"));
        
        // Add panel to frame
        add(panel);
        setVisible(true);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new FlowLayoutDemo());
    }
}
