package Section9_Greedy_Algorithm.Wedding;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Plan_4th implements Comparable<Plan_4th> {

    int time;
    char type;

    Plan_4th(int time, char type) {
        this.time = time;
        this.type = type;
    }

    @Override
    public int compareTo(Plan_4th o) {
        if (this.time == o.time) {
            return this.type - o.type;
        }
        else {
            return this.time - o.time;
        }
    }
}

public class Main_4th {

    public int solution(List<Plan_4th> list) {

        Collections.sort(list);
        int cnt = 0;
        int answer = 0;

        for (Plan_4th p : list) {
            if (p.type == 's') {
                cnt++;
            }
            else if (p.type == 'e') {
                cnt--;
            }
            answer = Math.max(answer, cnt);
        }

        return answer;
    }

    public static void main(String[] args) {

        Main_4th T = new Main_4th();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Plan_4th> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();

            list.add(new Plan_4th(s, 's'));
            list.add(new Plan_4th(e, 'e'));
        }

        System.out.println(T.solution(list));
    }
}
