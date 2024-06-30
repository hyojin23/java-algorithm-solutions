package Section5_Stack_and_Queue.Curriculum_Design;

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class Main {

    public String solution(String odr, String plan) {

        Queue<Character> q = new LinkedList<>();

        for (int i = 0; i < odr.length(); i++) {
            q.offer(odr.charAt(i));
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

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        String odr = sc.next();
        String plan = sc.next();

        System.out.println(T.solution(odr, plan));
    }
}
