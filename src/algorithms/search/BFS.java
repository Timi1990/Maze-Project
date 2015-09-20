package algorithms.search;

import java.util.ArrayList;

/**
 * Best First Search algorithm implementation, for solving different Searchable objects 
 * by finding the "cheapest" path via searchable's states.
 */
public class BFS extends CommonSearcher {
	
	
	/**
	 * Receives current searchable object, using 2 different collections, calculates
	 * in run-time which path is the shortest, finally returns Solution
	 * @param Searchable
	 * @see Solution
	 */
	@Override
	public Solution search(Searchable s) {
		openList.add(s.getStartState());
		
		while(!(openList.isEmpty()))
		{
			State n=popOpenList();
			addToClosedList(n);
			if(n.equals(s.getGoalState()))
			{
				return backTrace(n);
			}
			ArrayList<State> successors = s.getAllPossibleStates(n);
			
			for(State st:successors)
			{
				double pathPrice=st.getCost();
				
				if(!closedList.contains(st)&&!openList.contains(st))
				{	
					st.setCameFrom(n);
					openList.add(st);
				}
				else
				{
					if(pathPrice<getEvaluatedPath())
					{
						if(!openList.contains(st))
							openList.add(st);
					}
				}
			}
			
		}
		return null;
	}
	
}
