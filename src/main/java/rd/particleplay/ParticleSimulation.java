package rd.particleplay;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Ryan on 8/26/2015.
 */
public class ParticleSimulation extends JPanel{

    PriorityQueue<Event> events;

    private double t = 0.0;
    private double hz = 1;
    private double limit = 10000;

    private Particle[] particles;

    public ParticleSimulation(Particle[] particles)
    {
        this.particles = particles;
    }

    public void simulate(double limit, double hz)
    {
        this.limit = limit;
        this.hz = hz;

        events = new PriorityQueue(100);

        for(int i = 0; i < particles.length; i++)
        {
            predictCollisions(particles[i], limit);
        }

        events.insert(new Event(0, null, null));

        while(true)
        {
            Event event = events.deleteMinimum();
            if(!event.isValid()) { continue; }

            for(int i = 0; i < particles.length; i++)
            {
                particles[i].move(event.time - t);
            }
            t = event.time;

            Particle a = event.a;
            Particle b = event.b;

            if      (a != null && b != null) {a.bounceOff(b);}
            else if (a != null && b == null) {a.bounceOffVerticalWall();}
            else if (a == null && b != null) {b.bounceOffHorizontalWall();}
            else if (a == null && b == null) {redraw();}

            predictCollisions(a, limit);
            predictCollisions(b, limit);
        }
    }

    public void redraw()
    {
        repaint();

        if(t < limit) {events.insert(new Event(t + 1/hz, null, null));}
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D gg = (Graphics2D)g;

        for(int i = 0; i < particles.length; i++)
        {
            particles[i].draw(gg);
            //particles[i].move(hz);
        }
        //try {
         //   Thread.sleep(100);
        //} catch (InterruptedException e) {
        //    e.printStackTrace();
       // }
    }

    public void predictCollisions(Particle a, double limit)
    {
        if(a == null){ return; }

        for(int i = 0; i < particles.length; i++)
        {
            double dt = a.timeToHit(particles[i]);
            if(t + dt <= limit){ events.insert(new Event(t+dt, a, particles[i])); }
        }

        double dtX = a.timeToHitHorizontalWall(this.getWidth());
        if(t + dtX <= limit){ events.insert(new Event(t+dtX, a, null)); }

        double dtY = a.timeToHitVerticleWall(this.getHeight());
        if(t + dtY <= limit){ events.insert(new Event(t+dtY, null, a)); }
    }



    public static void main(String[] args)
    {
        JFrame mainFrame = new JFrame("Particle Play");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        int numberOfParticles = 10;
        int sideSize = 600;

        Particle[] initParticles = new Particle[numberOfParticles];
        for(int i = 0; i < numberOfParticles; i++)
        {
            initParticles[i] = new Particle();
        }

        ParticleSimulation sim = new ParticleSimulation(initParticles);

        mainFrame.setPreferredSize(new Dimension(sideSize, sideSize));
        mainFrame.setResizable(false);

        mainFrame.add(sim);
        mainFrame.pack();

        mainFrame.setVisible(true);

        sim.simulate(10000, 1);
    }
}
