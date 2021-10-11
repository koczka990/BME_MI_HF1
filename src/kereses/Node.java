package kereses;

import java.util.ArrayList;
import java.util.List;

public class Node {
    ArrayList<Edge> edges;
    int posX;
    int posY;

    Node(int x, int y){
        posX = x;
        posY = y;
        edges = new ArrayList<>();
    }

    public void addEdge(Node destination){
        double weight = Math.sqrt(Math.pow(this.posX - destination.posX, 2) + Math.pow(this.posY - destination.posY, 2));
        edges.add(new Edge(destination, weight));
    }

    public Edge getEdge(int i){
        return edges.get(i);
    }

    public ArrayList<Edge> getEdges(){
        return edges;
    }
}
