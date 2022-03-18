package Section5_Stack_and_Queue.Curriculum_Design;

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class Main {

    public String solution(String m, String p) {
        String answer = "YES";
        Queue<Character> q = new LinkedList<>();
        for (char x : m.toCharArray()) {
            q.offer(x);
        }
        for (char x : p.toCharArray()) {
            if (q.contains(x)) {
                if (x != q.poll()) {
                    return  "NO";
                }
            }
        }
        if (!q.isEmpty()) return "NO";
        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        String m = sc.nextLine();
        String p = sc.nextLine();
        System.out.println(T.solution(m, p));
    }
}
