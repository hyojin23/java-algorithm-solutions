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

    public int solution(int n, int maxDay, List<Schedule> list) {

        Collections.sort(list);
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int answer = 0;

        int j = 0;
        for (int i = maxDay; i >= 1; i--) {
            for ( ; j < n ; j++) {
                if (list.get(j).d >= i) {
                    pq.offer(list.get(j).m);
                }
                else {
                    break;
                }
            }
            if (!pq.isEmpty()) {
                answer += pq.poll();
            }
        }
        return answer;
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
            maxDay = Math.max(maxDay, d);
            list.add(new Schedule(m, d));
        }
        System.out.println(T.solution(n, maxDay, list));
    }
}
