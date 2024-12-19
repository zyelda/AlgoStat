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
        graph.addStation("Stasiun A");
        graph.addStation("Pabrik A");
        graph.addStation("Pabrik B");
        graph.addStation("Taman");
        graph.addStation("Bukit");
        graph.addStation("Laut");
        graph.addStation("Hutan");
        graph.addStation("Rumah Sakit");
        graph.addStation("Bandara");
        graph.addStation("Stasiun B");

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
        System.out.println("Recommending train...");
        System.out.print("Masukkan tujuan: ");
        String destination = scanner.nextLine();
        System.out.print("Masukkan jam keberangkatan (HH:mm): ");
        String departureTime = scanner.nextLine();

        TrainNode temp = trains.head;
        Train recommendedTrain1 = null, recommendedTrain2 = null;

        while (temp != null) {
            Train currentTrain = temp.train;
            if (currentTrain.schedule.compareTo(departureTime) >= 0) {
                if (recommendedTrain1 == null || currentTrain.schedule.compareTo(recommendedTrain1.schedule) < 0) {
                    recommendedTrain2 = recommendedTrain1;
                    recommendedTrain1 = currentTrain;
                } else if (recommendedTrain2 == null || currentTrain.schedule.compareTo(recommendedTrain2.schedule) < 0) {
                    recommendedTrain2 = currentTrain;
                }
            }
            temp = temp.next;
        }

        if (recommendedTrain1 != null) {
            System.out.println("Rekomendasi 1: " + recommendedTrain1.name + " - " + recommendedTrain1.schedule + " - " + recommendedTrain1.departureStation);
        }
        if (recommendedTrain2 != null) {
            System.out.println("Rekomendasi 2: " + recommendedTrain2.name + " - " + recommendedTrain2.schedule + " - " + recommendedTrain2.departureStation);
        }
        if (recommendedTrain1 == null && recommendedTrain2 == null) {
            System.out.println("Tidak ada kereta yang cocok.");
        }
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
                train.addPassenger(passengerName);
                System.out.println("Tiket berhasil dipesan untuk " + passengerName + " di kereta " + trainName);
            } else {
                System.out.println("Kereta " + trainName + " sudah penuh.");
            }
        } else {
            System.out.println("Kereta " + trainName + " tidak ditemukan.");
        }
    }
}

