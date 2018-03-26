package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class MyClock {

	// Variables
	private int clockRadius;
	private Timer globalTimer; 
	private ClockFace clockFace;
	private ClockHand secondHand;
	private ClockHand minuteHand;
	private ClockHand hourHand;
	
	// Constructor
	public MyClock(int radius) {
		this.clockRadius = radius;
		clockFace = new ClockFace(0, 0, clockRadius);
		
		// Timer to be referenced by all ClockHands
		// Triggers every 1000 milliseconds
		// Shifts the hands and repaints the ClockFace
		globalTimer = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				secondHand.translate();
				minuteHand.translate();
				hourHand.translate();
				clockFace.repaint();
			}
		});
		globalTimer.start();
		
		// Create and Add ClockHands
		secondHand = new ClockHand(HandType.CLOCK_SECOND, clockRadius, globalTimer);
		clockFace.handList.add(secondHand);
		minuteHand = new ClockHand(HandType.CLOCK_MINUTE, clockRadius, globalTimer);
		clockFace.handList.add(minuteHand);
		hourHand = new ClockHand(HandType.CLOCK_HOUR, clockRadius, globalTimer);
		clockFace.handList.add(hourHand);
	}
	
	// Returns ClockFace for JFrame
	public ClockFace getFace() {
		return clockFace;
	}
}
