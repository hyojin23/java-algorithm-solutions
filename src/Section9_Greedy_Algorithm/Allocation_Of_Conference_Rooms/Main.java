package Section9_Greedy_Algorithm.Allocation_Of_Conference_Rooms;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Time implements Comparable<Time> {

    int s, e;

    Time(int s, int e) {
        this.s = s;
        this.e = e;
    }

    @Override
    public int compareTo(Time ob) {
        if (this.e == ob.e) {
            return this.s - ob.s;
        }
        else {
            return this.e - ob.e;
        }
    }
}

public class Main {

    public int solution(List<Time> list) {

        Collections.sort(list);
        int lastTime = Integer.MIN_VALUE;
        int answer = 0;
        for (Time t : list) {
            if (t.s >= lastTime) {
                answer++;
                lastTime = t.e;
            }
        }
        return answer;
    }

    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        List<Time> list = new ArrayList<>();

        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            list.add(new Time(s, e));
        }
        System.out.println(T.solution(list));
    }
}
