package Section8_Use_DFS_BFS.Get_The_Maximum_Score;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

class Problem_7th {
    int s, t;

    Problem_7th(int s, int t) {
        this.s = s;
        this.t = t;
    }
}

public class Main_7th {

    static int n, m;
    static List<Problem_7th> list;
    static int answer = Integer.MIN_VALUE;

    public void DFS(int L, int totalScore, int totalTime) {

        if (totalTime > m) {
            return;
        }

        if (L == n) {
            answer = Math.max(answer, totalScore);
        }
        else {
            DFS(L + 1, totalScore + list.get(L).s, totalTime + list.get(L).t);
            DFS(L + 1, totalScore, totalTime);
        }
    }

    public static void main(String[] args) {

        Main_7th T = new Main_7th();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int s = sc.nextInt();
            int t = sc.nextInt();
            list.add(new Problem_7th(s, t));
        }

        T.DFS(0, 0, 0);
        System.out.println(answer);
    }
}
