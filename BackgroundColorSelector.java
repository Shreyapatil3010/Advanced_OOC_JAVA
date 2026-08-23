import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class BackgroundColorSelector extends JFrame {
    private final JPanel colorPanel;
    private final JComboBox<String> colorComboBox;

    public BackgroundColorSelector() {
        setTitle("Background Color Selector");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(400, 250));

        colorPanel = new JPanel();
        colorPanel.setBackground(Color.WHITE);

        String[] colors = {"White", "Red", "Green", "Blue", "Yellow", "Cyan", "Magenta", "Gray"};
        colorComboBox = new JComboBox<>(colors);
        colorComboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    colorPanel.setBackground(getColor((String) e.getItem()));
                }
            }
        });

        JLabel instructionLabel = new JLabel("Select a color to change the background:", JLabel.CENTER);

        add(instructionLabel, BorderLayout.NORTH);
        add(colorComboBox, BorderLayout.SOUTH);
        add(colorPanel, BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }

    private Color getColor(String name) {
        return switch (name) {
            case "Red" -> Color.RED;
            case "Green" -> Color.GREEN;
            case "Blue" -> Color.BLUE;
            case "Yellow" -> Color.YELLOW;
            case "Cyan" -> Color.CYAN;
            case "Magenta" -> Color.MAGENTA;
            case "Gray" -> Color.GRAY;
            default -> Color.WHITE;
        };
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            BackgroundColorSelector frame = new BackgroundColorSelector();
            frame.setVisible(true);
        });
    }
}
