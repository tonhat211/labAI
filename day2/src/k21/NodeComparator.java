package k21;

import java.util.Comparator;

public class NodeComparator implements Comparator<Node>{
	private Node n1, n2;

	public NodeComparator(Node n1, Node n2) {
		super();
		this.n1 = n1;
		this.n2 = n2;
	}
	
	

	public NodeComparator() {
		super();
	}



	@Override
	public int compare(Node o1, Node o2) {
		// TODO Auto-generated method stub
		if(o1.getPathCost() > o2.getPathCost())
				return 1;
		else if (o1.getPathCost() < o2.getPathCost())
				return -1;
		return o1.getLabel().compareTo(o2.getLabel());
		
		
		
	}
	

}
