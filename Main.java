
package modul.pkg5.ez;

class Main {
    static class Edge {
        int source, destination, weight;

        Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }

    static class Graph {
        int vertices;
        Edge[] edges;

        Graph(int vertices, int edgeCount) {
            this.vertices = vertices;
            edges = new Edge[edgeCount];
        }

        void addEdge(int index, int source, int destination, int weight) {
            edges[index] = new Edge(source, destination, weight);
        }   

