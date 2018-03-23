package main;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.time.LocalDateTime;

import javax.swing.Timer;

public class ClockHand implements MoveableShape {

	// Variables
	private Timer globalTimer;
	private HandType type;
	private double handRate;
	private double timeReference;
	private double currentTime;
	private double handRadius;
	private double rotationFactor;
	
	// Constructor
	public ClockHand(HandType type, double clockRadius, Timer globalTimer, ClockFace clock) {
		this.globalTimer = globalTimer;
		this.type = type;
		
		// Initialize the Hands length, rate, and current time
		// Adds the remainder of time to the time reference
		switch(type) {
			case CLOCK_HOUR: 
				this.handRadius = clockRadius/4;
				this.handRate = 3600000;
				this.currentTime = LocalDateTime.now().getHour();
				this.timeReference = LocalDateTime.now().getMinute()*1000;
				rotationFactor = Math.toRadians(30);
				break;
			case CLOCK_MINUTE:
				this.handRadius = 5*clockRadius/16;
				this.handRate = 60000;
				this.currentTime = LocalDateTime.now().getMinute();
				this.timeReference = LocalDateTime.now().getSecond()*1000;
				rotationFactor = Math.toRadians(6);
				break;
			case CLOCK_SECOND:
				this.handRadius = 3*clockRadius/8;
				this.handRate = 1000;
				this.currentTime = (int) LocalDateTime.now().getSecond();
				this.timeReference = currentTime*1000;
				rotationFactor = Math.toRadians(6);
				break;
				// TODO: Implement HandType Cases With Stopwatch
			case WATCH_MINUTE:
				this.handRadius = 5*clockRadius/16;
				this.handRate = 60000;
				this.currentTime = 0;
				this.timeReference = 0;
				rotationFactor = Math.toRadians(6);
				break;
			case WATCH_SECOND:
				this.handRadius = 3*clockRadius/8;
				this.handRate = 1000;
				this.currentTime = 0;
				this.timeReference = 0;
				rotationFactor = Math.toRadians(6);
				break;	
			default:
				throw new Error("Unsupported Type of ClockHand");
		}
	}

	@Override
	// Draws the hand based on 
	public void draw(Graphics2D g2) {
		// Set Stroke
		switch(type) {
			case CLOCK_HOUR: 
				g2.setColor(Color.BLACK);
				g2.setStroke(new BasicStroke(5f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND, 1f));
				break;
			case CLOCK_MINUTE:
				g2.setColor(Color.BLACK);
				g2.setStroke(new BasicStroke(3f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND, 1f));
				break;
			case CLOCK_SECOND:
				g2.setStroke(new BasicStroke(1f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND, 1f));
				g2.setColor(Color.RED);
				break;
			// Use these for stopwatch
			case WATCH_MINUTE:
				break;
				
			case WATCH_SECOND:
				break;
			default:
				throw new Error("Unsupported Type of ClockHand");
		}
		
		// x = R*cos((t-15)*theta)
		// y = R*sin((t-15)*theta)
		// Add 250 to adjust for Java coordinates
		g2.drawLine(250, 250,
				(int) (handRadius*Math.cos((currentTime-15)*rotationFactor) +250), 
				(int) (handRadius*Math.sin((currentTime-15)*rotationFactor) +250));
	}
	
	@Override
	// Adjusts the current time
	public void translate() {
		// How much time has passed since the last tick
		timeReference += globalTimer.getDelay();
		if(timeReference >= handRate) {
			currentTime++;
			if(type == HandType.CLOCK_HOUR) {
				currentTime = currentTime%12;
			}
			else {
				currentTime = currentTime%60;
			}
		}
			// Reset Time Reference
			timeReference -= handRate;
	}

	// TODO: May need a setTime() method to reinitialize time. Use LocalDateTime.now().get_____()
}

