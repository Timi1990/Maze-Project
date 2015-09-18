package algorithms.search;

import algorithms.demo.Maze3dState;

/**
 * Implements Heuristic interface and specifies the heuristic for Maze3d objects
 * @author Artiom Petrov
 *
 */
public abstract class HeuristicMaze implements Heuristic {

	protected Maze3dState _currentState;
	protected Maze3dState _goalState;

	@Override
	public abstract double calcStartToGoalCost(State currentState, State goalState);
}
