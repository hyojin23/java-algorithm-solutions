package BOJ.BOJ1715;

import java.util.Scanner;
import java.util.PriorityQueue;

public class Main {

    public int solution(PriorityQueue<Integer> pq) {
        int sum = 0;
        while(!pq.isEmpty()) {
            if (pq.size() == 1) {
                pq.poll();
            }
            else {
                int a = pq.poll();
                int b = pq.poll();
                int c = a + b;
                sum += c;
                pq.offer(c);
            }
        }
        return sum;
    }


    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            pq.offer(sc.nextInt());
        }
        System.out.println(T.solution(pq));
    }
}
