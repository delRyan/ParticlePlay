package com.ryand;

import java.util.Random;

/**
 * Created by Ryan on 8/12/2015.
 */
public class Particle {

    private double _pX;
    private double _pY;
    private double _vX;
    private double _vY;
    private double _radius;
    private double _mass;

    public Particle(){
        Random generator = new Random(1);

        _pX = generator.nextDouble(); _pY = generator.nextDouble();
        _vX = generator.nextDouble(); _vY = generator.nextDouble();
        _radius = generator.nextDouble(); _mass = generator.nextDouble();
    }
    public Particle(double  pX, double pY, double vX, double vY, double radius, double mass){
        _pX = pX; _pY = pY;
        _vX = vX; _vY = vY;
        _radius = radius; _mass = mass;
    }

    public void move(double dt){
        _pX = _pX + _vX*dt;
        _pY = _pY + _vY*dt;
    }

    public int count(){
        return 0;
    }

    public void bounceOff(Particle b){

    }

    public void bounceOffHorizontalWall(){ _vY = -_vY; }
    public void bounceOffVerticalWall(){ _vX = -_vX; }


}
