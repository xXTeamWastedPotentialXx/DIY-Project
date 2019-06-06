/* 
 * TCSS 360
 */

package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
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
    
    /** */
    private Application myApp;
    
    /** To bring up directory for user. */
    private final JFileChooser myOpenFile;
    
    /** The button for the more tab. */
    private JButton myAddButton;
    
    /** The button for the more tab. */
    private JButton myDeleteButton;
    
    /** menu bar for GUI. */
    private JMenuBar myMenuBar;
    
    /** The button for the JMenu tab. */
    private JMenu myFileShareMenu;
    
    /** The button for the Other tab. */
    private JMenu myOtherMenu;
    
    /** button for pop up to talk about version.*/
    private JMenuItem myAboutButton;
    
    /** The button for the sort tab. */
    private JMenuItem mySortButton;
    
    /** The button for importing files. */
    private JMenuItem myImportButton;
    
    /** The button for exporting items. */
    private JMenuItem myExportButton;
    
    /** Button for confirming the users settings. */
    private JMenuItem mySettings;
    
    /** stores the information of last opened file. */
    private File myLocation;
    
    /** Creates list for projects. */
    private JList myList;

    /** String for taking users email. */
    private String myEmail;

    /** String for taking users name. */
    private String myName;

    
 
    
    /**
     * Initializes fields with reasonable values.
     * @author gehry guest
     */
    public HomePage() {
        myEmail = "Email not Given";
        
        myName = "Name not Given";
        
        myOpenFile = new JFileChooser();
        
        myLocation = new File("project_files");
        
        myAddButton = new JButton("Add");
        
        myDeleteButton = new JButton("Delete");
        
        myMenuBar = new JMenuBar();
        
        myFileShareMenu = new JMenu("FileSharing...");
        
        myOtherMenu = new JMenu("Options...");

        myImportButton = new JMenuItem("Import");
        
        myExportButton = new JMenuItem("Export");
        
        myAboutButton = new JMenuItem("About");
        
        mySortButton = new JMenuItem("Sort");
        
        mySettings = new JMenuItem("Settings");
        
        setUp();
    }
    
    
    /**
     * sets up containers, JPanels, and progress bar with layouts and colors.
     * @author gehry guest
     */
    private void setUp() {
        
        final Container container = getContentPane();

        final JPanel mainPanel = new JPanel();
        
        setUpMainPanel(mainPanel);
        
        container.add(mainPanel, BorderLayout.CENTER);
 
        displayHome();
    }
    
    
    /**
     * populates the menu bar with actions,buttons and menus.
     * @author gehry guest
     */
    private void setUpMenuBar() {
        
        //height of buttons
        final int width = 100;
        final int height = 20;
        final String buffer = " | ";
        
        //create spacers and make them not selectable.
        final JMenu spacer1 = new JMenu(buffer);
        final JMenu spacer2 = new JMenu(buffer);
        final JMenu spacer3 = new JMenu(buffer);
        final JMenu spacer4 = new JMenu(buffer);
        final JMenu spacer5 = new JMenu(buffer);
        
        spacer1.setEnabled(false);
        spacer2.setEnabled(false);
        spacer3.setEnabled(false);
        spacer4.setEnabled(false);
        spacer5.setEnabled(false);
        
        //to make buttons look like Jmenu items.
        myAddButton.setOpaque(true);
        myAddButton.setContentAreaFilled(false);
        myAddButton.setBorderPainted(false);
        myAddButton.setFocusable(false);
        
        myDeleteButton.setOpaque(true);
        myDeleteButton.setContentAreaFilled(false);
        myDeleteButton.setBorderPainted(false);
        myDeleteButton.setFocusable(false);
        
        customizeJMenuButtons();

        //Set the sizes of the buttons.
        myAddButton.setPreferredSize(new Dimension(width, height));
        myFileShareMenu.setPreferredSize(new Dimension(width, height));
        myOtherMenu.setPreferredSize(new Dimension(width, height));
        myDeleteButton.setPreferredSize(new Dimension(width, height));
        myMenuBar.setPreferredSize(new Dimension(WIDTH, 30));
        
        //Add items to JMenuBar.
        myMenuBar.add(spacer5);
        myMenuBar.add(myAddButton);
        myMenuBar.add(spacer1);
        myMenuBar.add(myDeleteButton);
        myMenuBar.add(spacer2);
        
        //Add items to FileShare SubMenu
        myMenuBar.add(myFileShareMenu);
        myFileShareMenu.add(myImportButton);
        myFileShareMenu.addSeparator();
        myFileShareMenu.add(myExportButton);
        myMenuBar.add(spacer3);
        
        //Add Items to OtherMenu SubMenu.
        myOtherMenu.add(myAboutButton);
        myOtherMenu.addSeparator();
        myOtherMenu.add(mySortButton);
        myOtherMenu.addSeparator();
        myOtherMenu.add(mySettings);
        myMenuBar.add(myOtherMenu);
        myMenuBar.add(spacer4);
        
        //sets the layout through gridbag layout.
        myMenuBar.setLayout(new GridBagLayout());        
    }
    
    
    /**
     * changes the look of the buttons to appear and act similar to jmenus.
     * @author gehry guest
     */
    private void customizeJMenuButtons() {
        
        myAddButton.getModel().addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(final ChangeEvent theE) {
                final ButtonModel model = (ButtonModel) theE.getSource();

                if (model.isRollover()) {
                    myAddButton.setBackground(new Color(163,184,204)); 
                    
                    myAddButton.setOpaque(true);
                } else {
                    myAddButton.setBackground(null);
                    
                    myAddButton.setOpaque(false);
                }
            }
        });
        
        myDeleteButton.getModel().addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(final ChangeEvent theE) {
                final ButtonModel model = (ButtonModel) theE.getSource();

                if (model.isRollover()) {
                    myDeleteButton.setBackground(new Color(163,184,204)); 
                    
                    myDeleteButton.setOpaque(true);
                } else {
                    myDeleteButton.setBackground(null);
                    
                    myDeleteButton.setOpaque(false);
                }
            }
        });
    }
    

    /**
     * This is where we populate the list that appears on the GUI.
     * @author gehry guest
     */
    private void setUpList() {
        
        final String[] col = {"Project: DogHouse \n Difficultly: 3  Tasks Completed: 0/10","erw","wer","erw", "we", "dew", "ewr","45","4","re","fg","fgdfg","dgdfg,","dgdfgdfgd","dfgdgdg","dfgd"};
        
        myList = new JList(col);
        
        myList.setVisibleRowCount(10);
        
        myList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        
        myList.setLayoutOrientation(JList.VERTICAL);
        
        myList.setFixedCellHeight(60);
        
        myList.setFixedCellWidth(580);
    }
    

    /**
     * creates the main panel which everything is built off of.
     * @param theMainPanel
     * @author gehry guest
     */
    private void setUpMainPanel(JPanel theMainPanel) {
        
        final JScrollPane scrollPane = new JScrollPane(myList);
        
        scrollPane.setPreferredSize(new Dimension(WIDTH, 500));
        
        setUpMenuBar();
        
        setUpList();
        
        theMainPanel.add(myMenuBar, BorderLayout.NORTH);
        
        theMainPanel.add(new JScrollPane(myList), BorderLayout.CENTER);
        
        //add action listeners to buttons.
        myAddButton.addActionListener(this);
        
        myDeleteButton.addActionListener(this);
        
        myExportButton.addActionListener(this);
        
        myImportButton.addActionListener(this);
        
        myAboutButton.addActionListener(this);
        
        mySortButton.addActionListener(this);
        
        mySettings.addActionListener(this);
        
        myFileShareMenu.addActionListener(this);
    }
    
    
    /**
     * Sets up size, location, visibility for frame of the home page.
     * @author gehry guest
     */
    private void displayHome() {

        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
    
        this.pack();
    
        this.setLocationRelativeTo(null);
    
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
        this.setResizable(false);
    
        this.setVisible(true);
    }    
    
    /**
     * @author joseph rushford
     */
    private void openFile() {
    
        myOpenFile.setCurrentDirectory(myLocation);

        final int returnValue = myOpenFile.showOpenDialog(null); 

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            try {
                
                myLocation = myOpenFile.getCurrentDirectory();
                
                final Scanner file = new Scanner(myOpenFile.getSelectedFile());
                
                if (file.hasNext()) {
                    
                    myEmail = file.next();
                }
                if (file.hasNext()) {
                    
                    myName = file.next();
                }
                
                myApp.loadProjects(file);
            } catch (final FileNotFoundException e) {
                
                JOptionPane.showMessageDialog(null, "File Not Found"); 
            }
        }
    }
    
    
    /**
     * @author joseph rushford
     */
    private void saveFile() {
        
        myOpenFile.setCurrentDirectory(myLocation);
        
        final int returnValue = myOpenFile.showSaveDialog(null);
        
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            try (FileWriter export = new FileWriter(myOpenFile.getSelectedFile() + ".csv")) {
                
                export.write(myEmail + "\n" + myName + "\n");
                
                export.close();
            } catch (final IOException e1) {
                
                e1.printStackTrace();
            }
        }
    }
   
    
    @Override
    public void actionPerformed(final ActionEvent theEvent) {
        
        if (theEvent.getSource() == myAddButton) {
            this.setVisible(false);
            
            new AddPage(this, myApp);
            
        } else if (theEvent.getSource() == myAboutButton) {
            new AboutMe();
            
        } else if (theEvent.getSource() == myImportButton) {
            openFile();
            
        } else if (theEvent.getSource() == myExportButton) {
            saveFile();
            
        } else if (theEvent.getSource() == mySettings) {
            final SettingPopUp set = new SettingPopUp(myEmail, myName);
            
            myEmail = set.getEmail();
            
            myName = set.getName();
        }
    }
}
