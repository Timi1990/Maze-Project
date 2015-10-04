package algorithms.search;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * General class for representing the solution of various Searchables
 * as array of nodes.
 *
 * @param ArrayList<State>,nodes evaluated
 * @author Artiom Petrov
 */
public class Solution implements Serializable
{
    private ArrayList<State> sol;
    private int nodes;

    public Solution()
    {
        sol = new ArrayList<State>();
        this.nodes = 0;
    }
    
    public ArrayList<State> getSolutionList()
    {
    	return sol;
    }

    public void addState(State state)
    {
        sol.add(state);
    }

    public void printSolution()
    {
        for (State s : sol)
        {
            System.out.printf(s.getState() + " ,");
        }
        System.out.println("Numbers of nodes evaluated: " + getNodes());
    }

    public int getNodes()
    {
        return nodes;
    }

    public void setNodes(int nodes)
    {
        this.nodes = nodes;
    }
}
