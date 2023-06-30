package Section5_Stack_and_Queue.Postfix_Expression;

import java.util.Scanner;
import java.util.Stack;

public class Main_v2 {

    public int solution(String str) {

        int answer;
        Stack<Character> stack = new Stack<>();

        for (char c : str.toCharArray()) {
            stack.push(c);
            if (!Character.isDigit(c)) {
                stack.pop();
                int b = stack.pop() - 48;
                int a = stack.pop() - 48;

                switch (c) {
                    case '+':
                        stack.push((char) (a + b + 48));
                        break;
                    case '-':
                        stack.push((char) (a - b + 48));
                        break;
                    case '*':
                        stack.push((char) (a * b + 48));
                        break;
                    case '/':
                        stack.push((char) (a / b + 48) );
                        break;
                }
            }
        }
        answer = stack.get(0) - 48;
        return answer;
    }

    public static void main(String[] args) {

        Main_v2 T = new Main_v2();
        Scanner sc = new Scanner(System.in);

        String str = sc.next();

        System.out.println(T.solution(str));
    }
}
