package Section5_Stack_and_Queue.Saving_Princess;

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class Main_6th {

    public int solution(int n, int k) {

        Queue<Integer> q = new LinkedList<>();
        int answer = 0;

        for (int i = 1; i <= n; i++) {
            q.offer(i);
        }

        int cnt = 0;
        while (!q.isEmpty() && q.size() != 1) {
            int prince = q.poll();
            cnt++;
            if (cnt == k) {
                cnt = 0;
            }
            else {
                q.offer(prince);
            }
        }
        if (!q.isEmpty()) {
            answer = q.poll();
        }
        return answer;
    }


    public static void main(String[] args) {

        Main_6th T = new Main_6th();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        System.out.println(T.solution(n, k));
    }
}
