package BOJ.BOJ3109;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

    static char[][] board;
    static int R, C, cnt;
    static int[] dx = {-1, 0, 1};
    static int[] dy = {1, 1, 1};
    static boolean[][] visited;
    static boolean isSuccess;

    public static void dfs(int x, int y) {

        if (isSuccess) {
            return;
        }

        if (y == C - 1) {
            cnt++;
            isSuccess = true;
        }
        else {
            for (int i = 0; i < 3; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && nx < R && ny >= 0 && ny < C && !visited[nx][ny] && board[nx][ny] != 'x') {
                    visited[nx][ny] = true;
                    dfs(nx, ny);
                    if (isSuccess) {
                        break;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");

        R = Integer.parseInt(arr[0]);
        C = Integer.parseInt(arr[1]);
        board = new char[R][C];
        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                board[i][j] = str.charAt(j);
            }
        }
        for (int i = 0; i < R; i++) {
            isSuccess = false;
            visited[i][0] = true;
            dfs(i, 0);
        }
        System.out.println(cnt);
    }
}
