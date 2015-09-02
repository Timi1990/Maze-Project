package io;

import algorithms.mazeGenerators.InitMazeArguments;
import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.MyMaze3dGenerator;

public class Stammain {

	public static void main(String[] args) {
		InitMazeArguments initMazeArguments= new InitMazeArguments();
		initMazeArguments.set_rows(10);         
		initMazeArguments.set_columns(10);
		initMazeArguments.set_dimension(4);
		Maze3d maze=new MyMaze3dGenerator().generate(initMazeArguments);
		maze.PrintMaze();
		byte[] stam=maze.toByteArray();
		Maze3d other=new Maze3d(stam);
		other.PrintMaze();

	}

}
