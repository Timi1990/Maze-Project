package io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import algorithms.mazeGenerators.InitMazeArguments;
import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.MyMaze3dGenerator;

public class Stammain {

	public static void main(String[] args) {
		InitMazeArguments initMazeArguments= new InitMazeArguments();
		initMazeArguments.set_rows(5);         
		initMazeArguments.set_columns(5);
		initMazeArguments.set_dimension(3);
		Maze3d maze=new MyMaze3dGenerator().generate(initMazeArguments);
		maze.PrintMaze();
		try {
			OutputStream out=new MyCompressorOutputStream(new FileOutputStream("maze.txt"));
			out.write(maze.toByteArray());
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
				


	}

}
