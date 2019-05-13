/* 
 * TCSS 360
 */

package view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JWindow;
import javax.swing.SwingConstants;
import javax.swing.Timer;

/**
 * Class to start splash screen for DIY project.
 * 
 * @author gehry guest
 * @version 1.7.44
 */
public class SplashScreen extends JWindow {
    
    /** A number for Serialization. */
    private static final long serialVersionUID = -2102839873375270630L;
                    
    /** Constant time for each update. */
    private static final int TIMER_PAUSE = 1; 
    
    /** The width of the panel. */
    private static final int WIDTH = 600;

    /** The height of the panel. */
    private static final int HEIGHT = 700;
    
    /** count to increment bar and check progress of bar. */
    private int myCount = 1;
        
    /** Timer for bar to update to. */
    private Timer mySplashTimer;

    /** loading time. */
    private final int myLoadingTime = 100;
    
    
    /**
     * Initializes fields with reasonable values.
     * 
     */
    public SplashScreen() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        
        mySplashTimer = new Timer(TIMER_PAUSE, new TimeListener());
        
        mySplashTimer.start();
        
        setUp();
    }
    
    
    /**
     * sets up containers, JPanels, and progress bar with layouts and colors.
     * 
     */
    private void setUp() {
        
        final Container container = getContentPane();

        final JPanel panel = new JPanel();
        
        final JLabel imgLabel = new JLabel("",
                                        new ImageIcon("./Resources/App Logo_without name.png"), 
                                        SwingConstants.CENTER);

//        final JLabel text = new JLabel("ADVANTAGE", SwingConstants.CENTER); //option 1
//        final JLabel text = new JLabel("EASY HUB", SwingConstants.CENTER); //option 2
//        final JLabel text = new JLabel("EASYNOTE", SwingConstants.CENTER); //option 3
//        final JLabel text = new JLabel("HITask", SwingConstants.CENTER); //option 4
//      final JLabel text = new JLabel("Outline", SwingConstants.CENTER); //option 4
        
        container.add(panel, BorderLayout.CENTER);
        
        panel.add(imgLabel, BorderLayout.CENTER);
  
        this.pack();
        
        this.setLocationRelativeTo(null);
        
        this.setVisible(true);
    }
    


    /**
    * A inner class that listens for timer events.
    * 
    */
    private class TimeListener implements ActionListener {

        @Override
        public void actionPerformed(final ActionEvent theEvt) {
            
            if (myLoadingTime == myCount) {
                
                mySplashTimer.stop();
                
                SplashScreen.this.setVisible(false);
                
                new HomePage();
            }
            myCount++;
        }
    };
}
