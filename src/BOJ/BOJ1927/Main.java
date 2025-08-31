package BOJ.BOJ1927;

import java.util.Scanner;
import java.util.PriorityQueue;

public class Main {

    public void solution(int N, int[] arr) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int x : arr) {
            if (x == 0) {
                if (pq.isEmpty()) {
                    System.out.println(0);
                }
                else {
                    System.out.println(pq.poll());
                }
            }
            else {
                pq.offer(x);
            }
        }
    }


    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        T.solution(N, arr);
    }
}
