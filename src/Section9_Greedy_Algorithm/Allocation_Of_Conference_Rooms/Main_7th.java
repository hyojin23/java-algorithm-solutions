package Section9_Greedy_Algorithm.Allocation_Of_Conference_Rooms;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Time_7th implements Comparable<Time_7th> {

    int s, e;

    Time_7th(int s, int e) {
        this.s = s;
        this.e = e;
    }

    @Override
    public int compareTo(Time_7th ob) {
        if (this.e == ob.e) {
            return this.s - ob.s;
        }
        else {
            return this.e - ob.e;
        }
    }
}

public class Main_7th {

    public int solution(List<Time_7th> list) {

        Collections.sort(list);
        int lastTime = Integer.MIN_VALUE;
        int answer = 0;
        for (Time_7th t : list) {
            if (t.s >= lastTime) {
                answer++;
                lastTime = t.e;
            }
        }
        return answer;
    }

    public static void main(String[] args) {

        Main_7th T = new Main_7th();
        Scanner sc = new Scanner(System.in);
        List<Time_7th> list = new ArrayList<>();

        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            list.add(new Time_7th(s, e));
        }
        System.out.println(T.solution(list));
    }
}
