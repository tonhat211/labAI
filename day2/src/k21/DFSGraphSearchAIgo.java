package k21;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class DFSGraphSearchAIgo implements ISearchAlgo {

	@Override
	public Node execute(Node root, String goal) {
		// TODO Auto-generated method stub
		
		Stack<Node> frontier = new Stack<>();
		List<Node> visited = new ArrayList<>();
		frontier.push(root);
		while(!frontier.isEmpty()) {
			Node checking = frontier.pop();
			if(checking.getLabel().equals(goal)) return checking;
			List<Node> subs = checking.getChildrenNodes();
			Collections.reverse(subs);
			for (Node n : subs) {
				if(!frontier.contains(n) && !visited.contains(n)) {
					visited.add(n);
					n.setParent(checking);
					frontier.push(n);
				}
			}
			
		}
		return null;
	}

	@Override
	public Node execute(Node root, String start, String goal) {
		// TODO Auto-generated method stub
		boolean started=false;
		Stack<Node> frontier = new Stack<>();
		frontier.add(root);
		List<Node> visited = new ArrayList<Node>();
		while(!frontier.isEmpty()) {
			Node checking = frontier.pop();
//			visited.add(checking);
			
			if(checking.getLabel().equals(start)) {
				started=true;
				frontier.clear();
//				visited.clear();
				checking.setParent(null);
//				return checking;
			}
			
			if(checking.getLabel().equals(goal) && started==true) {

				return checking;
			}

			List<Node> subs = checking.getChildrenNodes();
			Collections.reverse(subs);

			for(Node n : subs) {
				if(!frontier.contains(n) && !visited.contains(n)) {
					frontier.add(n);
					n.setParent(checking);
					Edge ed = new Edge(checking, n);
					n.setPathCost(ed.getWeight());
				}		
			}
				
			
			
		}
		return null;
	}

}
