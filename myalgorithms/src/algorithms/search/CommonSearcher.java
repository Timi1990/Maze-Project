package algorithms.search;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * Abstract class. implements Searcher, includes common data members and methods
 * for the search algorithms.
 *
 * @author Artiom Petrov
 */
public abstract class CommonSearcher implements Searcher
{


    protected PriorityQueue<State> openList;
    private int evaluatedNodes;
    private static double evaluatedPath;
    protected ArrayList<State> closedList;

    public CommonSearcher()
    {
        openList = new PriorityQueue<State>(new SortQueueViaCost());  //Prioritizing by cost
        closedList = new ArrayList<State>();
        evaluatedPath = 0;
        evaluatedNodes = 0;
    }

    /**
     * Every time a parameter gets popped out from the open list, it updates
     * the total sum of evaluated nodes so far.
     */
    protected State popOpenList()
    {
        evaluatedNodes++;
        return openList.poll();
    }

    @Override
    public int getNumOfNodes()
    {
        return evaluatedNodes;
    }

    /**
     * Every time parameter is added to the closed list, it also updates the whole path's cost
     * with the current parameter's cost.
     *
     * @param State
     */
    protected void addToClosedList(State s)
    {
        evaluatedPath += s.getCost();
        closedList.add(s);
    }

    protected static double getEvaluatedPath()
    {
        return evaluatedPath;
    }

    /**
     * Backtracking from the goal state to the initial state using the came-from state reference.
     *
     * @param State
     * @return Solution
     * @see State
     */
    protected Solution backTrace(State goalState)
    {
        Solution solution = new Solution();
        while (goalState.getCameFrom() != null)
        {
            solution.addState(goalState);
            goalState = goalState.getCameFrom();
        }
        solution.addState(goalState);
        solution.setNodes(getNumOfNodes());
        return solution;
    }

}
