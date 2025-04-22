package Recommended_Problems.DFS_BFS.BOJ2583;

import java.util.Scanner;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class Main {

    static int n, m, k, cnt, width = 0;
    static int[][] board;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static List<Integer> list;

    public void DFS(int x, int y) {

        board[x][y] = 1;
        width++;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < m && ny >= 0 && ny < n && board[nx][ny] == 0) {
                DFS(nx, ny);
            }
        }
    }


    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        m = sc.nextInt();
        n = sc.nextInt();
        k = sc.nextInt();
        board = new int[m][n];
        list = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            for (int j = m - y2; j < m - y1; j++) {
                for (int l = x1; l < x2; l++) {
                    board[j][l] = 1;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 0) {
                    cnt++;
                    width = 0;
                    T.DFS(i, j);
                    list.add(width);
                }
            }
        }
        System.out.println(cnt);
        Collections.sort(list);
        for (int x : list) {
            System.out.print(x + " ");
        }
    }
}
