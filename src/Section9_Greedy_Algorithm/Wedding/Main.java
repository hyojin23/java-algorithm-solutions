package Section9_Greedy_Algorithm.Wedding;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Plan implements Comparable<Plan> {

    char s;
    int t;

    Plan(char s, int t) {
        this.s = s;
        this.t = t;
    }

    @Override
    public int compareTo(Plan ob) {
        if (this.t == ob.t) {
            return this.s - ob.s;
        }
        else {
            return this.t - ob.t;
        }
    }
}

public class Main {

    public int solution(List<Plan> list) {

        Collections.sort(list);
        int answer = Integer.MIN_VALUE;
        int cnt = 0;
        for (Plan p : list) {
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

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Plan> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new Plan('s', sc.nextInt()));
            list.add(new Plan('e', sc.nextInt()));
        }
        System.out.println(T.solution(list));
    }
}
