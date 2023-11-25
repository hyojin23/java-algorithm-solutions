package Section9_Greedy_Algorithm.Schedule_Of_Maximum_Income;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Collections;

class Lecture implements Comparable<Lecture> {

    int money, day;

    public Lecture(int time, int day) {
        this.money = time;
        this.day = day;
    }

    @Override
    public int compareTo(Lecture o) {
        return o.day - this.day;
    }
}

public class Main {

    static int n;
    static int max = Integer.MIN_VALUE;
    public int solution(List<Lecture> list) {


        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        Collections.sort(list);

        int answer = 0;

        int j = 0;
        for (int i = max; i > 0; i--) {

            for (; j < n; j++) {
                if (list.get(j).day < i) break;

                pq.offer(list.get(j).money);
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

        n = sc.nextInt();
        List<Lecture> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int m = sc.nextInt();
            int d = sc.nextInt();

            list.add(new Lecture(m, d));

            if (d > max) {
                max = d;
            }
        }

        System.out.println(T.solution(list));
    }
}
