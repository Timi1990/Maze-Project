package algorithms.demo;

import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.Position;
import algorithms.search.Searchable;
import algorithms.search.State;

import java.util.ArrayList;

/**
 * This class serves as Object Adapter, which converts maze3d objects, 
 * to searchable problem.
 * @author Artiom Petrov
 * @see Searchable
 */
public class Maze3dDomain implements Searchable {

	Maze3d maze;
	Maze3dState startState;
	Maze3dState goalState;

	public Maze3dDomain(Maze3d maze) {
		this.maze = maze;
		startState = new Maze3dState(maze.getStartPosition());
		goalState = new Maze3dState(maze.getExitPosition());
	}

	@Override
	public State getStartState() {
		return startState;
	}

	@Override
	public State getGoalState() {
		return goalState;
	}
	/**
	 * Creates an array list of all possible states according to given state, uses Maze3d
	 * "getAllPossibleMoves" method.
	 * Moving right or left costs 1,forward or back costs 2, up and down costs 3.
	 * @param State
	 * @return ArrayList<State>
	 */
	@Override
	public ArrayList<State> getAllPossibleStates(State s) {
		Maze3dState state = new Maze3dState((Maze3dState) (s));
		ArrayList<State> moves = new ArrayList<State>();
		String[] positionMoves = maze.getPossibleMoves(state.getPosition());
		double cost = s.getCost();
		for (String move : positionMoves) {

			Position temp = new Position(state.getPosition());

			switch (move) {
			case "Right": {
				temp.changeX(1);
				moves.add(new Maze3dState(temp, cost +1));
				break;
			}
			case "Left": {
				temp.changeX(-1);
				moves.add(new Maze3dState(temp, cost + 1));

				break;
			}
			case "Forward": {
				temp.changeY(1);
				moves.add(new Maze3dState(temp, cost + 2));

				break;
			}
			case "Back": {
				temp.changeY(-1);
				moves.add(new Maze3dState(temp, cost + 2));
				break;
			}
			case "Up": {
				temp.changeZ(-1);
				moves.add(new Maze3dState(temp, cost + 3));

				break;
			}
			case "Down": {
				temp.changeZ(1);
				moves.add(new Maze3dState(temp, cost + 3));
				break;
			}
			default:
				break;
			}
		}
		return moves;
	}
}