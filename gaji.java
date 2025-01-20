import java.util.Scanner;

public class GajiKaryawan {

    // Fungsi untuk menghitung gaji total
    public static double hitungGaji(double gajiPokok, double tunjangan, double potongan) {
        return gajiPokok + tunjangan - potongan;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Menampilkan judul program
        System.out.println("Program Perhitungan Gaji Karyawan");
        
        // Input data
        System.out.print("Masukkan gaji pokok: Rp ");
        double gajiPokok = scanner.nextDouble();
        
        System.out.print("Masukkan tunjangan: Rp ");
        double tunjangan = scanner.nextDouble();
        
        System.out.print("Masukkan potongan: Rp ");
        double potongan = scanner.nextDouble();
        
        // Menghitung gaji total
        double gajiTotal = hitungGaji(gajiPokok, tunjangan, potongan);
        
        // Menampilkan hasil perhitungan
        System.out.println("\nRingkasan Gaji:");
        System.out.println("Gaji Pokok: Rp " + gajiPokok);
        System.out.println("Tunjangan: Rp " + tunjangan);
        System.out.println("Potongan: Rp " + potongan);
        System.out.println("Gaji Total: Rp " + gajiTotal);
        
        scanner.close();
    }
}