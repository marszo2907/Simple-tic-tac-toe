package TicTacToe;

public class TicTacToeView {
    public static TicTacToeView getInstance() {
        if (null == _object) {
            _object = new TicTacToeView();
        }

        return _object;
    }

    public void printGameGrid(TicTacToeModel gameGrid) {
        // TODO
    }

    private static TicTacToeView _object;

    private TicTacToeView() {}
}
