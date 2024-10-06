package Section5_Stack_and_Queue.Postfix_Expression;

import java.util.Scanner;
import java.util.Stack;

public class Main_4th {

    public int solution(String str) {

        Stack<Integer> stack = new Stack<>();

        for (char c : str.toCharArray()) {
            if (Character.isDigit(c)) {
                stack.push(c - 48);
            }
            else {
                int b = stack.pop();
                int a = stack.pop();
                int res;
                if (c == '+') {
                    res = a + b;
                }
                else if (c == '-') {
                    res = a - b;
                }
                else if (c == '*') {
                    res = a * b;
                }
                else {
                    res = a / b;
                }
                stack.push(res);
            }
        }
        return stack.get(0);
    }

    public static void main(String[] args) {

        Main_4th T = new Main_4th();
        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        System.out.println(T.solution(str));
    }
}
