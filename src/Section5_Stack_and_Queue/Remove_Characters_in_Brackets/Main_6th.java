package Section5_Stack_and_Queue.Remove_Characters_in_Brackets;

import java.util.Scanner;
import java.util.Stack;

public class Main_6th {

    public String solution(String str) {

        Stack<Character> stack = new Stack<>();

        for (char c : str.toCharArray()) {
            if (c == ')') {
                while (stack.pop() != '(');
            }
            else {
                stack.push(c);
            }
        }

        StringBuilder answer = new StringBuilder();
        for (char c : stack) {
            answer.append(c);
        }
        return answer.toString();
    }


    public static void main(String[] args) {

        Main_6th T = new Main_6th();
        Scanner sc = new Scanner(System.in);

        String str = sc.next();

        System.out.println(T.solution(str));
    }
}
