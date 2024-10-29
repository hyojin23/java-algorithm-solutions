package Section9_Greedy_Algorithm.Schedule_Of_Maximum_Income;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

class Schedule_4th implements Comparable<Schedule_4th> {

    int m, d;

    Schedule_4th(int m, int d) {
        this.m = m;
        this.d = d;
    }

    @Override
    public int compareTo(Schedule_4th ob) {
        return ob.d - this.d;
    }
}

public class Main_4th {

    static int max = Integer.MIN_VALUE;

    public int solution(int n, List<Schedule_4th> list) {

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

        Main_4th T = new Main_4th();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Schedule_4th> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int m = sc.nextInt();
            int d = sc.nextInt();

            list.add(new Schedule_4th(m, d));

            if (d > max) {
                max = d;
            }
        }

        System.out.println(T.solution(n, list));
    }
}
