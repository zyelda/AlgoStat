//linked list untuk merepresentasikan graph sebagai rute kereta
class Graph {
    StationNode head;

    void addStation(String station) {
        StationNode newStation = new StationNode(station);
        if (head == null) {
            head = newStation;
        } else {
            StationNode temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newStation;
        }
    }

    StationNode findStation(String station) {
        StationNode temp = head;
        while (temp != null) {
            if (temp.station.equals(station)) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    void addEdge(String fromStation, String toStation, int distance) {
        StationNode station = findStation(fromStation);
        if (station != null) {
            station.addRoute(toStation, distance);
        }
    }

    void displayGraph() {
        System.out.println("Displaying graph:");
        StationNode temp = head;
        while (temp != null) {
            System.out.print(temp.station);
            temp.displayDestination();
            temp = temp.next;
        }
    }
    void dijkstra(String sourceStation) {
        StationNode source = findStation(sourceStation);
        source.distance = 0;

        StationNode current = source;
        while (current != null) {
            Places neighbor = current.destination;
            while (neighbor != null) {
                int newDistance = current.distance + neighbor.distance;
                StationNode neighborStation = findStation(neighbor.station);
                if (newDistance < neighborStation.distance) {
                    neighborStation.distance = newDistance;
                    neighborStation.previous = current;
                }
                neighbor = neighbor.next;
            }
            current = getNextStation(current);
        }
    }

    StationNode getNextStation(StationNode current) {
        StationNode next = current.next;
        while (next != null && next.distance == Integer.MAX_VALUE) {
            next = next.next;
        }
        return next;
    }

    void printShortestPath(String destinationStation) {
        StationNode destination = findStation(destinationStation);
        System.out.print("Rute Terpendek: ");
        StationNode current = destination;
        while (current != null) {
            System.out.print(current.station + "   ");
            current = current.previous;
        }
        System.out.println("");
    }
}