package TicTacToe;

public class TicTacToeController {
    public TicTacToeController() {
        _model = new TicTacToeModel();
    }

    public void printGameGrid() {
        TicTacToeView.getInstance().printGameGrid(_model);
    }
    public void processUserInput() {
        // TODO
    }
    public boolean isGameOver() {
        // TODO
        return false;
    }
    public void printResult() {
        // TODO
    }
    private TicTacToeModel _model;
}