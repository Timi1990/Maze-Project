package algorithms.mazeGenerators;

import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Stack;

//Maze 3d object class
//Includes the 3d array 
//Also includes getCrossBy and getPossibleMoves methods

public class Maze3d implements Serializable
{
    private int maze[][][];
    private Position startPosition;
    private Position exitPosition;
    private int maxRows, maxColumns, Dimension;

    public Maze3d(int arr[][][], Position start, Position goal)
    {
        maze = arr;
        this.startPosition = start;
        this.exitPosition = goal;
    }
    public void yoav(){};

    public void setMazeBounds(int Dimension, int maxRows, int maxColumns)
    {
        this.Dimension = Dimension;
        this.maxRows = maxRows;
        this.maxColumns = maxColumns;
    }

    public int getMaxRows()
    {
        return maxRows;
    }

    public int getMaxColumns()
    {
        return maxColumns;
    }

    public int getDimension()
    {
        return Dimension;
    }

    public Position getStartPosition()
    {
        return startPosition;
    }

    public Position getExitPosition()
    {
        return exitPosition;
    }

    public void printMaze()
    {
        for (int[][] aMaze : maze)
        {
            System.out.printf("{");
            for (int j = 0; j < aMaze.length; j++)
            {
                System.out.printf("{");
                for (int k = 0; k < aMaze[j].length; k++)
                {
                    System.out.printf(aMaze[j][k] + ",");
                }
                System.out.printf("}");
                System.out.printf("\n");
            }
            System.out.printf("}");
            System.out.printf("\n");
        }
    }

    public String[] getPossibleMoves(Position position)
    {

        Stack<String> Moves = new Stack<String>();
        for (Move move : Move.values())
        {


            switch (move)
            {
                case Right:
                    if (position.getX() + 1 < getMaxColumns())     //Right
                    {
                        if (maze[position.getZ()][position.getY()][position.getX() + 1] == 0)
                            Moves.push(Move.Right.toString());
                    }
                    break;
                case Left:
                    if (position.getX() - 1 > 0)      //Left
                    {

                        if (maze[position.getZ()][position.getY()][position.getX() - 1] == 0)
                            Moves.push(Move.Left.toString());
                    }
                    break;
                case Forward:
                    if (position.getY() + 1 < getMaxRows())         //Forward
                    {
                        if (maze[position.getZ()][position.getY() + 1][position.getX()] == 0)
                            Moves.push(Move.Forward.toString());
                    }
                    break;
                case Back:
                    if (position.getY() - 1 > 0)          //Back
                    {
                        if (maze[position.getZ()][position.getY() - 1][position.getX()] == 0)
                            Moves.push(Move.Back.toString());
                    }
                    break;
                case Up:
                    if (position.getZ() > 0)        //Up
                    {
                        if (maze[position.getZ() - 1][position.getY()][position.getX()] == 0)
                            Moves.push(Move.Up.toString());
                    }
                    break;
                case Down:
                    if (position.getZ() + 1 < getDimension())       //Down
                    {
                        if (maze[position.getZ() + 1][position.getY()][position.getX()] == 0)
                            Moves.push(Move.Down.toString());
                    }
                    break;
                default:
                    break;
            }
        }
        return Moves.toArray(new String[Moves.size()]);
    }

    public Integer[][] getCrossSectionByX(int column) throws IndexOutOfBoundsException
    {
        if (column >= getMaxColumns() || column < 0)
        {
            throw new IndexOutOfBoundsException("Out of array bounds!");
        }
        Integer[][] array2d = new Integer[getDimension()][getMaxRows()];
        int i = 0;
        while (i < getDimension())
        {
            for (int j = 0; j < getDimension(); j++)
            {
                for (int k = 0; k < getMaxRows(); k++)
                {
                    array2d[j][k] = maze[i][k][column];

                }
                i++;
            }

        }
        return array2d;
    }

    public int[][] getCrossSectionByY(int row)throws IndexOutOfBoundsException 
	{
		if(row>=getMaxRows()||row<0)
		{
			throw new IndexOutOfBoundsException("Out of array bounds!");
		}
		int[][] array2d=new int[getDimension()][getMaxColumns()];
		int i=0;
		while(i<getDimension())
		{
			for(int j=0;j<getDimension();j++)
			{
				for(int k=0;k<getMaxColumns();k++)
				{
					array2d[j][k]=maze[i][row][k];

				}
				i++;
			}
		}
		return array2d;
	}
	public int[][] getCrossSectionByZ(int dimension)throws IndexOutOfBoundsException 
	{
		if(dimension>=getDimension()||dimension<0)
		{
			throw new IndexOutOfBoundsException("Out of array bounds!");
		}
		int[][] array2d=new int[getMaxRows()][getMaxColumns()];
		for(int i=0;i<array2d.length;i++)
		{
			for(int j=0;j<array2d[i].length;j++)
			{
				array2d[i][j]=maze[dimension][i][j];
			}
		}
		return array2d;
	}

    public byte[] toByteArray()
    {
        ByteBuffer buffer = ByteBuffer.allocate((getDimension() * getMaxColumns() * getMaxRows()) + 9);
        initMazeDetailsInBytes(buffer);
        for (int i = 0; i < maze.length; i++)
        {
            for (int j = 0; j < maze[i].length; j++)
            {
                for (int k = 0; k < maze[i][j].length; k++)
                {
                    buffer.put((byte) maze[i][j][k]);
                }
            }
        }
        return buffer.array();
    }

    public Maze3d(byte[] b)
    {
        setMazeBounds(b[0], b[1], b[2]);
        startPosition = new Position(b[3], b[4], b[5]);
        exitPosition = new Position(b[6], b[7], b[8]);
        maze = new int[getDimension()][getMaxRows()][getMaxColumns()];
        int current = 9;
        for (int i = 0; i < maze.length; i++)
        {
            for (int j = 0; j < maze[i].length; j++)
            {
                for (int k = 0; k < maze[i][j].length; k++)
                {
                    maze[i][j][k] = b[current++];
                }
            }
        }

    }

    private void initMazeDetailsInBytes(ByteBuffer buffer)
    {
        buffer.put((byte) (getDimension()));
        buffer.put((byte) (getMaxRows()));
        buffer.put((byte) (getMaxColumns()));
        buffer.put((byte) startPosition.getZ());
        buffer.put((byte) startPosition.getY());
        buffer.put((byte) startPosition.getX());
        buffer.put((byte) exitPosition.getZ());
        buffer.put((byte) exitPosition.getY());
        buffer.put((byte) exitPosition.getX());
    }

    private enum Move
    {
        Left, Right, Back, Forward, Up, Down
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Maze3d maze3d = (Maze3d) o;

        if (maxRows != maze3d.maxRows) return false;
        if (maxColumns != maze3d.maxColumns) return false;
        if (Dimension != maze3d.Dimension) return false;
        if (!Arrays.deepEquals(maze, maze3d.maze)) return false;
        if (startPosition != null ? !startPosition.equals(maze3d.startPosition) : maze3d.startPosition != null)
            return false;
        return !(exitPosition != null ? !exitPosition.equals(maze3d.exitPosition) : maze3d.exitPosition != null);

    }

    @Override
    public int hashCode() {
        int result = maze != null ? Arrays.deepHashCode(maze) : 0;
        result = 31 * result + (startPosition != null ? startPosition.hashCode() : 0);
        result = 31 * result + (exitPosition != null ? exitPosition.hashCode() : 0);
        result = 31 * result + maxRows;
        result = 31 * result + maxColumns;
        result = 31 * result + Dimension;
        return result;
    }
}
