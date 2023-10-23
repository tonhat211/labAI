package k21;

import java.awt.event.FocusAdapter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

import javax.net.ssl.CertPathTrustManagerParameters;

public class UniformCostGraphSearchAIgo implements ISearchAlgo {

	@Override
	public Node execute(Node root, String goal) {
		// TODO Auto-generated method stub
//		PriorityQueue<Node> froniter = new PriorityQueue<>(new NodeComparator());
		PriorityQueue<Node> froniter = new PriorityQueue<>(new Comparator<Node>() {

			@Override
			public int compare(Node o1, Node o2) {
				// TODO Auto-generated method stub
				return 0;
			}
		});
		List<Node> explored = new ArrayList<Node>();
		froniter.add(root);
		while(!froniter.isEmpty()) {
			Node checking = froniter.poll();
			explored.add(checking);
			if(checking.getLabel().equals(goal))
				return checking;
			else {
				List<Edge> edges = checking.getChildren();
//				List<Node> subs = checking.getChildrenNodes();
				for(Edge e: edges) {
//					froniter.add(n);
					Node end = e.getEnd();
					double newPathCost = checking.getPathCost() + e.getWeight();

					if(!froniter.contains(end) && !explored.contains(end)) {
						froniter.add(end);
						end.setParent(checking);
						end.setPathCost(newPathCost);
						
					}
					else if (end.getPathCost() > newPathCost) {
						
						end.setParent(checking);

						end.setPathCost(newPathCost);

					}
				}
			}
		}
		
		return null;
	}

	@Override
	public Node execute(Node root, String start, String goal) {
		// TODO Auto-generated method stub
		PriorityQueue<Node> frontier = new PriorityQueue<>(new Comparator<Node>() {

			@Override
			public int compare(Node o1, Node o2) {
				// TODO Auto-generated method stub
				return 0;
			}
		});
		boolean started=false;
		List<Node> explored = new ArrayList<Node>();
		frontier.add(root);
		while(!frontier.isEmpty()) {
			Node checking = frontier.poll();
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
						
			List<Edge> edges = checking.getChildren();
//			List<Node> subs = checking.getChildrenNodes();
			for(Edge e: edges) {
//				froniter.add(n);
				Node end = e.getEnd();
				double newPathCost = checking.getPathCost() + e.getWeight();

				if(!frontier.contains(end) && !explored.contains(end)) {
					frontier.add(end);
					end.setParent(checking);
					end.setPathCost(newPathCost);
					
				}
				else if (end.getPathCost() > newPathCost) {
					
					end.setParent(checking);

					end.setPathCost(newPathCost);

				}
			}
				
			
			
		}
		return null;
	}

}
