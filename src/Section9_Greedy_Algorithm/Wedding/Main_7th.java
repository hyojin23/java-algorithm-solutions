package Section9_Greedy_Algorithm.Wedding;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Plan_7th implements Comparable<Plan_7th> {

    char s;
    int t;

    Plan_7th(char s, int t) {
        this.s = s;
        this.t = t;
    }

    @Override
    public int compareTo(Plan_7th ob) {
        if (this.t == ob.t) {
            return this.s - ob.s;
        }
        else {
            return this.t - ob.t;
        }
    }
}

public class Main_7th {

    public int solution(List<Plan_7th> list) {

        Collections.sort(list);
        int answer = Integer.MIN_VALUE;
        int cnt = 0;
        for (Plan_7th p : list) {
            if (p.s == 's') {
                cnt++;
            }
            else if (p.s == 'e') {
                cnt--;
            }
            answer = Math.max(cnt, answer);
        }
        return answer;
    }

    public static void main(String[] args) {

        Main_7th T = new Main_7th();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Plan_7th> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new Plan_7th('s', sc.nextInt()));
            list.add(new Plan_7th('e', sc.nextInt()));
        }
        System.out.println(T.solution(list));
    }
}
