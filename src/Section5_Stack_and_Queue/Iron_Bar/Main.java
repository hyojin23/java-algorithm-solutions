package Section5_Stack_and_Queue.Iron_Bar;

import java.util.Scanner;
import java.util.Stack;

public class Main {

    public int solution(String str) {

        Stack<Character> stack = new Stack<>();
        int answer = 0;
        int len = str.length();
        char[] arr = str.toCharArray();

        for (int i = 0; i < len; i++) {
            if (arr[i] == ')' && arr[i - 1] == '(') {
                stack.pop();
                answer += stack.size();
            }
            else if (arr[i] == ')' && arr[i - 1] == ')') {
                answer++;
                stack.pop();
            }
            else {
                stack.push(arr[i]);
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
