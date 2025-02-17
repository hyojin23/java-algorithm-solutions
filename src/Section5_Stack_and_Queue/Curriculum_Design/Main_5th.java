package Section5_Stack_and_Queue.Curriculum_Design;

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class Main_5th {

    public String solution(String must, String plan) {

        Queue<Character> q = new LinkedList<>();

        for (char c : must.toCharArray()) {
            q.offer(c);
        }

        for (char c : plan.toCharArray()) {
            if (q.contains(c)) {
                if (c == q.peek()) {
                    q.poll();
                }
                else {
                    return "NO";
                }
            }
        }

        if (!q.isEmpty()) {
            return "NO";
        }

        return "YES";
    }


    public static void main(String[] args) {

        Main_5th T = new Main_5th();
        Scanner sc = new Scanner(System.in);

        String must = sc.next();
        String plan = sc.next();

        System.out.println(T.solution(must, plan));
    }
}
