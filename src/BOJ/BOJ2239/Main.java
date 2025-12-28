package BOJ.BOJ2239;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

    static int[][] board;
    static boolean solved;

    public static void dfs(int row, int col) {

        if (col == 9) {
            dfs(row + 1, 0);
            return;
        }

        if (row == 9) {
            printBoard();
            solved = true;
            return;
        }

        if (board[row][col] != 0) {
            dfs(row, col + 1);
            return;
        }

        for (int num = 1; num <= 9; num++) {
            if (isValid(row, col, num)) {
                board[row][col] = num;
                dfs(row, col + 1);
                if (solved) {
                    return;
                }
                board[row][col] = 0;
            }
        }
    }

    public static boolean isValid(int row, int col, int num) {

        //행 검사
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num) {
                return false;
            }
        }

        //열 검사
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == num) {
                return false;
            }
        }

        //3x3 검사
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == num) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void printBoard() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sb.append(board[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        board = new int[9][9];

        for (int i = 0; i < 9; i++) {
            String str = br.readLine();
            for (int j = 0; j < 9; j++) {
                board[i][j] = str.charAt(j) - '0';
            }
        }

        dfs(0, 0);
    }
}
