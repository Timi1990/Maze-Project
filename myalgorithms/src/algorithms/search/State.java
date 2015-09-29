package algorithms.search;

import java.io.Serializable;

/**
 * General class which represents every searchable's states as "State" (String)
 *
 * @author Artiom Petrov
 */
public class State implements Serializable
{
    private String state;
    private Double cost;
    private State cameFrom;

    public String getState()
    {
        return state;
    }

    public State(String state)
    {
        this.state = state;
        this.cost = (double) 0;
    }

    //Copy C'tor
    public State(State other)
    {
        this.state = other.getState();
        this.cost = other.getCost();
        this.cameFrom = other.getCameFrom();
    }

    public void setState(String state)
    {
        this.state = state;
    }

    public double getCost()
    {
        return cost;
    }

    public void setCost(double cost)
    {
        this.cost = cost;
    }

    public State getCameFrom()
    {
        return cameFrom;
    }

    public void setCameFrom(State cameFrom)
    {
        this.cameFrom = cameFrom;
    }

    /**
     * Overrides object's equal method, compared by Strings
     */
    public boolean equals(Object obj)
    {
        return state.equals(((State) obj).getState());
    }
}
