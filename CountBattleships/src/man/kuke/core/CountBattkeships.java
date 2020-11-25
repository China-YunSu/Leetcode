package man.kuke.core;

public class CountBattkeships {
        public int countBattleships(char[][] board) {
            int count = 0;

            for (int row = 0; row < board.length; row++) {
                for (int col = 0; col < board[row].length; col++) {
                  if (board[row][col] == 'X') {
                      if((row == 0 || board[row - 1][col] == '.')
                            && (col == 0 || board[row][col - 1] == '.')) {
                          ++count;
                      }
                  }
                }
            }

            return count;
        }


    public static void main(String[] args) {

    }

}
