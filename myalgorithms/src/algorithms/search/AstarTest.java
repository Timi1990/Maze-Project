package algorithms.search;

import algorithms.demo.Maze3dDomain;
import algorithms.mazeGenerators.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class AstarTest
{
    private final MazeManhattanDistance mazeManhattanDistance = new MazeManhattanDistance();
    private final Astar astar = new Astar(mazeManhattanDistance);
    private final Maze3dGenerator maze3dGenerator = new SimpleMaze3dGenerator();

    @Test
    public void aStartSearch_startAndGoalIsSame_oneStatForSolution()
    {
        Position start = new Position();
        Position goal = new Position();

        Maze3d maze3d = new Maze3d(null, start, goal);
        Maze3dDomain maze3dDomain = new Maze3dDomain(maze3d);

        Solution search = astar.search(maze3dDomain);

        assertEquals(search.getSolutionList().size(), 1);
    }

    @Test
    public void aStartSearch_generateMazeWithThreeRowAndColumns_twoStateForSolution()
    {
        MazeArgumentsForInit mazeArgumentsForInit = new MazeArgumentsForInit(1, 3, 3);
        Maze3d generate = maze3dGenerator.generate(mazeArgumentsForInit);
        Maze3dDomain maze3dDomain = new Maze3dDomain(generate);

        Solution search = astar.search(maze3dDomain);

        assertEquals(search.getSolutionList().size(), 2);
    }

    @Test
    public void aStartSearch_generateOneMazeAndSearchSolutionsTwice_itsSameSolutionList()
    {
        MazeArgumentsForInit mazeArgumentsForInit = new MazeArgumentsForInit(1, 3, 3);
        Maze3d generate = maze3dGenerator.generate(mazeArgumentsForInit);
        Maze3dDomain maze3dDomain = new Maze3dDomain(generate);

        Solution searchOne = astar.search(maze3dDomain);
        Solution searchTwo = astar.search(maze3dDomain);

        assertArrayEquals(searchOne.getSolutionList().toArray(), searchTwo.getSolutionList().toArray());
    }

    @Test
    public void aStartSearch_generateTwoDiffMazeAndSearchSolutionsTwice_itsNotSameSolutionList()
    {
        MazeArgumentsForInit mazeArgumentsForInitOne = new MazeArgumentsForInit(10, 15, 15);
        Maze3d maze3dOne = maze3dGenerator.generate(mazeArgumentsForInitOne);
        Maze3dDomain maze3dDomainOne = new Maze3dDomain(maze3dOne);

        MazeArgumentsForInit mazeArgumentsForInitTwo = new MazeArgumentsForInit(15, 13, 15);
        Maze3d maze3dTwo = maze3dGenerator.generate(mazeArgumentsForInitTwo);
        Maze3dDomain maze3dDomainTwo = new Maze3dDomain(maze3dTwo);

        Solution searchOne = astar.search(maze3dDomainOne);
        Solution searchTwo = astar.search(maze3dDomainTwo);

        assertNotEquals(searchOne.getSolutionList(), searchTwo.getSolutionList());
    }

}