package Section5_Stack_and_Queue.Remove_Characters_in_Brackets;

import java.util.Enumeration;
import java.util.Scanner;
import java.util.Stack;

public class Main_v2_lecture {

    public String solution(String str) {

        Stack<Character> stack = new Stack<>();
        StringBuilder answer = new StringBuilder();

        for (char x : str.toCharArray()) {
            if (x == ')') {
                while (stack.pop() != '(');
            }
            else {
                stack.push(x);
            }
        }

        for (char c : stack) {
            answer.append(c);
        }
        return answer.toString();
    }

    public static void main(String[] args) {

        Main_v2_lecture T = new Main_v2_lecture();
        Scanner sc = new Scanner(System.in);

        String str = sc.next();

        System.out.print(T.solution(str));
    }
}
