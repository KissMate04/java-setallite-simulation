import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Panel extends JPanel {
    SpaceObject planet;
    ArrayList<SpaceObject> satellites;

    static final double G = 1.0;
    static final double TIME_STEP = 0.05;
    static final int WIDTH = 1000, HEIGHT = 1000;


    Panel() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.BLACK);

        planet = new SpaceObject((float)WIDTH / 2,(float)HEIGHT / 2,0,0,60000,200,Color.BLUE);
        double orbitRadius = planet.radius + 50;
        satellites = new ArrayList<SpaceObject>();
        for (int i = 0; i < 6; i++) {
            satellites.add(new SpaceObject(planet.x + orbitRadius,planet.y + i*10,0,Math.sqrt(G * planet.mass / orbitRadius),0.6, 5,Color.GRAY));
        }
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        planet.paint(g2d);
        for (SpaceObject sat : satellites) {
            sat.paint(g2d);
        }
        paintUI(g2d);
    }
    public void paintUI(Graphics2D g) {
        g.setColor(Color.WHITE);
        g.setFont(new Font("TimesRoman", Font.BOLD, 16));
        g.drawString(
                "Planet: pos: {" + planet.x +", "+ planet.y+"}, radius: "+(int)planet.radius + ", mass: "+(int)planet.mass,
                2, 20);
        g.drawString("Number of satellites: "+satellites.size(),
                2, 40);
        double speed = Math.sqrt(satellites.getFirst().vx * satellites.getFirst().vx + satellites.getFirst().vy * satellites.getFirst().vy);
        g.drawString("Circular orbit sat speed: "+ speed,
                2, 60);
        speed = Math.sqrt(satellites.get(1).vx * satellites.get(1).vx + satellites.get(1).vy * satellites.get(1).vy);
        g.drawString("Elliptical orbit sat speed: "+ speed,
                2, 80);
    }

    public void update() {
        for (SpaceObject sat : satellites) {
            sat.update(planet.x, planet.y, planet.mass);
        }
    }
    public void addTrailPoints() {
        for (SpaceObject sat : satellites) {
            sat.addTrailPoint();

        }
    }
}