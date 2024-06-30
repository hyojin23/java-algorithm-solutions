package Section10_Dynamic_Programming.Get_The_Maximum_Score;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

class Problem_2nd {

    int s, t;

    public Problem_2nd(int s, int t) {
        this.s = s;
        this.t = t;
    }
}

public class Main_2nd {

    public int solution(int m, List<Problem_2nd> list) {

        int[] dy = new int[m + 1];

        for (Problem_2nd p : list) {
            for (int j = m; j >= p.t; j--) {
                dy[j] = Math.max(dy[j], dy[j - p.t] + p.s);
            }
        }
        return dy[m];

    }

    public static void main(String[] args) {

        Main_2nd T = new Main_2nd();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        List<Problem_2nd> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            list.add(new Problem_2nd(a, b));
        }

        System.out.println(T.solution(m, list));
    }
}

