import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Panel extends JPanel {
    SpaceObject planet;
    ArrayList<SpaceObject> setallites;

    static final double G = 1.0;
    static final double TIME_STEP = 0.05;
    static final int WIDTH = 1000, HEIGHT = 1000;


    Panel() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.BLACK);

        planet = new SpaceObject(0,0,0,0,6000,20,Color.BLUE);
        double r1 = 50;
        setallites = new ArrayList<SpaceObject>();
        setallites.add(new SpaceObject(r1,0,0,Math.sqrt(G * planet.mass / r1),6, 5,Color.GRAY));
        setallites.add(new SpaceObject(r1,20,0,Math.sqrt(G * planet.mass / r1),6, 5,Color.GRAY));
        setallites.add(new SpaceObject(r1,30,0,Math.sqrt(G * planet.mass / r1),6, 5,Color.GRAY));
        setallites.add(new SpaceObject(r1,40,0,Math.sqrt(G * planet.mass / r1),6, 5,Color.GRAY));
        setallites.add(new SpaceObject(r1,50,0,Math.sqrt(G * planet.mass / r1),6, 5,Color.GRAY));


    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        int centerX = WIDTH / 2;
        int centerY = HEIGHT / 2;

        planet.paint(g2d, centerX, centerY);
        for (SpaceObject set : setallites) {
            set.paint(g2d, centerX, centerY);
        }
    }

    public void update() {
        for (SpaceObject set : setallites) {
            set.update(planet.x, planet.y, planet.mass);
        }
    }
}