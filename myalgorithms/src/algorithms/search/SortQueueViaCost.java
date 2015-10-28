package algorithms.search;

import java.io.Serializable;
import java.util.Comparator;

/**
 * A type of comparator, comparing States by their cost
 *
 * @author Artiom Petrov
 */
public class SortQueueViaCost implements Comparator<State>,Serializable
{

    @Override
    public int compare(State o1, State o2)
    {
        return (int) (o1.getCost() - o2.getCost());
    }

}
