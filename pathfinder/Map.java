package pathfinder;

import java.awt.Point;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Map {
	private char[][] map;
	private int mapHeight;
	private int mapWidth;
	private static int start1X;
	private static int start1Y;
	private static int start2X;
	private static int start2Y;
	private static int end1X;
	private static int end1Y;
	private static int end2X;
	private static int end2Y;
	
	/*
	 * Constructor for the Map class
	 */
	public Map(Scanner mapScanner, Scanner widthScanner, Scanner heightScanner) throws FileNotFoundException{
		mapHeight = getMapHeight(heightScanner);
		mapWidth = getMapWidth(widthScanner);
    	map = new char[mapHeight][mapWidth];
    	
    	clearMap();
    	constructMap(mapScanner);
	}
	
	/*
	 * Function that takes a scanner and returns the width of the map
	 */
    public int getMapWidth(Scanner scanner) throws FileNotFoundException {
    	String line;
    	int width = 0;
    	while(scanner.hasNextLine()){
    		line = scanner.nextLine();
    		if(line.length() > width){
    			width = line.length();
    		}
    	}
    	scanner.close();
    	return width;
    }
    
    /*
     * Function that takes a scanner and returns the height of the map
     */
    public int getMapHeight(Scanner scanner) throws FileNotFoundException {
    	int i = 0;
    	for(i = 0; scanner.hasNextLine(); i++){
    		scanner.nextLine();
    	}
    	scanner.close();
    	return i;
    }
    
    /*
     * Function that sets the array to ' ' so as not
     * to have data anomalies and extra characters
     */
    private void clearMap(){
    	for(int a = 0; a < mapHeight; a++){
    		for(int b = 0; b < mapWidth; b++){
    			map[a][b] = ' ';
    		}
    	}
    }
    
    /*
     * Function to clear the path map of the V's it is
     * marked with to show the search procedure for the 
     * second robot to recycle the map
     */
    public void clearV(){
    	for(int a = 0; a < mapHeight; a++){
    		for(int b = 0; b < mapWidth; b++){
    			if(map[a][b] == 'V')
    				map[a][b] = ' ';
    		}
    	}
    }
    
    /*
     * Function that takes a scanner and reads through the map
     * and scans it into a 2D array.
     */
    private void constructMap(Scanner scanner) throws FileNotFoundException{
    	String line = "";
    	for(int i = 0; scanner.hasNextLine(); i++){
    		line = scanner.nextLine();
    		for(int j = 0; j < line.length(); j++){
    			map[i][j] = line.charAt(j);
    			if (map[i][j] == 'S'){
    				start1X = j;
    				start1Y = i;
    			} else if (map[i][j] == 'E'){
    				end1X = j;
    				end1Y = i;
    			} else if (map[i][j] == 'F'){
    				start2X = j;
    				start2Y = i;
    			} else if (map[i][j] == 'L'){
    				end2X = j;
    				end2Y = i;
    			} else if (map[i][j] != ' ' && map[i][j] != '#'){
    				System.err.println("Invalid Characters in Map!");
    				System.exit(1);
    			}
    		}
    	}
    	scanner.close();
    }
    
    /*
     * Function that checks if the robot found the end of its route
     */
	public boolean isEnd(Point pos, Robot robot)
	{
		if(pos.x == robot.getEnd().x && pos.y == robot.getEnd().y)
			return true;
		return false;
	}
	
	/*
	 * Function that checks if the tile has been checked or is a wall
	 */
	public boolean isClear(Point pos)
	{
		if (map[pos.y][pos.x] == 'V' || map[pos.y][pos.x] == '#')
			return false;
		else
			return true;
	}
	
	/*
	 * Function that checks if the tile has been checked
	 */
	public boolean isMarked(Point pos)
	{
		return (map[pos.y][pos.x] == 'V');
	}
	
	/*
	 * Function that marks tiles on the map
	 */
	public char mark(Point pos, char value)
	{
		
		char temp = map[pos.y][pos.x];
		map[pos.y][pos.x] = value;
		return temp;
	}
	
	/*
	 * Function that prints out a map
	 */
	public void printMap(){
    	for(int j = 0; j < mapHeight; j++){
    		for(int k = 0; k < mapWidth; k++){
    			System.out.print(map[j][k]);
    		}
    		System.out.print("\n");
    	}
	}
	
	/*
	 * Setters and getters for the robot coordinates
	 */
    
    public int getStart1X(){
    	return Map.start1X;
    }
    
    public int getStart1Y(){
    	return Map.start1Y;
    }
    
    public int getStart2X(){
    	return Map.start2X;
    }
    
    public int getStart2Y(){
    	return Map.start2Y;
    }
    
    public int getEnd1X(){
    	return Map.end1X;
    }
    
    public int getEnd1Y(){
    	return Map.end1Y;
    }
    
    public int getEnd2X(){
    	return Map.end2X;
    }
    
    public int getEnd2Y(){
    	return Map.end2Y;
    }
}
