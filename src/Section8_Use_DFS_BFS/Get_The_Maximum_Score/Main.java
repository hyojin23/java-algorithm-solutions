package Section8_Use_DFS_BFS.Get_The_Maximum_Score;

import java.util.Scanner;

public class Main {

    static int n, m;
    static int answer = Integer.MIN_VALUE;


    public void DFS(int L, int sum, int time, int[] arrScore, int[] arrTime) {

        if (time > m) return;

        if (L == n) {
            answer = Math.max(answer, sum);
        }
        else {
            DFS(L + 1, sum + arrScore[L], time + arrTime[L], arrScore, arrTime);
            DFS(L + 1, sum, time, arrScore, arrTime);
        }
    }

    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        int[] arrScore = new int[n];
        int[] arrTime = new int[n];

        for (int i = 0; i < n; i++) {
            arrScore[i] = sc.nextInt();
            arrTime[i] = sc.nextInt();
        }

        T.DFS(0, 0, 0, arrScore, arrTime);
        System.out.println(answer);
    }
}
