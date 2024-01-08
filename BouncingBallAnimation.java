import javax.swing.*;
import java.awt.*;

public class BouncingBallAnimation extends JPanel {
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private static final int BALL_SIZE = 50;
    private static final int DELAY = 10;

    private int x = 0;
    private int y = 0;
    private int xSpeed = 4;
    private int ySpeed = 1;

    public BouncingBallAnimation() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.BLACK);

        // Start the animation
        startAnimation();
    }

    private void startAnimation() {
        Timer timer = new Timer(DELAY, e -> {
            // Update ball position
            x += xSpeed;
            y += ySpeed;

            // Check for collision with window boundaries
            if (x <= 0 || x >= WIDTH - BALL_SIZE) {
                xSpeed = -xSpeed;
            }
            if (y <= 0 || y >= HEIGHT - BALL_SIZE) {
                ySpeed = -ySpeed;
            }

            // Repaint the panel
            repaint();
        });
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw the ball
        g.setColor(Color.RED);
        g.fillOval(x, y, BALL_SIZE, BALL_SIZE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Bouncing Ball Animation");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.getContentPane().add(new BouncingBallAnimation());
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
