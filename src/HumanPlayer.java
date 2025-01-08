import java.util.Scanner;

public class HumanPlayer extends Player{
    private Scanner scan;
     public HumanPlayer(String name, char mark, Scanner scan){
        this.name = name;
        this.mark = mark;
        this.scan = scan;
    }

    void makeMove(){

        int row, col;
        do{
            System.out.println("Enter the row and col:");
            row  = scan.nextInt();
            col = scan.nextInt();
        }
        while(isValidMove(row, col));
        TicTacToe.placeMark(row, col, mark);

    }
}
