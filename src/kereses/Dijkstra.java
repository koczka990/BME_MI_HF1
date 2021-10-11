package kereses;

import java.util.ArrayList;

public class Dijkstra {

    public double shortestRoute(Graph graph, int[] route){
        Node start = graph.getNode(route[0]);
        Node end = graph.getNode(route[1]);

        double[] distances = new double[graph.getSize()];
        ArrayList<Node> unexplored = new ArrayList<>(graph.getNodes());


        for(int i = 0; i < distances.length; i++){
            distances[i] = graph.getMaxDistance();
        }

        distances[graph.getIndex(start)] = 0;
        Node currentNode = start;

        boolean found = false;
        while(!unexplored.isEmpty()){
            currentNode = graph.getNode(min(graph, unexplored, distances));

            if (currentNode == end){
                found = true;
                break;
            }
            unexplored.remove(currentNode);

            for(Edge e : currentNode.getEdges()){
                if(unexplored.contains(e.getDestination())){
                    double potentialDistance = distances[graph.getIndex(currentNode)] + e.getWeight();
                    if(potentialDistance < distances[graph.getIndex(e.getDestination())]){
                        distances[graph.getIndex(e.getDestination())] = potentialDistance;
                    }
                }
            }
        }

        if (found){
            return distances[graph.getIndex(end)];
        }else{
            return -1;
        }
    }

    private int min(Graph graph, ArrayList<Node> unexplored, double[] distances){
        int index = graph.getIndex(unexplored.get(0));
        double minDistance = distances[index];

        for(Node n : unexplored){
            if(distances[graph.getIndex(n)] < minDistance){
                minDistance = distances[graph.getIndex(n)];
                index = graph.getIndex(n);
            }
        }
        return index;
    }

}
