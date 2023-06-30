package Section5_Stack_and_Queue.Curriculum_Design;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_v2 {

    public String solution(String a, String b) {

        String answer;
        Queue<Character> Q = new LinkedList<>();

        for (int i = 0; i < a.length(); i++) {
            Q.offer(a.charAt(i));
        }

        for (int i = 0; i < b.length(); i++) {
            if (Q.contains(b.charAt(i)) && Q.peek() == b.charAt(i)) {
                Q.poll();
            }
            else if (Q.contains(b.charAt(i)) && Q.peek() != b.charAt(i)) {
                break;
            }
        }
        if (Q.isEmpty()) {
            answer = "YES";
        }
        else {
            answer = "NO";
        }
        return answer;
    }

    public static void main(String[] args) {

        Main_v2 T = new Main_v2();
        Scanner sc = new Scanner(System.in);

        String a = sc.next();
        String b = sc.next();

        System.out.println(T.solution(a, b));
    }
}
