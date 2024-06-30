package Section8_Use_DFS_BFS.Get_The_Maximum_Score;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

class Problem {

    int s;
    int t;

    public Problem(int s, int t) {
        this.s = s;
        this.t = t;
    }
}

public class Main {

    static List<Problem> list;
    static int n, m;
    static int max = Integer.MIN_VALUE;

    public void DFS(int L, int totTime, int totScore) {

        if (totTime > m) return;

        if (L == n) {
            max = Math.max(max, totScore);
        }
        else {
            DFS(L + 1, totTime + list.get(L).t, totScore + list.get(L).s);
            DFS(L + 1, totTime, totScore);
        }
    }

    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int s = sc.nextInt();
            int t = sc.nextInt();

            list.add(new Problem(s, t));
        }

        T.DFS(0, 0, 0);
        System.out.println(max);
    }
}
