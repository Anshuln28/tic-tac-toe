import java.util.Random;

public class AIPlayer extends Player{
    public AIPlayer(String name, char mark){
        this.name = name;
        this.mark = mark;
    }
    void makeMove(){
        if (TicTacToe.checkDraw()) {
            System.out.println("Board is full! AI cannot move.");
            return;
        }
        int row, col;
        do{
            Random r = new Random();
            row = r.nextInt(3)+1;
            col = r.nextInt(3)+1;
        }
        while(isValidMove(row, col));
        TicTacToe.placeMark(row, col, mark);
    }
}
