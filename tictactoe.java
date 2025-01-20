import java.util.Scanner;

public class TicTacToe {

    // Fungsi untuk menampilkan papan permainan
    public static void printBoard(char[] board) {
        System.out.println();
        for (int i = 0; i < 3; i++) {
            System.out.print(" " + board[i * 3] + " | " + board[i * 3 + 1] + " | " + board[i * 3 + 2] + " ");
            System.out.println();
            if (i < 2) {
                System.out.println("---|---|---");
            }
        }
        System.out.println();
    }

    // Fungsi untuk mengecek apakah pemain menang
    public static boolean checkWin(char[] board, char player) {
        int[][] winConditions = {
            {0, 1, 2}, {3, 4, 5}, {6, 7, 8},  // baris
            {0, 3, 6}, {1, 4, 7}, {2, 5, 8},  // kolom
            {0, 4, 8}, {2, 4, 6}              // diagonal
        };

        for (int[] condition : winConditions) {
            if (board[condition[0]] == player && board[condition[1]] == player && board[condition[2]] == player) {
                return true;
            }
        }
        return false;
    }

    // Fungsi untuk mengecek apakah papan penuh
    public static boolean isBoardFull(char[] board) {
        for (char space : board) {
            if (space == ' ') {
                return false;
            }
        }
        return true;
    }

    // Fungsi utama permainan
    public static void playGame() {
        char[] board = new char[9];  // papan Tic Tac Toe kosong
        for (int i = 0; i < 9; i++) {
            board[i] = ' ';
        }

        char currentPlayer = 'X';
        Scanner scanner = new Scanner(System.in);

        while (true) {
            printBoard(board);

            // Meminta pemain untuk memilih posisi
            System.out.print("Player " + currentPlayer + ", pilih posisi (1-9): ");
            int move = scanner.nextInt();

            if (move < 1 || move > 9 || board[move - 1] != ' ') {
                System.out.println("Posisi tidak valid atau sudah terisi, coba lagi.");
                continue;
            }

            // Menandai posisi dengan simbol pemain saat ini
            board[move - 1] = currentPlayer;

            // Mengecek apakah pemain menang
            if (checkWin(board, currentPlayer)) {
                printBoard(board);
                System.out.println("Selamat! Pemain " + currentPlayer + " menang!");
                break;
            }

            // Mengecek apakah papan penuh (seri)
            if (isBoardFull(board)) {
                printBoard(board);
                System.out.println("Permainan berakhir dengan seri!");
                break;
            }

            // Ganti giliran pemain
            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        }
    }

    // Fungsi utama
    public static void main(String[] args) {
        playGame();
    }
}