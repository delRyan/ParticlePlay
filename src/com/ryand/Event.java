package com.ryand;

/**
 * Created by Ryan on 8/12/2015.
 */
public class Event implements Comparable<Event> {

    private double time;
    private Particle a, b;
    private int countA, countB;

    public int compareTo(Event that) {
        if(this.time < that.time) return -1;
        if(this.time > that.time) return 1;
        return 0;
    }
}
