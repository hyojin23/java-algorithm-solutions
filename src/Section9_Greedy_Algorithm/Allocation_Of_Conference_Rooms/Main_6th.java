package Section9_Greedy_Algorithm.Allocation_Of_Conference_Rooms;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Time_6th implements Comparable<Time_6th> {

    int s, e;

    Time_6th(int s, int e) {
        this.s = s;
        this.e = e;
    }

    @Override
    public int compareTo(Time_6th ob) {
        if (this.e == ob.e) {
            return this.s - ob.s;
        }
        else {
            return this.e - ob.e;
        }
    }
}

public class Main_6th {

    public int solution(List<Time_6th> list) {

        int answer = 0;
        Collections.sort(list);
        int lastEnd = Integer.MIN_VALUE;

        for (Time_6th t : list) {
            if (t.s >= lastEnd) {
                answer++;
                lastEnd = t.e;
            }
        }
        return answer;
    }


    public static void main(String[] args) {

        Main_6th T = new Main_6th();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Time_6th> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            list.add(new Time_6th(s, e));
        }

        System.out.println(T.solution(list));
    }
}
