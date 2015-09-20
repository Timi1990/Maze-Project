package algorithms.search;

import algorithms.demo.Maze3dState;

/**
 * Manhattan distance: calculates the absolute value of the path
 * available from the current state till the goal state.
 * @author Artiom Petrov
 *
 */
public class MazeManhattanDistance extends HeuristicMaze {

	@Override
	public double calcStartToGoalCost(State currentState, State goalState) {
		_currentState=new Maze3dState((Maze3dState)currentState);
		_goalState=new Maze3dState((Maze3dState)goalState);
		int currentX=_currentState.getPosition().getX();
		int currentY=_currentState.getPosition().getY();
		int currentZ=_currentState.getPosition().getZ();
		int goalX=_goalState.getPosition().getX();
		int goalY=_goalState.getPosition().getY();
		int goalZ=_goalState.getPosition().getZ();
		return (Math.abs(goalX-currentX))+(Math.abs(goalY-currentY))+(Math.abs(goalZ-currentZ));
	}

}
