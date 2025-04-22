package Section10_Dynamic_Programming.Get_The_Maximum_Score;

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

    public int solution(int n, int m, List<Problem_7th> list) {

        int[] dy = new int[m + 1];
        for (Problem_7th p : list) {
            for (int i = m; i >= p.t; i--) {
                dy[i] = Math.max(dy[i], dy[i - p.t] + p.s);
            }
        }
        return dy[m];
    }


    public static void main(String[] args) {

        Main_7th T = new Main_7th();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        List<Problem_7th> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int s = sc.nextInt();
            int t = sc.nextInt();
            list.add(new Problem_7th(s, t));
        }
        System.out.println(T.solution(n, m, list));
    }
}
