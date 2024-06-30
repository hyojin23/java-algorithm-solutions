package Section5_Stack_and_Queue.Postfix_Expression;

import java.util.Scanner;
import java.util.Stack;

public class Main {

    public int solution(String str) {

        Stack<Integer> stack = new Stack<>();

        for (char c : str.toCharArray()) {

            if (Character.isDigit(c)) {
                stack.add(c - 48);
            }
            else {
                int s2 = stack.pop();
                int s1 = stack.pop();

                switch (c) {

                    case '+':
                        stack.add(s1 + s2);
                        break;

                    case '-':
                        stack.add(s1 - s2);
                        break;

                    case '*':
                        stack.add(s1 * s2);
                        break;

                    case '/':
                        stack.add(s1 / s2);
                        break;
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
