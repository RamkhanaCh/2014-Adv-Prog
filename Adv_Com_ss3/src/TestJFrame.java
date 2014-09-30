import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class TestJFrame extends JFrame {
	static JSlider j;
	static JLabel sliderLabel;

	public static void createAndShowGUI() {
		JFrame frame = new JFrame("Ramkhana's Self-Study 3");
		frame.setVisible(true);

		// JPanel
		JPanel p = new JPanel();
		p.setBackground(Color.pink);
		JPanel p1 = new JPanel();
		p1.setBackground(Color.pink);
		frame.add(p);
		frame.add(p1);

		// JLabel
		ImageIcon icon = new ImageIcon("D:\\coffee.PNG");
		JLabel label = new JLabel("Hello java", icon, JLabel.CENTER);
		p.add(label);

		// JButton
		JButton bt[] = new JButton[3];
		frame.setLayout(new GridLayout(6, 1));
		bt[0] = new JButton("Button 1");
		p1.add(bt[0]);
		bt[1] = new JButton("Button 2");
		p1.add(bt[1]);
		bt[2] = new JButton("Button 3");
		p1.add(bt[2]);

		// JTextArea
		final JTextArea t = new JTextArea();
		t.setBackground(Color.cyan);
		frame.add(t);
		JScrollPane scroll = new JScrollPane(t);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		frame.add(scroll);

		// Actionlistener
		bt[0].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Execute when button is pressed
				t.append("You clicked the first button \n");
			}
		});
		bt[1].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Execute when button is pressed
				t.append("You clicked the second button \n");
			}
		});
		bt[2].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Execute when button is pressed
				t.append("You clicked the last button \n");
			}
		});

		// JSlider
		j = new JSlider(JSlider.HORIZONTAL, 0, 20, 0);
		j.setMajorTickSpacing(5);
		j.setPaintTicks(true);
		frame.add(j);
		Event e = new Event();
		j.addChangeListener(e);
		sliderLabel = new JLabel("Current value = 0", JLabel.CENTER);
		sliderLabel.setLayout(new BorderLayout());
		frame.add(sliderLabel);

		// Bottom part of page
		JPanel p2 = new JPanel();
		p2.setLayout(new BorderLayout());
		frame.add(p2);
		JButton button = new JButton("End");
		JButton button2 = new JButton("Click");
		p2.setBackground(Color.yellow);
		p2.add(button, BorderLayout.WEST);
		p2.add(button2, BorderLayout.EAST);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Execute when button is pressed
				t.append("Program is stopped. \n");
			}
		});
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Execute when button is pressed
				t.append("Welcome. \n");
			}
		});
		frame.pack();
	}

	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});

	}
}
