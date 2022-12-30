import TicTacToe.*;

public class TicTacToeDemo {
    public static void main(String[] args) {
        TicTacToeController ticTacToeController = new TicTacToeController();

        while(!ticTacToeController.isGameOver()) {
            ticTacToeController.printGameGrid();
            ticTacToeController.processUserInput();
        }

        ticTacToeController.printResult();
    }
}
