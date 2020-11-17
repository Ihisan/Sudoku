public class Main {

    private static boolean possible(int[][] board, int x, int y, int value){
        //kontrollera rad och kolumn
        for(int i = 0; i < 9; i++){
            if(board[y][i] == value || board[i][x] == value){
                return false;
            }
        }
        //kontrollera rutan
        int x0 = (int)Math.floor(x/3) * 3;
        int y0 = (int)Math.floor(y/3) * 3;
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if (board[y0+i][x0+j] == value){
                    return false;
                }
            }
        }
        return true;
    }

    private static void solve(int[][] board){
        //Loopa igenom alla rader och kolumner
        //  Kolla om det är en nolla på aktuell pos
        //      Loopa igenom alla värden från 1 till 9
        //          Kolla om man kan placera aktuellt värd på aktuell position
        //              Om ja, placera aktuellt värde
        //                  anropa solve
        //                      Ta bort aktuellt värde
        //      Gör return
        // Skriv ut lösning
    }

    private static boolean solve(int[][] board, int x, int y, int value) {
        //Loopa igenom alla rader och kolumner
        //  Kolla om det är en nolla på aktuell pos
        //      Loopa igenom alla värden från 1 till 9
        //          Kolla om man kan placera aktuellt värd på aktuell position
        //              Om ja, placera aktuellt värde
        //                  anropa solve
        //                      Ta bort aktuellt värde
        //      Gör return
        // Skriv ut lösning


        for (int x = 0; x < value; x++) {
            for (int y = 0; y < value; y++) {
                //search an empty cell
                if (board[x][y] == 0) {
                    //try possible numbers
                    for (int number = 1; number <= value; number++) {
                        if (!possible (x, y, number)) {
                            // number ok. it respects sudoku constraints
                            board[x][y] = number;
                            // we start backtracking recursively
                            if (solve ()) {
                                return true;
                                // if not a solution, we empty the cell and we continue
                            } else {
                                board[x][y] = 0;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }

                public static void main (String[]args){
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
                }
            }
        }