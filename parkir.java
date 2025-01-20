import java.util.ArrayList;
import java.util.Scanner;

class Parkir {
    private int kapasitas;
    private ArrayList<String> kendaraanParkir;

    public Parkir(int kapasitas) {
        this.kapasitas = kapasitas;
        kendaraanParkir = new ArrayList<>();
    }

    public void masukParkir() {
        if (kendaraanParkir.size() < kapasitas) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Masukkan nama kendaraan yang ingin parkir: ");
            String kendaraan = scanner.nextLine();
            kendaraanParkir.add(kendaraan);
            System.out.println(kendaraan + " berhasil masuk ke area parkir.");
        } else {
            System.out.println("Parkir sudah penuh!");
        }
    }

    public void keluarParkir() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan nama kendaraan yang ingin keluar: ");
        String kendaraan = scanner.nextLine();

        if (kendaraanParkir.contains(kendaraan)) {
            kendaraanParkir.remove(kendaraan);
            System.out.println(kendaraan + " telah keluar dari area parkir.");
        } else {
            System.out.println(kendaraan + " tidak ditemukan di parkir.");
        }
    }

    public void statusParkir() {
        if (kendaraanParkir.isEmpty()) {
            System.out.println("Area parkir kosong.");
        } else {
            System.out.println("Kendaraan yang terparkir:");
            for (String kendaraan : kendaraanParkir) {
                System.out.println(kendaraan);
            }
        }
    }
}

public class SistemParkir {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan kapasitas parkir: ");
        int kapasitasParkir = scanner.nextInt();

        Parkir parkir = new Parkir(kapasitasParkir);

        int pilihan;
        do {
            System.out.println("\nPilih menu:");
            System.out.println("1. Masukkan kendaraan");
            System.out.println("2. Keluarkan kendaraan");
            System.out.println("3. Lihat status parkir");
            System.out.println("4. Keluar");

            System.out.print("Pilihan Anda: ");
            pilihan = scanner.nextInt();
            scanner.nextLine(); // Untuk menangani newline setelah memasukkan pilihan

            switch (pilihan) {
                case 1:
                    parkir.masukParkir();
                    break;
                case 2:
                    parkir.keluarParkir();
                    break;
                case 3:
                    parkir.statusParkir();
                    break;
                case 4:
                    System.out.println("Terima kasih telah menggunakan sistem parkir!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid, coba lagi.");
            }
        } while (pilihan != 4);

        scanner.close();
    }
}