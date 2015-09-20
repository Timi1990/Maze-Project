package algorithms.demo;

import algorithms.mazeGenerators.InitMazeArguments;
import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.MyMaze3dGenerator;
import algorithms.search.Astar;
import algorithms.search.BFS;
import algorithms.search.MazeAirDistance;
import algorithms.search.MazeManhattanDistance;
import algorithms.search.Searchable;
import algorithms.search.Searcher;
import algorithms.search.Solution;


/**
 * This class demonstrates the creation of the current maze, using MyMazeGenerator algorithm,
 * Prints the maze and solving it using 3 different methods which are based
 *on the shortest path
 *@author Artiom Petrov
 */
public class Demo {
	/**
	 * Initializing maze's arguments, creates new maze3d,converts it to Searchable
	 * and finally solves it using different algorithms
	 */
	public void Run()
	{
		InitMazeArguments initMazeArguments= new InitMazeArguments();
		initMazeArguments.set_rows(10);         
		initMazeArguments.set_columns(10);
		initMazeArguments.set_dimension(4);
		Maze3d maze=new MyMaze3dGenerator().generate(initMazeArguments);
		maze.PrintMaze();
		Searchable s=new Maze3dDomain(maze);
		System.out.println("BFS:");
		applySearch(new BFS(), s);
		System.out.println("A* (Manhatan distance):");
		applySearch(new Astar(new MazeManhattanDistance()), s);
		System.out.println("A* (Air distance):");
		applySearch(new Astar(new MazeAirDistance()), s);
	}
	/**
	 * Private method which uses Dependency Injection pattern, uses different types of Searchers
	 * and Searchable problems, finally prints the solution
	 * @param searcher
	 * @param searchable
	 */
	private void applySearch(Searcher searcher,Searchable searchable)
	{	
		Solution solution=searcher.search(searchable);
		solution.printSolution();
	}
}