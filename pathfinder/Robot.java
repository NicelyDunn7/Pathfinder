package pathfinder;

import java.awt.Point;

public class Robot {
	private Point start;
	private Point end;
	
	/*
	 * Constructor for  the robot class,
	 * taking starting and ending coordinates
	 */
	public Robot(int sx, int sy, int ex, int ey){
		start=new Point();
		end=new Point();
		setStart(sx, sy);
		setEnd(ex, ey);
	}
	
	/*
	 * Setter function for the starting coordinate
	 */
	private void setStart(int sx, int sy){
		start.x = sx;
		start.y = sy;
	}
	
	/*
	 * Setter function for the ending coordinate
	 */
	private void setEnd(int ex, int ey){
		end.x = ex;
		end.y = ey;
	}
	
	/*
	 * Getter function for the starting coordinate
	 */
	public Point getStart(){
		return start;
	}
	
	/*
	 * Getter function for the ending coordinate
	 */
	public Point getEnd(){
		return end;
	}
}
