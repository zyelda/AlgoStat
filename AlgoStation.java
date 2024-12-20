import java.util.Scanner;
// Main class untuk sistem manajemen kereta api
public class AlgoStation {
    static TrainList trains = new TrainList();
    static Graph graph = new Graph();

    public static void main(String[] args) {
        initializeTrains();
        initializeGraph();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("=================================================");
            System.out.println("|            ALGOSTAT TRAIN STATION             |");
            System.out.println("=================================================");
            System.out.println("Silahkan Pilih Menu:");
            System.out.println("1. Rekomendasi kereta");
            System.out.println("2. Cek jadwal kereta");
            System.out.println("3. Beli tiket kereta");
            System.out.println("4. Cek jumlah penumpang");
            System.out.println("5. Keluar dari program");
            System.out.print("Pilih menu (1-5): ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Membersihkan buffer

            System.out.println("User selected menu option: " + choice);

            switch (choice) {
                case 1:
                    recommendTrain(scanner);
                    break;
                case 2:
                    trains.bubblesort();
                    trains.displaySchedule();
                    break;
                case 3:
                    bookTicket(scanner);
                    break;
                case 4:
                    trains.displayPassengers();
                    break;
                case 5:
                    running = false;
                    System.out.println("Have a nice trip, thank you.");
                    break;
                default:
                    System.out.println("Silahkan Pilih Menu Ynag Tersedia");
            }
        }
        scanner.close();
    }

    static void initializeTrains() {
        trains.addTrain(new Train("Alpha", "Stasiun A", "06:00", 10));
        trains.addTrain(new Train("Beta", "Stasiun A", "11:00", 10));
        trains.addTrain(new Train("Delta", "Stasiun A", "17:00", 10));
        trains.addTrain(new Train("Sigma", "Stasiun B", "21:00", 10));
        trains.addTrain(new Train("Theta", "Stasiun B", "02:00", 10));
    }

    static void initializeGraph() {
        // Menambahkan stasiun ke graph
        graph.addVertex("Stasiun A");
        graph.addVertex("Pabrik A");
        graph.addVertex("Pabrik B");
        graph.addVertex("Taman");
        graph.addVertex("Bukit");
        graph.addVertex("Laut");
        graph.addVertex("Hutan");
        graph.addVertex("Rumah Sakit");
        graph.addVertex("Bandara");
        graph.addVertex("Stasiun B");

        // Menambahkan edge ke graph
        graph.addEdge("Stasiun A", "Pabrik A", 3);
        graph.addEdge("Stasiun A", "Pabrik B", 5);
        graph.addEdge("Pabrik A", "Pabrik B", 6);
        graph.addEdge("Pabrik A", "Taman", 10);
        graph.addEdge("Pabrik B", "Bukit", 7);
        graph.addEdge("Pabrik B", "Laut", 8);
        graph.addEdge("Taman", "Hutan", 2);
        graph.addEdge("Taman", "Bukit", 5);
        graph.addEdge("Laut", "Bukit", 15);
        graph.addEdge("Laut", "Rumah Sakit", 7);
        graph.addEdge("Rumah Sakit", "Bukit", 5);
        graph.addEdge("Rumah Sakit", "Bandara", 2);
        graph.addEdge("Bukit", "Hutan", 4);
        graph.addEdge("Hutan", "Bandara", 3);
        graph.addEdge("Hutan", "Stasiun B", 4);
        graph.addEdge("Bandara", "Stasiun B", 2);
    }

    static void recommendTrain(Scanner scanner) {
        System.out.print("Masukkan stasiun tujuan: ");
        String destinationStation = scanner.nextLine();
        graph.dijkstra("Stasiun A");
        graph.printShortestPath(destinationStation);
    }
    
    static void bookTicket(Scanner scanner) {
        System.out.println("Beli Tiket");
        System.out.print("Masukkan nama kereta: ");
        String trainName = scanner.nextLine();
        System.out.print("Masukkan nama penumpang: ");
        String passengerName = scanner.nextLine();

        Train train = trains.findTrainByName(trainName);
        if (train != null) {
            if (train.capacity > 0) {
                train.pushPassenger(passengerName);
                System.out.println("Tiket berhasil dipesan untuk " + passengerName + " di kereta " + trainName);
            } else {
                System.out.println("Kereta " + trainName + " sudah penuh.");
            }
        } else {
            System.out.println("Kereta " + trainName + " tidak ditemukan.");
        }
    }
}

