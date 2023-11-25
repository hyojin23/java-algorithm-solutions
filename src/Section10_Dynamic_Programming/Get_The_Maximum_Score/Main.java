package Section10_Dynamic_Programming.Get_The_Maximum_Score;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

class Problem {

    int s, t;

    public Problem(int s, int t) {
        this.s = s;
        this.t = t;
    }
}

public class Main {

    public int solution(int m, List<Problem> list) {

        int[] dy = new int[m + 1];

        for (Problem p : list) {
            for (int j = m; j >= p.t; j--) {
                dy[j] = Math.max(dy[j], dy[j - p.t] + p.s);
            }
        }
        return dy[m];

    }

    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        List<Problem> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            list.add(new Problem(a, b));
        }

        System.out.println(T.solution(m, list));
    }
}

