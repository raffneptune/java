import java.util.Scanner;

class Vehicle {
    private String model;
    private int price;
    private int stock;

    public Vehicle(String model, int price, int stock) {
        this.model = model;
        this.price = price;
        this.stock = stock;
    }

    // Menampilkan informasi kendaraan
    public void displayInfo() {
        System.out.println("Model: " + model + ", Harga: Rp" + price + ", Stok: " + stock);
    }

    // Mengupdate stok setelah pembelian
    public void updateStock(int quantity) {
        stock -= quantity;
        if (stock < 0) {
            stock = 0;
        }
    }

    // Memeriksa ketersediaan stok
    public boolean isAvailable(int quantity) {
        return stock >= quantity;
    }

    public int getPrice() {
        return price;
    }

    public String getModel() {
        return model;
    }

    public int getStock() {
        return stock;
    }
}

class VehicleDealer {
    private Vehicle[] vehicles;
    private int vehicleCount;

    public VehicleDealer(int maxVehicles) {
        vehicles = new Vehicle[maxVehicles];
        vehicleCount = 0;
    }

    // Menambahkan kendaraan ke diler
    public void addVehicle(String model, int price, int stock) {
        if (vehicleCount < vehicles.length) {
            vehicles[vehicleCount] = new Vehicle(model, price, stock);
            vehicleCount++;
        } else {
            System.out.println("Diler sudah penuh, tidak bisa menambah kendaraan.");
        }
    }

    // Menampilkan semua kendaraan yang tersedia
    public void displayVehicles() {
        if (vehicleCount == 0) {
            System.out.println("Tidak ada kendaraan di diler.");
            return;
        }

        System.out.println("\nKendaraan yang Tersedia di Diler:");
        for (int i = 0; i < vehicleCount; i++) {
            System.out.print((i + 1) + ". ");
            vehicles[i].displayInfo();
        }
    }

    // Pembelian kendaraan
    public void purchaseVehicle() {
        displayVehicles();

        if (vehicleCount == 0) {
            return;
        }

        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("\nPilih kendaraan (masukkan nomor): ");
            int choice = scanner.nextInt();
            System.out.print("Berapa banyak yang ingin dibeli? ");
            int quantity = scanner.nextInt();

            if (choice < 1 || choice > vehicleCount) {
                System.out.println("Pilihan tidak valid.");
                return;
            }

            Vehicle selectedVehicle = vehicles[choice - 1];
            if (selectedVehicle.isAvailable(quantity)) {
                int totalPrice = selectedVehicle.getPrice() * quantity;
                System.out.println("\nPembelian Sukses! Total Harga: Rp" + totalPrice);
                selectedVehicle.updateStock(quantity);
            } else {
                System.out.println("\nStok tidak cukup.");
            }
        } catch (Exception e) {
            System.out.println("Input tidak valid.");
        }
    }
}

public class VehicleDealerApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        VehicleDealer dealer = new VehicleDealer(10); // Maksimal 10 kendaraan

        // Menambahkan beberapa kendaraan ke diler
        dealer.addVehicle("Mobil Sedan", 300000000, 10);
        dealer.addVehicle("Motor Sport", 100000000, 5);
        dealer.addVehicle("Mobil SUV", 500000000, 3);

        while (true) {
            System.out.println("\n--- Menu Diler Kendaraan ---");
            System.out.println("1. Lihat kendaraan yang tersedia");
            System.out.println("2. Pembelian kendaraan");
            System.out.println("3. Keluar");

            System.out.print("\nPilih menu: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    dealer.displayVehicles();
                    break;
                case 2:
                    dealer.purchaseVehicle();
                    break;
                case 3:
                    System.out.println("Terima kasih telah mengunjungi diler kami!");
                    return;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }
}