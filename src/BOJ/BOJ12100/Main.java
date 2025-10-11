package BOJ.BOJ12100;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

    static int N, max;

    public void DFS(int depth, int[][] board) {

        if (depth == 5) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    max = Math.max(max, board[i][j]);
                }
            }
        }
        else {
            for (int dir = 0; dir < 4; dir++) {
                int[][] copiedBoard = copyBoard(board);
                move(copiedBoard, dir);
                DFS(depth + 1, copiedBoard);
            }
        }
    }

    public int[][] copyBoard(int[][] source) {
        int[][] newBoard = new int[N][N];
        for (int i = 0; i < N; i++) {
            System.arraycopy(source[i], 0, newBoard[i], 0, N);
        }
        return newBoard;
    }

    public void move(int[][] board, int dir) {
        boolean[][] merged = new boolean[N][N];
        switch(dir) {
            case 0: //up
                for (int j = 0; j < N; j++) {
                    for (int i = 1; i < N; i++) {
                        if (board[i][j] == 0) {
                            continue;
                        }
                        int x = i;
                        while (x > 0 && board[x - 1][j] == 0) {
                            board[x - 1][j] = board[x][j];
                            board[x][j] = 0;
                            x--;
                        }
                        if (x > 0 && board[x - 1][j] == board[x][j] && !merged[x - 1][j]) {
                            board[x - 1][j] *= 2;
                            board[x][j] = 0;
                            merged[x - 1][j] = true;
                        }
                    }
                }
                break;
            case 1: //down
                for (int j = 0; j < N; j++) {
                    for (int i = N - 1; i >= 0; i--) {
                        if (board[i][j] == 0) {
                            continue;
                        }
                        int x = i;
                        while (x < N - 1 && board[x + 1][j] == 0) {
                            board[x + 1][j] = board[x][j];
                            board[x][j] = 0;
                            x++;
                        }
                        if (x < N - 1 && board[x + 1][j] == board[x][j] && !merged[x + 1][j]) {
                            board[x + 1][j] *= 2;
                            board[x][j] = 0;
                            merged[x + 1][j] = true;
                        }
                    }

                }
                break;
            case 2: //left
                for (int i = 0; i < N; i++) {
                    for (int j = 1; j < N; j++) {
                        if (board[i][j] == 0) {
                            continue;
                        }
                        int x = j;
                        while (x > 0 && board[i][x - 1] == 0) {
                            board[i][x - 1] = board[i][x];
                            board[i][x] = 0;
                            x--;
                        }
                        if (x > 0 && board[i][x - 1] == board[i][x] && !merged[i][x - 1]) {
                            board[i][x - 1] *= 2;
                            board[i][x] = 0;
                            merged[i][x - 1] = true;
                        }
                    }
                }
                break;
            case 3: //right
                for (int i = 0; i < N; i++) {
                    for (int j = N - 2; j >= 0; j--) {
                        if (board[i][j] == 0) {
                            continue;
                        }
                        int x = j;
                        while (x < N - 1 && board[i][x + 1] == 0) {
                            board[i][x + 1] = board[i][x];
                            board[i][x] = 0;
                            x++;
                        }
                        if (x < N - 1 && board[i][x + 1] == board[i][x] && !merged[i][x + 1]) {
                            board[i][x + 1] *= 2;
                            board[i][x] = 0;
                            merged[i][x + 1] = true;
                        }
                    }
                }
                break;
            default:
                break;
        }
    }


    public static void main(String[] args) throws IOException {

        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[][] board = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        T.DFS(0, board);
        System.out.println(max);
    }
}
