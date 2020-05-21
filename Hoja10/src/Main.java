

public class Main {
	 public static void main(String[] args) {
		Grafo grafo = new Grafo();
		Vertice v1 = new Vertice("Guate");
		Vertice v2 = new Vertice("Salama");
		Vertice v3 = new Vertice("Antigua");
		Vertice v4 = new Vertice("Mixco");
		Vertice v5 = new Vertice("Guastatoya");
		
		v1.addEdge(new Edge(v2,1));
		
		v2.addEdge(new Edge(v3,2));
		
		v2.addEdge(new Edge(v4, 3));
		
		v4.addEdge(new Edge(v5,1));
		
		grafo.addVertice(v1);
		grafo.addVertice(v2);
		grafo.addVertice(v3);
		grafo.addVertice(v4);
		grafo.addVertice(v5);
     }
	
}

