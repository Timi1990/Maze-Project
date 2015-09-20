package algorithms.mazeGenerators;

import java.util.Random;


//Abstract class, which implements the interface
//Has several mutual methods and data members which are used by classes which derive it

public abstract class Maze3dGeneratorBase implements Maze3dGenerator {

	Random rand=new Random();   
	int rows,columns,dimension;
	int[][][] arr;
	int exitXpos,exitYpos;  
	Position startPosition;
	
	public abstract Maze3d generate(InitMazeArguments initMazeArguments);

	@Override
	public String measureAlgorithmTime(InitMazeArguments initMazeArguments) {
		long startTime=System.currentTimeMillis();
		generate(initMazeArguments);
		long totalTime=System.currentTimeMillis()-startTime;
		return "Proccess took "+(totalTime)+" milliseconds";
	}
	protected Position createStartPosition()   
	{
		Position p=new Position(0,rand.nextInt(getRows()),0);
		while(p.getY()==0||p.getY()==rows-1)
		{
			p=new Position(0,rand.nextInt(getRows()),0);
		}
		return p;
	}
	protected void fillArrayWith1()
	{
		for(int i=0;i<arr.length;i++)
		{
			for(int j=0;j<arr[i].length;j++)
			{
				for(int k=0;k<arr[i][j].length;k++)
					arr[i][j][k]=1;
			}
		}
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public void setColumns(int columns) {
		this.columns = columns;
	}

	public void setDimension(int dimension) {
		this.dimension = dimension;
	}

	public int getRows() {
		return rows;
	}

	public int getColumns() {
		return columns;
	}

	public int getDimension() {
		return dimension;
	}
	public int getExitXpos() {
		return exitXpos;
	}

	public int getExitYpos() {
		return exitYpos;
	}

	public void setExitXpos(int exitXpos) {
		this.exitXpos = exitXpos;
	}

	public void setExitYpos(int exitYpos) {
		this.exitYpos = exitYpos;
	}


}
