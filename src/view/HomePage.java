/* 
 * TCSS 360
 */

package view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JWindow;
import javax.swing.SwingConstants;

/**
 * Class to start splash screen for DIY project.
 * 
 * @author gehry guest
 * @version 1.7.44
 */
public class HomePage extends JFrame implements ActionListener {
    
    /** A number for Serialization. */
    private static final long serialVersionUID = -2102839873375270630L;
                    
    /** The width of the panel. */
    private static final int WIDTH = 600;

    /** The height of the panel. */
    private static final int HEIGHT = 700;
    
    /** The button for the editing tab. */
    private RoundButton myEditButton;
    
    /** The button for the more tab. */
    private RoundButton myAddButton;
    
    /** The button for the more tab. */
    private RoundButton myDeleteButton;
    
    private RoundButton myAboutButton;
    
   
    /**
     * Initializes fields with reasonable values.
     * 
     */
    public HomePage() {
        
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        
        myEditButton = new RoundButton("Edit");
       
        myAddButton = new RoundButton("Add");
        
        myDeleteButton = new RoundButton("Dele");
        
        myAboutButton = new RoundButton("About");
        
        //myMenuBar = new JMenuBar();
        
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
                                        new ImageIcon("./Resources/HomePage BackGround.png"), 
                                        SwingConstants.CENTER);

        container.add(panel, BorderLayout.CENTER);
        
        panel.add(imgLabel, BorderLayout.CENTER);
        
        myAddButton.addActionListener(this);
        
        panel.add(myAddButton, FlowLayout.LEFT);
        
        panel.add(myDeleteButton, FlowLayout.LEFT);
        
        panel.add(myEditButton, FlowLayout.LEFT);
        
        panel.add(myAboutButton, FlowLayout.LEFT);
        
        myAboutButton.addActionListener(this);
        
        //panel.add(myMenuBar);
        
        panel.setOpaque(false);
  
        this.pack();

        this.setLocationRelativeTo(null);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setResizable(false);

        this.setVisible(true);
    }
    
    @Override
    public void actionPerformed(final ActionEvent theEvent) {
        
        if (theEvent.getSource() == myAddButton) {
            this.setVisible(false);
            new AddPage();
            
        } else if (theEvent.getSource() == myAboutButton) {
            
            new AboutMe();
        }
    }
   
}
