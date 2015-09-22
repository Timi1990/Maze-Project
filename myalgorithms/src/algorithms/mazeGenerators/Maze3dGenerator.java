package algorithms.mazeGenerators;


//Interface for different kinds of 3d maze generators


public interface Maze3dGenerator
{

    public Maze3d generate(MazeArgumentsForInit mazeArgumentsForInit);

    public String measureAlgorithmTime(MazeArgumentsForInit mazeArgumentsForInit);
}
