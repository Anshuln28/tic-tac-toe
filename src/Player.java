public abstract class Player {
    String name;
    char mark;
    boolean isValidMove(int row, int col){
        if(row >=1 && row <=3 && col >=1 && col <=3){
            return TicTacToe.board[row - 1][col - 1] != ' ';
        }
        return true;
    }
    abstract void makeMove();
}
