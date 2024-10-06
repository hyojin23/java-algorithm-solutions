package Section5_Stack_and_Queue.Iron_Bar;

import java.util.Scanner;
import java.util.Stack;

public class Main_4th {

    public int solution(String str) {

        int answer = 0;
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {

            if (str.charAt(i) == '(') {
                stack.push(str.charAt(i));
            }
            else if (str.charAt(i - 1) == '(') {
                stack.pop();
                answer += stack.size();
            }
            else {
                stack.pop();
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {

        Main_4th T = new Main_4th();
        Scanner sc = new Scanner(System.in);

        String str = sc.next();

        System.out.println(T.solution(str));
    }
}
