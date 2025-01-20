import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Blackjack {

    // Daftar kartu dalam deck
    private static final String[] deck = {
        "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", // Set pertama
        "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", // Set kedua
        "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", // Set ketiga
        "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"  // Set keempat
    };

    // Fungsi untuk menghitung nilai kartu
    public static int cardValue(String card) {
        switch (card) {
            case "J":
            case "Q":
            case "K":
                return 10;
            case "A":
                return 11; // Menganggap Ace = 11 untuk kesederhanaan
            default:
                return Integer.parseInt(card); // Kartu angka (2-10)
        }
    }

    // Fungsi untuk membagikan kartu secara acak
    public static String dealCard(ArrayList<String> deck) {
        Collections.shuffle(deck);
        return deck.remove(0); // Keluarkan kartu pertama dari deck
    }

    // Fungsi untuk menghitung total nilai kartu dalam hand
    public static int calculateHand(ArrayList<String> hand) {
        int total = 0;
        for (String card : hand) {
            total += cardValue(card);
        }
        return total;
    }

    // Fungsi utama untuk menjalankan permainan
    public static void startGame() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> deckCopy = new ArrayList<>();
        Collections.addAll(deckCopy, deck); // Salinan deck untuk permainan

        // Kartu untuk pemain dan dealer
        ArrayList<String> playerHand = new ArrayList<>();
        ArrayList<String> dealerHand = new ArrayList<>();

        // Membagikan dua kartu untuk pemain dan dealer
        playerHand.add(dealCard(deckCopy));
        playerHand.add(dealCard(deckCopy));
        dealerHand.add(dealCard(deckCopy));
        dealerHand.add(dealCard(deckCopy));

        // Menampilkan kartu awal pemain dan dealer (satu kartu dealer tersembunyi)
        System.out.println("Kartu Anda: " + playerHand + " dengan nilai " + calculateHand(playerHand));
        System.out.println("Kartu Dealer: " + dealerHand.get(0) + " dan kartu tersembunyi");

        // Giliran pemain
        while (calculateHand(playerHand) < 21) {
            System.out.print("Apakah Anda ingin 'Hit' atau 'Stand'? ");
            String action = scanner.nextLine().toLowerCase();

            if (action.equals("hit")) {
                playerHand.add(dealCard(deckCopy));
                System.out.println("Kartu Anda sekarang: " + playerHand + " dengan nilai " + calculateHand(playerHand));
            } else if (action.equals("stand")) {
                break;
            } else {
                System.out.println("Pilihan tidak valid. Pilih 'Hit' atau 'Stand'.");
            }
        }

        // Jika pemain melebihi 21
        if (calculateHand(playerHand) > 21) {
            System.out.println("Nilai kartu Anda melebihi 21! Anda kalah!");
            return;
        }

        // Giliran dealer (dealer akan 'hit' sampai total kartu >= 17)
        System.out.println("Kartu Dealer sekarang: " + dealerHand + " dengan nilai " + calculateHand(dealerHand));
        while (calculateHand(dealerHand) < 17) {
            System.out.println("Dealer memukul kartu...");
            dealerHand.add(dealCard(deckCopy));
            System.out.println("Kartu Dealer sekarang: " + dealerHand + " dengan nilai " + calculateHand(dealerHand));
        }

        // Menentukan pemenang
        int playerTotal = calculateHand(playerHand);
        int dealerTotal = calculateHand(dealerHand);

        if (dealerTotal > 21) {
            System.out.println("Dealer melebihi 21! Anda menang!");
        } else if (playerTotal > dealerTotal) {
            System.out.println("Anda menang!");
        } else if (playerTotal < dealerTotal) {
            System.out.println("Dealer menang!");
        } else {
            System.out.println("Hasil seri!");
        }

        scanner.close();
    }

    // Fungsi utama untuk menjalankan permainan
    public static void main(String[] args) {
        System.out.println("Selamat datang di permainan Dealer Kartu!");
        startGame();
    }
}