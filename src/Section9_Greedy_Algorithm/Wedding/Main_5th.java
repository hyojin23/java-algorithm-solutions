package Section9_Greedy_Algorithm.Wedding;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Plan_5th implements Comparable<Plan_5th> {

    int t;
    char s;

    Plan_5th(int t, char s) {
        this.t = t;
        this.s = s;
    }

    @Override
    public int compareTo(Plan_5th ob) {
        if (this.t == ob.t) {
            return this.s - ob.s;
        }
        else {
            return this.t - ob.t;
        }
    }
}

public class Main_5th {

    public int solution(int n, List<Plan_5th> list) {

        Collections.sort(list);
        int answer = Integer.MIN_VALUE;
        int cnt = 0;

        for (Plan_5th p : list) {
            if (p.s == 's') {
                cnt++;
            }
            else if (p.s == 'e') {
                cnt--;
            }
            answer = Math.max(answer, cnt);
        }
        return answer;
    }


    public static void main(String[] args) {

        Main_5th T = new Main_5th();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Plan_5th> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            list.add(new Plan_5th(a, 's'));

            int b = sc.nextInt();
            list.add(new Plan_5th(b, 'e'));
        }

        System.out.println(T.solution(n, list));
    }
}
