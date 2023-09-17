package Section9_Greedy_Algorithm.Allocation_Of_Conference_Rooms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

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

    public int solution(List<Time> list, int n) {

        int answer = 0;
        int endTime = 0;

        for (int i = 0; i < n; i++) {

            if (list.get(i).s >= endTime) {
                answer++;
                endTime = list.get(i).e;
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
            list.add(new Time(sc.nextInt(), sc.nextInt()));
        }
        Collections.sort(list);

        System.out.println(T.solution(list, n));
    }
}
