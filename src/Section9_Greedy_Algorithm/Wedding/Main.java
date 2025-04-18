package Section9_Greedy_Algorithm.Wedding;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Plan implements Comparable<Plan> {

    int t;
    char c;

    Plan (int t, char c) {
        this.t = t;
        this.c = c;
    }

    @Override
    public int compareTo(Plan ob) {
        if (this.t == ob.t) {
            return this.c - ob.c;
        }
        else {
            return this.t - ob.t;
        }
    }
}

public class Main {

    public int solution(int n, List<Plan> list) {

        int answer = Integer.MIN_VALUE;
        int cnt = 0;
        Collections.sort(list);
        for (Plan p : list) {
            if (p.c == 's') {
                cnt++;
            }
            else if (p.c == 'e') {
                cnt--;
            }
            answer = Math.max(answer,cnt);
        }
        return answer;
    }


    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Plan> list = new ArrayList<>();
        for  (int i = 0; i < n; i++) {
            list.add(new Plan(sc.nextInt(), 's'));
            list.add(new Plan(sc.nextInt(), 'e'));
        }
        System.out.println(T.solution(n, list));
    }
}
