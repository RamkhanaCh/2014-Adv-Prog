import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

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
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;

public class SelfStudy4 extends JFrame {
	JPanel p = new JPanel();
	private double x = 0.5;
	private JLabel l;


	public SelfStudy4() {
		super("Ramkhana's self-study");
		p.setBorder(BorderFactory.createLineBorder(Color.pink));
		p.setBackground(Color.LIGHT_GRAY);
		p.setLayout(new BorderLayout());
		this.add(p);
		createMenu();
		ImageIcon bird = new ImageIcon("twitterbird.png");
		l = new JLabel("Self-Study 4", bird, JLabel.CENTER);
		l.setLayout(new BorderLayout());
		p.add(l, BorderLayout.PAGE_END);
		p.add( new MyComp());

	}
	
	
	class LoadAction extends AbstractAction {
		public LoadAction() {
			super("Open", new ImageIcon("twitterbird.png"));
			putValue(AbstractAction.ACCELERATOR_KEY, KeyStroke.getKeyStroke(
					KeyEvent.VK_O, ActionEvent.CTRL_MASK));
			putValue(AbstractAction.SHORT_DESCRIPTION, "Open a file");
		}

		public void actionPerformed(ActionEvent e) {
			JFileChooser chooser = new JFileChooser();
			int returnVal = chooser.showOpenDialog(SelfStudy4.this);
			// This demo does nothing with returnVal
		}
	}

	class QuitAction extends AbstractAction {
		public QuitAction() {
			super("Quit", new ImageIcon("quit.png"));
			putValue(AbstractAction.ACCELERATOR_KEY,
					KeyStroke.getKeyStroke(KeyEvent.VK_Q, ActionEvent.ALT_MASK));
			putValue(AbstractAction.SHORT_DESCRIPTION, "Quit the program");
		}

		public void actionPerformed(ActionEvent e) {
			int choice = JOptionPane.showConfirmDialog(SelfStudy4.this,
					"Are you sure?", "Please confirm",
					JOptionPane.YES_NO_OPTION);
			if (choice == JOptionPane.YES_OPTION) {
				System.exit(0);
			}
		}
	}

	class StartAction extends AbstractAction {
		public StartAction() {
			super("Start", new ImageIcon("D:\\coffee.PNG"));
			putValue(AbstractAction.ACCELERATOR_KEY, KeyStroke.getKeyStroke(
					KeyEvent.VK_T, ActionEvent.CTRL_MASK));
			putValue(AbstractAction.SHORT_DESCRIPTION, "Open dialog");
		}

		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(null, "Welcome");
		}
	}

	private void createMenu() {
		JMenuBar menuBar = new JMenuBar();
		JMenu start = new JMenu("Start");
		JMenuItem dialog = new JMenuItem(new StartAction());
		JMenu menuFile = new JMenu("File");
		JMenuItem itemQuit = new JMenuItem(new QuitAction());
		JMenuItem itemLoad = new JMenuItem(new LoadAction());
		itemQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int choice = JOptionPane.showConfirmDialog(SelfStudy4.this,
						"Are you sure?", "Please confirm",
						JOptionPane.YES_NO_OPTION);
				if (choice == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});
		start.add(dialog);
		menuFile.add(itemQuit);
		menuFile.add(itemLoad);
		menuBar.add(start);
		menuBar.add(menuFile);
		this.setJMenuBar(menuBar);

	}

	private void createGUI() {
		SelfStudy4 frame = new SelfStudy4();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(500, 400));
		frame.pack();
		frame.setVisible(true);
		
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				SelfStudy4 s4 = new SelfStudy4();
				s4.createGUI();
			}
		});
	}
	

}
