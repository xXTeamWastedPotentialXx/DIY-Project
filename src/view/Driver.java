/* 
 * TCSS 360
 */

package view;

import java.awt.EventQueue;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * Driver file runs the program.
 * 
 * @author Gehry Guest
 * @version 1.7.44
 */
public final class Driver {

    /**
     * Private constructor, to prevent instantiation of this class.
     * 
     */
    private Driver() {
        
        throw new IllegalStateException();
    }

    /**
     * re-textures portions of the program with a new skin.
     * 
     */
    public static void programSkin() {
        try {
            
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
            
        } catch (final ClassNotFoundException | InstantiationException | IllegalAccessException
                        | UnsupportedLookAndFeelException e) {
            
            e.printStackTrace();
        }
    }
   
    /**
     * The main method, invokes the GUI. Command line arguments are ignored.
     * 
     * @param theArgs Command line arguments.
     */
    public static void main(final String[] theArgs) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                
                programSkin();
                
                new SplashScreen();
            }
        });
    }
}
