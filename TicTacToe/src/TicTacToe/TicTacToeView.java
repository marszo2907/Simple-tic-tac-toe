package TicTacToe;

public class TicTacToeView {
    public static TicTacToeView getInstance() {
        if (null == _object) {
            _object = new TicTacToeView();
        }

        return _object;
    }

    public void printGameGrid(TicTacToeModel gameModel) {
        final int ROW_AND_COL_COUNT = 3;

        StringBuilder gameGrid = new StringBuilder();

        for (int i = 0; ROW_AND_COL_COUNT > i; ++i) {
            for (int j = 0; ROW_AND_COL_COUNT > j; ++j) {
                try {
                    char tempField = gameModel.getField(i, j);
                    gameGrid.append("[ %c ] ".formatted(tempField));
                } catch (ArrayIndexOutOfBoundsException err) {
                    System.err.println(err.getMessage());
                    gameGrid.append("[ E ] ");
                }
            }

            gameGrid.append('\n');
        }

        System.out.print(gameGrid);
    }

    private static TicTacToeView _object;

    private TicTacToeView() {}
}
