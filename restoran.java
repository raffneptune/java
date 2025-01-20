import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Menu {
    String nama;
    int harga;

    public Menu(String nama, int harga) {
        this.nama = nama;
        this.harga = harga;
    }
}

class Pesanan {
    Menu menu;
    int jumlah;

    public Pesanan(Menu menu, int jumlah) {
        this.menu = menu;
        this.jumlah = jumlah;
    }
}

public class Restoran {

    private static List<Menu> menuList = new ArrayList<>();
    private static List<Pesanan> pesananList = new ArrayList<>();

    static {
        menuList.add(new Menu("Nasi Goreng", 25000));
        menuList.add(new Menu("Mie Goreng", 20000));
        menuList.add(new Menu("Sate Ayam", 30000));
        menuList.add(new Menu("Ayam Penyet", 35000));
        menuList.add(new Menu("Es Teh", 5000));
        menuList.add(new Menu("Es Jeruk", 7000));
    }

    public static void tampilkanMenu() {
        System.out.println("\nMenu Restoran:");
        for (int i = 0; i < menuList.size(); i++) {
            System.out.println((i + 1) + ". " + menuList.get(i).nama + " - Rp" + menuList.get(i).harga);
        }
    }

    public static int hitungTotal() {
        int total = 0;
        for (Pesanan pesanan : pesananList) {
            total += pesanan.menu.harga * pesanan.jumlah;
        }
        return total;
    }

    public static void tampilkanPesanan() {
        if (pesananList.isEmpty()) {
            System.out.println("\nBelum ada pesanan.");
        } else {
            System.out.println("\nPesanan Anda:");
            for (Pesanan pesanan : pesananList) {
                System.out.println(pesanan.menu.nama + " x " + pesanan.jumlah + " - Rp" + pesanan.menu.harga * pesanan.jumlah);
            }
            System.out.println("Total Harga: Rp" + hitungTotal());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int pilihan;

        while (true) {
            System.out.println("\n-- Menu Utama --");
            System.out.println("1. Lihat Menu");
            System.out.println("2. Tambah Pesanan");
            System.out.println("3. Tampilkan Pesanan");
            System.out.println("4. Hitung Total");
            System.out.println("5. Keluar");

            System.out.print("Pilih opsi (1-5): ");
            pilihan = scanner.nextInt();

            switch (pilihan) {
                case 1:
                    tampilkanMenu();
                    break;
                case 2:
                    tampilkanMenu();
                    System.out.print("\nPilih nomor menu untuk dipesan (0 untuk selesai): ");
                    pilihan = scanner.nextInt();

                    if (pilihan == 0) break;

                    if (pilihan > 0 && pilihan <= menuList.size()) {
                        System.out.print("Berapa banyak " + menuList.get(pilihan - 1).nama + " yang ingin dipesan? ");
                        int jumlah = scanner.nextInt();

                        pesananList.add(new Pesanan(menuList.get(pilihan - 1), jumlah));
                        System.out.println(jumlah + " " + menuList.get(pilihan - 1).nama + " ditambahkan ke pesanan.");
                    } else {
                        System.out.println("Nomor menu tidak valid!");
                    }
                    break;
                case 3:
                    tampilkanPesanan();
                    break;
                case 4:
                    System.out.println("Total Harga: Rp" + hitungTotal());
                    break;
                case 5:
                    System.out.println("Terima kasih telah berkunjung!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opsi tidak valid!");
                    break;
            }
        }
    }
}