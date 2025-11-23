package BOJ.BOJ1918;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

public class Main {

    public String solution(String input) {

        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (char x : input.toCharArray()) {
            if (x >= 'A' && x <= 'Z') {
                sb.append(x);
            }
            else if (x == '(') {
                stack.push(x);
            }
            else if (x == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    sb.append(stack.pop());
                }
                stack.pop();
            }
            else {
                while (!stack.isEmpty() && getPrecedence(stack.peek()) >= getPrecedence(x)) {
                    sb.append(stack.pop());
                }
                stack.push(x);
            }
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }

    public int getPrecedence(char c) {
        if (c == '+' || c == '-') {
            return 1;
        }
        else if (c == '*' || c == '/') {
            return 2;
        }
        return 0;
    }


    public static void main(String[] args) throws IOException {

        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println(T.solution(br.readLine()));
    }
}
