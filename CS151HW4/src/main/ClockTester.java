package main;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ClockTester {
	// Variables
	private static final int CLOCK_RADIUS = 500;
	private static MyStopWatch stopwatch = new MyStopWatch(CLOCK_RADIUS);
	private static MyClock clock = new MyClock(CLOCK_RADIUS);
	private static JFrame frame = new JFrame();
	private static JFrame clockFrame = new JFrame();
	
	// Main
	public static void main(String[] args) {
		//
		stopwatch.getSecDial().add(stopwatch.getMinDial());
		frame.setLayout(new BorderLayout());
		clockFrame.setLayout(new BorderLayout());
		clockFrame.add(clock.getFace(), BorderLayout.CENTER);
		frame.add(stopwatch.getSecDial(), BorderLayout.CENTER);

		// Bottom Buttons
		JPanel bottomNav = new JPanel(new FlowLayout());
		JButton stop = new JButton("Stop");
		stop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				stopwatch.stopTimer();
			}
		});
		JButton start = new JButton("Start");
		start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				stopwatch.startTimer();
			}
		});
		JButton restart = new JButton("Restart");
		restart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				// REPOSITIONS THE HANDS AND STARTS FROM 0 WITHOUT STARTING AGAIN
				stopwatch.restart();
				stopwatch.getSecDial().repaint();
				stopwatch.getMinDial().repaint();
			}
		});
		bottomNav.add(restart);
		bottomNav.add(start);
		bottomNav.add(stop);
		// Top Buttons
		JPanel topNav = new JPanel(new FlowLayout());
		JButton time = new JButton("Clock");
		time.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				clockFrame.add(topNav, BorderLayout.NORTH);
				clockFrame.pack();
				clockFrame.setVisible(true);
				frame.setVisible(false);
			}
		});
		topNav.add(time);
		JButton stopWatchButt = new JButton("Stopwatch");
		stopWatchButt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				frame.add(bottomNav, BorderLayout.SOUTH);
				frame.add(topNav, BorderLayout.NORTH);
				frame.pack();
				frame.setVisible(true);
				clockFrame.setVisible(false);
			}
		});
		topNav.add(stopWatchButt);



		// DISPLAYS CLOCK FIRST
		stopwatch.getSecDial().repaint();
		stopwatch.getMinDial().repaint();
		clockFrame.add(topNav, BorderLayout.NORTH);
		clock.getFace().repaint();

		clockFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		clockFrame.pack();
		clockFrame.setVisible(true);
	}


}
