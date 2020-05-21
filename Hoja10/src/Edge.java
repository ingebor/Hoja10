/**
 * 
 */

/**
 * @author Ingebor Rubio
 *
 */
public class Edge {
	private Vertice to;
	private int weight;
	
	public Edge(Vertice to, int weight) {
		super();
		this.to= to;
		this.weight = weight;
	}
	
	
	Vertice getTo() {
		return to;
	}
	
	int getWeight() {
		return weight;
	}
}
