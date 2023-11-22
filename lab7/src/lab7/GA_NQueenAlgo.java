package lab7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class GA_NQueenAlgo {
	public static final int POP_SIZE = 100;// Population size
	public static final double MUTATION_RATE = 0.03;
	public static final int MAX_ITERATIONS = 100000;
	List<Node> population = new ArrayList<Node>();
	Random rd = new Random();

// initialize the individuals of the population
	public void initPopulation() {
		for (int i = 0; i < POP_SIZE; i++) {
			Node ni = new Node();
			ni.generateBoard();
			population.add(ni);
		}
	}

	public Node execute() {
	// Enter your code here

		Node child = null;
		int k = 0;
		while (k++ < MAX_ITERATIONS) {
			List<Node> newPop = new ArrayList<Node>();
			for (int i = 0; i < this.population.size(); i++) {

				Node x = getParentByTournamentSelection();
				Node y = getParentByRandomSelection();
				child = reproduce(x, y);

				if (rd.nextDouble() < MUTATION_RATE) {
					mutate(child);
				}
				if (child.getH() == 0)
					return child;
				newPop.add(child);
			}
			this.population = newPop;
		}
		Collections.sort(this.population);
		
		return this.population.get(0);
	}

	// Mutate an individual by selecting a random Queen and move it to a random row.
	public void mutate(Node node) {
		// Enter your code here
		node.setRow(rd.nextInt(Node.N), rd.nextInt(Node.N));
	}

	//Crossover x and y to reproduce a child
	public Node reproduce(Node x, Node y) {
	// Enter your code here
		Queen[] queens = new Queen[Node.N];
		for (int i = 0; i < Node.N; i++) {
			if (i < Node.N / 2)
				queens[i] = x.getState()[i];
			else
				queens[i] = y.getState()[i];
		}
		Node child = new Node(queens);
		return child;
	}

	// Select K individuals from the population at random and select the best out of these to become a parent.
	public Node getParentByTournamentSelection() {
	// Enter your code here
		Node[] node = new Node[3];
		for (int i = 0; i < 3; i++) {
			node[i] = this.population.get(rd.nextInt(POP_SIZE));
		}
		Node maxNode = node[0];
		for (int i = 1; i < 3; i++) {
			if (node[i].getH() < maxNode.getH()) {
				maxNode = node[i];
			}
		}
		return maxNode;
	}

	//Select a random parent from the population
	public Node getParentByRandomSelection() {
	// Enter your code here
		return this.population.get(rd.nextInt(POP_SIZE));
	}
	
	public static void main(String[] args) {
		GA_NQueenAlgo algo = new GA_NQueenAlgo();
		algo.initPopulation();
		Node result = algo.execute();
		result.displayBoard();
	}
}
