import java.util.Scanner;

public class HelloWorld {
    public static void main(String[] args) {
        // Menampilkan pesan ke layar
        System.out.println("Hello, World!");

        // Membuat scanner untuk membaca input dari pengguna
        Scanner scanner = new Scanner(System.in);

        // Meminta nama pengguna
        System.out.print("Masukkan nama Anda: ");
        String nama = scanner.nextLine();

        // Menampilkan salam dengan nama pengguna
        System.out.println("Halo, " + nama + "! Selamat datang di dunia Java.");

        // Menutup scanner
        scanner.close();
    }
}
