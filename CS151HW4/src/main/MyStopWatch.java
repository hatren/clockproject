package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

//this class is similar to MyClock Class
public class MyStopWatch {
	private ClockFace minDial;
	private ClockFace secDial;
	private ClockHand secondHand;
	private ClockHand minuteHand;
	private Timer timer; 
	private int radius;
	
	public MyStopWatch(int radius) {
		this.radius=radius;
		//create the clock
		minDial = new ClockFace(0,0,30);
		secDial = new ClockFace(0,0,500);
		timer = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				secondHand.translate();
				minuteHand.translate();
				secDial.repaint();
				minDial.repaint();
			}
		});
		
		// Create and Add ClockHands
		secondHand = new ClockHand(HandType.WATCH_SECOND, radius, timer, secDial);
		secDial.handList.add(secondHand);
		minuteHand = new ClockHand(HandType.WATCH_MINUTE, radius, timer, minDial);
		minDial.handList.add(minuteHand);
		
	}
	
	public ClockFace getSecDial() {
		return secDial;
	}
	
	public ClockFace getMinDial() {
		return minDial;
	}
	
	//these next three methods are for the action handler to use and stop/start the watch
	public void startTimer() {
		timer.start();
	}
	
	public void stopTimer() {
		timer.stop();
	}
	
	public void redo() {
		timer.stop();
		//TODO: this method will be used to reset the clock so it needs to reset the hand positions
		//and be able to update the watch display in gui
	}
	
}
