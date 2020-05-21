
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Grafo {
	private Set<Vertice> vertices;
	
	public Grafo() {
		vertices = new HashSet<>();
	}
	
	List<Vertice> getVertices(){
		return new ArrayList<>(vertices);
	}
	
	boolean addVertice(Vertice vertice) {
		return vertices.add(vertice);
	}
     
}