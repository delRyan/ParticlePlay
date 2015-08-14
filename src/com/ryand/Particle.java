package com.ryand;

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

    public Particle(){
        Random generator = new Random(1);

        pX = generator.nextDouble(); pY = generator.nextDouble();
        vX = generator.nextDouble(); vY = generator.nextDouble();
        radius = generator.nextDouble(); mass = generator.nextDouble();
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

    public void bounceOff(Particle b){
        double dx = b.pX - pX;
        double dy = b.pY - pY;
        double dvx = b.vX - vX;
        double dvy = b.vY - vY;

        double velocityDotPosition = dx*dvx + dy*dvy;
        double distance = radius + b.radius;

        //compute the normal force
        double F = 2* mass * b.mass * velocityDotPosition / ((mass + b.mass) * distance);
        double fx = F * dx / distance;
        double fy = F * dy / distance;

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


}
