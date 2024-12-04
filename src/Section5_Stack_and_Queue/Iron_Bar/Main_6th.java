package Section5_Stack_and_Queue.Iron_Bar;

import java.util.Scanner;
import java.util.Stack;

public class Main_6th {

    public int solution(String str) {

        Stack<Character> stack = new Stack<>();
        int len = str.length();
        int answer = 0;

        for (int i = 0; i < len; i++) {
            if (str.charAt(i) == ')') {
                if (str.charAt(i - 1) == '(') {
                    stack.pop();
                    answer += stack.size();
                }
                else {
                    answer++;
                    stack.pop();
                }
            }
            else {
                stack.push(str.charAt(i));
            }
        }
        return answer;
    }


    public static void main(String[] args) {

        Main_6th T = new Main_6th();
        Scanner sc = new Scanner(System.in);

        String str = sc.next();

        System.out.println(T.solution(str));
    }
}
