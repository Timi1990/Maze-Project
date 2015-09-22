package algorithms.search;

import java.util.ArrayList;

/**
 * A* algorithm implementation, for solving different Searchable objects
 * by finding the "cheapest" path via searchable's states.
 * Uses 2 Heuristic: Manhattan distance and Air distance, which initialized
 * via constructor
 *
 * @param Heuristic
 * @see Heuristic
 */

public class Astar extends CommonSearcher
{

    Heuristic h;

    public Astar(Heuristic h)
    {
        this.h = h;
    }

    /**
     * Receives current searchable object, using 2 different collections, calculates
     * in run-time which path is the shortest, finally returns Solution
     *
     * @param Searchable
     * @see Solution
     */
    @Override
    public Solution search(Searchable s)
    {

        openList.add(s.getStartState());
        while (!openList.isEmpty())
        {
            State state = popOpenList();
            if (state.equals(s.getGoalState()))
            {
                return backTrace(state);
            }
            addToClosedList(state);
            ArrayList<State> succesors = s.getAllPossibleStates(state);
            for (State st : succesors)
            {
                double temp_gscore = getEvaluatedPath() + st.getCost();
                if (closedList.contains(st) && temp_gscore >= getEvaluatedPath())
                {
                    continue;
                }
                if (!openList.contains(st) || temp_gscore < st.getCost())
                {
                    st.setCameFrom(state);
                    st.setCost(temp_gscore + h.calcStartToGoalCost(st, s.getGoalState()));
                }
                if (!openList.contains(st))
                    openList.add(st);
            }
        }
        return null;
    }

}


