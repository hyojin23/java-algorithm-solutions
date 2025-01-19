package Section9_Greedy_Algorithm.Wedding;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Plan_6th implements Comparable<Plan_6th> {

    int time;
    char type;

    Plan_6th(int time, char type) {
        this.time = time;
        this.type = type;
    }

    @Override
    public int compareTo(Plan_6th ob) {
        if (this.time == ob.time) {
            return this.type - ob.type;
        }
        else {
            return this.time - ob.time;
        }
    }
}

public class Main_6th {

    public int solution(List<Plan_6th> list) {

        Collections.sort(list);

        int answer = Integer.MIN_VALUE;
        int cnt = 0;
        for (Plan_6th p : list) {
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

        Main_6th T = new Main_6th();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Plan_6th> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(new Plan_6th(sc.nextInt(), 's'));
            list.add(new Plan_6th(sc.nextInt(), 'e'));
        }

        System.out.println(T.solution(list));
    }
}
