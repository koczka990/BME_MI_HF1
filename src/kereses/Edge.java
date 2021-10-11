package kereses;

public class Edge {
    private Node destination;
    double weight;

    Edge(Node dest, double w){
        destination = dest;
        weight = w;
    }

    public double getWeight() {
        return weight;
    }

    public Node getDestination() {
        return destination;
    }
}
