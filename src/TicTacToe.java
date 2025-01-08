import java.util.Arrays;

public class TicTacToe {
    static char[][] board;

    public TicTacToe(){
        board = new char[3][3];
        initBoard();
    }

    void initBoard(){
        for (char[] chars : board) {
            Arrays.fill(chars, ' ');
        }
    }

    void displayBoard() {
        System.out.println("_____________");
        for (char[] chars : board) {
            System.out.print("| ");
            for (char aChar : chars) {
                System.out.print(aChar + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }
    static void placeMark(int row, int column, char mark){

        if(row >=1 && row <= 3 && column>=1 && column <= 3){
            board[row-1][column-1] = mark;
        }
        else{
            System.out.println("Invalid position");
        }
    }
     boolean checkColWin(){
        for(int j = 0; j< 3; j++){
            if( board[0][j] != ' '  && board[0][j]== board[1][j] && board[1][j] == board[2][j] ){
                 return true;
            }
        }
        return false;
     }
    boolean checkRowWin(){
        for(int i = 0; i<3; i++){
            if(board[i][0] != ' ' && board[i][0]== board[i][1] && board[i][1] == board[i][2] ){
                return true;
            }
        }
        return false;
    }
    boolean checkDiagonalWin(){
        return (board[1][1] != ' ' && board[0][0] == board[1][1] && board[1][1] == board[2][2]) || (board[1][1] != ' ' && board[0][2] == board[1][1] && board[1][1] == board[2][0]);
    }
    static boolean checkDraw(){
        for(int i = 0 ; i<= 2; i++){
            for(int j = 0; j<=2 ; j++){
                if(board[i][j] == ' ')
                    return false;
            }
        }
        return true;
    }

    boolean checkWin(){
        return checkDiagonalWin() || checkRowWin() || checkColWin();
    }
}
