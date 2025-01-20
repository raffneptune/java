import java.util.Scanner;

class Komputer {
    int nomor;
    boolean tersedia;
    long mulaiSewa;
    double durasiSewa;

    public Komputer(int nomor) {
        this.nomor = nomor;
        this.tersedia = true;
        this.mulaiSewa = 0;
        this.durasiSewa = 0;
    }

    public void sewa() {
        if (tersedia) {
            tersedia = false;
            mulaiSewa = System.currentTimeMillis();
            System.out.println("Komputer " + nomor + " telah disewa.");
        } else {
            System.out.println("Komputer " + nomor + " sedang disewa.");
        }
    }

    public void selesaiSewa() {
        if (!tersedia) {
            long selesaiSewa = System.currentTimeMillis();
            durasiSewa = (selesaiSewa - mulaiSewa) / (1000 * 60);  // durasi dalam menit
            double biaya = durasiSewa * 2000;  // biaya per menit misalnya 2000 IDR
            tersedia = true;
            System.out.println("Komputer " + nomor + " selesai disewa. Durasi: " + String.format("%.2f", durasiSewa) + " menit.");
            System.out.println("Biaya yang harus dibayar: Rp " + String.format("%.2f", biaya));
        } else {
            System.out.println("Komputer " + nomor + " belum disewa.");
        }
    }
}

class Warnet {
    Komputer[] komputer;

    public Warnet(int jumlahKomputer) {
        komputer = new Komputer[jumlahKomputer];
        for (int i = 0; i < jumlahKomputer; i++) {
            komputer[i] = new Komputer(i + 1);
        }
    }

    public void tampilkanKomputer() {
        System.out.println("\nDaftar Komputer:");
        for (Komputer kom : komputer) {
            String status = kom.tersedia ? "Tersedia" : "Sedang disewa";
            System.out.println("Komputer " + kom.nomor + ": " + status);
        }
    }

    public void sewaKomputer(int nomor) {
        if (nomor >= 1 && nomor <= komputer.length) {
            komputer[nomor - 1].sewa();
        } else {
            System.out.println("Nomor komputer tidak valid!");
        }
    }

    public void selesaiKomputer(int nomor) {
        if (nomor >= 1 && nomor <= komputer.length) {
            komputer[nomor - 1].selesaiSewa();
        } else {
            System.out.println("Nomor komputer tidak valid!");
        }
    }
}

public class Main {
    public static void menu() {
        Warnet warnet = new Warnet(5); // Misalkan ada 5 komputer di warnet
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n--- Menu Warnet ---");
            System.out.println("1. Tampilkan Daftar Komputer");
            System.out.println("2. Sewa Komputer");
            System.out.println("3. Selesai Sewa Komputer");
            System.out.println("4. Keluar");
            System.out.print("Pilih menu: ");
            int pilihan = scanner.nextInt();

            switch (pilihan) {
                case 1:
                    warnet.tampilkanKomputer();
                    break;
                case 2:
                    System.out.print("Masukkan nomor komputer yang ingin disewa: ");
                    int nomorSewa = scanner.nextInt();
                    warnet.sewaKomputer(nomorSewa);
                    break;
                case 3:
                    System.out.print("Masukkan nomor komputer yang selesai disewa: ");
                    int nomorSelesai = scanner.nextInt();
                    warnet.selesaiKomputer(nomorSelesai);
                    break;
                case 4:
                    System.out.println("Terima kasih telah menggunakan layanan warnet!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Pilihan tidak valid!");
                    break;
            }
        }
    }

    public static void main(String[] args) {
        menu();
    }
}