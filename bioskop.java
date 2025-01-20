import java.util.Scanner;

public class Bioskop {

    // Menampilkan daftar film yang tersedia
    public static void showFilms() {
        System.out.println("Daftar Film yang Tersedia:");
        System.out.println("1. Film A - Harga: Rp 50000");
        System.out.println("2. Film B - Harga: Rp 60000");
        System.out.println("3. Film C - Harga: Rp 70000");
        System.out.println("4. Film D - Harga: Rp 55000");
    }

    // Memilih film yang diinginkan oleh pengguna
    public static int pilihFilm(Scanner scanner) {
        int pilihan;
        while (true) {
            System.out.print("\nPilih film (1-4): ");
            if (scanner.hasNextInt()) {
                pilihan = scanner.nextInt();
                if (pilihan >= 1 && pilihan <= 4) {
                    return pilihan;
                } else {
                    System.out.println("Pilihan tidak valid, coba lagi.");
                }
            } else {
                System.out.println("Masukkan angka yang valid.");
                scanner.next(); // Clear invalid input
            }
        }
    }

    // Mendapatkan nama film berdasarkan pilihan
    public static String getFilmName(int pilihan) {
        switch (pilihan) {
            case 1: return "Film A";
            case 2: return "Film B";
            case 3: return "Film C";
            case 4: return "Film D";
            default: return "Film Tidak Diketahui";
        }
    }

    // Proses membeli tiket
    public static void beliTiket(Scanner scanner) {
        int pilihan, jumlahTiket, totalHarga;

        while (true) {
            showFilms();
            pilihan = pilihFilm(scanner);

            // Menghitung harga berdasarkan film yang dipilih
            switch (pilihan) {
                case 1: totalHarga = 50000; break;
                case 2: totalHarga = 60000; break;
                case 3: totalHarga = 70000; break;
                case 4: totalHarga = 55000; break;
                default: totalHarga = 0; break;
            }

            // Input jumlah tiket
            System.out.print("Masukkan jumlah tiket yang ingin dibeli: ");
            while (!scanner.hasNextInt()) {
                System.out.print("Jumlah tiket tidak valid, coba lagi: ");
                scanner.next(); // Clear invalid input
            }
            jumlahTiket = scanner.nextInt();

            totalHarga *= jumlahTiket; // Menghitung total harga

            // Menampilkan hasil pembelian
            System.out.printf("\nTiket untuk film %s (%d tiket) berhasil dipesan.\n", getFilmName(pilihan), jumlahTiket);
            System.out.printf("Total harga: Rp %d\n", totalHarga);

            // Tanya apakah ingin membeli tiket lagi
            System.out.print("\nApakah Anda ingin membeli tiket lagi? (y/t): ");
            char lagi = scanner.next().charAt(0);

            if (Character.toLowerCase(lagi) == 't') {
                System.out.println("Terima kasih telah membeli tiket di bioskop kami!");
                break;
            }
        }
    }

    // Program utama
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        beliTiket(scanner);
        scanner.close();
    }
}