package Section5_Stack_and_Queue.Postfix_Expression;

import java.util.Scanner;
import java.util.Stack;

public class Main_6th {

    public int solution(String str) {

        Stack<Integer> stack = new Stack<>();
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) {
                int b = stack.pop();
                int a = stack.pop();
                if (c == '+') {
                    stack.push(a + b);
                }
                else if (c == '-') {
                    stack.push(a - b);
                }
                else if (c == '*') {
                    stack.push(a * b);
                }
                else if (c == '/') {
                    stack.push(a / b);
                }
            }
            else {
                stack.push(c - 48);
            }
        }
        return stack.get(0);
    }


    public static void main(String[] args) {

        Main_6th T = new Main_6th();
        Scanner sc = new Scanner(System.in);

        String str = sc.next();

        System.out.println(T.solution(str));
    }
}
