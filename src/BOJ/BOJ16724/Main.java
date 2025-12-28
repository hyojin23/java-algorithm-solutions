package BOJ.BOJ16724;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

    static int cycleCount = 0;
    static char[][] board;
    static int[][] state;
    public void dfs(int x, int y) {

        state[x][y] = 1;
        int nx = x;
        int ny = y;
        if (board[x][y] == 'U') {
            nx--;
        }
        else if (board[x][y] == 'R') {
            ny++;
        }
        else if (board[x][y] == 'D') {
            nx++;
        }
        else if (board[x][y] == 'L') {
            ny--;
        }

        if (state[nx][ny] == 1) {
            cycleCount++;
        }
        else if (state[nx][ny] == 0){
            dfs(nx, ny);
        }
        state[x][y] = 2;
    }


    public static void main(String[] args) throws IOException {

        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        board = new char[N][M];
        state = new int[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = str.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (state[i][j] == 0) {
                    main.dfs(i, j);
                }
            }
        }
        System.out.println(cycleCount);
    }
}
