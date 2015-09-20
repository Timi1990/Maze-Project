package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import algorithms.mazeGenerators.InitMazeArguments;
import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.MyMaze3dGenerator;

public class Stammain {

	public static void main(String[] args) {
		InitMazeArguments initMazeArguments= new InitMazeArguments();
		initMazeArguments.set_rows(7);         
		initMazeArguments.set_columns(10);
		initMazeArguments.set_dimension(4);
		Maze3d maze=new MyMaze3dGenerator().generate(initMazeArguments);
		maze.PrintMaze();
		try {
			OutputStream out=new MyCompressorOutputStream(new FileOutputStream("maze.maz"));
			out.write(maze.toByteArray());
			out.flush();
			out.close();
			InputStream in=new MyDecompressorInputStream(new FileInputStream("maze.maz"));
			byte[] b=new byte[maze.toByteArray().length];
			in.read(b);
			in.close();
			Maze3d loaded=new Maze3d(b);
			loaded.PrintMaze();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	
				


	}

}
