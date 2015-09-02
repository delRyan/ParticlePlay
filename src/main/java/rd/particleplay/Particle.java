package rd.particleplay;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.Random;

/**
 * Created by Ryan on 8/12/2015.
 */
public class Particle {

    private double pX;
    private double pY;
    private double vX;
    private double vY;
    private double radius;
    private double mass;

    private int count;

    private Random random = new Random();

    public Particle(){

        pX = random.nextInt(200); pY = random.nextInt(200);
        vX = random.nextInt(5); vY = random.nextInt(5);
        radius = random.nextInt(10) + 5; mass = radius;
    }
    public Particle(double  pX, double pY, double vX, double vY, double radius, double mass){
        this.pX = pX; this.pY = pY;
        this.vX = vX; this.vY = vY;
        this.radius = radius; this.mass = mass;
    }

    public void move(double dt){
        pX = pX + vX *dt;
        pY = pY + vY *dt;
    }

    public int count(){
        return count;
    }

    public double timeToHitHorizontalWall(int areaHeight)
    {
        if      (vY < 0)    { return -(pY)/vY; }
        else if (vY > 0)    { return ((areaHeight-radius*2)-(pY))/vY; }

        return Double.POSITIVE_INFINITY;
    }

    public double timeToHitVerticalWall(int areaWidth)
    {
        if      (vX < 0)    { return -pX/vX; }
        else if (vX > 0)    { return ((areaWidth-radius*2)-(pX))/vX; }

        return Double.POSITIVE_INFINITY;
    }

    public double timeToHit(Particle b)
    {
        if (this == b) return Double.POSITIVE_INFINITY;

        double dx  = b.pX - pX;
        double dy  = b.pY - pY;
        double dvx = b.vX - vX;
        double dvy = b.vY - vY;
        double dvdr = dx*dvx + dy*dvy;

        if (dvdr > 0) return Double.POSITIVE_INFINITY;

        double dvdv = dvx*dvx + dvy*dvy;
        double drdr = dx*dx + dy*dy;
        double sigma = radius + b.radius;
        double d = (dvdr*dvdr) - dvdv * (drdr - sigma*sigma);

        if (d < 0) return Double.POSITIVE_INFINITY;

        return -(dvdr + Math.sqrt(d)) / dvdv;
    }

    public void bounceOff(Particle b){
        double dx  = b.pX - pX;
        double dy  = b.pY - pY;
        double dvx = b.vX - vX;
        double dvy = b.vY - vY;
        double dvdr = dx*dvx + dy*dvy;
        double dist = radius + b.radius;

        double F = 2 * this.mass * b.mass * dvdr / ((mass + b.mass) * dist);
        double fx = F * dx / dist;
        double fy = F * dy / dist;

        vX += fx / mass;
        vY += fy / mass;
        b.vX -= fx / b.mass;
        b.vY -= fy / b.mass;

        count++;
        b.count++;
    }

    public void bounceOffHorizontalWall()
    {
        vY = -vY;
        count++;
    }
    public void bounceOffVerticalWall()
    {
        vX = -vX;
        count++;
    }

    public void draw(Graphics2D gg)
    {
        Ellipse2D.Double circle = new Ellipse2D.Double(pX, pY, radius*2, radius*2);
        gg.fill(circle);
    }
}
