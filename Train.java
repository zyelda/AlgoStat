// Linked list untuk setiap kereta
class Train {
    String name;
    String departureStation;
    String schedule;
    int capacity;
    Passenger headPassenger;

    Train(String name, String departureStation, String schedule, int capacity) {
        this.name = name;
        this.departureStation = departureStation;
        this.schedule = schedule;
        this.capacity = capacity;
        this.headPassenger = null;
    }

    void addPassenger(String passengerName) {
        System.out.println("Berhasil menambahkan " + passengerName + " ke dalam kereta " + name);
        Passenger newPassenger = new Passenger(passengerName);
        if (headPassenger == null) {
            headPassenger = newPassenger;
        } else {
            Passenger temp = headPassenger;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newPassenger;
        }
        capacity--;
    }

    void displayPassengers() {
        Passenger temp = headPassenger;
        System.out.println("Penumpang Kereta " + name + ":");
        if (temp == null) {
            System.out.println("Tidak ada penumpang.");
        } else {
            while (temp != null) {
                System.out.println("- " + temp.name);
                temp = temp.next;
            }
        }
    }
}