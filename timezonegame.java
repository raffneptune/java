import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class TimezoneMall {

    // Kelas untuk menyimpan data pengguna
    static class User {
        String name;
        int kredit;
        List<String> permainan;

        public User(String name) {
            this.name = name;
            this.kredit = 0;
            this.permainan = new ArrayList<>();
        }
    }

    // Daftar pengguna
    static List<User> users = new ArrayList<>();

    // Fungsi untuk mendaftar pengguna baru
    static void registerUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan nama pengguna: ");
        String name = scanner.nextLine();

        // Cek apakah pengguna sudah terdaftar
        for (User user : users) {
            if (user.name.equals(name)) {
                System.out.println("Pengguna dengan nama " + name + " sudah terdaftar.");
                return;
            }
        }

        // Menambahkan pengguna baru
        users.add(new User(name));
        System.out.println("Selamat datang, " + name + "! Akun Anda telah dibuat.");
    }

    // Fungsi untuk membeli kredit
    static void buyCredits(String userName) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Berapa banyak kredit yang ingin Anda beli? (1 kredit = 5000 IDR): ");
        int creditAmount = scanner.nextInt();

        // Cari pengguna berdasarkan nama
        for (User user : users) {
            if (user.name.equals(userName)) {
                user.kredit += creditAmount;
                System.out.println(creditAmount + " kredit telah ditambahkan ke akun Anda.");
                return;
            }
        }

        System.out.println("Pengguna tidak ditemukan. Silakan mendaftar terlebih dahulu.");
    }

    // Fungsi untuk bermain game
    static void playGame(String userName) {
        Scanner scanner = new Scanner(System.in);

        // Cari pengguna berdasarkan nama
        for (User user : users) {
            if (user.name.equals(userName)) {
                if (user.kredit < 1) {
                    System.out.println("Anda tidak memiliki kredit cukup untuk bermain game. Silakan beli kredit terlebih dahulu.");
                    return;
                }

                System.out.println("Pilih permainan yang ingin dimainkan:");
                System.out.println("1. Pac-Man (1 kredit)");
                System.out.println("2. Street Fighter (2 kredit)");
                System.out.println("3. Racing Game (3 kredit)");

                int gameChoice = scanner.nextInt();

                if (gameChoice == 1 && user.kredit >= 1) {
                    user.kredit -= 1;
                    System.out.println("Anda sedang bermain Pac-Man! Semoga berhasil!");
                } else if (gameChoice == 2 && user.kredit >= 2) {
                    user.kredit -= 2;
                    System.out.println("Anda sedang bermain Street Fighter! Bertarunglah dengan kuat!");
                } else if (gameChoice == 3 && user.kredit >= 3) {
                    user.kredit -= 3;
                    System.out.println("Anda sedang bermain Racing Game! Gaspol!");
                } else {
                    System.out.println("Anda tidak memiliki kredit cukup untuk memilih permainan ini.");
                    return;
                }

                // Simulasi hasil permainan (acak)
                Random rand = new Random();
                int result = rand.nextInt(2); // 0 = Kalah, 1 = Menang
                System.out.println("Memulai permainan...");
                System.out.println("Hasil permainan: " + (result == 1 ? "Menang" : "Kalah"));

                // Menyimpan riwayat permainan
                user.permainan.add(result == 1 ? "Menang" : "Kalah");
                return;
            }
        }

        System.out.println("Pengguna tidak ditemukan. Silakan mendaftar terlebih dahulu.");
    }

    // Fungsi untuk mengecek saldo kredit
    static void checkBalance(String userName) {
        // Cari pengguna berdasarkan nama
        for (User user : users) {
            if (user.name.equals(userName)) {
                System.out.println("Sisa kredit Anda: " + user.kredit + " kredit.");
                return;
            }
        }

        System.out.println("Pengguna tidak ditemukan. Silakan mendaftar terlebih dahulu.");
    }

    // Menu utama
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu Utama:");
            System.out.println("1. Daftar pengguna baru");
            System.out.println("2. Beli kredit");
            System.out.println("3. Mainkan game");
            System.out.println("4. Cek saldo kredit");
            System.out.println("5. Keluar");

            System.out.print("Pilih menu (1/2/3/4/5): ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Membersihkan newline

            if (choice == 1) {
                registerUser();
            } else if (choice == 2) {
                System.out.print("Masukkan nama pengguna untuk membeli kredit: ");
                String userName = scanner.nextLine();
                buyCredits(userName);
            } else if (choice == 3) {
                System.out.print("Masukkan nama pengguna untuk bermain game: ");
                String userName = scanner.nextLine();
                playGame(userName);
            } else if (choice == 4) {
                System.out.print("Masukkan nama pengguna untuk cek saldo: ");
                String userName = scanner.nextLine();
                checkBalance(userName);
            } else if (choice == 5) {
                System.out.println("Terima kasih telah bermain di Timezone Mall! Sampai jumpa lagi!");
                break;
            } else {
                System.out.println("Pilihan tidak valid. Silakan pilih lagi.");
            }
        }
    }
}