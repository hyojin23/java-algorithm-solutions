package Section9_Greedy_Algorithm.Schedule_Of_Maximum_Income;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Collections;

class Schedule implements Comparable<Schedule> {

    int m, d;

    Schedule(int m, int d) {
        this.m = m;
        this.d = d;
    }

    @Override
    public int compareTo(Schedule ob) {
        return ob.d - this.d;
    }
}

public class Main {

    public int solution(int n, List<Schedule> list, int maxDay) {

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        Collections.sort(list);
        int sum = 0;
        int j = 0;
        for (int i = maxDay; i >= 1; i--) {
            for ( ; j < n; j++) {
                if (i == list.get(j).d) {
                    pq.offer(list.get(j).m);
                }
                else {
                    break;
                }
            }
            if (!pq.isEmpty()) {
                sum += pq.poll();
            }
        }
        return sum;
    }


    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Schedule> list = new ArrayList<>();
        int maxDay = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            int m = sc.nextInt();
            int d = sc.nextInt();
            list.add(new Schedule(m, d));
            maxDay = Math.max(d, maxDay);
        }

        System.out.println(T.solution(n, list, maxDay));
    }
}
