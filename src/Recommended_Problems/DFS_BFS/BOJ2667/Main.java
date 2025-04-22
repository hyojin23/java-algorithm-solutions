package Recommended_Problems.DFS_BFS.BOJ2667;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

    static int[][] board;
    static int cnt = 0, width = 0;
    static int n;

    public void DFS(int x, int y) {

        width++;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < n && ny >= 0 && ny < n && board[nx][ny] == 1) {
                board[nx][ny] = 0;
                DFS(nx, ny);
            }
        }
    }

    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        sc.nextLine();

        board = new int[n][n];
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String str = sc.nextLine();
            for (int j = 0; j < n; j++) {
                board[i][j] = str.charAt(j) - '0';
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1) {
                    cnt++;
                    board[i][j] = 0;
                    width = 0;
                    T.DFS(i, j);
                    list.add(width);
                }
            }
        }

        Collections.sort(list);
        System.out.println(cnt);
        for (int x : list) {
            System.out.println(x);
        }
    }
}
