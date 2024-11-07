package Section5_Stack_and_Queue.Correct_Bracket;

import java.util.Scanner;
import java.util.Stack;

public class Main_5th {

    public String solution(String str) {

        Stack<Character> stack = new Stack<>();

        for (char c : str.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            }
            else if (!stack.isEmpty()) {
                stack.pop();
            }
            else {
                return "NO";
            }
        }

        if (stack.isEmpty()) {
            return "YES";
        }

        return "NO";
    }


    public static void main(String[] args) {

        Main_5th T = new Main_5th();
        Scanner sc = new Scanner(System.in);

        String str = sc.next();

        System.out.println(T.solution(str));
    }
}
