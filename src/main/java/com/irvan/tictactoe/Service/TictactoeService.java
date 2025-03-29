package com.irvan.tictactoe.Service;

import java.util.Arrays;

import org.springframework.stereotype.Service;

@Service
public class TictactoeService {
    private char[][] board;
    private char currentPlayer = 'X';
    private int boardSize = 3;

    public String gameStart(int size) {
        if (size < 3) {
            return "minimum board size is 3x3";
        }
        boardSize = size;
        initializeBoard();
        return "game starts with board size " + size + " by " + size;
    }

    private void initializeBoard() {
        board = new char[boardSize][boardSize];
        for (char[] row : board) {
            Arrays.fill(row, ' ');
        }
    }

    public String getBoard() {
        return Arrays.deepToString(board);
    }

    public String gameMove(int row, int col) {
        if (row < 0 || row >= boardSize || col < 0 || col >= boardSize || board[row][col] != ' ') {
            return "invalid move";
        }
        board[row][col] = currentPlayer;
        if (checkWinning(currentPlayer)) {
            return "player " + currentPlayer + " wins!";
        }
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        return "move accepted";
    }

    private boolean checkWinning(char Player) {
        for (int i = 0; i < boardSize; i++) {
            if (checkRow(i, Player) || checkCol(i, Player)) {
                return true;
            }
        }
        return checkDiagonal(Player);
    }

    private boolean checkRow(int row, char player) {
        for (int col = 0; col < boardSize; col++) {
            if (board[row][col] != player) {
                return false;
            }
        }
        return true;
    }

    private boolean checkCol(int col, char player) {
        for (int row = 0; row < boardSize; row++) {
            if (board[row][col] != player) {
                return false;
            }
        }
        return true;
    }

    private boolean checkDiagonal(char player) {
        boolean diagonal1 = true;
        boolean diagonal2 = true;
        for (int i = 0; i < boardSize; i++) {
            if (board[i][i] != player) {
                diagonal1 = false;
            }
            if (board[i][boardSize - 1 - i] != player) {
                diagonal2 = false;
            }
        }
        return diagonal1 || diagonal2;
    }

}
