package student;

public class SA {
	public Node execute(Node initialState) {
		// Enter your code here.
		Node current = initialState;
		Node next = null;
		int t= 1000;
		while(current.getH()!=0) {
			next = current.selectNextRandomCandidate();
			int deltaA = next.getH() - current.getH();
			if(deltaA<0) {
				current=next;
				
			}
			else {
				if(Math.exp(deltaA/t)> Math.random()) {
					current=next;
					t--;
				}
				return current;
			}
			
		}
		return null;
	}
	public Node executeHillClimbingWithRandomRestart(Node initialState) {
		// Enter your code here.
		return null;
	}

}
