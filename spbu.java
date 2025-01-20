import java.util.Scanner;

public class SPBU {

    // Menampilkan menu pilihan bahan bakar
    public static void displayMenu() {
        System.out.println("Selamat datang di SPBU!");
        System.out.println("Pilih jenis bahan bakar:");
        System.out.println("1. Premium (Rp 10.000 per liter)");
        System.out.println("2. Pertalite (Rp 12.000 per liter)");
        System.out.println("3. Pertamax (Rp 15.000 per liter)");
    }

    // Menghitung total harga berdasarkan jenis bahan bakar dan jumlah liter
    public static double calculateTotalPrice(int fuelType, double liters) {
        double pricePerLiter = 0;

        if (fuelType == 1) {
            pricePerLiter = 10000;  // Harga Premium
        } else if (fuelType == 2) {
            pricePerLiter = 12000;  // Harga Pertalite
        } else if (fuelType == 3) {
            pricePerLiter = 15000;  // Harga Pertamax
        }

        return pricePerLiter * liters;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Menampilkan menu dan meminta input jenis bahan bakar
        displayMenu();
        System.out.print("Masukkan pilihan (1/2/3): ");
        int fuelType = scanner.nextInt();
        if (fuelType < 1 || fuelType > 3) {
            System.out.println("Pilihan tidak valid.");
            return;
        }

        // Meminta input jumlah liter
        System.out.print("Masukkan jumlah liter: ");
        double liters = scanner.nextDouble();
        if (liters <= 0) {
            System.out.println("Jumlah liter tidak valid.");
            return;
        }

        // Menghitung total harga
        double totalPrice = calculateTotalPrice(fuelType, liters);

        // Menampilkan struk pembayaran
        System.out.println("\n--- STRUK PEMBAYARAN ---");
        if (fuelType == 1) {
            System.out.println("Bahan Bakar: Premium");
        } else if (fuelType == 2) {
            System.out.println("Bahan Bakar: Pertalite");
        } else if (fuelType == 3) {
            System.out.println("Bahan Bakar: Pertamax");
        }
        System.out.printf("Jumlah Liter: %.2f liter\n", liters);
        System.out.printf("Total Pembayaran: Rp %.0f\n", totalPrice);
        System.out.println("-------------------------");
        System.out.println("Terima kasih telah menggunakan layanan kami!");
        
        // Menutup scanner
        scanner.close();
    }
}