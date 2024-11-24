package Section9_Greedy_Algorithm.Schedule_Of_Maximum_Income;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Collections;

class Schedule_5th implements Comparable<Schedule_5th> {

    int m, d;

    Schedule_5th(int m, int d) {
        this.m = m;
        this.d = d;
    }

    @Override
    public int compareTo(Schedule_5th ob) {
        return ob.d - this.d;
    }
}

public class Main_5th {

    public int solution(int n, int max, List<Schedule_5th> list) {

        Collections.sort(list);
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int answer = 0;

        int j = 0;
        for (int i = max; i >= 1; i--) {
            for ( ; j < n; j++)  {
                if (list.get(j).d < i) {
                    break;
                }
                pq.offer(list.get(j).m);
            }
            if (!pq.isEmpty()) {
                answer += pq.poll();
            }
        }
        return answer;
    }


    public static void main(String[] args) {

        Main_5th T = new Main_5th();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Schedule_5th> list = new ArrayList<>();
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            int m = sc.nextInt();
            int d = sc.nextInt();
            max = Math.max(d, max);

            list.add(new Schedule_5th(m, d));
        }

        System.out.println(T.solution(n, max, list));
    }
}
