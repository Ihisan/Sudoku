/*
//Loopa igenom alla rader och kolumner
            //  Kolla om det är en nolla på aktuell pos
            //      Loopa igenom alla värden från 1 till 9
            //          Kolla om man kan placera aktuellt värd på aktuell position
            //              Om ja, placera aktuellt värde
            //                  anropa solve
            //                      Ta bort aktuellt värde
            //      Gör return
            // Skriv ut lösning
 */
public class Main {
    private int [][] board;
    static int size = 9;
    static int empty = 0;

        private static boolean possible(int[][] board, int x, int y, int value){
            //kontrollera rad och kolumn
            for(int i = 0; i < size; i++){
                if(board[y][i] == value || board[i][x] == value){
                    return true;
                }
            }
            //kontrollera rutan
            return false;

        }

        private boolean isInBox(int [][] board,int x, int y, int value) {
            int x0 = x / 3 * 3;
            int y0 = y / 3 * 3;

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board[y0 + i][x0 + j] == value) {
                        return true;
                    }
                }
            }return false;
        }

        private boolean isOk(int x, int y, int value){
            return !possible (x,y,value) && possible (x,value) && possible (x,y,value);
        }

        private void solve(int[][] board){
            this.board = new int[size][size];
            for (int i = 0; i < size; i++){
                for (int j = 0; j < size; j++){
                    this.board[i][j] = board[i][j];

                }
            }
            solve (board);

        }



        public static void main(String[] args) {
            int [][] board = {{0, 0, 0, 8, 0, 4, 9, 3, 7},
                    {0, 7, 4, 1, 0, 0, 0, 8, 0},
                    {8, 3, 2, 0, 0, 0, 4, 0, 0},
                    {2, 0, 5, 3, 0, 0, 7, 4, 0},
                    {0, 0, 0, 0, 0, 0, 0, 1, 6},
                    {1, 4, 3, 0, 0, 0, 2, 0, 0},
                    {0, 0, 7, 0, 9, 0, 6, 0, 0},
                    {0, 2, 1, 7, 5, 6, 8, 9, 0},
                    {6, 5, 9, 2, 3, 0, 0, 7, 4}};
            System.out.println(possible(board, 4, 4, 2));
            System.out.println(possible(board, 4, 4, 1));
            System.out.println(possible(board, 5, 6, 3));
            System.out.println(possible(board, 0, 0, 5));
        }
    }
