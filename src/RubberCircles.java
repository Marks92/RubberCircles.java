/* Mark Schuberth
 * Professor Abdollahzadeh
 * CS 152 - 02
 * 5/3/18
 */
import javax.swing.JFrame;

public class RubberCircles 
{
	//creates and displays the application frame for rubberbanding circles
	public static void main(String[] args)
	{
		//sets up the frame with a title "Rubberbanding Circles"
		JFrame frame = new JFrame ("Rubberbanding Circles");
		frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		//adds the content of the panel to the pane
		frame.getContentPane().add (new RubberCirclesPanel());
		//makes the pane visible to the user
		frame.pack();
		frame.setVisible(true);
	}
}
