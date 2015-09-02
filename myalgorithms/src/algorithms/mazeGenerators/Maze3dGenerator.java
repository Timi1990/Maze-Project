package algorithms.mazeGenerators;


//Interface for different kinds of 3d maze generators


public interface Maze3dGenerator {

	public Maze3d generate(InitMazeArguments initMazeArguments);
	public String measureAlgorithmTime(InitMazeArguments initMazeArguments);
}
