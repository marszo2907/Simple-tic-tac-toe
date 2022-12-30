package TicTacToe;

import java.util.Scanner;

public class TicTacToeController {
    public TicTacToeController() {
        _model = new TicTacToeModel();
    }

    public void printGameGrid() {
        TicTacToeView.getInstance().printGameGrid(_model);
    }
    public void processUserInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print(_model.getCurrentPlayer() + "'s turn: ");

        try {
            int x = Integer.parseInt(scanner.next());
            int y = Integer.parseInt(scanner.next());

            _model.setField(x, y);
        } catch (NumberFormatException err) {
            System.err.println(err.getMessage());
        } catch (ArrayIndexOutOfBoundsException err) {
            System.err.println(err.getMessage());
        } catch (IllegalArgumentException err) {
            System.err.println("Field is already taken");
        }
    }
    public boolean isGameOver() {
        if (GameStatus.IN_PROGRESS == _model.getGameStatus()) {
            return false;
        }

        return true;
    }
    public void printResult() {
        switch(_model.getGameStatus()) {
            case DRAW:
                System.out.println("Draw!");
                break;
            case X_WINS:
                System.out.println("X wins!");
                break;
            case O_WINS:
                System.out.println("O wins!");
                break;
        }
    }
    private TicTacToeModel _model;
}