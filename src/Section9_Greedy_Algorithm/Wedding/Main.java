package Section9_Greedy_Algorithm.Wedding;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Time implements Comparable<Time> {

    int t;
    char s;

    public Time(int t, char s) {
        this.s = s;
        this.t = t;
    }

    @Override
    public int compareTo(Time o) {
        if (t != o.t) {
            return this.t - o.t;
        }
        else {
            return this.s - o.s;
        }
    }
}

public class Main {

    public int solution(List<Time> list) {

        int answer = Integer.MIN_VALUE;
        int cnt = 0;

        Collections.sort(list);

        for (Time o : list) {
            if (o.s == 's') {
                cnt++;
            }
            else if (o.s == 'e') {
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

            list.add(new Time(s, 's')); // start time
            list.add(new Time(e, 'e')); // end time
        }

        System.out.println(T.solution(list));
    }
}
