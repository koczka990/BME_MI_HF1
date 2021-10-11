package kereses;

public class Main {

    public static void main(String[] args) {
	    GraphReader reader = new GraphReader();
	    Graph graph = reader.createGraph();

	    Dijkstra alg = new Dijkstra();
	    for(int[] i : graph.routesToFind){
            System.out.print(alg.shortestRoute(graph, i) + "\t");
        }
        System.out.print("\n");
    }

    public static void graphPrinter(Graph graph){
        int i = 0;
        for(Node n : graph.getNodes()){
            System.out.println(i++);
            System.out.println("(" + n.posX + "," + n.posY + ")");
            for (Edge e : n.edges){
                System.out.print(e.weight + " | ");
            }
            System.out.print("\n\n");
        }
    }
}
