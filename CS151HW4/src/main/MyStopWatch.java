package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

//this class is similar to MyClock Class
public class MyStopWatch {
	
	// Variables
	private ClockFace minDial;
	private ClockFace secDial;
	private ClockHand secondHand;
	private ClockHand minuteHand;
	private Timer timer; 
	private int clockRadius;
	
	// Constructor
	public MyStopWatch(int radius) {
		this.clockRadius=radius;
		// Create two ClockFaces
		minDial = new ClockFace(0,clockRadius/4, clockRadius/2);
		secDial = new ClockFace(0,0, clockRadius);
		secDial.add(minDial);
		timer = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				secondHand.translate();
				minuteHand.translate();
				secDial.repaint();
				minDial.repaint();
			}
		});
		
		//Create and Add ClockHands
		secondHand = new ClockHand(HandType.WATCH_SECOND, radius, timer);
		secDial.handList.add(secondHand);
		minuteHand = new ClockHand(HandType.WATCH_MINUTE, radius/2, timer);
		minDial.handList.add(minuteHand);
		
	}
	
	public ClockFace getSecDial() {
		return secDial;
	}
	
	public ClockFace getMinDial() {
		return minDial;
	}
	
	public void startTimer() {
		timer.start();
	}
	
	public void stopTimer() {
		timer.stop();
	}
	
	// Restarts the StopWatch
	public void restart() {
		timer.stop();
		secondHand.setTime(0);
		minuteHand.setTime(0);
	}
	
}
