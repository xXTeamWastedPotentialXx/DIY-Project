/* 
 * TCSS 360
 */

package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.ButtonModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
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
    
    /** menu bar for GUI. */
    private JMenuBar myMenuBar;
    
    /** The button for the more tab. */
    private JButton myAddButton;
    
    /** The button for the more tab. */
    private JButton myDeleteButton;
    
    /** button for pop up to talk about version.*/
    private JMenuItem myAboutButton;
    
    private JMenuItem mySortButton;
    
    private JMenu myFileShareMenu;
    
    private JMenu myOtherMenu;
    
    private JMenuItem myImportButton;
    
    private JMenuItem myExportButton;
    
    private Application myApp;
    
    private final JFileChooser myOpenFile;
    
    /** stores the information of last opened file. */
    private File myLocation;
    
    private JList myList;

    private String myEmail;

    private String myName;

    private JButton mySettings;
    
    //make jmenu bar
    //list of buttons, examples on canvas.
    //make each list item into its own page.
    //
    /**
     * Initializes fields with reasonable values.
     * 
     */
    public HomePage() {
        
        
        myEmail = "Email not Given";
        
        myName = "Name not Given";
        

        mySettings = new JButton("Settings");
        
        //JScrollPane listScroller = new JScrollPane(myList);
        
        //listScroller.setPreferredSize(new Dimension(250, 80));
        myOpenFile = new JFileChooser();
        
        myLocation = new File("project_files");
        
        myMenuBar = new JMenuBar();
        
        myAddButton = new JButton("Add");
        
        myDeleteButton = new JButton("Delete");
        
        myFileShareMenu = new JMenu("FileSharing...");
        
        myOtherMenu = new JMenu("Options...");

        myImportButton = new JMenuItem("Import");
        
        myExportButton = new JMenuItem("Export");
        
        myAboutButton = new JMenuItem("About");
        
        mySortButton = new JMenuItem("Sort");
        
        setUp();
    }
    
    /**
     * sets up containers, JPanels, and progress bar with layouts and colors.
     * 
     */
    private void setUp() {
        
        final Container container = getContentPane();

        final JPanel mainPanel = new JPanel();
        
        setUpMainPanel(mainPanel);
        
        container.add(mainPanel, BorderLayout.CENTER);
 
        displayHome();
    }
    
    private void setUpMenuBar() {
        
        //height of buttons
        final int width = 100;
        final int height = 20;
        
        //create spacers and make them not clickable.
        JMenu spacer1 = new JMenu(" | ");
        spacer1.setEnabled(false);
        JMenu spacer2 = new JMenu(" | ");
        spacer2.setEnabled(false);
        JMenu spacer3 = new JMenu(" | ");
        spacer3.setEnabled(false);
        JMenu spacer4 = new JMenu(" | ");
        spacer4.setEnabled(false);
        JMenu spacer5 = new JMenu(" | ");
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
        
        
        //myAddButton.setRolloverEnabled(true);
        myAddButton.getModel().addChangeListener(new ChangeListener()
        {
            @Override
            public void stateChanged(ChangeEvent e) 
            {
                ButtonModel model = (ButtonModel) e.getSource();

                if(model.isRollover())
                {
                    myAddButton.setBackground(new Color(163,184,204)); //Changes the colour of the button
                    myAddButton.setOpaque(true);
                } 

                else 
                {
                    myAddButton.setBackground(null);
                    myAddButton.setOpaque(false);
                }
             }
        });
        
        myDeleteButton.getModel().addChangeListener(new ChangeListener()
        {
            @Override
            public void stateChanged(ChangeEvent e) 
            {
                ButtonModel model = (ButtonModel) e.getSource();

                if(model.isRollover())
                {
                    myDeleteButton.setBackground(new Color(163,184,204)); //Changes the colour of the button
                    myDeleteButton.setOpaque(true);
                } 

                else 
                {
                    myDeleteButton.setBackground(null);
                    myDeleteButton.setOpaque(false);
                }
             }
        });
        
        
        
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
        myMenuBar.add(myOtherMenu);
        myMenuBar.add(spacer4);
        
        //sets the layout through gridbag layout.
        myMenuBar.setLayout(new GridBagLayout());
        //myMenuBar.setBackground(new Color(40,83,135));
        
    }

    private void setUpList() {
        
        String[] col = {"Project: DogHouse \n Difficultly: 3  Tasks Completed: 0/10","erw","wer","erw", "we", "dew", "ewr","45","4","re","fg","fgdfg","dgdfg,","dgdfgdfgd","dfgdgdg","dfgd"};
        
        myList = new JList(col);
        
        myList.setVisibleRowCount(10);
        
        myList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        
        myList.setLayoutOrientation(JList.VERTICAL);
        
        //paints each cell in the list
        //myList.setCellRenderer(cellRenderer);
        
        myList.setFixedCellHeight(60);
        
        myList.setFixedCellWidth(580);
    }
    

    
    private void setUpMainPanel(JPanel mainPanel) {
        
        final JLabel imgLabel = new JLabel("",
                                           new ImageIcon("./Resources/HomePage BackGround.png"), 
                                           SwingConstants.CENTER);
        
        
        JScrollPane scrollPane = new JScrollPane(myList);
        
        scrollPane.setPreferredSize(new Dimension(WIDTH,500));
        
        
        setUpMenuBar();
        
        setUpList();
        
        //add finished components to Main Panel.
        
        mainPanel.add(myMenuBar, BorderLayout.NORTH);
        
        mainPanel.add(new JScrollPane(myList), BorderLayout.CENTER);
        
        mainPanel.add(imgLabel, BorderLayout.CENTER);
        
        
        //add action listeners to buttons.
        myAddButton.addActionListener(this);
        
        myDeleteButton.addActionListener(this);
        
        myExportButton.addActionListener(this);
        
        myImportButton.addActionListener(this);
        
        myAboutButton.addActionListener(this);
        
        mySortButton.addActionListener(this);
        
        myFileShareMenu.addActionListener(this);
    }
    
    private void displayHome() {

        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
    
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
            new AddPage(this, myApp);
            
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
    
    private void openFile() {
    
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
                myApp.loadProjects(file);
            } catch (final FileNotFoundException e) 
            {
                JOptionPane.showMessageDialog(null, "File Not Found"); 
            }
        }
    }
    
    private void saveFile() {
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
