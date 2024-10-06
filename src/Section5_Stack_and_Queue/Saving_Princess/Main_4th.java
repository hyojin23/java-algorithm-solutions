package Section5_Stack_and_Queue.Saving_Princess;

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class Main_4th {

    public int solution(int n, int k) {

        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            q.offer(i);
        }

        while (q.size() > 1) {
            for (int i = 1; i <= k; i++) {
                if (i == k) {
                    q.poll();
                }
                else {
                    q.offer(q.poll());
                }
            }
        }

        return q.peek();
    }

    public static void main(String[] args) {

        Main_4th T = new Main_4th();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        System.out.println(T.solution(n, k));
    }
}