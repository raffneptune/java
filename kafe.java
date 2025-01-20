import java.util.Scanner;

class Cafe {

    // Daftar menu dan harga
    private String[] menu = {"Kopi", "Teh", "Espresso", "Cappuccino", "Kue"};
    private int[] harga = {15000, 10000, 20000, 25000, 12000};
    private String[] pesanan = new String[10];
    private int[] jumlahPesanan = new int[10];
    private int pesananCount = 0;

    // Menampilkan menu
    public void tampilkanMenu() {
        System.out.println("\n--- Menu Kafe ---");
        for (int i = 0; i < menu.length; i++) {
            System.out.println((i + 1) + ". " + menu[i] + ": Rp " + harga[i]);
        }
    }

    // Menambahkan pesanan
    public void tambahPesanan() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            tampilkanMenu();
            System.out.print("\nMasukkan nomor item yang ingin dipesan (ketik 0 untuk selesai): ");
            int pilihan = scanner.nextInt();

            if (pilihan == 0) {
                break;
            }

            if (pilihan >= 1 && pilihan <= menu.length) {
                System.out.print("Berapa banyak " + menu[pilihan - 1] + " yang ingin dipesan? ");
                int jumlah = scanner.nextInt();

                // Tambahkan pesanan ke dalam daftar pesanan
                if (pesananCount < pesanan.length) {
                    boolean ditemukan = false;
                    for (int i = 0; i < pesananCount; i++) {
                        if (pesanan[i].equals(menu[pilihan - 1])) {
                            jumlahPesanan[i] += jumlah;
                            ditemukan = true;
                            break;
                        }
                    }

                    if (!ditemukan) {
                        pesanan[pesananCount] = menu[pilihan - 1];
                        jumlahPesanan[pesananCount] = jumlah;
                        pesananCount++;
                    }

                    System.out.println(jumlah + " " + menu[pilihan - 1] + " telah ditambahkan ke pesanan.");
                } else {
                    System.out.println("Tidak dapat menambahkan pesanan. Maksimal pesanan tercapai.");
                }
            } else {
                System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }
    }

    // Menghitung total harga pesanan
    public int hitungTotal() {
        int total = 0;
        for (int i = 0; i < pesananCount; i++) {
            for (int j = 0; j < menu.length; j++) {
                if (pesanan[i].equals(menu[j])) {
                    total += harga[j] * jumlahPesanan[i];
                }
            }
        }
        return total;
    }

    // Menampilkan pesanan dan total harga
    public void tampilkanPesanan() {
        if (pesananCount == 0) {
            System.out.println("\nTidak ada pesanan.");
        } else {
            System.out.println("\n--- Pesanan Anda ---");
            for (int i = 0; i < pesananCount; i++) {
                for (int j = 0; j < menu.length; j++) {
                    if (pesanan[i].equals(menu[j])) {
                        System.out.println(pesanan[i] + " x " + jumlahPesanan[i] + " = Rp " + harga[j] * jumlahPesanan[i]);
                    }
                }
            }
            System.out.println("\nTotal yang harus dibayar: Rp " + hitungTotal());
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Cafe cafe = new Cafe();
        int pilihan;

        while (true) {
            System.out.println("\n--- Selamat Datang di Kafe! ---");
            System.out.println("1. Lihat Menu");
            System.out.println("2. Tambah Pesanan");
            System.out.println("3. Lihat Pesanan dan Total");
            System.out.println("4. Keluar");

            System.out.print("Pilih menu (1-4): ");
            pilihan = scanner.nextInt();

            switch (pilihan) {
                case 1:
                    cafe.tampilkanMenu();
                    break;
                case 2:
                    cafe.tambahPesanan();
                    break;
                case 3:
                    cafe.tampilkanPesanan();
                    break;
                case 4:
                    System.out.println("Terima kasih telah mengunjungi kafe kami. Sampai jumpa!");
                    return;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                    break;
            }
        }
    }
}