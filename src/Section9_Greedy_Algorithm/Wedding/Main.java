package Section9_Greedy_Algorithm.Wedding;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;


class Time implements Comparable<Time> {

    int t;
    char s;

    public Time(int t, char s) {
        this.t = t;
        this.s = s;
    }

    @Override
    public int compareTo(Time o) {

        if (this.t == o.t) {
            return this.s - o.s;
        }
        else {
            return this.t - o.t;
        }
    }
}

public class Main {

    public int solution(List<Time> list) {

        Collections.sort(list);

        int answer = 0;
        int cnt = 0;

        for (Time t : list) {
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

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Time> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            list.add(new Time(s, 's'));
            list.add(new Time(e, 'e'));
        }

        System.out.println(T.solution(list));

    }

}
