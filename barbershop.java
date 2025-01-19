import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Barbershop {
    private Queue<String> antrian;  // Antrian pelanggan
    private boolean buka;  // Status barbershop

    // Konstruktor untuk menginisialisasi Barbershop
    public Barbershop() {
        antrian = new LinkedList<>();
        buka = true;
    }

    // Fungsi untuk membuka Barbershop
    public void bukaBarbershop() {
        System.out.println("Barbershop sedang buka, silakan masuk!");
    }

    // Fungsi untuk menutup Barbershop
    public void tutupBarbershop() {
        buka = false;
        System.out.println("Barbershop sudah tutup. Terima kasih sudah datang!");
    }

    // Fungsi untuk menambah pelanggan ke dalam antrian
    public void tambahPelanggan(String nama) {
        if (buka) {
            antrian.add(nama);
            System.out.println(nama + " telah masuk ke antrian.");
        } else {
            System.out.println("Barbershop sudah tutup. Anda tidak bisa mendaftar.");
        }
    }

    // Fungsi untuk memproses pelanggan
    public void prosesPelanggan() {
        if (!antrian.isEmpty()) {
            String pelanggan = antrian.poll();  // Mengambil pelanggan pertama dalam antrian
            System.out.println("Sedang melayani " + pelanggan + "...");
            try {
                Thread.sleep(2000);  // Simulasi pemotongan rambut selama 2 detik
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(pelanggan + " telah selesai dilayani.");
        } else {
            System.out.println("Tidak ada pelanggan di antrian.");
        }
    }

    // Fungsi untuk menampilkan antrian
    public void tampilkanAntrian() {
        if (!antrian.isEmpty()) {
            System.out.println("Antrian pelanggan:");
            int no = 1;
            for (String pelanggan : antrian) {
                System.out.println(no++ + ". " + pelanggan);
            }
        } else {
            System.out.println("Tidak ada pelanggan di antrian.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Barbershop barbershop = new Barbershop();
        barbershop.bukaBarbershop();

        while (true) {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Tambah Pelanggan");
            System.out.println("2. Proses Pelanggan");
            System.out.println("3. Lihat Antrian");
            System.out.println("4. Tutup Barbershop");
            System.out.println("5. Keluar");

            System.out.print("Pilih menu (1-5): ");
            int pilihan = scanner.nextInt();
            scanner.nextLine();  // Membersihkan newline setelah nextInt()

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan nama pelanggan: ");
                    String nama = scanner.nextLine();
                    barbershop.tambahPelanggan(nama);
                    break;
                case 2:
                    barbershop.prosesPelanggan();
                    break;
                case 3:
                    barbershop.tampilkanAntrian();
                    break;
                case 4:
                    barbershop.tutupBarbershop();
                    return;
                case 5:
                    System.out.println("Terima kasih telah menggunakan program ini!");
                    return;
                default:
                    System.out.println("Pilihan tidak valid, coba lagi.");
            }
        }
    }
}