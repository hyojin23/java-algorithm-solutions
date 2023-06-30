package Section5_Stack_and_Queue.Iron_Bar;

import java.util.Scanner;
import java.util.Stack;

public class Main_v2 {

    public int solution(String str) {

        int answer = 0;
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i ++) {
            if (str.charAt(i) == '(') {
                stack.push(str.charAt(i));
            }
            else {
                stack.pop();
                if (str.charAt(i - 1) == '(') {
                    answer += stack.size();
                }
                else if (str.charAt(i - 1) == ')') {
                    answer += 1;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {

        Main_v2 T = new Main_v2();
        Scanner sc = new Scanner(System.in);

        String str = sc.next();

        System.out.println(T.solution(str));
    }
}
