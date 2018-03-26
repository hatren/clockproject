package main;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ClockTester {
	public static void main(String[] args) {
		// SET UP FRAME BASE
		stopwatch.getSecDial().add(stopwatch.getMinDial());
		frame.setLayout(new BorderLayout());
		clockFrame.setLayout(new BorderLayout());
		clockFrame.add(clock.getFace(), BorderLayout.CENTER);
		frame.add(stopwatch.getSecDial(), BorderLayout.CENTER);

		// SETTING UP THE TOP BUTTONS
		JPanel topNav = new JPanel(new FlowLayout());
		JButton time = new JButton("Clock");
		topNav.add(time);
		JButton stopWatchButt = new JButton("Stopwatch");
		topNav.add(stopWatchButt);
		// SETTING UP THE BOTTOM BUTTONS(ONLY APPEARS WHEN STOPWATCH IS ON)
		JPanel bottomNav = new JPanel(new FlowLayout());
		JButton stop = new JButton("Stop");
		JButton start = new JButton("Start");
		JButton redo = new JButton("Restart");
		bottomNav.add(redo);
		bottomNav.add(start);
		bottomNav.add(stop);
		////////////////////////////////////

		// ACTION LISTENERS FOR CLOCK AND STOPWATCH
		time.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				clockFrame.add(topNav, BorderLayout.NORTH);
				clockFrame.pack();
				clockFrame.setVisible(true);
				frame.setVisible(false);
			}
		});
		stopWatchButt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				frame.add(bottomNav, BorderLayout.SOUTH);
				frame.add(topNav, BorderLayout.NORTH);
				frame.pack();
				frame.setVisible(true);
				clockFrame.setVisible(false);
			}
		});
		///////////////////////////////

		// ACTION LISTENER FOR STOPWATCH BUTTONS
		stopwatch.getSecDial().repaint();
		stopwatch.getMinDial().repaint();
		// starts the stop watch (working)
		start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				stopwatch.startTimer();
			}
		});
		// stops the stop watch (working)
		stop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				stopwatch.stopTimer();
			}
		});
		// restarts the stop watch (working)
		redo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				// REPOSITIONS THE HANDS AND STARTS FROM 0 WITHOUT STARTING AGAIN
				stopwatch.restart();
				stopwatch.getSecDial().repaint();
				stopwatch.getMinDial().repaint();
			}
		});
		//////////////////////////////////////////////

		// DISPLAYS CLOCK FIRST
		clockFrame.add(topNav, BorderLayout.NORTH);
		clock.getFace().repaint();

		clockFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		clockFrame.pack();
		clockFrame.setVisible(true);
	}

	private static final int CLOCK_RADIUS = 500;
	private static MyStopWatch stopwatch = new MyStopWatch(CLOCK_RADIUS);
	private static MyClock clock = new MyClock(CLOCK_RADIUS);
	private static JFrame frame = new JFrame();
	private static JFrame clockFrame = new JFrame();
}
