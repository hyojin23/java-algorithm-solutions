package Section5_Stack_and_Queue.Saving_Princess;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_v2 {

    public int solution(int n, int k) {

        int answer = 0;
        Queue<Integer> Q = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            Q.offer(i);
        }

        while (!Q.isEmpty()) {
            for (int i = 0; i < k - 1; i++) {
                Q.offer(Q.poll());
            }
            Q.poll();

            if (Q.size() == 1)
                answer = Q.poll();
        }
        return answer;
    }

    public static void main(String[] args) {

        Main_v2 T = new Main_v2();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        System.out.println(T.solution(n, k));
    }
}
