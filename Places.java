// Node untuk menyimpan tetangga dari stasiun (linked list)
class Places {
    String station;
    int distance;
    Places next;

    Places(String station, int distance) {
        this.station = station;
        this.distance = distance;
        this.next = null;
    }
}