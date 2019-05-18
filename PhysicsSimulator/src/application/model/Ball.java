package application.model;

import java.util.ArrayList;

//import samrudh.shapes.Line;

import javafx.scene.canvas.GraphicsContext;
import samarthshah.shapes.Circle;
import samarthshah.shapes.Line;

/** The class of the ball that is in the simulation that moves based on the forces on it
 * 
 * @author samarthshah
 *
 */
public class Ball {

	private double x, y, r;
	private double mass;
	private double vx, vy;
	private Circle circle;
	//	private ArrayList<Line> bounds;

	/** Creates a new ball with the values
	 *  
	 * @param xVal The initial x value
	 * @param yVal The initial y value
	 * @param radius The radius of the ball
	 * @param mass The mass of the ball
	 * @param velocityX The initial x velocity of the ball
	 * @param velocityY The initial y velocity of the ball
	 */
	public Ball(double xVal, double yVal, double radius, double mass, double velocityX, double velocityY) {
		x = xVal;
		y = yVal;
		r = radius;
		this.mass = mass;

		circle = new Circle(x, y, r); 

		vx = velocityX;
		vy = velocityY;
	}

	/** Changes the velocity and the position based on the forces acting on the ball
	 * 
	 * @param actingForces The forces acting on the ball at that moment
	 */
	public void act(ArrayList<Force> actingForces) {

		double resultantX = 0.0, resultantY = 0.0;

		for (Force f: actingForces) {

			double angle = f.getAngle();
			double mag = f.getMagnitude();

			resultantX += mag * Math.cos(Math.toRadians(angle));
			resultantY += mag * Math.sin(Math.toRadians(angle));
		}

		resultantX = ((int)resultantX*100)/100.0;
		resultantY = ((int)resultantY*100)/100.0;

		vx += resultantX/mass;
		vy += resultantY/mass;

		//		System.out.println(vx);
		//		System.out.println(vy);

		x += vx/60;
		y -= vy/60;		
	}

	/**  Draws the ball on the canvas using the graphics context
	 * 
	 * @param gc The graphics context to draw the ball on
	 */
	public void draw(GraphicsContext gc) {
		gc.fillOval(x, y, r, r);
	}

	/** Checks if the ball is colliding with the obstacle
	 * 
	 * @param o The obstacles to check for collision
	 * @return True of the ball is currently colliding with the obstacle
	 */
	public boolean collides(Obstacle o) {
		Line l = o.getLine();
		int a = Math.abs((int)(l.gety2()-l.getY()));
		int b = (int)(l.getX2()-l.getX());
		int c= (int)((l.getX()*l.gety2()) - (l.getX2()*l.getY()));

		double dist = (Math.abs(a * x + b * y + c)) /  
				Math.sqrt(a * a + b * b); 

		//		System.out.println(x + ", " + y);
		//		
		//		System.out.println(dist);
		//		System.out.println(r);
		//		
		//		System.out.println(r/2 >= dist);
		//		System.out.println();

		return r >= dist;	
	}

	/**
	 *  
	 * @return The x value of the ball
	 */
	public double getX() {
		return x;
	}

	/**
	 * 
	 * @return The y value of the ball
	 */
	public double getY() {
		return y;
	}

	/**
	 * 
	 * @return The radius of the ball
	 */
	public double getRadius() {
		return r;
	}

	/**
	 * 
	 * @return The mass of the ball
	 */
	public double getMass() {
		return mass;
	}

	/**
	 * 
	 * @return The velocity in the x direction
	 */
	public double getVX() {
		return vx;
	}

	/**
	 * 
	 * @return The velocity in the y direction
	 */
	public double getVY() {
		return vy;
	}

	/**
	 * 
	 * @param val The value to set the x value to
	 */
	public void setX(double val) {
		x = val;
	}

	/**
	 * 
	 * @param val The value to set the y value to
	 */
	public void setY(double val) {
		y = val;
	}

	/**
	 * 
	 * @param val The value to set the radius value to
	 */
	public void setRadius(double val) {
		r = val;
	}

	/**
	 * 
	 * @param val The value to set the mass value to
	 */
	public void setMass(double val) {
		mass = val;
	}

	/**
	 * 
	 * @param val The value to set the velocity in the x direction value to
	 */
	public void setVX(double val) {
		vx = val;
	}

	/**
	 * 
	 * @param val The value to set the velocity in the y direction value to
	 */
	public void setVY(double val) {
		vy = val;
	}

	/**
	 * 
	 * @return The normal force of the ball
	 */
	public double getNormalForce() {
		return 9.81 * mass;
	}

	/**
	 * 
	 * @return The total magnitude of the velocity of the ball
	 */
	public double getVelocity() {
		return Math.sqrt(vx*vx + vy*vy);
	}

	/**
	 * 
	 * @return The total angle of the velocity of the ball
	 */
	public double getAngle() {
		return Math.toDegrees(Math.atan(vy/vx));
	}


}
