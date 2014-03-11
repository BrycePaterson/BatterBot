import java.awt.Color;
import java.awt.Dimension;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

/**
 * Simple IO class designed to interact with the console.
 * 
 * @author Yasha
 *
 */
public class IOconsole implements IOInterface
{
	private Scanner scan;
	/*private JFrame pane;
	private JScrollPane scroll;
	private int location = 5;*/
	
	public IOconsole(){
		scan = new Scanner(System.in);
		/*pane = new JFrame("Batman Conversation");
		pane.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		scroll = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.getViewport().setBackground(Color.darkGray);
		pane.setContentPane(scroll);
		pane.setSize(new Dimension(1000,500));
		pane.setVisible(true);*/		
	}
	
	@Override
	public void print(String response) 
	{
		/*JLabel res = new JLabel("BatterBot: " + response);
		res.setForeground(Color.yellow);
		
		pane.setLayout(null);
		scroll.getViewport().add(res);
		res.setLocation(5, location);
		pane.setVisible(true);*/
		System.out.println("BatterBot: " + response);
		//location=location+25;
	}

	@Override
	public String read() 
	{
		//input = new JTextField();
		//input.setBounds(5, 400, 100, 50);
		//pane.getContentPane().add(input);
		System.out.print("You: ");
		return scan.nextLine();
	}

}