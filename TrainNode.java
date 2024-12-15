// Node untuk menyimpan daftar kereta (linked list)
class TrainNode {
    Train train;
    TrainNode next;

    TrainNode(Train train) {
        this.train = train;
        this.next = null;
    }
}