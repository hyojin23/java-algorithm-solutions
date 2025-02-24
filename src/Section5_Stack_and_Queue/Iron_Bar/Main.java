package Section5_Stack_and_Queue.Iron_Bar;

import java.util.Scanner;
import java.util.Stack;

public class Main {

    public int solution(String str) {

        Stack<Character> stack = new Stack<>();
        int answer = 0;
        int n = str.length();
        for (int i = 0; i < n; i++) {
            if (str.charAt(i) == ')') {
                stack.pop();
                if (str.charAt(i - 1) == '(') {
                    answer += stack.size();
                }
                else {
                    answer++;
                }
            }
            else {
                stack.push('(');
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
