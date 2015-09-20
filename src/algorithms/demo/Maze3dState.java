package algorithms.demo;

import algorithms.mazeGenerators.Position;
import algorithms.search.State;

/**
 * Converts general state to Maze3d position.
 * Also in charge of setting and changing the cost from position to position
 * @see State
 * @author Artiom Petrov
 */
public class Maze3dState extends State {

	private Position position;


	public Maze3dState(Position position) {
		super(position.toString());
		this.position = position;	
	}

	public Maze3dState(Maze3dState maze3dState) {
		super(maze3dState.getPosition().toString());
		super.setCost(maze3dState.getCost());
		this.position = maze3dState.getPosition();

	}

	public Maze3dState(Position temp, double cost) {
		super(temp.toString());
		this.position=temp;
		super.setCost(cost);
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}
}