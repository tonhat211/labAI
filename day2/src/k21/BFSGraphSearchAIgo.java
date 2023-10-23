package k21;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFSGraphSearchAIgo implements ISearchAlgo {

	@Override
	public Node execute(Node root, String goal) {
		// TODO Auto-generated method stub
		Queue<Node> frontier = new LinkedList<Node>();
		frontier.add(root);
		List<Node> explored = new ArrayList<Node>();
		while(!frontier.isEmpty()) {
			Node checking = frontier.remove();
			explored.add(checking);
			
			if(checking.getLabel().equals(goal)) {
				
				return checking;
			}
//			List<Edge> edges = checking.getChildren();
//			for(Edge e : edges) {
//				if(!checking.getChildren()) {
//					frontier.add(n);
//					n.setParent(checking);
//					Edge ed = new Edge(checking, n);
//					n.setPathCost(ed.getWeight());
//			}
			List<Node> subs = checking.getChildrenNodes();
			for(Node n : subs) {
				if(!frontier.contains(n) && !explored.contains(n)) {
					frontier.add(n);
					n.setParent(checking);
					Edge ed = new Edge(checking, n);
					n.setPathCost(ed.getWeight());
				}		
			}
				
			
			
		}
		return null;
	}

	@Override
	public Node execute(Node root, String start, String goal) {
		// TODO Auto-generated method stub
		boolean started=false;
		Queue<Node> frontier = new LinkedList<Node>();
		frontier.add(root);
		List<Node> explored = new ArrayList<Node>();
		while(!frontier.isEmpty()) {
			Node checking = frontier.remove();
			explored.add(checking);
			
			if(checking.getLabel().equals(start)) {
				started=true;
				frontier.clear();
				explored.clear();
				checking.setParent(null);
//				return checking;
			}
			
			if(checking.getLabel().equals(goal) && started==true) {

				return checking;
			}

			List<Node> subs = checking.getChildrenNodes();
			for(Node n : subs) {
				if(!frontier.contains(n) && !explored.contains(n)) {
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
