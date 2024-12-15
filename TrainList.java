// Linked list untuk daftar kereta
class TrainList {
    TrainNode head;

    void addTrain(Train train) {
        TrainNode newNode = new TrainNode(train);
        if (head == null) {
            head = newNode;
        } else {
            TrainNode temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    void displaySchedule() {
        TrainNode temp = head;
        System.out.println("Jadwal Kereta:");
        while (temp != null) {
            System.out.println(temp.train.name + " - " + temp.train.schedule + " - " + temp.train.departureStation);
            temp = temp.next;
        }
    }

    Train findTrainByName(String name) {
        System.out.println("Searching for train: " + name);
        TrainNode temp = head;
        while (temp != null) {
            if (temp.train.name.equalsIgnoreCase(name)) {
                return temp.train;
            }
            temp = temp.next;
        }
        return null;
    }

    void displayPassengers() {
        TrainNode temp = head;
        while (temp != null) {
            temp.train.displayPassengers();
            temp = temp.next;
        }
    }
}