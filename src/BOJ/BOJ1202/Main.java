package BOJ.BOJ1202;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

class Jewel implements Comparable<Jewel>{

    int w, v;

    Jewel(int w, int v) {
        this.w = w;
        this.v = v;
    }
    @Override
    public int compareTo(Jewel ob) {
        return this.w - ob.w;
    }
}

public class Main {

    public long solution(List<Jewel> jList, List<Integer> bList) {

        Collections.sort(jList);
        Collections.sort(bList);
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int i = 0;
        long sum = 0;
        for (int b : bList) {
            for (; i < jList.size(); i++) {
                if (jList.get(i).w > b) {
                    break;
                }
                else {
                    pq.offer(jList.get(i).v);
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
        List<Jewel> jList = new ArrayList<>();
        List<Integer> bList = new ArrayList<>();
        int N = sc.nextInt();
        int K = sc.nextInt();
        for (int i = 0; i < N; i++) {
            int m = sc.nextInt();
            int v = sc.nextInt();
            jList.add(new Jewel(m, v));
        }
        for (int i = 0; i < K; i++) {
            int b = sc.nextInt();
            bList.add(b);
        }
        System.out.println(T.solution(jList, bList));
    }
}
