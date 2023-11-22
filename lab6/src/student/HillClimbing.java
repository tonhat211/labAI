package student;

public class HillClimbing {
	public Node execute(Node initialState) {
		// Enter your code here.
		Node current = initialState;
		Node neighbor = null;
		while(true) {
			neighbor = current.getBestCandidate();
			if(neighbor.getH() < current.getH())
				current = neighbor;
			else 
				return current;
		}
//		return null;
	}
	public Node executeHillClimbingWithRandomRestart(Node initialState) {
		// Enter your code here.
		return null;
	}

}
