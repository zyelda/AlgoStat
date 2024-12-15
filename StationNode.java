// Node untuk menyimpan data stasiun di graph (linked list)
class StationNode {
    String station;
    Places destination;
    StationNode next;

    StationNode(String station) {
        this.station = station;
        this.destination = null;
        this.next = null;
    }

    void addRoute(String Route, int distance) {
        Places newRoute = new Places(Route, distance);
        if (destination == null) {
            destination = newRoute;
        } else {
            Places temp = destination;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newRoute;
        }
    }

    void displayDestination() {
        Places temp = destination;
        while (temp != null) {
            System.out.print(" -> " + temp.station + " (" + temp.distance + " km)");
            temp = temp.next;
        }
        System.out.println();
    }
}