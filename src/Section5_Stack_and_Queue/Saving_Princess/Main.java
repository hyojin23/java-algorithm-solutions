package Section5_Stack_and_Queue.Saving_Princess;

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class Main {

    public int solution(int n, int k) {

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            q.offer(i + 1);
        }

        while (q.size() != 1) {

            for (int i = 1; i <= k; i++) {

                int p = 0;
                if (!q.isEmpty()) {
                    p = q.poll();
                }

                if (i != k) {
                    q.offer(p);
                }
            }
        }

        return q.poll();
    }

    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        System.out.println(T.solution(n, k));
    }
}
