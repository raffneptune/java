import java.util.ArrayList;
import java.util.Scanner;

class Barang {
    String nama;
    double harga;
    int jumlah;
    double total;

    // Constructor untuk membuat objek Barang
    public Barang(String nama, double harga, int jumlah) {
        this.nama = nama;
        this.harga = harga;
        this.jumlah = jumlah;
        this.total = harga * jumlah;
    }

    // Menampilkan rincian barang
    public void tampilkanRincian() {
        System.out.println(nama + " - Harga: " + harga + " - Jumlah: " + jumlah + " - Total: " + total);
    }
}

class Kasir {
    ArrayList<Barang> daftarBarang;
    double totalHarga;

    // Constructor untuk inisialisasi
    public Kasir() {
        daftarBarang = new ArrayList<>();
        totalHarga = 0;
    }

    // Menambah barang ke daftar belanja
    public void tambahBarang(String nama, double harga, int jumlah) {
        Barang barang = new Barang(nama, harga, jumlah);
        daftarBarang.add(barang);
        totalHarga += barang.total;
        System.out.println(nama + " x" + jumlah + " ditambahkan ke daftar belanja.");
    }

    // Menampilkan rincian belanja
    public void tampilkanRincian() {
        System.out.println("\n--- Rincian Belanja ---");
        for (Barang barang : daftarBarang) {
            barang.tampilkanRincian();
        }
        System.out.println("\nTotal Belanja: " + totalHarga);
    }

    // Proses pembayaran dan menghitung kembalian
    public void bayar(double uangDibayar) {
        if (uangDibayar >= totalHarga) {
            double kembalian = uangDibayar - totalHarga;
            System.out.println("\nTotal yang harus dibayar: " + totalHarga);
            System.out.println("Uang yang dibayar: " + uangDibayar);
            System.out.println("Kembalian: " + kembalian);
        } else {
            System.out.println("\nUang yang dibayar kurang dari total belanja. Transaksi dibatalkan.");
        }
    }
}

public class ProgramKasir {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Kasir kasir = new Kasir();

        while (true) {
            System.out.println("\nMenu Kasir");
            System.out.println("1. Tambah barang");
            System.out.println("2. Tampilkan rincian belanja");
            System.out.println("3. Bayar");
            System.out.println("4. Keluar");
            System.out.print("Pilih menu (1/2/3/4): ");
            int pilihan = scanner.nextInt();
            scanner.nextLine(); // Clear buffer

            if (pilihan == 1) {
                System.out.print("Masukkan nama barang: ");
                String namaBarang = scanner.nextLine();
                System.out.print("Masukkan harga barang: ");
                double harga = scanner.nextDouble();
                System.out.print("Masukkan jumlah barang: ");
                int jumlah = scanner.nextInt();
                kasir.tambahBarang(namaBarang, harga, jumlah);
            } else if (pilihan == 2) {
                kasir.tampilkanRincian();
            } else if (pilihan == 3) {
                kasir.tampilkanRincian();
                System.out.print("Masukkan uang yang dibayar: ");
                double uangDibayar = scanner.nextDouble();
                kasir.bayar(uangDibayar);
            } else if (pilihan == 4) {
                System.out.println("Terima kasih, sampai jumpa!");
                break;
            } else {
                System.out.println("Pilihan tidak valid, coba lagi.");
            }
        }
        scanner.close();
    }
}