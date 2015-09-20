package algorithms.search;

/**
 * Heuristic interface which contains a method for calculating paths,
 * depends on heuristic type
 * @author Artiom Petrov
 *
 */
public interface Heuristic {

	double calcStartToGoalCost(State currentState,State goalState);
}
