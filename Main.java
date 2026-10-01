import javax.swing.*;

class Main {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Simulation Window");
        Panel simulation = new Panel();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(simulation);
        frame.pack();
        frame.setVisible(true);

        Timer timer = new Timer(16, e -> {
            for (int i = 0; i < 4; i++) {
                simulation.update();
            }
            simulation.repaint();
        });
        timer.start();
    }
}
