package algorithms.search;

/**
 * General interface for different searching algorithms represented as "Searcher"s.
 * Includes the search method, specific for each searching algorithm
 *
 * @author Artiom Petrov
 * @see Searchable
 * @see Solution
 */
public interface Searcher
{
    Solution search(Searchable s);

    int getNumOfNodes();
}
