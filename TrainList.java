// Linked list untuk daftar kereta
class TrainList {
    TrainNode head;

    //Menambah kereta dengan menggunakan struktur linked list
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

    //Search sekuensial
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
    
    //Sort kereta berdasarkan jadwal menggunakan bubble sort
    void bubblesort(){
        if (head == null || head.next == null) {
            return;
        }
    
        boolean swapped;
        do {
            swapped = false;
            TrainNode current = head;
            TrainNode prev = null;
    
            while (current != null && current.next != null) {
                if (current.train.schedule.compareTo(current.next.train.schedule) > 0) {
                    Train tempTrain = current.train;
                    current.train = current.next.train;
                    current.next.train = tempTrain;
    
                    swapped = true;
                }
                prev = current;
                current = current.next;
            }
        } while (swapped);
    }
}