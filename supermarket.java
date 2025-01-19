import java.util.ArrayList;
import java.util.Scanner;

class Produk {
    String nama;
    int harga;

    Produk(String nama, int harga) {
        this.nama = nama;
        this.harga = harga;
    }
}

public class Supermarket {

    // Daftar produk dan harga
    static Produk[] produkList = {
        new Produk("Apel", 10000),
        new Produk("Pisang", 8000),
        new Produk("Jeruk", 12000),
        new Produk("Mangga", 15000),
        new Produk("Semangka", 20000)
    };

    // Fungsi untuk menampilkan daftar produk
    public static void tampilkanProduk() {
        System.out.println("\nDaftar Produk Supermarket:");
        for (Produk produk : produkList) {
            System.out.println(produk.nama + ": Rp " + produk.harga);
        }
    }

    // Fungsi untuk menambah barang ke keranjang
    public static void tambahKeKeranjang(ArrayList<String> keranjang, ArrayList<Integer> jumlah, String produkNama, int jumlahBarang) {
        int index = keranjang.indexOf(produkNama);
        if (index != -1) {
            jumlah.set(index, jumlah.get(index) + jumlahBarang);
        } else {
            keranjang.add(produkNama);
            jumlah.add(jumlahBarang);
        }
    }

    // Fungsi untuk menghitung total belanjaan
    public static int hitungTotal(ArrayList<String> keranjang, ArrayList<Integer> jumlah) {
        int total = 0;
        for (int i = 0; i < keranjang.size(); i++) {
            String produkNama = keranjang.get(i);
            int qty = jumlah.get(i);
            for (Produk produk : produkList) {
                if (produk.nama.equals(produkNama)) {
                    total += produk.harga * qty;
                    break;
                }
            }
        }
        return total;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> keranjang = new ArrayList<>();
        ArrayList<Integer> jumlah = new ArrayList<>();
        String pilihan;
        
        while (true) {
            tampilkanProduk();
            System.out.print("\nMasukkan nama produk yang ingin dibeli (atau ketik 'selesai' untuk keluar): ");
            pilihan = scanner.nextLine();
            
            if (pilihan.equalsIgnoreCase("selesai")) {
                break;
            }
            
            boolean ditemukan = false;
            for (Produk produk : produkList) {
                if (produk.nama.equalsIgnoreCase(pilihan)) {
                    ditemukan = true;
                    System.out.print("Berapa banyak " + pilihan + " yang ingin Anda beli? ");
                    int jumlahBarang = scanner.nextInt();
                    scanner.nextLine();  // Membersihkan buffer
                    tambahKeKeranjang(keranjang, jumlah, produk.nama, jumlahBarang);
                    break;
                }
            }
            
            if (!ditemukan) {
                System.out.println("Produk tidak tersedia. Silakan pilih produk yang ada.");
            }
        }

        // Menampilkan keranjang belanja
        System.out.println("\nKeranjang Belanja Anda:");
        int total = 0;
        for (int i = 0; i < keranjang.size(); i++) {
            String produkNama = keranjang.get(i);
            int qty = jumlah.get(i);
            for (Produk produk : produkList) {
                if (produk.nama.equals(produkNama)) {
                    int subtotal = produk.harga * qty;
                    System.out.println(produk.nama + ": " + qty + " x Rp " + produk.harga + " = Rp " + subtotal);
                    total += subtotal;
                    break;
                }
            }
        }
        
        System.out.println("\nTotal Belanja: Rp " + total);
        scanner.close();
    }
}