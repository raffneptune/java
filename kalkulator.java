import java.util.Scanner;

public class Kalkulator {

    // Fungsi untuk penjumlahan
    public static double tambah(double x, double y) {
        return x + y;
    }

    // Fungsi untuk pengurangan
    public static double kurang(double x, double y) {
        return x - y;
    }

    // Fungsi untuk perkalian
    public static double kali(double x, double y) {
        return x * y;
    }

    // Fungsi untuk pembagian
    public static double bagi(double x, double y) {
        if (y != 0) {
            return x / y;
        } else {
            System.out.println("Tidak bisa membagi dengan nol");
            return Double.NaN; // Mengembalikan nilai NaN (Not a Number) jika pembagian dengan nol
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Menampilkan menu operasi
        System.out.println("Pilih operasi:");
        System.out.println("1. Tambah");
        System.out.println("2. Kurang");
        System.out.println("3. Kali");
        System.out.println("4. Bagi");

        // Meminta input pilihan operasi
        System.out.print("Masukkan pilihan (1/2/3/4): ");
        int pilihan = scanner.nextInt();
        
        // Meminta input angka
        System.out.print("Masukkan angka pertama: ");
        double num1 = scanner.nextDouble();
        
        System.out.print("Masukkan angka kedua: ");
        double num2 = scanner.nextDouble();

        // Melakukan operasi sesuai dengan pilihan pengguna
        switch (pilihan) {
            case 1:
                System.out.println(num1 + " + " + num2 + " = " + tambah(num1, num2));
                break;
            case 2:
                System.out.println(num1 + " - " + num2 + " = " + kurang(num1, num2));
                break;
            case 3:
                System.out.println(num1 + " * " + num2 + " = " + kali(num1, num2));
                break;
            case 4:
                double hasilBagi = bagi(num1, num2);
                if (!Double.isNaN(hasilBagi)) {
                    System.out.println(num1 + " / " + num2 + " = " + hasilBagi);
                }
                break;
            default:
                System.out.println("Pilihan tidak valid!");
                break;
        }
        
        scanner.close();
    }
}