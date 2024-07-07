package Section5_Stack_and_Queue.Correct_Bracket;

import java.util.Scanner;
import java.util.Stack;

public class Main {

    public String solution(String str) {

        Stack<Character> stack = new Stack<>();

        for (char c : str.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            }
            else {
                if (stack.isEmpty()) {
                    return "NO";
                }
                else {
                    stack.pop();
                }
            }
        }

        if (!stack.isEmpty()) {
            return "NO";
        }
        return "YES";
    }

    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        System.out.println(T.solution(str));
    }
}
