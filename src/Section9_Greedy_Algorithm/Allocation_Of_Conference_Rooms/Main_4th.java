package Section9_Greedy_Algorithm.Allocation_Of_Conference_Rooms;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Time_4th implements Comparable<Time_4th> {

    int s, e;

    Time_4th(int s, int e) {
        this.s = s;
        this.e = e;
    }

    @Override
    public int compareTo(Time_4th t) {
        if (this.e == t.e) {
            return this.s - t.s;
        }
        else {
            return this.e - t.e;
        }
    }
}
public class Main_4th {

    public int solution(List<Time_4th> list) {

        Collections.sort(list);
        int last = Integer.MIN_VALUE;
        int answer = 0;

        for (Time_4th t : list) {
            if (t.s >= last) {
                last = t.e;
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {

        Main_4th T = new Main_4th();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Time_4th> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();

            list.add(new Time_4th(s, e));
        }

        System.out.println(T.solution(list));
    }
}
