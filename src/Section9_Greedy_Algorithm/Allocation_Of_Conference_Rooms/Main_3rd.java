package Section9_Greedy_Algorithm.Allocation_Of_Conference_Rooms;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Time_3rd implements Comparable<Time_3rd> {

    int s, e;

    Time_3rd(int s, int e) {
        this.s = s;
        this.e = e;
    }

    @Override
    public int compareTo(Time_3rd o) {
        if (this.e == o.e) {
            return this.s - o.s;
        }
        else {
            return this.e - o.e;
        }
    }
}
public class Main_3rd {

    public int solution(List<Time_3rd> list) {

        int answer = 0;
        int lastEndTime = Integer.MIN_VALUE;

        Collections.sort(list);

        for (Time_3rd time : list) {

            if (time.s >= lastEndTime) {
                answer++;
                lastEndTime = time.e;
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        Main_3rd T = new Main_3rd();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Time_3rd> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();

            list.add(new Time_3rd(s, e));
        }

        System.out.println(T.solution(list));
    }
}
