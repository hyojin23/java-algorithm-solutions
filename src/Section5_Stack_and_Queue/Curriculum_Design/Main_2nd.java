package Section5_Stack_and_Queue.Curriculum_Design;

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class Main_2nd {

    public String solution(String must, String plan) {

        String answer = "YES";
        Queue<Character> q = new LinkedList<>();

        for (char c : must.toCharArray()) {
            q.offer(c);
        }

        for (char c: plan.toCharArray()) {
            if (q.contains(c)) {
                if (q.poll() != c) {
                    return "NO";
                }
            }
        }

        if (!q.isEmpty()) {
            answer = "NO";
        }

        return answer;
    }

    public static void main(String[] args) {

        Main_2nd T = new Main_2nd();
        Scanner sc = new Scanner(System.in);

        String must = sc.next();
        String plan = sc.next();

        System.out.println(T.solution(must, plan));
    }
}
