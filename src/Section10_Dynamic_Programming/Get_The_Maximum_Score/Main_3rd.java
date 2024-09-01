package Section10_Dynamic_Programming.Get_The_Maximum_Score;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;

class Problem_3rd implements Comparable<Problem_3rd> {

    int s, t;

    Problem_3rd(int s, int t) {
        this.s = s;
        this.t = t;
    }

    @Override
    public int compareTo(Problem_3rd ob) {
        return this.t - ob.t;
    }
}
public class Main_3rd {

    public int solution(int n, int m, List<Problem_3rd> list) {

        Collections.sort(list);
        int[] dy = new int[m + 1];
        Arrays.fill(dy, 0);

        for (int i = 0; i < n; i++) {
            Problem_3rd p = list.get(i);
            for (int j = m; j >= p.t; j--) {
                if (dy[j] < dy[j - p.t] + p.s) {
                    dy[j] = dy[j - p.t] + p.s;
                }
            }
        }

        return dy[m];
    }

    public static void main(String[] args) {

        Main_3rd T = new Main_3rd();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        List<Problem_3rd> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int s = sc.nextInt();
            int t = sc.nextInt();

            list.add(new Problem_3rd(s, t));
        }

        System.out.println(T.solution(n, m, list));
    }
}
