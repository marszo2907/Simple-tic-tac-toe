package TicTacToe;

public class TicTacToeModel {
    public TicTacToeModel() {
        _isXPlaying = true;
        _gameGrid = new char[][] {
                {'_', '_', '_'},
                {'_', '_', '_'},
                {'_', '_', '_'}
        };
    }

    public GameStatus getGameStatus() {
        GameStatus gameStatus = GameStatus.DRAW;
        // TODO
        return gameStatus;
    }
    public void setField(int x, int y) throws ArrayIndexOutOfBoundsException, IllegalArgumentException {
        // TODO
    }
    public char getField(int x, int y) throws ArrayIndexOutOfBoundsException {
        return _gameGrid[x][y];
    }

    private boolean _isXPlaying;
    private char[][] _gameGrid;

    private GameStatus checkAcross() {
        GameStatus gameStatus = GameStatus.DRAW;
        // TODO
        return gameStatus;
    }
    private GameStatus checkAlong() {
        GameStatus gameStatus = GameStatus.DRAW;
        // TODO
        return gameStatus;
    }
    private GameStatus checkDiagonally() {
        GameStatus gameStatus = GameStatus.DRAW;
        // TODO
        return gameStatus;
    }
}