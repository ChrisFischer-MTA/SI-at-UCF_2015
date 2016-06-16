package javaclass;

// solution by: Joseph Burfield

//import MovingBox.StudentWorkSolution;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.lang.Character;
import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.util.Random;

class StudentWorkSolution extends JComponent
{

	Color outlineColor, backgroundColor, highlightColor;
    public Random rand;
	char charDisplayed;

	/********************************
	 * This will be called
	 * at the beginning of the
	 * program
	 ********************************/
	public void initialize()
	{
            rand = new Random();
	}

	public void draw(Graphics g)
	{
            g.setColor(Color.BLUE);
            g.fillRect(0, 0, 500, 500);
            g.setColor(Color.GREEN);
            g.drawRect(116, 200, 50, 50);
            
            g.drawRect(166, 200, 50, 50);
            g.drawRect(216, 200, 50, 50);
            fillRandomSquare(g);
	    // Fill this in
	    // 1. Set the color and fill the frame.
	    // 2. Change the color and draw three rectangles.
	    // 3. Fill the random square passing g to the method fillRandomSquare
	}

	public void fillRandomSquare(Graphics g)
	{
        // 1. Make random selection.
        int z = rand.nextInt(3);
        char c = (char)(rand.nextInt(26) + 'A');
        
        switch(z){
                    case 0: g.fillRect(116, 200, 50, 50);
                    charDisplayed = c;
                    g.setColor(Color.RED);
                    g.drawString(""+c, 136, 220);
                    g.setColor(Color.BLUE);
                    break;
                    case 1: g.fillRect(166, 200, 50, 50);
                    g.setColor(Color.RED);
                    g.drawString(""+c, 186, 220);
                    g.setColor(Color.BLUE);
                    charDisplayed = c;
                    break;
                    case 2: g.fillRect(216, 200, 50, 50);
                    g.setColor(Color.RED);
                    g.drawString(""+c, 236, 220);
                    g.setColor(Color.BLUE);
                    charDisplayed = c;
                    break;
                    default:
                        break;
                                    
        }
        // 2. Determine x coordinate to highlight and fill appropriate rectangle with desired color
        // 3. Set character color and then draw the appropriate String in the desired location.
	}

    /*** No need to change this. ***/
	public boolean checkIfWhacked(KeyEvent e)
	{
                //System.out.println()
		return charDisplayed == Character.toUpperCase(e.getKeyChar());
	}

	/*****************************************
	 * Do not edit this method
	 ****************************************/
	public StudentWorkSolution()
	{
		this.initialize();
		outlineColor = Color.green;
		backgroundColor = Color.white;
		highlightColor = Color.blue;
	}

	public void paintComponent(Graphics g)
	{
		this.draw(g);
	}
}

/****************************************************
 *
 * 	STOP
 *
 *  For this problems there is no reason to edit
 *  below this warning.
 *
 ***************************************************/
public class WhackAMoleV2
{
	static JFrame frame;
	static JPanel panel;
	static JLabel label = new JLabel();
	static JLabel pointLabel;
	static Timer gameTime;

	static int currentTime;
	static int timeSinceLastWhack = 0;
	static int points = 0;

	static StudentWorkSolution student;

	static KeyboardListener kl = new KeyboardListener();

	public static void main(String[] args)
	{
		frame = new JFrame("Homework Problem 2");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 500);
		panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

		pointLabel = new JLabel("Points: " + points);

		student = new StudentWorkSolution();
		student.setFocusable(true);
		student.addKeyListener(kl);

		gameTime = new Timer(1000, new GameTimer());

		panel.add(student);
		panel.add(label);
		panel.add(pointLabel);

		frame.add(panel);
		frame.setResizable(false);
		frame.setVisible(true);
	}

	// handles displaying the countdown timer
	static class GameTimer implements ActionListener
	{
		public int seconds = 60;

		@Override
		public void actionPerformed(ActionEvent e)
		{
			label.setText("Game Time left: " + seconds);

			currentTime = seconds;

			if (seconds == 0)
			{
				gameTime.stop();
				pointLabel.setText("Final Score: " + points);
				student.removeKeyListener(kl);
			}

			seconds--;
		}
	}

	// handles checking for keyboard input
	static class KeyboardListener implements KeyListener
	{
		public void keyTyped(KeyEvent e)
		{
			int scoreCalc;

			if (gameTime.isRunning())
			{
				if (student.checkIfWhacked(e))
				{
					scoreCalc = timeSinceLastWhack - currentTime;
                    points += Math.max(0, 4-scoreCalc);
					timeSinceLastWhack = currentTime;
					pointLabel.setText("Points: " + points);
					student.repaint();
				}
			}
			else
			{
				// we start the game
				if (student.checkIfWhacked(e))
				{
					timeSinceLastWhack = 60;
					gameTime.start();
				}
			}
		}

		public void keyPressed(KeyEvent e)
		{
			// unused
		}

		public void keyReleased(KeyEvent e)
		{
			// unused
		}
	}
}