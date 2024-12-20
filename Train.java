// Linked list untuk setiap kereta
class Train {
    String name;
    String departureStation;
    String schedule;
    int capacity;
    Passenger topPassenger;

    Train(String name, String departureStation, String schedule, int capacity) {
        this.name = name;
        this.departureStation = departureStation;
        this.schedule = schedule;
        this.capacity = capacity;
        this.topPassenger = null;
    }

    void addPassenger(String passengerName) {
        System.out.println("Berhasil menambahkan " + passengerName + " ke dalam kereta " + name);
        Passenger newPassenger = new Passenger(passengerName);
        if (topPassenger == null) {
            topPassenger = newPassenger;
        } else {
            newPassenger.next = topPassenger;
            topPassenger = newPassenger;
        }
        capacity--;
    }

    void displayPassengers() {
        Passenger temp = topPassenger;
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