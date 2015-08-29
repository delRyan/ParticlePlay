package com.ryand;

/**
 * Created by Ryan on 8/12/2015.
 */
public class Event implements Comparable<Event> {

    public final double time;

    public final Particle a, b;
    private int countA, countB;

    public Event(double time, Particle a, Particle b)
    {
        this.time = time;
        this.a = a;
        this.b = b;

        if(a != null) countA = a.count(); else countA = -1;
        if(b != null) countB = b.count(); else countB = -1;
    }

    public boolean isValid()
    {
        if(a != null && a.count() != countA) return false;
        if(b != null && b.count() != countB) return false;
        return true;
    }

    public int compareTo(Event that)
    {
        if(time < that.time) return -1;
        if(time > that.time) return 1;
        return 0;
    }
}
