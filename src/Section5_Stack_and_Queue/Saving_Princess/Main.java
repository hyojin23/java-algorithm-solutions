package Section5_Stack_and_Queue.Saving_Princess;

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class Main {

    public int solution(int n, int k) {

        Queue<Integer> q = new LinkedList<>();
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            q.offer(i);
        }
        while (!q.isEmpty()) {
            for (int i = 0; i < k - 1; i++) {
                q.offer(q.poll());
            }
            q.poll();
            if (q.size() == 1) {
                answer = q.poll();
            }
        }
        return answer;
    }


    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        System.out.println(T.solution(n, k));
    }
}
