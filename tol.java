import java.util.ArrayList;
import java.util.List;

class Kendaraan {
    private String nama;
    private String golongan;

    public Kendaraan(String nama, String golongan) {
        this.nama = nama;
        this.golongan = golongan;
    }

    public String getNama() {
        return nama;
    }

    public String getGolongan() {
        return golongan;
    }
}

class GerbangTol {
    private List<Kendaraan> antrian;

    public GerbangTol() {
        this.antrian = new ArrayList<>();
    }

    // Menambah kendaraan ke antrian
    public void tambahAntrian(String nama, String golongan) {
        antrian.add(new Kendaraan(nama, golongan));
        System.out.println(nama + " ditambahkan ke antrian.");
    }

    // Memproses kendaraan pertama dalam antrian
    public void prosesKendaraan() {
        if (!antrian.isEmpty()) {
            System.out.println(antrian.get(0).getNama() + " sedang diproses.");
            antrian.remove(0); // Hapus kendaraan pertama
        } else {
            System.out.println("Antrian kosong, tidak ada kendaraan yang diproses.");
        }
    }

    // Menampilkan antrian kendaraan
    public void tampilkanAntrian() {
        if (!antrian.isEmpty()) {
            System.out.println("Antrian kendaraan saat ini:");
            for (Kendaraan kendaraan : antrian) {
                System.out.println(kendaraan.getNama() + " - " + kendaraan.getGolongan());
            }
        } else {
            System.out.println("Antrian kosong.");
        }
    }
}

class SistemTol {
    private int tarifGolongan1;
    private int tarifGolongan2;
    private int tarifGolongan3;

    public SistemTol() {
        this.tarifGolongan1 = 5000;
        this.tarifGolongan2 = 10000;
        this.tarifGolongan3 = 15000;
    }

    // Menghitung biaya tol berdasarkan golongan dan jarak
    public void hitungBiaya(String golongan, int jarak) {
        int tarif = 0;

        switch (golongan) {
            case "golongan_1":
                tarif = tarifGolongan1;
                break;
            case "golongan_2":
                tarif = tarifGolongan2;
                break;
            case "golongan_3":
                tarif = tarifGolongan3;
                break;
            default:
                System.out.println("Golongan kendaraan tidak valid!");
                return;
        }

        int biaya = tarif * jarak;
        System.out.println("Biaya tol untuk " + golongan + " dengan jarak " + jarak + " km adalah: " + biaya + " IDR");
    }
}

public class Main {
    public static void main(String[] args) {
        GerbangTol gerbang = new GerbangTol();
        SistemTol sistem = new SistemTol();

        // Menambah kendaraan ke antrian
        gerbang.tambahAntrian("Mobil Kecil - Golongan 1", "golongan_1");
        gerbang.tambahAntrian("Truk Kecil - Golongan 2", "golongan_2");
        gerbang.tambahAntrian("Truk Besar - Golongan 3", "golongan_3");

        // Menampilkan antrian kendaraan
        gerbang.tampilkanAntrian();

        // Proses kendaraan pertama
        gerbang.prosesKendaraan();

        // Menghitung biaya tol untuk kendaraan pertama
        sistem.hitungBiaya("golongan_1", 10);  // Misalnya jarak 10 km
    }
}