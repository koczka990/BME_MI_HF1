package kereses;

import java.util.ArrayList;

public class Graph {
    private ArrayList<Node> nodes;
    ArrayList<int[]> routesToFind;

    public Graph(){
        nodes = new ArrayList<>();
        routesToFind = new ArrayList<>();
    }

    public void addNode(Node n){
        nodes.add(n);
    }

    public Node getNode(int i){
        return nodes.get(i);
    }

    public void addRoute(int[] route){
        routesToFind.add(route);
    }

    public int getSize(){
        return nodes.size();
    }

    public ArrayList<Node> getNodes(){
        return nodes;
    }

    public double getMaxDistance(){
        double sum = 0;
        for(Node n : nodes){
            for(Edge e : n.getEdges()){
                sum += e.getWeight();
            }
        }
        return sum;
    }

    public int getIndex(Node n){
        return nodes.indexOf(n);
    }
}
