package com.lab04.inClass;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class NiceQuote extends JFrame {
	JFrame frame;
	JPanel panel, imagepanel, bigpanel;
	JLabel label;
	JTextField textField;
	JTextArea textArea;
	JFileChooser chooser;
	JMenuBar menubar;
	JMenu menu;
	JMenuItem menuItem1;
	JMenuItem menuItem2;
	JMenuItem menuItem3;
	File file;
	Image image;
	ImagePanel imagePanel;

	public NiceQuote() {
		frame = new JFrame("NiceQuote");
		frame.setLayout(new BorderLayout());
		createMenuBar();
		bigpanel = new JPanel(new BorderLayout());
		frame.add(bigpanel, BorderLayout.CENTER);
		panel = new JPanel();
		bigpanel.add(panel, BorderLayout.NORTH);
		label = new JLabel("Quote :");
		textField = new JTextField(30);
		textField.setFocusable(false);
		panel.add(label);
		panel.add(textField);
		imageSite();

	}

	public void createAndShowGUI() {
		frame.setPreferredSize(new Dimension(700, 500));
		frame.setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.pack();
	}

	public void createMenuBar() {
		menubar = new JMenuBar();
		frame.add(menubar, BorderLayout.PAGE_START);
		menu = new JMenu("File");
		menubar.add(menu);
		menuItem1 = new JMenuItem(new NewAction());
		menuItem2 = new JMenuItem(new LoadBackground());
		menuItem3 = new JMenuItem(new QuitAction());
		menu.add(menuItem1);
		menu.add(menuItem2);
		menu.addSeparator();
		menu.add(menuItem3);

	}

	public void imageSite() {
		imagepanel = new JPanel(new FlowLayout());
//		textArea = new JTextArea();
//		imagepanel.add(textArea);
		imagepanel.setBorder(BorderFactory.createLineBorder(Color.black));
		bigpanel.add(imagepanel, BorderLayout.CENTER);
		textField.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void changedUpdate(DocumentEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void insertUpdate(DocumentEvent arg0) {
				imagePanel.repaint();

			}

			@Override
			public void removeUpdate(DocumentEvent arg0) {
				// TODO Auto-generated method stub
				imagePanel.repaint();
			}

		});
		// imagepanel.setBackground(Color.red);
	}

	class LoadBackground extends AbstractAction {
		public LoadBackground() {
			super("Load Backgroud");
			// putValue(AbstractAction.ACCELERATOR_KEY, KeyStroke.getKeyStroke(
			// KeyEvent.VK_O, ActionEvent.CTRL_MASK));
			putValue(AbstractAction.SHORT_DESCRIPTION, "Load Background image");
		}

		public void actionPerformed(ActionEvent e) {
			chooser = new JFileChooser();
			int returnVal = chooser.showOpenDialog(NiceQuote.this);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				file = chooser.getSelectedFile();
				try {
					image = ImageIO.read(file);
					textField.setFocusable(true);
					frame.setSize(image.getWidth(null)+80, image.getHeight(null)+100);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				imagePanel = new ImagePanel(image);
				imagepanel.add(imagePanel);
				imagePanel.repaint();
			}
			// This demo does nothing with returnVal
		}
	}

	class QuitAction extends AbstractAction {
		public QuitAction() {
			super("Exit");
			// putValue(AbstractAction.ACCELERATOR_KEY,
			// KeyStroke.getKeyStroke(KeyEvent.VK_Q, ActionEvent.ALT_MASK));
			putValue(AbstractAction.SHORT_DESCRIPTION, "Quit the program");
		}

		public void actionPerformed(ActionEvent e) {

			System.exit(0);

		}
	}
	
	class NewAction extends AbstractAction {
		public NewAction() {
			super("New");
			// putValue(AbstractAction.ACCELERATOR_KEY,
			// KeyStroke.getKeyStroke(KeyEvent.VK_Q, ActionEvent.ALT_MASK));
			putValue(AbstractAction.SHORT_DESCRIPTION, "Clear the screen");
		}

		public void actionPerformed(ActionEvent e) {
			textField.setText("");

		}
	}

	class ImagePanel extends JPanel {

		private Image img;

		public ImagePanel(String img) {
			this(new ImageIcon(img).getImage());
		}

		public ImagePanel(Image img) {
			this.img = img;
			Dimension size = new Dimension(img.getWidth(null),
					img.getHeight(null));
			setPreferredSize(size);
			setMinimumSize(size);
			setMaximumSize(size);
			setSize(size);
			setLayout(null);
		}

		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(img, 0, 40, null);
			g.drawString(textField.getText(), 50, 50);
		}

	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				NiceQuote nc = new NiceQuote();
				nc.createAndShowGUI();
			}
		});
	}
}
