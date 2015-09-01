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
        radius = random.nextInt(10); mass = random.nextInt(20);
    }
    public Particle(double  pX, double pY, double vX, double vY, double radius, double mass){
        this.pX = pX; this.pY = pY;
        this.vX = vX; this.vY = vY;
        this.radius = radius; this.mass = mass;
    }

    public void move(double dt){
        pX = pX + vX *dt;
        pY = pY + vY *dt;

        if(pX >= 600 || pX <= 0){bounceOffVerticalWall(); }
        if(pY >= 600 || pY <= 0){bounceOffHorizontalWall(); }
    }

    public int count(){
        return count;
    }

    public double timeToHitHorizontalWall(int areaHeight)
    {
        if      (vY < 0)    { return -pY/vY; }
        else if (vY > 0)    { return (areaHeight-pY)/vY; }

        return Double.POSITIVE_INFINITY;
    }

    public double timeToHitVerticleWall(int areaWidth)
    {
        if      (vX < 0)    { return -pX/vX; }
        else if (vX > 0)    { return (areaWidth-pX)/vX; }

        return Double.POSITIVE_INFINITY;
    }

    public double timeToHit(Particle b)
    {
        return Double.POSITIVE_INFINITY;
    }

    public void bounceOff(Particle b){
        double dx = b.pX - pX;
        double dy = b.pY - pY;
        double dvx = b.vX - vX;
        double dvy = b.vY - vY;

        double velocityDotPosition = dx*dvx + dy*dvy;
        double distance = radius + b.radius;

        //compute the normal force
        double Force = 2* mass * b.mass * velocityDotPosition / ((mass + b.mass) * distance);
        double fx = Force * dx / distance;
        double fy = Force * dy / distance;

        vX += fx / mass;
        vY += fy / mass;
        b.vY -= fy / mass;
        b.vY -= fy / mass;

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
