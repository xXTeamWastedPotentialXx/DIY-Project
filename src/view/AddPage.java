package view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import model.Materials;
import model.Project;
import model.Tasks;

public class AddPage extends JFrame implements ChangeListener, ActionListener {
	
    /**
     * 
     */
    private static final long serialVersionUID = 1304544587598674961L;

    /** The width of the panel. */
    private static final int WIDTH = 600;

    /** The height of the panel. */
    private static final int HEIGHT = 700;
    
    /** Integer value to hold difficulty level. */
    private static int myDifficultyValue;
    
    /** The slider for difficulty of project. */
    private JSlider myDifficultySlider;
    
    /** Integer value to hold difficulty level. */
    private static int myPriortyValue;
    
    /** The slider for difficulty of project. */
    private JSlider myPriortySlider;
    
    private JButton myConfirmButton;
    
    private JButton myCancelButton;
    
    private JPanel myMatPan;
    private JPanel myTaskPan;
    private JTextField myName;
    private ArrayList<Materials> myMaterials;
    private ArrayList<Tasks> myTasks;
    private Project myProject;
    private HomePage myHome;
    private JTabbedPane myTab;
    private JScrollPane myMats;
    private JScrollPane myTsks;
    
    public AddPage(HomePage theHome) {
        
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        
        final Container container = getContentPane();
        myHome = theHome;
        final JPanel panel = new JPanel(new GridLayout(0, 1, 0, 20));
        myMats = new JScrollPane();
        myTsks = new JScrollPane();
        myTab = new JTabbedPane();

        
        final JLabel imgLabel = new JLabel("",
                                        new ImageIcon("./Resources/HomePage BackGround.png"), 
                                        SwingConstants.CENTER);
       
        createSliders();
        container.add(panel, BorderLayout.CENTER);
        panel.setOpaque(true);
        myName = new JTextField(20);
        JPanel namePan = new JPanel();
        namePan.add(new JLabel("Project Name:"));
        namePan.add(myName);
        panel.add(namePan);
        myTaskPan = new JPanel();
        myTaskPan.add(new JLabel("Tasks:"));
        JButton t = new JButton();
        t.add(new JLabel("Add Tasks"));
        myTaskPan.add(t);
        
        myMatPan = new JPanel();
        myMatPan.add(new JLabel("Materials:"));
       
        panel.add(myMatPan);

        panel.add(myTaskPan);
        createTabPanes();
        panel.add(myTab);
        JPanel diffPan = new JPanel();
        diffPan.add(new JLabel("Difficulty"));
        diffPan.add(myDifficultySlider);

        panel.add(diffPan);
        JPanel priorPan = new JPanel();
        priorPan.add(new JLabel("Priorty"));
        priorPan.add(myPriortySlider);

        panel.add(priorPan);
        //panel.add(priorPan, BorderLayout.SOUTH);
        container.add(panel, BorderLayout.WEST);
        final JPanel buttonOptions = new JPanel();
        myConfirmButton = new JButton("Confirm");
        myCancelButton = new JButton("Cancel");
        buttonOptions.add(myConfirmButton);
        buttonOptions.add(myCancelButton);
        container.add(buttonOptions, BorderLayout.SOUTH);
        myConfirmButton.addActionListener(this);
        myCancelButton.addActionListener(this);
        this.pack();

        this.setLocationRelativeTo(null);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setResizable(false);

        this.setVisible(true);
    }
    
    
    
    /**
     * creates the slider for the thickness menu.
     * 
     */
    public void createSliders() {
        final int increment = 5;
           
        final int maxNumber = 10;

        myDifficultySlider = new JSlider(SwingConstants.HORIZONTAL, 0, maxNumber, increment);
           
        myDifficultySlider.setMajorTickSpacing(increment);
           
        myDifficultySlider.setMinorTickSpacing(1);
           
        myDifficultySlider.setPaintLabels(true);
           
        myDifficultySlider.setPaintTicks(true);
           
        myDifficultySlider.addChangeListener(this);
           
        myDifficultyValue = increment;
        
        myPriortySlider = new JSlider(SwingConstants.HORIZONTAL, 0, maxNumber, increment);
        
        myPriortySlider.setMajorTickSpacing(increment);
           
        myPriortySlider.setMinorTickSpacing(1);
           
        myPriortySlider.setPaintLabels(true);
           
        myPriortySlider.setPaintTicks(true);
       
        myPriortySlider.addChangeListener(this);
        
        myPriortyValue = increment;
    }
    public void createTabPanes() {
    	myTab.add("Materials", myMats);
    	myTab.add("Tasks", myTsks);
    }

   /**
    * sets the integer value for thickness.
    * 
    * @param theThicknessValue integer for thickness.
    */
    public void setMyDifficultyValue(final int theThicknessValue) {

        myDifficultyValue = theThicknessValue;
    }
       
   /**
    * returns a integer value.
    * 
    * @return myThicknessValue integer from slider.
    */
    public int getMyDifficultyValue() {

        return myDifficultyValue;
    }
    /**
     * sets the integer value for thickness.
     * 
     * @param theThicknessValue integer for thickness.
     */
     public void setMyPriortyValue(final int theThicknessValue) {

         myDifficultyValue = theThicknessValue;
     }
        
    /**
     * returns a integer value.
     * 
     * @return myThicknessValue integer from slider.
     */
     public int getMyPriortyValue() {

         return myDifficultyValue;
     }
    /** {@inheritDoc} */
    @Override
    public void stateChanged(final ChangeEvent theEvent) {
    	if(theEvent.getSource() == myDifficultySlider) {
    		setMyDifficultyValue(myDifficultySlider.getValue());
    	} else if( theEvent.getSource() == myPriortySlider) {
    		setMyPriortyValue(myPriortySlider.getValue());
    	}
    }
    
    @Override
    public void actionPerformed(final ActionEvent theEvent) {
        
        if (theEvent.getSource() == myConfirmButton) {
            this.setVisible(false);
            myHome.setVisible(true);
            
        } else if (theEvent.getSource() == myCancelButton) {
            this.setVisible(false);
            myHome.setVisible(true);
        }
    }
    
}
