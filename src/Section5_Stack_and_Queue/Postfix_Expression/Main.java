package Section5_Stack_and_Queue.Postfix_Expression;

import java.util.Scanner;
import java.util.Stack;

public class Main {

    public int solution(String str) {

        Stack<Integer> stack = new Stack<>();

        for (char c : str.toCharArray()) {
            if (Character.isDigit(c)) {
                stack.push((c - 48));
            }
            else {
                int i2 = stack.pop();
                int i1 = stack.pop();
                int res = 0;
                if (c == '+') {
                    res = i1 + i2;
                }
                else if (c == '-') {
                    res = i1 - i2;
                }
                else if (c == '*') {
                    res = i1 * i2;
                }
                else if (c == '/') {
                    res = i1 / i2;
                }
                stack.push(res);
            }
        }
        return stack.peek();
    }

    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        String str = sc.next();

        System.out.println(T.solution(str));
    }
}
