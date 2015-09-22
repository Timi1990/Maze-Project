package algorithms.search;

import algorithms.demo.Maze3dState;

/**
 * Air Distance measuring: sums all paths from the current state to the goal state
 * in 2nd power, and then uses sqrt method on the result
 *
 * @author Artiom Petrov
 */
public class MazeAirDistance extends HeuristicMaze
{

    @Override
    public double calcStartToGoalCost(State currentState, State goalState)
    {
        _currentState = new Maze3dState((Maze3dState) currentState);
        _goalState = new Maze3dState((Maze3dState) goalState);
        int currentX = _currentState.getPosition().getX();
        int currentY = _currentState.getPosition().getY();
        int currentZ = _currentState.getPosition().getZ();
        int goalX = _goalState.getPosition().getX();
        int goalY = _goalState.getPosition().getY();
        int goalZ = _goalState.getPosition().getZ();
        return Math.sqrt(Math.pow(goalX - currentX, 2) + Math.pow(goalY - currentY, 2) + Math.pow(goalZ - currentZ, 2));

    }

}
