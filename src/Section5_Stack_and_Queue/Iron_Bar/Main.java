package Section5_Stack_and_Queue.Iron_Bar;

import java.util.Scanner;
import java.util.Stack;

public class Main {

    public int solution(String str) {

        Stack<Character> stack = new Stack<>();
        int answer = 0;

        for (int i = 0; i < str.length(); i++) {

            char c = str.charAt(i);

            if (c == '(') {
                stack.push(c);
            }
            else if (c == ')'){
                if (str.charAt(i - 1) == '(') {
                    stack.pop();
                    answer += stack.size();
                }
                else if (str.charAt(i - 1) == ')') {
                    stack.pop();
                    answer++;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        String str = sc.next();

        System.out.println(T.solution(str));
    }
}
