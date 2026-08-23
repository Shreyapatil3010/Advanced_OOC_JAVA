import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class BounceBall extends JPanel implements Runnable {
    private static final int PANEL_WIDTH = 600;
    private static final int PANEL_HEIGHT = 400;
    private static final int BALL_SIZE = 40;
    private static final int DELAY_MS = 10;

    private int x = 100;
    private int y = 100;
    private int dx = 4;
    private int dy = 4;
    private boolean moving = false;
    private Thread animationThread;

    public BounceBall() {
        setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        setBackground(Color.WHITE);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (!moving) {
                    moving = true;
                    animationThread = new Thread(BounceBall.this);
                    animationThread.start();
                }
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLUE);
        g.fillOval(x, y, BALL_SIZE, BALL_SIZE);
    }

    @Override
    public void run() {
        while (moving) {
            x += dx;
            y += dy;

            if (x <= 0 || x + BALL_SIZE >= getWidth()) {
                dx = -dx;
                x = Math.max(0, Math.min(x, getWidth() - BALL_SIZE));
            }
            if (y <= 0 || y + BALL_SIZE >= getHeight()) {
                dy = -dy;
                y = Math.max(0, Math.min(y, getHeight() - BALL_SIZE));
            }

            repaint();

            try {
                Thread.sleep(DELAY_MS);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Blue Ball Bounce");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.getContentPane().add(new BounceBall());
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
