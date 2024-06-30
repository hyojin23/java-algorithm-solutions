package Section9_Greedy_Algorithm.Wedding;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;


class Time_2nd implements Comparable<Time_2nd> {

    int t;
    char s;

    public Time_2nd(int t, char s) {
        this.t = t;
        this.s = s;
    }

    @Override
    public int compareTo(Time_2nd o) {

        if (this.t == o.t) {
            return this.s - o.s;
        }
        else {
            return this.t - o.t;
        }
    }
}

public class Main_2nd {

    public int solution(List<Time_2nd> list) {

        Collections.sort(list);

        int answer = 0;
        int cnt = 0;

        for (Time_2nd t : list) {
            if (t.s == 's') {
                cnt++;
            }
            else if (t.s == 'e') {
                cnt--;
            }
            answer = Math.max(answer, cnt);
        }

        return answer;
    }

    public static void main(String[] args) {

        Main_2nd T = new Main_2nd();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Time_2nd> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            list.add(new Time_2nd(s, 's'));
            list.add(new Time_2nd(e, 'e'));
        }

        System.out.println(T.solution(list));

    }

}
