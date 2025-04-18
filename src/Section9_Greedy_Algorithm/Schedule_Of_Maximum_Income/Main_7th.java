package Section9_Greedy_Algorithm.Schedule_Of_Maximum_Income;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Collections;

class Schedule_7th implements Comparable<Schedule_7th> {

    int m, d;

    Schedule_7th(int m, int d) {
        this.m = m;
        this.d = d;
    }

    @Override
    public int compareTo(Schedule_7th ob) {
        return ob.d - this.d;
    }
}

public class Main_7th {

    public int solution(int n, List<Schedule_7th> list) {

        Collections.sort(list);
        int lastDay = list.get(0).d;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int answer = 0;

        int j = 0;
        for (int i = lastDay; i >= 1; i--) {
            for (; j < n; j++) {
                if (list.get(j).d == i) {
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

        Main_7th T = new Main_7th();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Schedule_7th> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int m = sc.nextInt();
            int d = sc.nextInt();
            list.add(new Schedule_7th(m, d));
        }
        System.out.println(T.solution(n, list));
    }
}
