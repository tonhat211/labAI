package lab4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;


public class GreedyBestFirstSearchAlgo implements IInformedSearchAlgo {

	@Override
	public Node execute(Node root, String goal) {
		// TODO Auto-generated method stub
//		PriorityQueue<Node> froniter = new PriorityQueue<>(new NodeComparator());
		PriorityQueue<Node> froniter = new PriorityQueue<>(new NodeComparatorByHn());
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
					double h = checking.getH();


					if(!froniter.contains(end) && !explored.contains(end)) {
						froniter.add(end);
						end.setParent(checking);
						end.setG(checking.getG() + e.getWeight());

						
					}
//					else if (end.getH() < h) {
//						
//						end.setParent(checking);
//
////						end.setPathCost(newPathCost);
//
//					}
				}
			}
		}
		
		return null;
	}

	@Override
	public Node execute(Node root, String start, String goal) {
		// TODO Auto-generated method stub
		boolean started=false;
		PriorityQueue<Node> frontier = new PriorityQueue<>(new NodeComparatorByHn());
		frontier.add(root);
		List<Node> explored = new ArrayList<Node>();
		while(!frontier.isEmpty()) {
			Node checking = frontier.poll();
			explored.add(checking);
			
			if(checking.getLabel().equals(start)) {
				started=true;
				frontier.clear();
				explored.clear();
				checking.setParent(null);
				
			}
			
			if(checking.getLabel().equals(goal) && started==true) {

				return checking;
			}
			
			List<Edge> edges = checking.getChildren();
//			List<Node> subs = checking.getChildrenNodes();
			for(Edge e: edges) {
//				froniter.add(n);
			
				Node end = e.getEnd();
				double h = checking.getH();


				if(!frontier.contains(end) && !explored.contains(end)) {
					frontier.add(end);
					end.setParent(checking);
					end.setG(checking.getG() + e.getWeight());

					
				}
			}
				
			
			
		}
		return null;
	}

}
