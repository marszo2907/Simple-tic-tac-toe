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
        boolean isXWinner = false;
        boolean isOWinner = false;

        GameStatus acrossStatus = checkAcross();
        switch (acrossStatus) {
            case X_WINS:
                isXWinner = true;
                break;
            case O_WINS:
                isOWinner = true;
                break;
        }

        if (!isXWinner && !isOWinner) {
            GameStatus alongStatus = checkAlong();
            switch (alongStatus) {
                case X_WINS:
                    isXWinner = true;
                    break;
                case O_WINS:
                    isOWinner = true;
                    break;
            }

            if (!isXWinner && !isOWinner) {
                GameStatus diagonalStatus = checkDiagonally();
                switch (diagonalStatus) {
                    case X_WINS:
                        isXWinner = true;
                        break;
                    case O_WINS:
                        isOWinner = true;
                        break;
                }
            }
        }

        if (isXWinner) {
            return GameStatus.X_WINS;
        } else if (isOWinner) {
            return GameStatus.O_WINS;
        } else if (areEmptySpaces()) {
            return GameStatus.IN_PROGRESS;
        } else {
            return GameStatus.DRAW;
        }
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
        int xInRow = 0;
        int oInRow = 0;

        for (var row : _gameGrid) {
            for (var col : row) {
                switch (col) {
                    case 'X':
                        xInRow++;
                        break;
                    case 'O':
                        oInRow++;
                        break;
                }
            }

            if (3 == xInRow) {
                return GameStatus.X_WINS;
            } else if (3 == oInRow) {
                return GameStatus.O_WINS;
            }

            xInRow = 0;
            oInRow = 0;
        }

        return GameStatus.IN_PROGRESS;
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
    private boolean areEmptySpaces() {
        for (var row : _gameGrid) {
            for (var col : row) {
                if ('_' == col) {
                    return true;
                }
            }
        }

        return false;
    }

}