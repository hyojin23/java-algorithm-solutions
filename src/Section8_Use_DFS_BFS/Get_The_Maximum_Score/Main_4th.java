package Section8_Use_DFS_BFS.Get_The_Maximum_Score;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

class Problem_4th {

    int s, t;

    Problem_4th(int s, int t) {
        this.s = s;
        this.t = t;
    }
}

public class Main_4th {

    static int n, m;
    static int answer = 0;
    static List<Problem_4th> list;

    public void DFS(int L, int s, int t) {

        if (t > m) return;

        if (L == n) {
            answer = Math.max(answer, s);
        }
        else {
            DFS(L + 1, s + list.get(L).s, t + list.get(L).t);
            DFS(L + 1, s, t);
        }
    }

    public static void main(String[] args) {

        Main_4th T = new Main_4th();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int s = sc.nextInt();
            int t = sc.nextInt();
            list.add(new Problem_4th(s, t));
        }

        T.DFS(0, 0, 0);
        System.out.println(answer);
    }
}
