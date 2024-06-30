package Section8_Use_DFS_BFS.Get_The_Maximum_Score;

import java.util.Scanner;

public class Main_2nd {

    static int answer = Integer.MIN_VALUE;
    static int n, m;
    static int[] score, time;

    public void DFS(int L, int s, int t) {

        if (t > m) return;

        if (L == n) {
            answer = Math.max(answer, s);
            return;
        }
        else {
            DFS(L + 1, s + score[L], t + time[L]);
            DFS(L + 1, s, t);
        }
    }

    public static void main(String[] args) {

        Main_2nd T = new Main_2nd();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        score = new int[n];
        time = new int[n];

        for (int i = 0; i < n; i++) {
            score[i] = sc.nextInt();
            time[i] = sc.nextInt();
        }

        T.DFS(0, 0, 0);
        System.out.println(answer);
    }
}
