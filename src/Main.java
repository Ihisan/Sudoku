/*
Med utgångspunkt i den länkade koden, skriv ett program som löser Sudoku

Ni kommer själva behöva implementera:
Backtracking
Kod för att hitta nästa lediga position
Kod för att skriva ut brädet

 */
public class Main {
    static int size = 9;
    static int empty = 0;

    private static boolean possible(int[][] board, int x, int y, int value) {
        //kontrollera rad och kolumn
        for (int i = 0; i < size; i++) {
            if (board[y][i] == value || board[i][x] == value) {
                return false;
            }
        }
        //kontrollera rutan
        int x0 = x / 3 * 3;
        int y0 = y / 3 * 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[y0 + i][x0 + j] == value) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean solve(int[][] board) {
        int x;
        int y;
        //Loopa igenom alla rader och kolumner
        for (x = 0; x < size; x++) {
            for (y = 0; y < size; y++) {
                //  Kolla om det är en nolla på aktuell pos
                if (board[y][x] == empty) {
                    //  Loopa igenom alla värden från 1 till 9
                    for (int number = 1; number <= size; number++) {
                        // Kolla om man kan placera aktuellt värd på aktuell position
                        if (possible (board, x, y, number)) {
                            board[y][x] = number;
                            // Om ja, placera aktuellt värde
                            //anropa solve
                            if (solve (board)) {
                                return true;
                                // Ta bort aktuellt värde
                            } else {
                                board[y][x] = empty;
                            }
                        }
                    }
                    //   Gör return
                    return false;
                }
            }
        }
        // Skriv ut lösning
        return true;
    }

    public static void printSudoku(int[][] board) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print (board[i][j] + " ");
            }

            System.out.println ();

        }
    }


    public static void main(String[] args) {
        int[][] board = {{0, 0, 0, 8, 0, 4, 9, 3, 7},
                {0, 7, 4, 1, 0, 0, 0, 8, 0},
                {8, 3, 2, 0, 0, 0, 4, 0, 0},
                {2, 0, 5, 3, 0, 0, 7, 4, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 6},
                {1, 4, 3, 0, 0, 0, 2, 0, 0},
                {0, 0, 7, 0, 9, 0, 6, 0, 0},
                {0, 2, 1, 7, 5, 6, 8, 9, 0},
                {6, 5, 9, 2, 3, 0, 0, 7, 4}};
        System.out.println("Sudoku the board");
        printSudoku (board);

        if (solve(board)) {
            System.out.println("\nSudoku board solved with backtracking");
            printSudoku (board);
        } else {
            System.out.println("Can't solve");
        }
    }
}