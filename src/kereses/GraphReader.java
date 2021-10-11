package kereses;

import java.util.Scanner;

public class GraphReader {

    public Graph createGraph(){
        Graph graph = new Graph();
        int[]parameters = new int[3]; //[0]-routes, [1]-nodes, [2]-edges
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < 3; i++){
            String line = sc.nextLine();
            parameters[i] = Integer.parseInt(line);
        }
        sc.nextLine();
        for(int i = 0; i < parameters[0]; i++){
            String line = sc.nextLine();
            String[] values = line.split("\t");
            int[] route = {Integer.parseInt(values[0]), Integer.parseInt(values[1])};
            graph.addRoute(route);
        }
        sc.nextLine();
        for(int i = 0; i < parameters[1]; i++){
            String line = sc.nextLine();
            String[] values = line.split("\t");
            int x = Integer.parseInt(values[0]);
            int y = Integer.parseInt(values[1]);
            graph.addNode(new Node(x,y));
        }
        sc.nextLine();
        for (int i = 0; i < parameters[2]; i++){
            String line = sc.nextLine();
            String[] values = line.split("\t");
            Node node1 = graph.getNode(Integer.parseInt(values[0]));
            Node node2 = graph.getNode(Integer.parseInt(values[1]));
            node1.addEdge(node2);
            node2.addEdge(node1);
        }
        return graph;
    }

}
