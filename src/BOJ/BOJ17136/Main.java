package BOJ.BOJ17136;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {

    static int[][] board;
    static int[] paperCnt;
    static int answer = Integer.MAX_VALUE;

    public static void dfs(int used) {

        if (used >= answer) {
            return;
        }

        int x = -1;
        int y = -1;

        outer:
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (board[i][j] == 1) {
                    x = i;
                    y = j;
                    break outer;
                }
            }
        }

        if (x == -1) {
            answer = used;
            return;
        }

        for (int size = 5; size >= 1; size--) {
            if (isPossible(x, y, size)) {
                attach(x, y, size);
                paperCnt[size]--;
                dfs(used + 1);
                detach(x, y, size);
                paperCnt[size]++;
            }
        }
    }

    public static void attach(int x, int y, int size) {
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                board[i][j] = 0;
            }
        }
    }

    public static void detach(int x, int y, int size) {
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                board[i][j] = 1;
            }
        }
    }

    public static boolean isPossible(int x, int y, int size) {
        if (paperCnt[size] == 0) {
            return false;
        }

        if (x + size > 10 || y + size > 10) {
            return false;
        }

        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (board[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        board = new int[10][10];
        paperCnt = new int[6];

        for (int i = 0; i < 10; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 10; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= 5; i++) {
            paperCnt[i] = 5;
        }

        dfs(0);

        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }
}
