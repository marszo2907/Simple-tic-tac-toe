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
        if ('_' != _gameGrid[x][y]) {
            throw new IllegalArgumentException();
        }

        if (_isXPlaying) {
            _gameGrid[x][y] = 'X';
        } else {
            _gameGrid[x][y] = 'O';
        }

        _isXPlaying = !_isXPlaying;
    }
    public char getField(int x, int y) throws ArrayIndexOutOfBoundsException {
        return _gameGrid[x][y];
    }
    public char getCurrentPlayer() {
        if (_isXPlaying) {
            return 'X';
        }

        return 'O';
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
        final int ROWS_AND_COLS_COUNT = 3;

        int xInRow = 0;
        int oInRow = 0;

        for (int j = 0; ROWS_AND_COLS_COUNT > j; ++j) {
            for (int i = 0; ROWS_AND_COLS_COUNT > i; ++i) {
                switch (_gameGrid[i][j]) {
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
    private GameStatus checkDiagonally() {
        final int ROWS_AND_COLS_COUNT = 3;

        int xInRow = 0;
        int oInRow = 0;

        for (int i = 0; ROWS_AND_COLS_COUNT > i; ++i) {
            switch (_gameGrid[i][i]) {
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

        for (int i = 0; ROWS_AND_COLS_COUNT > i; ++i) {
            switch (_gameGrid[i][2 - i]) {
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

        return GameStatus.IN_PROGRESS;
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