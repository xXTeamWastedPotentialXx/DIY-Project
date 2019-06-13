package view;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JOptionPane;


/**
 * Class to represent the about me box
 * @author Miranda Bessex
 *
 */
public class AboutMe {
    
    private String version;
    
    private String devolpers;
    
    
    public AboutMe () {
        version = "";
        devolpers = "";
        getVersion();
        
    }
    
    
    private void getVersion() {
        
        try {
            
            Scanner ver = new Scanner(new File("./Resources/version.txt"));
            version += ver.nextLine();
            devolpers += ver.nextLine();
            
        } catch (FileNotFoundException e) {
            
            e.printStackTrace();
        }
        
        aboutMeButtonAction();
    }
    
    private void aboutMeButtonAction() {
        
        JOptionPane.showMessageDialog(null, "About Me: \n Version: " + version + "\n Developers: " + devolpers );
        
        
    }
}
