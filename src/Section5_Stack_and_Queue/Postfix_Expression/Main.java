package Section5_Stack_and_Queue.Postfix_Expression;

import java.util.Scanner;
import java.util.Stack;

public class Main {

    public int solution(String str) {

        Stack<Integer> stack = new Stack<>();
        for (char c : str.toCharArray()) {
            if (Character.isDigit(c)) {
                stack.push((((int) c) - 48));
            }
            else {
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
        }
        return stack.pop();
    }


    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        System.out.println(T.solution(str));
    }
}
