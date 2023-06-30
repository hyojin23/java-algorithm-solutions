package Section5_Stack_and_Queue.Correct_Bracket;

import java.util.Scanner;
import java.util.Stack;

public class Main_v2 {

    public String solution(String str) {

        Stack<Character> stack = new Stack<>();

        for (char c : str.toCharArray()) {
            if (c == '(')
                stack.push(c);
            else if (c == ')') {
                if (stack.isEmpty())
                    return "NO";
                stack.pop();
            }
        }
        if (!stack.isEmpty())
            return "NO";
        return "YES";
    }

    public static void main(String[] args) {

        Main_v2 T = new Main_v2();
        Scanner sc = new Scanner(System.in);

        String str = sc.next();

        System.out.println(T.solution(str));
    }




}
