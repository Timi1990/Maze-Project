package algorithms.mazeGenerators;


//One of the maze 3d generators
//Creates a maze in "snake" design
//Includes the maze initialization method+2 methods which create 0 paths (to the right and to the left)

public class SimpleMaze3dGenerator extends Maze3dGeneratorBase {

	@Override
	public Maze3d generate(InitMazeArguments initMazeArguments) {
		setRows(initMazeArguments.get_rows());
		setColumns(initMazeArguments.get_columns());
		setDimension(initMazeArguments.get_dimension());
		arr=new int[getDimension()][getRows()][getColumns()];
		startPosition=createStartPosition();
		fillArrayWith1();
		initMaze();
		Position exitPosition=new Position(getLowLayer(),getExitYpos(),getExitXpos());
		Maze3d maze=new Maze3d(arr, startPosition, exitPosition);
		maze.setMazeBounds(dimension, rows, columns);
		return maze;
	}

	private void initMaze()
	{
		arr[getTopLayer()][startPosition.getY()][startPosition.getX()]=0;

		int currentXCoord=startPosition.getX();

		for(int i=0;i<arr.length-1;i++)
		{
			for(int j=0;j<arr[i].length-1;j++)
			{
				if(i%2==0&&j==startPosition.getY())
				{
					currentXCoord=startPosition.getX()+1;

					rightZeroPath(i, j, currentXCoord);

				}
				else if(i%2!=0&&j==startPosition.getY())
				{
					currentXCoord=getColumns()-2;
					leftZeroPath(i, j, currentXCoord);
				}

			}
		}
		setExitXpos(startPosition.getX()+1);  
		setExitYpos(startPosition.getY());
		arr[getLowLayer()][getExitYpos()][getExitXpos()]=0;
	}
	private void rightZeroPath(int currentDimension,int currentRows,int currentColumn)
	{
		while(currentColumn<getColumns()-1)
		{
			arr[currentDimension][currentRows][currentColumn]=0;
			currentColumn++;
			if(currentColumn+1==getColumns()-1)
			{
				if(currentRows+2<getRows()-1)
				{
					arr[currentDimension][currentRows+1][currentColumn]=0;
					leftZeroPath(currentDimension,currentRows+2,currentColumn);
				}

			}
		}
	}
	private void leftZeroPath(int currentDimension,int currentRows,int currentColumn)
	{

		while(currentColumn>0)
		{
			arr[currentDimension][currentRows][currentColumn]=0;
			currentColumn--;
			if(currentColumn-1==0)
			{
				if(currentRows+2<getRows()-1)
				{
					arr[currentDimension][currentRows+1][currentColumn]=0;
					rightZeroPath(currentDimension, currentRows+2, currentColumn);
				}

			}
		}
	}
	private int getTopLayer()
	{
		return getDimension()-getDimension();
	}
	private int getLowLayer()
	{
		return getDimension()-1;
	}
}
