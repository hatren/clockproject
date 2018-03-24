package main;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/*StopWatch: this is to try out the stop watch before adding it to the
 * main project since the stop watch button isn't available yet.
 * (StopWatchTest)
 */
public class StopWatch {
	private static final int CLOCK_RADIUS = 500;
	MyStopWatch stopwatch = new MyStopWatch(CLOCK_RADIUS);
	
	   public static void main(String[] args){
		  JFrame frame = new JFrame();
	      MyClock clock = new MyClock(CLOCK_RADIUS);
	      MyStopWatch stopwatch = new MyStopWatch(CLOCK_RADIUS);
		  
		  frame.setLayout(new BorderLayout());
		  frame.add(clock.getFace(), BorderLayout.CENTER);
		  frame.add(stopwatch.getSecDial(), BorderLayout.CENTER);
		  JPanel topNav = new JPanel(new FlowLayout());
		  JPanel bottomNav = new JPanel(new FlowLayout());
		  // TODO: Implement MyStopwatch class and JFrame for MyStopwatch
	      // TODO: Implement Buttons. Probably just stop the Clocks timer and hide the JFrame with Timer.stop() and JFrame.setVisible(false)
		  JButton time = new JButton("Clock");
		  topNav.add(time);
		  
	      topNav.add(new JButton("Stopwatch"));
	      
	      //adding the stop and start buttons
	      JButton stop = new JButton("stop");
	      JButton start = new JButton("start");
	      JButton redo = new JButton("restart");
	      bottomNav.add(redo);
	      bottomNav.add(start);
	      bottomNav.add(stop);
	      
	      frame.add(topNav, BorderLayout.NORTH);
	      frame.add(bottomNav, BorderLayout.SOUTH);
	      stopwatch.getSecDial().repaint();
	      
	      //starts the stopwatch (working)
	      start.addActionListener( new ActionListener() { 
	    	  public void actionPerformed(ActionEvent event) {
					stopwatch.startTimer();
		   }
	    	  });
	      //stops the stopwatch (working)
	      stop.addActionListener( new ActionListener() { 
	    	  public void actionPerformed(ActionEvent event) {
					stopwatch.stopTimer();
		   }
	    	  });
	      
	      //TODO: actionlistener for time isn't working, must clear stopwatch and set the clock
	      time.addActionListener( new ActionListener() { 
	    	  public void actionPerformed(ActionEvent event) {
	    		  frame.add(clock.getFace(), BorderLayout.CENTER);
	    		  clock.getFace().repaint();
		   }
	    	  });
	      
	      //restarts the Stopwatch
	      redo.addActionListener( new ActionListener() { 
	    	  public void actionPerformed(ActionEvent event) {
	    		  //TODO: have the gui display the watch back at zero
	    		  stopwatch.redo();
		   }
	    	  });
	      
	      
	      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      frame.pack();
	      frame.setVisible(true);
	      
	   }
	
}
