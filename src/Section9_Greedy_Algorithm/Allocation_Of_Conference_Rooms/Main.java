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
    public int compareTo(Time o) {
        if (this.e == o.e) {
            return this.s - o.s;
        }
        else {
            return this.e - o.e;
        }
    }
}
public class Main {

    public int solution(List<Time> list) {

        int answer = 0;
        int lastEndTime = Integer.MIN_VALUE;

        Collections.sort(list);

        for (Time time : list) {

            if (time.s >= lastEndTime) {
                answer++;
                lastEndTime = time.e;
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
            int s = sc.nextInt();
            int e = sc.nextInt();

            list.add(new Time(s, e));
        }

        System.out.println(T.solution(list));
    }
}
