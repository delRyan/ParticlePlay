package com.ryand;

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

    public Particle(double  pX, double pY, double vX, double vY, double radius, double mass){
        _pX = pX; _pY = pY;
        _vX = vX; _vY = vY;
        _radius = radius; _mass = mass;
    }


}
