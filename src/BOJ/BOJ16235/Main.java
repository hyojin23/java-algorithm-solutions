package BOJ.BOJ16235;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.ArrayDeque;
import java.util.Arrays;

public class Main {

    public int solution(int N, int M, int K, int[][] S2D2, Deque<Integer>[][] trees) {

        int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
        int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
        int[][] board = new int[N + 1][N + 1];
        for (int[] cols : board) {
            Arrays.fill(cols, 5);
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (!trees[i][j].isEmpty()) {
                    List<Integer> sorted = new ArrayList<>(trees[i][j]);
                    Collections.sort(sorted);
                    trees[i][j] = new ArrayDeque<>(sorted);
                }
            }
        }

        for (int year = 0; year < K; year++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (trees[i][j].isEmpty()) {
                        continue;
                    }
                    Deque<Integer> alive = new ArrayDeque<>();
                    int deadNutrient = 0;
                    while (!trees[i][j].isEmpty()) {
                        int age = trees[i][j].pollFirst();
                        if (board[i][j] < age) {
                            deadNutrient += age / 2;
                        }
                        else {
                            board[i][j] -= age;
                            alive.addLast(age + 1);
                        }
                    }
                    board[i][j] += deadNutrient;
                    trees[i][j] = alive;
                }
            }
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    for (int age : trees[i][j]) {
                        if (age % 5 == 0) {
                            for (int k = 0; k < 8; k++) {
                                int nx = i + dx[k];
                                int ny = j + dy[k];
                                if (nx >= 1 && nx <= N && ny >= 1 && ny <= N) {
                                    trees[nx][ny].addFirst(1);
                                }
                            }
                        }
                    }
                }
            }
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    board[i][j] += S2D2[i][j];
                }
            }
        }
        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                cnt += trees[i][j].size();
            }
        }
        return cnt;
    }


    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int K = sc.nextInt();
        int[][] S2D2 = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                S2D2[i][j] = sc.nextInt();
            }
        }
        Deque<Integer>[][] trees = new ArrayDeque[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                trees[i][j] = new ArrayDeque<>();
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int age = sc.nextInt();
            trees[x][y].add(age);
        }
        System.out.println(T.solution(N, M, K, S2D2, trees));
    }
}
