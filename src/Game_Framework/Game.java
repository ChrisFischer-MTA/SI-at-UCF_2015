package Game_Framework;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.JFrame;



/*
 * Kyle Dencker
 * Asteroids
 *
 */

public class Game extends JComponent implements KeyListener, Runnable {

	// Creates a JFrame and loads the game into it.
	// The key listener is added as well.
	public static void main(String[] args) {
		JFrame frame = new JFrame("Asteroids");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Game myGame = new Game();
		frame.add(myGame);
		frame.addKeyListener(myGame);
		//frame.setBackground(Color.BLACK);
		frame.setVisible(true);
		frame.setSize(500, 500);
		frame.setResizable(false);
		frame.getContentPane().setBackground(Color.BLACK);
	}


	// If we run out of lives, we set this to false.   We must restart the program
	// if we want to play again
	private boolean isRunning = true;

	// Used to calculate the time between frames.
	private long deltaTime, lastUpdate;

	// keeps record of what keys are pressed.
	private boolean turnLeft = false, turnRight = false, thrust = false, fire = false;

	// A list of all the asteroids in the game.
	private ArrayList<Asteroids> targets = new ArrayList<Asteroids>();

	// A list of all the bullets in the game.
	private ArrayList<Bullet> bulletList = new ArrayList<Bullet>();

	// What is our score?
	private int score = 0;

	// How many lives we have left.
	private int lives = 3;

	// Our player object.
	Player player;

	// Creates the player, and 3 asteroids to start the game.
	public Game() {
		player = new Player(250, 250);


		Thread t = new Thread(this);
		t.start();
		targets.add(new Asteroids(50, 50, 10, -20, 64, 3));
		targets.add(new Asteroids(450, 50, 20, 5, 64, 3));
		targets.add(new Asteroids(50, 450, -30, 40, 64, 3));

	}

	// Inbetween each frame we update.  I will give a detailed list of what each does
	public void update() {

		// Gets the current time, and compares that to the last updated time.
		// From there I get to know how much time in ms that has passed.  I need
		// that in seconds because all my speeds are in pixels per second.
		long currTime = System.currentTimeMillis();
		deltaTime = currTime - lastUpdate;
		double delta = deltaTime / 1000.0;
		lastUpdate = currTime;

		// I update the  player, asteroids and bullets.   This is pretty much
		// just moving.  Bullets have more to them because we have to calculate
		// how much time is left before they self delete.
		this.player.update(delta);

		/*** Update targets ***/


		/*** The oldest bullet is always the first one.
             So if that one times out, then remove it.
        ***/

		/*** Check to see if the bullets hit each other.
		     All of colliding will be calculated as if everything was
		     a circle.   To do this, we check to see if the distance between the
		     centers is less than both radii combined.
		***/
		for (int i=0; i<bulletList.size(); i++) {
			for (int j =0; j< targets.size(); j++) {


				/*** If there is a hit, create two asteroids of half the radius of the old ones. ***/




					/*** Remove the bullet and the targets from the arraylists.
					     This bullet will no longer hit anything so we
                    ***/

				}
			}


		

		/*** Check to see if any asteroids hit our player;
		     Player radius is 10
		     This is very similar to bullet/asteroid hits.
        ***/

		// Below we are handing the keyboard input
		if (this.turnLeft) {
			player.turnLeft(delta);
		}
		if (this.turnRight) {
			player.turnRight(delta);
		}
		if (this.thrust) {
			player.thrust(delta);
		}
		if (this.fire) {
			this.fire = false;
			bulletList.add(new Bullet((int)player.x, (int)player.y, player.angle, 5));
		}
	}

	// Drawing everything we need to draw.
	public void paint(Graphics g) {

		player.draw(g);
		for (Asteroids a : targets) {
			a.draw(g);
		}
		for (Bullet b : bulletList) {
			b.draw(g);
		}
		g.setColor(Color.YELLOW);
		g.drawString("Lives: " + this.lives, 30, 30);
		g.drawString("Score: " + this.score, 400, 30);
		if (lives == 0) {
			g.setColor(Color.red);
			g.drawString("Game Over", 225, 270);
		}
	}

	// The running method
	// Changing how much it sleeps will give you more frames per second
	// however it won't change the speed everything runs because of
	// delta time.
	public void run() {
		while (isRunning) {
			update();
			repaint();
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		repaint();
	}

	// Key handing below.
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		//System.out.println(e.getKeyCode());
		if (e.getKeyCode() == 37) {
			this.turnLeft = true;
		} else if (e.getKeyCode() == 39) {
			this.turnRight = true;
		} else if (e.getKeyCode() == 38) {
			this.thrust = true;
		} else if (e.getKeyCode() == 32) {
			this.fire = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == 37) {
			this.turnLeft = false;
		} else if (e.getKeyCode() == 39) {
			this.turnRight = false;
		} else if (e.getKeyCode() == 38) {
			this.thrust = false;
		}
	}
}





