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
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JWindow;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

import Application.Application;

/**
 * Class to start splash screen for DIY project.
 * 
 * @author gehry guest
 * @author joseph rushford
 * @version 1.7.44
 */
public class HomePage extends JFrame implements ActionListener {
    
    /** A number for Serialization. */
    private static final long serialVersionUID = -2102839873375270630L;
                    
    /** The width of the panel. */
    private static final int WIDTH = 600;

    /** The height of the panel. */
    private static final int HEIGHT = 700;
    
    
    /** The button for the more tab. */
    private JButton myAddButton;
    
    /** The button for the more tab. */
    private JButton myDeleteButton;
    
    private JButton myAboutButton;
    
    private JButton myImportButton;
    
    private JButton myExportButton;
    private JButton mySettings;
    private Application myApp;
    private final JFileChooser myOpenFile;
    /** stores the information of last opened file. */
    private File myLocation;

	private String myEmail;

	private String myName;
    /**
     * Initializes fields with reasonable values.
     * 
     */
    public HomePage() {
        myOpenFile = new JFileChooser();
        myLocation = new File("project_files");
        myEmail = "Email not Given";
        myName = "Name not Given";
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        
       
        myAddButton = new JButton("Add");
        
        myDeleteButton = new JButton("Dele");
        
        myAboutButton = new JButton("About");
        myImportButton = new JButton("Import");
        myExportButton = new JButton("Export");
        mySettings = new JButton("Settings");
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
        panel.add(myAboutButton, FlowLayout.LEFT);
        panel.add(myAddButton, FlowLayout.LEFT);
        
        panel.add(myDeleteButton, FlowLayout.LEFT);
        
        
        panel.add(myExportButton, FlowLayout.LEFT);
        panel.add(myImportButton, FlowLayout.LEFT);
        panel.add(mySettings, FlowLayout.LEFT);
        myAboutButton.addActionListener(this);
        myExportButton.addActionListener(this);
        myImportButton.addActionListener(this);
        mySettings.addActionListener(this);
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
            new AddPage(this);
            
        } else if (theEvent.getSource() == myAboutButton) {
            
            new AboutMe();
        } else if(theEvent.getSource() == myImportButton) {
        	openFile();
        } else if(theEvent.getSource() == myExportButton) {
        	saveFile();
        } else if(theEvent.getSource() == mySettings) {
        	SettingPopUp set = new SettingPopUp(myEmail, myName);
        	myEmail = set.getEmail();
        	myName = set.getName();
        	
        }
    }
    private void openFile() 
    {
    
        //FileNameExtensionFilter filter = new FileNameExtensionFilter("csv", "txt");
        myOpenFile.setCurrentDirectory(myLocation);
        //myOpenFile.setFileFilter(filter);

        final int returnValue = myOpenFile.showOpenDialog(null); 

        if (returnValue == JFileChooser.APPROVE_OPTION) 
        {
        	try {
        		myLocation = myOpenFile.getCurrentDirectory();
        		Scanner file = new Scanner(myOpenFile.getSelectedFile());
        		if(file.hasNext()) {
        			myEmail = file.next();
        			
        		}
        		if(file.hasNext()) {
        			myName = file.next();
        		}
        		//myApp.loadProjects(file);
        	} catch (final FileNotFoundException e) 
            {
                JOptionPane.showMessageDialog(null, "File Not Found"); 
            }
        }

    }
    private void saveFile() 
    {
    	myOpenFile.setCurrentDirectory(myLocation);
        final int returnValue = myOpenFile.showSaveDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) 
        {
        	try(FileWriter export = new FileWriter(myOpenFile.getSelectedFile()+".csv")) {
        	    export.write(myEmail + "\n" + myName + "\n");
        	    export.close();
        	} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

        }
    }
}
