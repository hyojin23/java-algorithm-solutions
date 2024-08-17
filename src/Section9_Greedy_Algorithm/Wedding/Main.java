package Section9_Greedy_Algorithm.Wedding;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Plan implements Comparable<Plan> {

    int time;
    char type;

    Plan(int time, char type) {
        this.time = time;
        this.type = type;
    }

    @Override
    public int compareTo(Plan o) {
        if (this.time == o.time) {
            return this.type - o.type;
        }
        else {
            return this.time - o.time;
        }
    }
}

public class Main {

    public int solution(List<Plan> list) {

        Collections.sort(list);
        int cnt = 0;
        int answer = 0;

        for (Plan p : list) {
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

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Plan> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();

            list.add(new Plan(s, 's'));
            list.add(new Plan(e, 'e'));
        }

        System.out.println(T.solution(list));
    }
}
