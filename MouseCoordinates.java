import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class MouseCoordinates extends JFrame {
    private final JLabel coordinateLabel;

    public MouseCoordinates() {
        setTitle("Mouse Coordinates Viewer");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(500, 300));

        coordinateLabel = new JLabel("Move the mouse over the window", JLabel.CENTER);
        coordinateLabel.setFont(coordinateLabel.getFont().deriveFont(16f));

        JPanel contentPanel = new JPanel(new BorderLayout());
        contentPanel.add(coordinateLabel, BorderLayout.SOUTH);
        contentPanel.add(new JLabel("", JLabel.CENTER), BorderLayout.CENTER);
        contentPanel.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseMoved(MouseEvent e) {
                updateCoordinates(e);
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                updateCoordinates(e);
            }
        });

        setContentPane(contentPanel);
        pack();
        setLocationRelativeTo(null);
    }

    private void updateCoordinates(MouseEvent e) {
        coordinateLabel.setText(String.format("Mouse position: x=%d, y=%d", e.getX(), e.getY()));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MouseCoordinates frame = new MouseCoordinates();
            frame.setVisible(true);
        });
    }
}
