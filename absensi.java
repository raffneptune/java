import java.util.Scanner;

public class Absensi {

    // Daftar nama siswa/pegawai
    static String[] daftarNama = {"Ali", "Budi", "Citra", "Dewi", "Eka"};
    
    // Menyimpan status absensi
    static String[] absensi = new String[daftarNama.length];
    
    // Fungsi untuk mencatat absensi
    public static void catatAbsensi() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Daftar Nama:");
        for (int i = 0; i < daftarNama.length; i++) {
            System.out.println((i + 1) + ". " + daftarNama[i]);
        }
        
        // Mencatat absensi untuk setiap nama
        for (int i = 0; i < daftarNama.length; i++) {
            System.out.print("Apakah " + daftarNama[i] + " hadir? (y/n): ");
            String status = scanner.nextLine().trim().toLowerCase();
            
            if (status.equals("y")) {
                absensi[i] = "Hadir";
            } else if (status.equals("n")) {
                absensi[i] = "Tidak Hadir";
            } else {
                absensi[i] = "Status Tidak Valid";
            }
        }

        // Menampilkan hasil absensi
        System.out.println("\nAbsensi Hari Ini:");
        for (int i = 0; i < daftarNama.length; i++) {
            System.out.println(daftarNama[i] + ": " + absensi[i]);
        }
        
        scanner.close();
    }

    public static void main(String[] args) {
        // Menjalankan fungsi untuk mencatat absensi
        catatAbsensi();
    }
}