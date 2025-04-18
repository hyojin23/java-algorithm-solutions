package Section8_Use_DFS_BFS.Get_The_Maximum_Score;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

class Problem {

    int s, t;

    Problem(int s, int t) {
        this.s = s;
        this.t = t;
    }
}

public class Main {

    static int n, m, answer = Integer.MIN_VALUE;
    static List<Problem> list;

    public void DFS(int totScore, int totTime, int L) {

        if (totTime > m) {
            return;
        }

        if (L == n) {
            answer = Math.max(answer, totScore);
        }
        else {
            DFS(totScore + list.get(L).s, totTime + list.get(L).t, L + 1);
            DFS(totScore, totTime, L + 1);
        }
    }

    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        list = new ArrayList<>();

        n = sc.nextInt();
        m = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int s = sc.nextInt();
            int t = sc.nextInt();
            list.add(new Problem(s, t));
        }
        T.DFS(0, 0, 0);
        System.out.println(answer);
    }
}
