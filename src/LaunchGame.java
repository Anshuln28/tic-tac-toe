import java.util.Scanner;

public class LaunchGame {
    public static void main(String[] args) {
        TicTacToe T = new TicTacToe();
        Scanner sc = new Scanner(System.in);

        // Game setup
        Player[] players = setupGame(sc);
        if (players == null) { // Exit if setup fails
            System.out.println("Game setup failed. Exiting.");
            return;
        }

        // Play game
        playGame(T, players[0], players[1]);
        sc.close();
    }

    static Player[] setupGame(Scanner sc) {
        try {
            System.out.println("1. Play with friend\n2. Play with AI\nWhat do you want?");
            int val = sc.nextInt(); // Read the game mode
    
            Player p1, p2;
    
            if (val == 1) {
                // Friend vs Friend
                System.out.println("Enter first player name:");
                String name1 = sc.next();
                p1 = new HumanPlayer(name1, 'X', sc);
    
                System.out.println("Enter second player name:");
                String name2 = sc.next();
                p2 = new HumanPlayer(name2, 'O', sc);
            } else if (val == 2) {
                // Human vs AI
                System.out.println("Enter your name:");
                String humanName = sc.next();
                p1 = new HumanPlayer(humanName, 'X', sc);
    
                System.out.println("Enter AI name:");
                String aiName = sc.next();
                p2 = new AIPlayer(aiName, 'O');
            } else {
                System.out.println("Invalid option. Please restart the game.");
                return null; // Return null if invalid option
            }
    
            return new Player[] { p1, p2 }; // Return the player array
    
        } catch (Exception e) {
            System.out.println("Invalid input encountered. Exiting game setup.");
            sc.nextLine(); // Clear the scanner buffer in case of invalid input
            return null; // Return null to indicate an error occurred
        }
    }
    

    static void playGame(TicTacToe T, Player p1, Player p2) {
        int pA = 1;
        Scanner playAgain = new Scanner(System.in); // Create a Scanner once and reuse it
    
        do {
            Player currentPlayer = p1; // Start with Player 1
            T.initBoard(); // Reinitialize the board for a new game
            System.out.println("Starting a new game!");
    
            while (true) {
                System.out.println(currentPlayer.name + "'s turn:");
                currentPlayer.makeMove();
                T.displayBoard();
    
                if (T.checkWin()) {
                    System.out.println(currentPlayer.name + " has won!");
                    break;
                } else if (TicTacToe.checkDraw()) {
                    System.out.println("It's a draw!");
                    break;
                }
    
                // Switch players
                currentPlayer = (currentPlayer == p1) ? p2 : p1;
            }
    
            // Ask if the user wants to play again
            System.out.println("Do you want to play again? Press 0 to exit or any other number to continue:");
            try {
                pA = playAgain.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid input.exiting...");
                try {
                    Thread.sleep(3000); // Pause for 5 seconds
                } catch (InterruptedException ie) {
                    System.out.println("An unexpected interruption occurred during the wait.");
                }
                pA = 0; // Exit on invalid input
                playAgain.nextLine(); // Clear the scanner buffer
            }
        } while (pA != 0);
    
        System.out.println("Thank you for playing!");
        playAgain.close();
    }
    
}
