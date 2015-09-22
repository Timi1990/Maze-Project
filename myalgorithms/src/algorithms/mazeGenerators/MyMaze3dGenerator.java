package algorithms.mazeGenerators;

import java.util.ArrayList;
import java.util.Collections;

//One of the 2 kinds of maze 3d generators, based on the Depth-First-Search algorithm
//Includes 3 methods:
//(1) The depth-first-search algorithm
//(2) A method which returns shuffled array of possible moves (the moves are explained in method body)
//(3) A boolean method, which checks whether a current position is the starting point or not

public class MyMaze3dGenerator extends Maze3dGeneratorBase
{


    @Override
    public Maze3d generate(MazeArgumentsForInit mazeArgumentsForInit)
    {
        setRows(mazeArgumentsForInit.getRows());
        setColumns(mazeArgumentsForInit.getColumns());
        setDimension(mazeArgumentsForInit.getDimension());
        arr = new int[getDimension()][getRows()][getColumns()];
        fillArrayWith1();
        startPosition = createStartPosition();
        arr[startPosition.getZ()][startPosition.getY()][startPosition.getX()] = 0;
        dfs(startPosition.getZ(), startPosition.getY(), startPosition.getX());
        Position exitPosition = new Position(getDimension() - 1, getExitYpos(), getExitXpos());
        arr[exitPosition.getZ()][exitPosition.getY()][exitPosition.getX()] = 0;
        Maze3d maze = new Maze3d(arr, startPosition, exitPosition);
        maze.setMazeBounds(getDimension(), getRows(), getColumns());
        return maze;
    }

    private void dfs(int z, int y, int x)
    {
        Integer[] direction = getRandomDirection();
        for (int n : direction)
        {
            switch (n)
            {
                case 1:
                    if (x + 2 >= columns - 1)      //Right
                        continue;
                    else
                    {
                        if (arr[z][y][x + 2] != 0)
                        {
                            arr[z][y][x + 1] = 0;
                            arr[z][y][x + 2] = 0;
                            dfs(z, y, x + 2);
                        }
                    }
                    break;
                case 2:
                    if (x - 2 <= 0)      //Left
                        continue;
                    else
                    {
                        if (arr[z][y][x - 2] != 0)
                        {
                            arr[z][y][x - 1] = 0;
                            arr[z][y][x - 2] = 0;
                            dfs(z, y, x - 2);
                        }
                    }
                    break;
                case 3:
                    if (y + 2 >= rows - 1 || (checkIfStart(x, y, z)))     //Forward
                        continue;
                    else
                    {
                        if (arr[z][y + 2][x] != 0)
                        {
                            arr[z][y + 1][x] = 0;
                            arr[z][y + 2][x] = 0;
                            dfs(z, y + 2, x);
                        }
                    }
                    break;
                case 4:
                    if (y - 2 <= 0 || (checkIfStart(x, y, z)))      //Back
                        continue;
                    else
                    {
                        if (arr[z][y - 2][x] != 0)
                        {
                            arr[z][y - 1][x] = 0;
                            arr[z][y - 2][x] = 0;
                            dfs(z, y - 2, x);
                        }
                    }
                    break;
                case 5:
                    if (z + 1 == dimension - 1)     //Up
                    {
                        exitXpos = x;
                        exitYpos = y;
                        continue;
                    } else
                    {
                        if (arr[z + 1][y][x] != 0 && (!checkIfStart(x, y, z)))
                        {
                            arr[z + 1][y][x] = 0;
                            dfs(z + 1, y, x);
                        }
                    }
                    break;
                case 6:
                    if (z - 1 <= 0 || checkIfStart(x, y, z))      //Down
                        continue;
                    else
                    {
                        if (arr[z - 1][y][x] != 0)
                        {
                            arr[z - 1][y][x] = 0;
                            dfs(z - 1, y, x);
                        }
                    }
                    break;
                default:
                    break;
            }
        }
    }

    private Integer[] getRandomDirection()
    {
        ArrayList<Integer> direction = new ArrayList<Integer>();
        for (int i = 1; i <= 6; i++)
        {
            direction.add(i);
        }
        Collections.shuffle(direction);
        return direction.toArray(new Integer[direction.size()]);
    }

    private boolean checkIfStart(int x, int y, int z)
    {
        if (x == startPosition.getX() && y == startPosition.getY() && z == startPosition.getZ())
            return true;
        else
            return false;
    }
}
