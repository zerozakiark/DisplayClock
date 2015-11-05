import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class DisplayClock extends JFrame {
	
	
	 //Create an analog clock for the current time
	   StillClock clock = new StillClock();
	    

	  //Display hour, minute, and seconds in the message panel
	   MessagePanel messagePanel = new MessagePanel(clock.getHour() +
	      ":" + clock.getMinute() + ":" + clock.getSecond());
	   
  public DisplayClock() {
   

    // Add the clock and message panel to the frame
    add(clock);
    add(messagePanel, BorderLayout.SOUTH);
    
    Timer timer = new Timer(1000, new TimerListener());
    timer.start();
  }
  
   class TimerListener implements ActionListener {
	    @Override 
	    public void actionPerformed(ActionEvent e) {
	      //set new time and 
	      //repaint the clock to 
	      //display current time
	      clock.setCurrentTime();
	      clock.repaint();
	      messagePanel.setMessage(clock.getHour() + ":" + clock.getMinute() + ":" + clock.getSecond());
	    }
	  }

  public static void main(String[] args) {
    DisplayClock frame = new DisplayClock();
    frame.setTitle("DisplayClock");
    frame.setLocationRelativeTo(null); // Center the frame
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(300, 350);
    frame.setVisible(true);
  }
}
