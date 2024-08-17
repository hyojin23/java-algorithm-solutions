package Section9_Greedy_Algorithm.Wedding;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Time_3rd implements Comparable<Time_3rd> {

    int t;
    char s;

    public Time_3rd(int t, char s) {
        this.s = s;
        this.t = t;
    }

    @Override
    public int compareTo(Time_3rd o) {
        if (t != o.t) {
            return this.t - o.t;
        }
        else {
            return this.s - o.s;
        }
    }
}

public class Main_3rd {

    public int solution(List<Time_3rd> list) {

        int answer = Integer.MIN_VALUE;
        int cnt = 0;

        Collections.sort(list);

        for (Time_3rd o : list) {
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

        Main_3rd T = new Main_3rd();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Time_3rd> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();

            list.add(new Time_3rd(s, 's')); // start time
            list.add(new Time_3rd(e, 'e')); // end time
        }

        System.out.println(T.solution(list));
    }
}
