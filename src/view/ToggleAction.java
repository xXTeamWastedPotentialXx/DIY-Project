package view;

import java.awt.Image;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;

/**
 * A implementation of Action that will "toggle" between two states. 
 * 
 * @author Charles Bryan
 * @author Joseph Rushford
 * @version Autumn 2018
 */
public class ToggleAction extends AbstractAction 
{

    /**  
     * A generated serial version UID for object Serialization. 
     * http://docs.oracle.com/javase/7/docs/api/java/io/Serializable.html
     */
    private static final long serialVersionUID = 1234567890L;
    
    /** A flag for the toggle. */
    private boolean myFlag;
    
    /** The text to use when the toggle is true. */
    private final String myFirstText;
    
    /** The text to use when the toggle is false. */
    private final String mySecondText;
    
    /** The behavior to run when the toggle is true. */
    private final Runnable myFirstAction;
    
    /** The behavior to run when the toggle is false. */
    private final Runnable mySecondAction;
    
    /**
     * Creates a ToggleAction.
     * 
     * @param theFirstText the text of this Action in the original state
     * @param theSecondText the text of this Action in the toggle state

     * @param theFirstAction the behavior of this Action in the original state
     * @param theSecondAction the behavior of this Action in the toggle state
     */
    public ToggleAction(final String theFirstText,
                        final String theSecondText,
                        final Runnable theFirstAction,
                        final Runnable theSecondAction) 
    {
        super(theFirstText);
        
        myFirstText = theFirstText;
        mySecondText = theSecondText;

        myFirstAction = theFirstAction;
        mySecondAction = theSecondAction;

        
        myFlag = true;
    }
    
    @Override
    public void actionPerformed(final ActionEvent theEvent) 
    {
        //Look at the status of the toggle. 
        if (myFlag) 
        {
            myFirstAction.run();
            putValue(Action.NAME, myFirstText);


        }
        else 
        {
            mySecondAction.run();
            putValue(Action.NAME, mySecondText);

        }
        myFlag = !myFlag;

    }


}
