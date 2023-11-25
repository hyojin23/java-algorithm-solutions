package Section5_Stack_and_Queue.Saving_Princess;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Queue;

public class Main_1st {

    public int solution(int n, int k) {
        int answer = 0;
        Queue<Integer> q = new LinkedList<>();
        for (int i=0; i<n; i++) {
            q.offer(i+1);
        }
        while (!q.isEmpty()) {
            for (int i=1; i<k; i++) {
                q.offer(q.poll());
            }
            q.poll();
            if (q.size() == 1) answer = q.poll();
        }
        return answer;
    }

    public static void main(String[] args) {
        Main_1st T = new Main_1st();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        System.out.println(T.solution(n, k));
    }
}
