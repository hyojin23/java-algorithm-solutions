package Recommended_Problems.DFS_BFS.BOJ2580;

import java.util.Scanner;

public class Main {

    static int[][] board;
    static boolean solved= false;

    public boolean valid(int row, int col, int value) {

        for (int i = 0; i < 9; i++) {
            if (board[row][i] == value) {
                return false;
            }
        }

        for (int i = 0; i < 9; i++) {
            if (board[i][col] == value) {
                return false;
            }
        }

        int sqStRow = row / 3 * 3;
        int sqStCol = col / 3 * 3;
        for (int i = sqStRow; i < sqStRow + 3; i++) {
            for (int j = sqStCol; j < sqStCol + 3; j++) {
                if (board[i][j] == value) {
                    return false;
                }
            }
        }
        return true;
    }

    public void DFS(int x, int y) {

        if (x == 9) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    System.out.print(board[i][j] + " ");
                }
                System.out.println();
            }
            solved = true;
            return;
        }

        if (board[x][y] == 0) {
            for (int i = 1; i <= 9; i++) {
                if (valid(x, y, i)) {
                    board[x][y] = i;
                    if (y == 8) {
                        DFS(x + 1, 0);
                    }
                    else  {
                        DFS(x, y + 1);
                    }
                    if (solved) {
                        return;
                    }
                    board[x][y] = 0;
                }
            }
        }
        else {
            if (y == 8) {
                DFS(x + 1, 0);
            }
            else  {
                DFS(x, y + 1);
            }
        }
    }

    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        board = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                board[i][j] = sc.nextInt();
            }
        }
        T.DFS(0, 0);
    }
}
