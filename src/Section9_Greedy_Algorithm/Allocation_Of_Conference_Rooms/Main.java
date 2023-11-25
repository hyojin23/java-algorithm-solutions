package Section9_Greedy_Algorithm.Allocation_Of_Conference_Rooms;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Time implements Comparable<Time> {

    int s, e;

    public Time(int s, int e) {
        this.s = s;
        this.e = e;
    }

    @Override
    public int compareTo(Time t) {

        if (this.e == t.e) {
            return this.s - t.s;
        }
        else {
            return this.e - t.e;
        }
    }
}

public class Main {

    public int solution(List<Time> list) {

        int answer = 0;
        int endTime = Integer.MIN_VALUE;

        Collections.sort(list);

        for (Time t : list) {

            if (t.s >= endTime) {
                endTime = t.e;
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Time> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            list.add(new Time(a, b));
        }

        System.out.println(T.solution(list));
    }
}
