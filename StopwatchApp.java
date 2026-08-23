import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class StopwatchApp extends JFrame {
    private final JLabel timeLabel;
    private final JButton startButton;
    private final JButton stopButton;
    private final JButton resetButton;

    private volatile boolean running;
    private long startTime;
    private long elapsedTime;
    private Thread workerThread;

    public StopwatchApp() {
        setTitle("Stopwatch - Multithreaded");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(320, 180));

        timeLabel = new JLabel(formatTime(0), JLabel.CENTER);
        timeLabel.setFont(new Font(Font.MONOSPACED, Font.BOLD, 36));

        startButton = new JButton("Start");
        stopButton = new JButton("Stop");
        resetButton = new JButton("Reset");

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                start();
            }
        });

        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stop();
            }
        });

        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reset();
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(startButton);
        buttonPanel.add(stopButton);
        buttonPanel.add(resetButton);

        add(timeLabel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
        pack();
        setLocationRelativeTo(null);
    }

    private synchronized void start() {
        if (running) {
            return;
        }
        running = true;
        startTime = System.currentTimeMillis() - elapsedTime;
        workerThread = new Thread(new StopwatchRunnable());
        workerThread.start();
    }

    private synchronized void stop() {
        running = false;
        if (workerThread != null) {
            workerThread.interrupt();
        }
    }

    private synchronized void reset() {
        running = false;
        elapsedTime = 0;
        timeLabel.setText(formatTime(0));
        if (workerThread != null) {
            workerThread.interrupt();
        }
    }

    private String formatTime(long milliseconds) {
        long totalSeconds = milliseconds / 1000;
        long minutes = totalSeconds / 60;
        long seconds = totalSeconds % 60;
        long centis = (milliseconds % 1000) / 10;
        return String.format("%02d:%02d:%02d", minutes, seconds, centis);
    }

    private class StopwatchRunnable implements Runnable {
        @Override
        public void run() {
            while (running) {
                elapsedTime = System.currentTimeMillis() - startTime;
                SwingUtilities.invokeLater(() -> timeLabel.setText(formatTime(elapsedTime)));
                try {
                    Thread.sleep(20);
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            StopwatchApp app = new StopwatchApp();
            app.setVisible(true);
        });
    }
}
