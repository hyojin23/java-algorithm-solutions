package BOJ.BOJ1655;

import java.util.Scanner;
import java.util.PriorityQueue;
import java.util.Collections;

public class Main {

    public String solution(int N, int[] arr) {

        PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> right = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();
        for (int x : arr) {
            if (left.size() == right.size()) {
                left.offer(x);
            }
            else {
                right.offer(x);
            }
            if (!right.isEmpty() && left.peek() > right.peek()) {
                int l = left.poll();
                int r = right.poll();
                left.offer(r);
                right.offer(l);
            }
            sb.append(left.peek()).append('\n');
        }
        return sb.toString();
    }


    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(T.solution(N, arr));
    }
}
