import javax.swing.text.GapContent;
import java.awt.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;

public class SpaceObject {
    double x, y;
    double vx, vy;
    double mass;
    double radius;
    Color color;
    ArrayList<Point2D.Double> trailPoints;

    SpaceObject(double x, double y, double vx, double vy, double mass ,double radius, Color color) {
        this.x = x;
        this.y = y;
        this.vx = vx;
        this.vy = vy;
        this.mass = mass;
        this.radius = radius;
        this.color = color;
        this.trailPoints = new ArrayList<>();
    }
    public void paint(Graphics2D g2d) {
        paintTrailPoints(g2d);
        g2d.setColor(color);
        g2d.fillOval((int)(x-radius),(int)(y-radius),(int)radius*2, (int)radius*2);
    }
    public void update(double px, double py, double pmass) {
        double dx = px - x;
        double dy = py - y;
        double dist = Math.sqrt(dx*dx + dy*dy);
        double acceleration = Panel.G * pmass / (dist*dist);
        vx += acceleration * dx / dist * Panel.TIME_STEP;
        vy += acceleration * dy / dist * Panel.TIME_STEP;

        x += vx * Panel.TIME_STEP;
        y += vy * Panel.TIME_STEP;
    }
    public void addTrailPoint() {
        trailPoints.add(new Point2D.Double(x,y));
    }
    public void paintTrailPoints(Graphics2D g2d) {
        g2d.setColor(Color.lightGray);
        for (Point2D.Double p : trailPoints) {
            g2d.fillOval((int)p.x-1,(int)p.y-1,2,2);
        }
    }
}