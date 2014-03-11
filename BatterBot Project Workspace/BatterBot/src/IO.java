import java.util.Scanner;
import java.awt.Dimension;
import java.io.*;

import javax.swing.JFrame;

/**
 * Implementation of the IO interface.  It might even work.
 * 
 * @author Benjamin
 */
public class IO implements IOInterface
{
	private JFrame pane = new JFrame("Batman Conversation");
	
	public void setFrame(){
		Dimension d = new Dimension(100,100);
		pane.setSize(d);
		pane.setVisible(true);
	}
	
    public String read()
    {
        Scanner askUser = new Scanner(System.in);
        System.out.print("Enter your answer: ");
        
        String read = askUser.next();
        return read;
    }
    
    public void print (String response)
    {
        System.out.println(response + "\n");
    }
}