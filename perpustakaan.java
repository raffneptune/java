import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Buku {
    private String judul;
    private String penulis;
    private int tahunTerbit;

    public Buku(String judul, String penulis, int tahunTerbit) {
        this.judul = judul;
        this.penulis = penulis;
        this.tahunTerbit = tahunTerbit;
    }

    public String getJudul() {
        return judul;
    }

    public String getPenulis() {
        return penulis;
    }

    public int getTahunTerbit() {
        return tahunTerbit;
    }

    @Override
    public String toString() {
        return "Judul: " + judul + ", Penulis: " + penulis + ", Tahun Terbit: " + tahunTerbit;
    }
}

class Perpustakaan {
    private List<Buku> daftarBuku = new ArrayList<>();

    public void tambahBuku(Buku buku) {
        daftarBuku.add(buku);
        System.out.println("Buku '" + buku.getJudul() + "' berhasil ditambahkan.");
    }

    public void hapusBuku(String judul) {
        Buku bukuUntukDihapus = null;
        for (Buku buku : daftarBuku) {
            if (buku.getJudul().equalsIgnoreCase(judul)) {
                bukuUntukDihapus = buku;
                break;
            }
        }

        if (bukuUntukDihapus != null) {
            daftarBuku.remove(bukuUntukDihapus);
            System.out.println("Buku '" + judul + "' berhasil dihapus.");
        } else {
            System.out.println("Buku '" + judul + "' tidak ditemukan.");
        }
    }

    public void tampilkanBuku() {
        if (daftarBuku.isEmpty()) {
            System.out.println("Tidak ada buku di perpustakaan.");
        } else {
            System.out.println("Daftar Buku Perpustakaan:");
            for (Buku buku : daftarBuku) {
                System.out.println(buku);
            }
        }
    }
}

public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Perpustakaan perpustakaan = new Perpustakaan();

        while (true) {
            System.out.println("\nMenu Perpustakaan:");
            System.out.println("1. Tambah Buku");
            System.out.println("2. Hapus Buku");
            System.out.println("3. Tampilkan Daftar Buku");
            System.out.println("4. Keluar");
            System.out.print("Pilih menu (1/2/3/4): ");
            int pilihan = scanner.nextInt();
            scanner.nextLine();  // Membersihkan newline yang tertinggal setelah nextInt()

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan judul buku: ");
                    String judulTambah = scanner.nextLine();

                    System.out.print("Masukkan penulis buku: ");
                    String penulisTambah = scanner.nextLine();

                    System.out.print("Masukkan tahun terbit buku: ");
                    int tahunTerbitTambah = scanner.nextInt();
                    scanner.nextLine();  // Membersihkan newline yang tertinggal setelah nextInt()

                    Buku bukuBaru = new Buku(judulTambah, penulisTambah, tahunTerbitTambah);
                    perpustakaan.tambahBuku(bukuBaru);
                    break;

                case 2:
                    System.out.print("Masukkan judul buku yang akan dihapus: ");
                    String judulHapus = scanner.nextLine();
                    perpustakaan.hapusBuku(judulHapus);
                    break;

                case 3:
                    perpustakaan.tampilkanBuku();
                    break;

                case 4:
                    System.out.println("Terima kasih! Keluar dari program.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Pilihan tidak valid, coba lagi.");
                    break;
            }
        }
    }
}