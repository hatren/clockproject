package main;

import java.awt.*;
import javax.swing.*;

/**
   This program implements an animation that moves
   a car shape.
*/
public class ClockTester
{
   public static void main(String[] args)
   {
      JFrame frame = new JFrame();
      MyClock clock = new MyClock(CLOCK_RADIUS);
      
      frame.setLayout(new BorderLayout());
      frame.add(clock.getFace(), BorderLayout.CENTER);
      
      JPanel topNav = new JPanel(new FlowLayout());
      
      // TODO: Implement MyStopwatch class and JFrame for MyStopwatch
      // TODO: Implement Buttons. Probably just stop the Clocks timer and hide the JFrame with Timer.stop() and JFrame.setVisible(false)
      topNav.add(new JButton("Clock"));
      topNav.add(new JButton("Stopwatch"));
      frame.add(topNav, BorderLayout.NORTH);
      clock.getFace().repaint();

      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.pack();
      frame.setVisible(true);
   }

   private static final int CLOCK_RADIUS = 500;
}
