package view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class AddPage extends JFrame implements ChangeListener{

    /**
     * 
     */
    private static final long serialVersionUID = 1304544587598674961L;

    /** The width of the panel. */
    private static final int WIDTH = 600;

    /** The height of the panel. */
    private static final int HEIGHT = 700;
    
    /** Integer value to hold thickness of drawings. */
    private static int myThicknessValue;
    
    /** The slider for thickness of drawings. */
    private JSlider myThicknessSlider;
    
    public AddPage() {
        
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        
        final Container container = getContentPane();

        final JPanel panel = new JPanel();
        
        final JLabel imgLabel = new JLabel("",
                                        new ImageIcon("./Resources/HomePage BackGround.png"), 
                                        SwingConstants.CENTER);

        container.add(panel, BorderLayout.CENTER);
       
        container.add(myThicknessSlider,BorderLayout.CENTER);
        
        panel.add(imgLabel, BorderLayout.CENTER);
        
        this.pack();

        this.setLocationRelativeTo(null);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setResizable(false);

        this.setVisible(true);
    }
    
    
    
    /**
     * creates the slider for the thickness menu.
     * 
     * @return JSlider with ticks and numbers.
     */
    public JSlider createSlider() {
        final int increment = 5;
           
        final int maxNumber = 15;

        myThicknessSlider = new JSlider(SwingConstants.HORIZONTAL, 0, maxNumber, increment);
           
        myThicknessSlider.setMajorTickSpacing(increment);
           
        myThicknessSlider.setMinorTickSpacing(1);
           
        myThicknessSlider.setPaintLabels(true);
           
        myThicknessSlider.setPaintTicks(true);
           
        myThicknessSlider.addChangeListener(this);
           
        myThicknessValue = increment;
        
        return myThicknessSlider;
    }

   /**
    * sets the integer value for thickness.
    * 
    * @param theThicknessValue integer for thickness.
    */
    public void setMyThicknessValue(final int theThicknessValue) {

        myThicknessValue = theThicknessValue;
    }
       
   /**
    * returns a integer value.
    * 
    * @return myThicknessValue integer from slider.
    */
    public int getMyThicknessValue() {

        return myThicknessValue;
    }
    
    /** {@inheritDoc} */
    @Override
    public void stateChanged(final ChangeEvent theEvent) {

        setMyThicknessValue(myThicknessSlider.getValue());
    }
    
}
