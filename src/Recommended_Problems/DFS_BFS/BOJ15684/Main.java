package Recommended_Problems.DFS_BFS.BOJ15684;

import java.util.Scanner;

public class Main {

    static int N, M, H, answer = -1;
    static int[][] ladder;
    boolean solved = false;

    public boolean chkLadder() {
        for (int i = 1; i <= N; i++) {
            int pos = i;
            for (int j = 1; j <= H; j++) {
                if (pos < N && ladder[j][pos] == 1) {
                    pos++;
                }
                else if (pos > 1 && ladder[j][pos] == 2) {
                    pos--;
                }
            }
            if (i != pos) {
                return false;
            }
        }
        return true;
    }

    public void DFS(int cnt, int row) {

        if (solved) {
            return;
        }

        if (cnt > 3) {
            return;
        }

        if (chkLadder()) {
            answer = cnt;
            solved = true;
        }
//        else {
            for (int i = row; i <= H; i++) {
                for (int j = 1; j < N; j++) {
                    if (ladder[i][j] == 0 && ladder[i][j + 1] == 0) {
                        ladder[i][j] = 1;
                        ladder[i][j + 1] = 2;
                        DFS(cnt + 1, i);
                        ladder[i][j] = 0;
                        ladder[i][j + 1] = 0;
                    }
                }
            }
//        }
    }

    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        H = sc.nextInt();
        ladder = new int[H + 1][N + 1];
        for (int i = 0; i < M; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            ladder[x][y] = 1;
            ladder[x][y + 1] = 2;
        }
        T.DFS(0, 1);
//        for (int i = 1; i <= H; i++) {
//            for (int j = 1; j <= N; j++) {
//                System.out.print(ladder[i][j] + "");
//            }
//            System.out.println();
//        }
        System.out.println(answer);
    }
}
