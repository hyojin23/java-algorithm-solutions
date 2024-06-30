package Section9_Greedy_Algorithm.Schedule_Of_Maximum_Income;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

class Lecture implements Comparable<Lecture> {

    int m, t;

    public Lecture(int m, int t) {
        this.m = m;
        this.t = t;
    }

    @Override
    public int compareTo(Lecture o) {
        return o.t - this.t;
    }
}

public class Main {

    static int n;
    public int solution(List<Lecture> list, int today) {

        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        Collections.sort(list);

        int j = 0;
        for (int i = today; i >= 1; i--) {
            for ( ; j < n; j++) {
                if (list.get(j).t >= i) {
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
        int today = Integer.MIN_VALUE;

        n = sc.nextInt();
        List<Lecture> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int m = sc.nextInt();
            int t = sc.nextInt();

            list.add(new Lecture(m, t));
            today = Math.max(t, today);
        }

        System.out.println(T.solution(list, today));
    }
}
