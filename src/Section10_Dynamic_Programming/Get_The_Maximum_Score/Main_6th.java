package Section10_Dynamic_Programming.Get_The_Maximum_Score;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class Problem_6th {

    int s, t;

    Problem_6th(int s, int t) {
        this.s = s;
        this.t = t;
    }
}

public class Main_6th {

    public int solution(int n, int m, List<Problem_6th> list) {

        int[] dy = new int[m + 1];
        Arrays.fill(dy, 0);

        for (Problem_6th p : list) {
            for (int i = m; i >= p.t; i--) {
                dy[i] = Math.max(dy[i], dy[i - p.t] + p.s);
            }
        }
        return dy[m];
    }


    public static void main(String[] args) {

        Main_6th T = new Main_6th();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        List<Problem_6th> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int s = sc.nextInt();
            int t = sc.nextInt();
            list.add(new Problem_6th(s, t));
        }

        System.out.println(T.solution(n, m, list));
    }
}
