package Section5_Stack_and_Queue.Curriculum_Design;

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class Main_1st {

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
        Main_1st T = new Main_1st();
        Scanner sc = new Scanner(System.in);
        String m = sc.nextLine();
        String p = sc.nextLine();
        System.out.println(T.solution(m, p));
    }
}