class Player {

	public double angle = 0;
	public double x, y;
	public double vx, vy;

	public Player(int x, int y) {
		this.x = x;
		this.y = y;
		this.vx = 0;
		this.vy = 0;
	}

	// Move forward based on the direction the ship is facing
	// You accelerate at 50 pixels per second per second
	public void thrust(double delta) {
		vx += 50 * Math.sin(Math.toRadians(angle))*delta;
		vy += 50 * Math.cos(Math.toRadians(angle))*delta;

	}

	// update the movement
	public void update(double delta) {
		this.x += vx * delta;
		this.y += vy * delta;
		if (this.x < 0- 10) {
			this.x = 500;
		}
		if (this.y < 0- 10) {
			this.y = 500;
		}
		if (this.x > 500) {
			this.x = -10;
		}
		if (this.y > 500) {
			this.y = -10;
		}
	}

	// turn left at a rate of 180 degrees per second
	public void turnLeft(double delta) {
		//System.out.println(delta + angle);
		angle+= 180*delta;
	}

	// turn right at a rate of 180 degrees per second
	public void turnRight(double delta) {
		angle-=180*delta;
	}

	public void slow() {



	}

	// draw the ship which is at a center of x, y.
	// Because it is a polygon, we use some trig to help with the rotation of the points.

	public void draw(Graphics g) {
		//g.setColor(Color.green);
		//g.fillOval((int)this.x - 5, (int)this.y - 5, 10, 10);
		int[] xs = new int[4], ys = new int[4];
		xs[0] = (int)(this.x + 10 * Math.sin(Math.toRadians(angle)));
		ys[0] = (int)(this.y +  10 * Math.cos(Math.toRadians(angle)));
		xs[1] = (int)(this.x + 10 * Math.sin(Math.toRadians(angle+135)));
		ys[1] = (int)(this.y +  10 * Math.cos(Math.toRadians(angle+135)));
		xs[2] = (int) this.x;
		ys[2] = (int) this.y;
		xs[3] = (int)(this.x + 10 * Math.sin(Math.toRadians(angle+225)));
		ys[3] = (int)(this.y + 10 * Math.cos(Math.toRadians(angle+225)));
		g.setColor(Color.WHITE);
		g.fillPolygon(xs, ys, 4);
		//System.out.println("Drawing player");
	}
}
class Bullet {
	int size;			// Size of the bullet
	double x, y;		// position of the bullet
	double vx, vy;		// Velocity of the bullet
	double time = 1;	// Time in seconds the bullet stays on the screen.

	public Bullet(int posx, int posy, double angle, int s) {
		this.size = s;
		this.x = posx;
		this.y = posy;
		this.vx = 300 * Math.sin(Math.toRadians(angle));
		this.vy = 300 * Math.cos(Math.toRadians(angle));
	}

	// move the bullets
	public void update(double delta) {
		this.x += this.vx*delta;
		this.y += this.vy*delta;

		this.time -= delta;

		if (this.x < 0 - this.size) {
			this.x = 500;
		} else if (this.x > 500) {
			this.x = - this.size;
		} else if (this.y < 0 - this.size) {
			this.y = 500;
		} else if (this.y > 500) {
			this.y = - this.size;
		}
	}

	// draw the bullets
	public void draw(Graphics g) {
		g.setColor(Color.red);
		g.fillOval((int)x, (int)y, (int)size, (int)size);
	}
}
class Asteroids {
	int size;			// Size of the Asteroid
	double x, y;		// position of the Asteroid
	double vx, vy;		// Velocity of the asteroid
	double splits;	// The number of times this asteroid splits

	public Asteroids(int posx, int posy, int velox, int veloy, int s, int split) {
		this.size = s;
		this.x = posx;
		this.y = posy;
		this.vx = velox;
		this.vy = veloy;
		this.splits = split;
	}

	// Update the asteroids
	public void update(double delta) {
		this.x += this.vx*delta;
		this.y += this.vy*delta;
		if (this.x < 0 - this.size) {
			this.x = 500;
		} else if (this.x > 500) {
			this.x = - this.size;
		} else if (this.y < 0 - this.size) {
			this.y = 500;
		} else if (this.y > 500) {
			this.y = - this.size;
		}
	}

	// draw the asteroids.
	public void draw(Graphics g) {
		g.setColor(Color.GRAY);
		g.fillOval((int)x, (int)y, (int)size, (int)size);
	}
}