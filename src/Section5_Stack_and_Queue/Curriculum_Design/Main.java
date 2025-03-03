package Section5_Stack_and_Queue.Curriculum_Design;

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class Main {

    public String solution(String must, String plan) {

        Queue<Character> q = new LinkedList<>();
        for (char c : must.toCharArray()) {
            q.offer(c);
        }
        for (char c : plan.toCharArray()) {
            if (q.contains(c)) {
                if (q.peek() != c) {
                    return "NO";
                }
                else {
                    q.poll();
                }
            }
        }
        if (!q.isEmpty()) {
            return "NO";
        }
        return "YES";
    }


    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        String must = sc.next();
        String plan = sc.next();
        System.out.println(T.solution(must, plan));
    }
}
