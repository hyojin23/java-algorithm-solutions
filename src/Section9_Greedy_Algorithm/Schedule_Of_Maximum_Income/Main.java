package Section9_Greedy_Algorithm.Schedule_Of_Maximum_Income;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

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

    static int max = Integer.MIN_VALUE;

    public int solution(int n, List<Schedule> list) {

        Collections.sort(list);
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        int j = 0;
        int sum = 0;
        for (int i = max; i >= 1; i--) {
            for ( ; j < n; j++) {
                if (list.get(j).d >= i) {
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

        for (int i = 0; i < n; i++) {
            int m = sc.nextInt();
            int d = sc.nextInt();

            list.add(new Schedule(m, d));

            if (d > max) {
                max = d;
            }
        }

        System.out.println(T.solution(n, list));
    }
}
