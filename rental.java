import java.util.Scanner;

class RentalItem {
    String name;
    int ratePerHour;

    public RentalItem(String name, int ratePerHour) {
        this.name = name;
        this.ratePerHour = ratePerHour;
    }

    public int calculateCost(int hours) {
        return ratePerHour * hours;
    }
}

class RentalSystem {
    RentalItem[] items;

    public RentalSystem() {
        items = new RentalItem[] {
            new RentalItem("Sepeda", 5000),
            new RentalItem("Skuter", 10000),
            new RentalItem("Mobil", 50000)
        };
    }

    public void displayItems() {
        System.out.println("Barang yang tersedia untuk disewa:");
        for (int i = 0; i < items.length; i++) {
            System.out.println((i + 1) + ". " + items[i].name + " - Rp" + items[i].ratePerHour + " per jam");
        }
    }

    public void rentItem() {
        displayItems();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Pilih barang yang ingin disewa (1/2/3): ");
        int choice = scanner.nextInt();

        if (choice < 1 || choice > items.length) {
            System.out.println("Pilihan tidak valid!");
            return;
        }

        System.out.print("Berapa jam Anda ingin menyewa " + items[choice - 1].name + "? ");
        int hours = scanner.nextInt();

        int totalCost = items[choice - 1].calculateCost(hours);
        System.out.println("Total biaya untuk menyewa " + items[choice - 1].name + " selama " + hours + " jam adalah: Rp" + totalCost);
    }
}

public class Main {
    public static void main(String[] args) {
        RentalSystem rentalSystem = new RentalSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nSelamat datang di sistem rental!");
            System.out.println("1. Sewa barang");
            System.out.println("2. Keluar");
            System.out.print("Pilih menu: ");
            String choice = scanner.nextLine();

            if (choice.equals("1")) {
                rentalSystem.rentItem();
            } else if (choice.equals("2")) {
                System.out.println("Terima kasih telah menggunakan sistem rental!");
                break;
            } else {
                System.out.println("Pilihan tidak valid, coba lagi.");
            }
        }
    }
}