package Section5_Stack_and_Queue.Iron_Bar;

import java.util.Scanner;
import java.util.Stack;

public class Main_2nd {

    public int solution(String str) {

        int answer = 0;
        Stack<Character> stack = new Stack<>();

        char[] arr = str.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '(') {
                stack.push(arr[i]);
            }
            else if (arr[i] == ')') {
                stack.pop();
                if (arr[i - 1] == '(') {
                    answer += stack.size();
                }
                else {
                    answer += 1;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        Main_2nd T = new Main_2nd();
        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        System.out.println(T.solution(str));
    }
}
