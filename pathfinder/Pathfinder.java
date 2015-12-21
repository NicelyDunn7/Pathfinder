package pathfinder;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Pathfinder {
	/*
	 * Driver function for the robot pathfinding program
	 */
	public static void main(String[] args) throws FileNotFoundException{
		//Get the filepath from the user
		Scanner userInput = new Scanner(System.in);
		System.out.print("Please enter the filepath: ");
		String filepath = userInput.nextLine();
		userInput.close();
		
		//Check if the file exists and open scanners for functions
		File file = new File(filepath);
		if(!file.exists() || file.isDirectory()){
			System.err.println("File Not Found!");
			System.exit(1);
		}
		Scanner mapScanner = new Scanner(file);
		Scanner widthScanner = new Scanner(file);
		Scanner heightScanner = new Scanner(file);
		Scanner traversedScanner = new Scanner(file);
		Scanner traversedwScanner = new Scanner(file);
		Scanner traversedhScanner = new Scanner(file);
		
		//Create a blank map and a path map and print out the blank map
		Map map = new Map(mapScanner, widthScanner, heightScanner);
		Map path = new Map(traversedScanner, traversedwScanner, traversedhScanner);
		map.printMap();
		
		//Find the starting and ending coordinates 
		//for the robots and create the robot objects
		int start1X = map.getStart1X();
		int start1Y = map.getStart1Y();
		int start2X = map.getStart2X();
		int start2Y = map.getStart2Y();
		int end1X = map.getEnd1X();
		int end1Y = map.getEnd1Y();
		int end2X = map.getEnd2X();
		int end2Y = map.getEnd2Y();
		Robot robot1 = new Robot(start1X, start1Y, end1X, end1Y);
		Robot robot2 = new Robot(start2X, start2Y, end2X, end2Y);
		
		//Run two bfs searches, one for each robot, and mark their paths
		bfs bfs = new bfs();
		bfs.navigateMapBFS(robot1, map, path, '.');
		map.clearV();
		bfs bfs2 = new bfs();
		bfs2.navigateMapBFS(robot2, map, path, '*');
	}
}
