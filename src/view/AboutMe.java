package view;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JOptionPane;


/**
 * Class to represent the about me box
 * @author Miranda Bessex 5/12/19
 *
 */
public class AboutMe {
    
    private String version;
    
    private String devolpers;
    
    /**
     * @author Miranda Bessex 5/12/19
     */
    public AboutMe () {
        version = "";
        devolpers = "";
        getVersion();
        
    }
    
    
    /**
     * @author Miranda Bessex 5/12/19
     */
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
    
    /**
     * @author Miranda Bessex 5/12/19
     */
    private void aboutMeButtonAction() {
        
        JOptionPane.showMessageDialog(null, "About Me: \n Version: " + version + "\n Developers: " + devolpers );
        
        
    }
}
