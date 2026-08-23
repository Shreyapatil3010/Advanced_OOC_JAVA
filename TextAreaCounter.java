import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class TextAreaCounter extends JFrame {
    private final JTextArea textArea;
    private final JLabel countLabel;

    public TextAreaCounter() {
        setTitle("Text Counter");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(500, 350));

        textArea = new JTextArea();
        textArea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 14));
        textArea.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                updateCounts();
            }
        });

        countLabel = new JLabel("Characters: 0    Words: 0");
        countLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 14));

        JPanel statusPanel = new JPanel(new BorderLayout());
        statusPanel.add(countLabel, BorderLayout.CENTER);

        add(new JScrollPane(textArea), BorderLayout.CENTER);
        add(statusPanel, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
    }

    private void updateCounts() {
        String text = textArea.getText();
        int charCount = text.length();
        int wordCount = 0;
        String trimmed = text.trim();
        if (!trimmed.isEmpty()) {
            wordCount = trimmed.split("\\s+").length;
        }
        countLabel.setText(String.format("Characters: %d    Words: %d", charCount, wordCount));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TextAreaCounter frame = new TextAreaCounter();
            frame.setVisible(true);
        });
    }
}
