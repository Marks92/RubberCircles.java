/* Mark Schuberth
 * Professor Abdollahzadeh
 * CS 152 - 02
 * 5/3/18
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//Rubber Circles Panel creates rubberbanding circles for the 
//user to create with a mouse click and drag
public class RubberCirclesPanel extends JPanel
{
	//point 1 and 2 are used to create the circle
	private Point point1 = null, point2 = null;
	
	private int radius = 0;
	
	Font font = new Font("Times New Roman", Font.BOLD, 32);
	
	public RubberCirclesPanel()
	{
		//circle listener creates a circle object 
		//mouse listeners and motion listener detect when the mouse 
		//is clicked, dragged, and moved
		CircleListener listener = new CircleListener();
		addMouseListener(listener);
		addMouseMotionListener(listener);
		
		//sets the background to blue with dimensions of 400 x 200 pixels
		setBackground(Color.blue);
		setPreferredSize(new Dimension(500,500));
	}
	//graphics page creates a white circle based on the user's clicks and drags
	public void paintComponent(Graphics page)
	{
		//creates a white oval as long as the user clicks and drags in the pane
		//original click is the center of the Oval and point2 acts as the width and 
		//height of the circle
		super.paintComponent(page);
		page.setColor(Color.white);
		//creates the circle and draws a line for the radius
		if(point1 != null && point2 != null)
		{
			page.fillOval(point1.x-radius, point1.y-radius, radius*2, radius*2);
			page.setColor(Color.blue);
			page.drawLine(point1.x,point1.y,point2.x,point2.y);
			page.drawString("radius: " + radius, 50, 50);
		}																		
		//calculates radius based on center click and drag of 
		//point 1.x and point2.x
	}
	
	private class CircleListener implements MouseListener, MouseMotionListener
	{
		public void mousePressed (MouseEvent event)
		{
			//gets the original mouse click which is the center of the circle
			point1 = event.getPoint();
		}
		
		public void mouseReleased (MouseEvent event)
		{
			//expands the width and height of circle based on the mouse drag
			point2 = event.getPoint();
			//calculates the radius based off of the original mouse click
			radius = (((point2.x-point1.x)^2)+((point2.y-point1.y)^2)^(1/2));
			//if radius is negative this converts the radius to a positive int
			if(radius < 0)
			{
				radius = radius * -1;
			}
			repaint();
		}
		//mouse event listeners for the mouse when it is clicked/dragged/moved
		  public void mouseClicked (MouseEvent event) {}
	      public void mouseDragged (MouseEvent event) {}
	      public void mouseEntered (MouseEvent event) {}
	      public void mouseExited (MouseEvent event) {}
	      public void mouseMoved (MouseEvent event) {}
	}
}
