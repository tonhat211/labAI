package student;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;


public class GreedyBestFirstSearch implements IPuzzleAlgo {

	@Override
	public Node execute(Puzzle model) {
		// TODO Auto-generated method stub
		
		
		PriorityQueue<Node> froniter = new PriorityQueue<>(PuzzleUtils.HeuristicComparatorByH);
		List<Node> explored = new ArrayList<Node>();
		froniter.add(model.getInitialState());
		while(!froniter.isEmpty()) {
			Node checking = froniter.poll();
			if(checking.getH() == 0) return checking;
			
			else {
				explored.add(checking);

				List<Node> children = checking.getSuccessors();
//				List<Node> subs = checking.getChildrenNodes();
				for(Node child: children) {
					if(!froniter.contains(child) && !explored.contains(child)) {						
						child.setG(checking.getG() + 1);
						froniter.add(child);


						
					}

				}
			}
		}
		
		return null;
	}
	

}
