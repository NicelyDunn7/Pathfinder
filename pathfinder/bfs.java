package pathfinder;

import java.awt.Point;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class bfs
{
	private HashMap<Point, Point> bef = new HashMap<Point, Point>(); 
	private HashMap<Point, Boolean> donebef = new HashMap<Point, Boolean>();
	
	public void navigateMapBFS(Robot robot, Map m, Map m2, char path)
	{
		//Points
		Point a= new Point(robot.getStart().x, robot.getStart().y);
		Point b= new Point(0,0);
		
		//queue instantiation
		Queue<Point> queue = new LinkedList<Point>(); // Queue used by the search

		//storing directions
		LinkedList<Point> fastest = new LinkedList<Point>();
		/*
		 * Above we instantiated two new points, one to serve as the current point set to the starting position of the passed in robot,
		 * the next was instantiated to 0 and then changed to the next position
		 * 
		 * We used a queue to track its path through the maze and stored the best path gathered in the bfs in the linked list.
		 * We used this linked list on the second map passed in which was the cloned map in the drive class. We marked the clone map
		 * with the best path and printed it out
		 */

		queue.add(a);
		donebef.put(a,true);
		
		while(!queue.isEmpty())
		{
			a=queue.remove();
		/*	if(queue.isEmpty())
				continue;*/
			if(m.isEnd(a, robot))
				continue;
			m.mark(a, 'V');
			
			b=new Point(a.x,a.y+1);
			if(m.isClear(b)&&!queue.contains(b))
			{
				queue.add(b);
				bef.put(b, a);
				donebef.put(b, true);
			}
			b=new Point(a.x,a.y-1);
			if(m.isClear(b)&&!queue.contains(b))
			{
				queue.add(b);
				bef.put(b, a);
				donebef.put(b, true);
			}
			b=new Point(a.x+1,a.y);
			if(m.isClear(b)&&!queue.contains(b))
			{
				queue.add(b);
				bef.put(b, a);
				donebef.put(b, true);
			}
			b=new Point(a.x-1,a.y);
			if(m.isClear(b)&&!queue.contains(b))
			{
				queue.add(b);
				bef.put(b, a);
				donebef.put(b, true);
			}
		}
		if(!queue.isEmpty())
			System.out.println("ExitFound");
		
		for(Point p=robot.getEnd(); p!=null;p=bef.get(p))
		{
			fastest.add(p);
			m2.mark(p,path);
		}
		m2.printMap();
	}
}
