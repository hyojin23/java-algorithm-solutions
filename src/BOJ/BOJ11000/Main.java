package BOJ.BOJ11000;

import java.util.Scanner;
import java.util.PriorityQueue;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Lecture implements Comparable<Lecture> {

    int s, e;

    Lecture(int s, int e) {
        this.s = s;
        this.e = e;
    }

    @Override
    public int compareTo(Lecture ob) {
        return Integer.compare(this.s, ob.s);
    }
}


public class Main {

    public int solution(int N, List<Lecture> list) {

        Collections.sort(list);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            if (!pq.isEmpty() && list.get(i).s >= pq.peek()) {
                pq.poll();
            }
            pq.offer(list.get(i).e);
        }
        return pq.size();
    }


    public static void main(String[] args) {

        Main main = new Main();
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        List<Lecture> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            list.add(new Lecture(s, e));
        }
        System.out.println(main.solution(N, list));
    }
}
