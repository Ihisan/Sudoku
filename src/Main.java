/*
Med utgångspunkt i den länkade koden, skriv ett program som löser Sudoku

Ni kommer själva behöva implementera:
Backtracking
Kod för att hitta nästa lediga position
Kod för att skriva ut brädet

Add info
 */
public class Main {

    private static int[][] board;
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
        int x0 = (int) Math.floor (x / 3) * 3;
        int y0 = (int) Math.floor (y / 3) * 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[y0 + i][x0 + j] == value) {
                    return false;
                }
            }
        }
        return true;
    }

        /*private static void solve(int[][] board){
            //Loopa igenom alla rader och kolumner
            //  Kolla om det är en nolla på aktuell pos
            //      Loopa igenom alla värden från 1 till 9
            //          Kolla om man kan placera aktuellt värd på aktuell position
            //              Om ja, placera aktuellt värde
            //                  anropa solve
            //                      Ta bort aktuellt värde
            //      Gör return
            // Skriv ut lösning
        }*/


    private static boolean solve(int[][] board) {
        //Loopa igenom alla rader och kolumner
        //  Kolla om det är en nolla på aktuell pos
        //      Loopa igenom alla värden från 1 till 9
        //          Kolla om man kan placera aktuellt värd på aktuell position
        //              Om ja, placera aktuellt värde
        //                  anropa solve
        //                      Ta bort aktuellt värde
        //      Gör return
        // Skriv ut lösning
        int x;
        int y;
        for (x = 0; x < size; x++) {
            for (y = 0; y < size; y++) {
                //search an empty cell
                if (board[y][x] == empty) {
                    //try possible numbers
                    for (int number = 1; number <= size; number++) {
                        if (!possible (board, x, y, number)) {
                            // number ok. it respects sudoku constraints
                            board[y][x] = number;
                            // we start backtracking recursively
                            if (solve (board)) {
                                return true;
                                // if not a solution, we empty the cell and we continue
                            } else {
                                board[y][x] = empty;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return false;
    }

    public void printsudoku(int[][] board) {
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
        System.out.println (possible (board, 4, 4, 2));
        System.out.println (possible (board, 4, 4, 1));
        System.out.println (possible (board, 5, 6, 3));
        System.out.println (possible (board, 0, 0, 5));

        Main sudoku = new Main ();
        System.out.println("Sudoku grid to solve");
        sudoku.printsudoku (board);

        // we try resolution
        if (solve(board)) {
            System.out.println("Sudoku Grid solved with simple BT");
            sudoku.printsudoku (board);
        } else {
            System.out.println("Unsolvable");
        }
    }
}