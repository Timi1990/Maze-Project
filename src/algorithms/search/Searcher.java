package algorithms.search;

/**
 * General interface for different searching algorithms represented as "Searcher"s.
 * Includes the search method, specific for each searching algorithm
 * @see Searchable
 * @see Solution 
 * @author Artiom Petrov
 *
 */
public interface Searcher {
	Solution search(Searchable s);
	int getNumOfNodes();
}
