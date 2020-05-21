import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 
 */

/**
 * @author Ingebor Rubio
 *
 */
public class Vertice {
	private String label;
	private Set<Edge> edges;
	
	public Vertice(String pageObject) {
		this.label = pageObject;
		edges = new HashSet<>();
	}
	
	String getLabel() {
		return label;
	}
	
	boolean addEdge(Edge edge) {
		return edges.add(edge);
	}
	
	List<Edge> getEdges(){
		return new ArrayList<>(edges);
	}
}
