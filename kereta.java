import java.util.ArrayList;
import java.util.Scanner;

class Kereta {
    private String namaKereta;
    private String tujuan;
    private String waktuBerangkat;
    private int kapasitas;
    private int terisi;

    public Kereta(String namaKereta, String tujuan, String waktuBerangkat, int kapasitas) {
        this.namaKereta = namaKereta;
        this.tujuan = tujuan;
        this.waktuBerangkat = waktuBerangkat;
        this.kapasitas = kapasitas;
        this.terisi = 0;
    }

    public void tampilkanInfo() {
        System.out.println("Nama Kereta: " + namaKereta);
        System.out.println("Tujuan: " + tujuan);
        System.out.println("Waktu Berangkat: " + waktuBerangkat);
        System.out.println("Kapasitas: " + kapasitas);
        System.out.println("Terisi: " + terisi + "/" + kapasitas);
        System.out.println();
    }

    public void pesanTiket(int jumlahTiket) {
        if (terisi + jumlahTiket <= kapasitas) {
            terisi += jumlahTiket;
            System.out.println("Berhasil memesan " + jumlahTiket + " tiket untuk " + namaKereta + ".");
        } else {
            System.out.println("Maaf, hanya tersisa " + (kapasitas - terisi) + " tiket untuk " + namaKereta + ".");
        }
    }

    public String getNamaKereta() {
        return namaKereta;
    }
}

class SistemKereta {
    private ArrayList<Kereta> keretaList;

    public SistemKereta() {
        keretaList = new ArrayList<>();
    }

    public void tambahKereta(Kereta kereta) {
        keretaList.add(kereta);
    }

    public void tampilkanJadwal() {
        System.out.println("Jadwal Kereta:");
        for (Kereta kereta : keretaList) {
            kereta.tampilkanInfo();
        }
    }

    public void pesanTiketKereta(String namaKereta, int jumlahTiket) {
        boolean ditemukan = false;
        for (Kereta kereta : keretaList) {
            if (kereta.getNamaKereta().equalsIgnoreCase(namaKereta)) {
                kereta.pesanTiket(jumlahTiket);
                ditemukan = true;
                break;
            }
        }
        if (!ditemukan) {
            System.out.println("Kereta dengan nama " + namaKereta + " tidak ditemukan.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SistemKereta sistemKereta = new SistemKereta();

        // Menambahkan beberapa kereta ke sistem
        Kereta kereta1 = new Kereta("Ekspres Jakarta", "Bandung", "10:00", 100);
        Kereta kereta2 = new Kereta("Argo Bromo", "Surabaya", "15:00", 150);
        Kereta kereta3 = new Kereta("Kelas Ekonomi", "Yogyakarta", "12:00", 200);

        sistemKereta.tambahKereta(kereta1);
        sistemKereta.tambahKereta(kereta2);
        sistemKereta.tambahKereta(kereta3);

        int pilihan;
        String namaKereta;
        int jumlahTiket;

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Tampilkan Jadwal Kereta");
            System.out.println("2. Pesan Tiket Kereta");
            System.out.println("3. Keluar");

            System.out.print("Pilih menu (1/2/3): ");
            pilihan = scanner.nextInt();

            if (pilihan == 1) {
                sistemKereta.tampilkanJadwal();
            } else if (pilihan == 2) {
                System.out.print("Masukkan nama kereta yang ingin dipesan: ");
                scanner.nextLine(); // Membersihkan newline
                namaKereta = scanner.nextLine();
                System.out.print("Masukkan jumlah tiket yang ingin dipesan: ");
                jumlahTiket = scanner.nextInt();
                sistemKereta.pesanTiketKereta(namaKereta, jumlahTiket);
            } else if (pilihan == 3) {
                System.out.println("Terima kasih telah menggunakan sistem kereta.");
                break;
            } else {
                System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }

        scanner.close();
    }
}