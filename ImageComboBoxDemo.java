import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.image.BufferedImage;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class ImageComboBoxDemo extends JFrame {
    private final JLabel imageLabel;
    private final JComboBox<String> imageComboBox;
    private final Map<String, ImageIcon> imageMap;

    public ImageComboBoxDemo() {
        setTitle("Image Selector with JComboBox");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(400, 350));

        imageMap = createImageMap();
        imageComboBox = new JComboBox<>(imageMap.keySet().toArray(new String[0]));
        imageComboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    String selectedName = (String) e.getItem();
                    imageLabel.setIcon(imageMap.get(selectedName));
                    imageLabel.setText(selectedName);
                }
            }
        });

        imageLabel = new JLabel(imageMap.values().iterator().next());
        imageLabel.setHorizontalAlignment(JLabel.CENTER);
        imageLabel.setVerticalAlignment(JLabel.CENTER);
        imageLabel.setPreferredSize(new Dimension(320, 240));
        imageLabel.setText(imageComboBox.getItemAt(0));
        imageLabel.setHorizontalTextPosition(JLabel.CENTER);
        imageLabel.setVerticalTextPosition(JLabel.BOTTOM);

        JPanel topPanel = new JPanel();
        topPanel.add(imageComboBox);

        add(topPanel, BorderLayout.NORTH);
        add(imageLabel, BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }

    private Map<String, ImageIcon> createImageMap() {
        Map<String, ImageIcon> map = new LinkedHashMap<>();
        map.put("Red Square", new ImageIcon(createColoredImage(Color.RED, "Square")));
        map.put("Green Circle", new ImageIcon(createColoredImage(Color.GREEN, "Circle")));
        map.put("Blue Triangle", new ImageIcon(createColoredImage(Color.BLUE, "Triangle")));
        return map;
    }

    private BufferedImage createColoredImage(Color color, String shape) {
        int width = 280;
        int height = 200;
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = image.createGraphics();
        try {
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(Color.WHITE);
            g2.fillRect(0, 0, width, height);
            g2.setColor(color);
            int inset = 40;
            switch (shape) {
                case "Circle" -> g2.fillOval(inset, inset, width - 2 * inset, height - 2 * inset);
                case "Triangle" -> g2.fillPolygon(
                        new int[] {width / 2, inset, width - inset},
                        new int[] {inset, height - inset, height - inset},
                        3);
                default -> g2.fillRect(inset, inset, width - 2 * inset, height - 2 * inset);
            }
        } finally {
            g2.dispose();
        }
        return image;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ImageComboBoxDemo frame = new ImageComboBoxDemo();
            frame.setVisible(true);
        });
    }
}
