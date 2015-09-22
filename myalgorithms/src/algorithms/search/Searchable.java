package algorithms.search;

import java.util.ArrayList;

/**
 * General interface for different problems, represented as "Searchable"s
 * and general states
 *
 * @author Artiom Petrov
 * @see State
 * @see Searcher
 */
public interface Searchable
{
    State getStartState();

    State getGoalState();

    ArrayList<State> getAllPossibleStates(State s);
}
