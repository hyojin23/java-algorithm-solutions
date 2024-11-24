package Section9_Greedy_Algorithm.Allocation_Of_Conference_Rooms;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Time_5th implements Comparable<Time_5th> {

    int s, e;

    Time_5th(int s, int e) {
        this.s = s;
        this.e = e;
    }

    @Override
    public int compareTo(Time_5th ob) {
        if (this.e == ob.e) {
            return this.s - ob.s;
        }
        else {
            return this.e - ob.e;
        }
    }
}

public class Main_5th {

    public int solution(int n, List<Time_5th> list) {

        int last = Integer.MIN_VALUE;
        int answer = 0;

        Collections.sort(list);

        for (Time_5th t : list) {
            if (t.s >= last) {
                answer++;
                last = t.e;
            }
        }
        return answer;
    }


    public static void main(String[] args) {

        Main_5th T = new Main_5th();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Time_5th> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            list.add(new Time_5th(s, e));
        }

        System.out.println(T.solution(n, list));
    }
}
