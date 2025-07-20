package BOJ.BOJ2504;

import java.util.Scanner;
import java.util.Stack;

public class Main {

    public int solution(String str) {

        Stack<Character> stack = new Stack<>();
        int tmp = 1;
        int answer = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '(') {
                stack.push(c);
                tmp *= 2;
            }
            else if (c == '[') {
                stack.push(c);
                tmp *= 3;
            }
            else if (c == ')') {
                if (!stack.isEmpty() && stack.peek() == '(') {
                    if (str.charAt(i - 1) == '(') {
                        answer += tmp;
                    }
                    stack.pop();
                    tmp /= 2;
                }
                else {
                    answer = 0;
                    break;
                }
            }
            else if (c == ']') {
                if (!stack.isEmpty() && stack.peek() == '[') {
                    if (str.charAt(i - 1) == '[') {
                        answer += tmp;
                    }
                    stack.pop();
                    tmp /= 3;
                }
                else {
                    answer = 0;
                    break;
                }
            }
        }
        if (!stack.isEmpty()) {
            return 0;
        }
        else {
            return answer;
        }
    }


    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc  = new Scanner(System.in);

        String str = sc.nextLine();
        System.out.println(T.solution(str));
    }
}
