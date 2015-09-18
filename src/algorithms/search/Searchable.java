package algorithms.search;

import java.util.ArrayList;
/**
 * General interface for different problems, represented as "Searchable"s
 * and general states
 * @see State
 * @see Searcher
 * @author Artiom Petrov
 *
 */
public interface Searchable {
	State getStartState();
	State getGoalState();
	ArrayList<State> getAllPossibleStates(State s);
}
