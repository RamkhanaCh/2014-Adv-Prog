


import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Event extends TestJFrame implements ChangeListener{
		
		public void stateChanged(ChangeEvent e){
			int value = j.getValue();
			sliderLabel.setText("Current value = " + value);
		}
	}
