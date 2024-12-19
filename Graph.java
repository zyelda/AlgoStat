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
}