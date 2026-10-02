import javax.swing.*;
import java.util.concurrent.atomic.AtomicLong;

class Main {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Simulation Window");
        Panel simulation = new Panel();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(simulation);
        frame.pack();
        frame.setVisible(true);

        AtomicLong startTime = new AtomicLong(System.currentTimeMillis());
        Timer timer = new Timer(16, e -> {
            for (int i = 0; i < 4; i++) {
                simulation.update();
            }
            if (System.currentTimeMillis() - startTime.get() > 400) {
                simulation.addTrailPoints();
                startTime.set(System.currentTimeMillis());
            }
            simulation.repaint();
        });
        timer.start();
    }
}
