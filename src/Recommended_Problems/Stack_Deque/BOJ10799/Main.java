package Recommended_Problems.Stack_Deque.BOJ10799;

import java.util.Scanner;
import java.util.Stack;

public class Main {

    public int solution(String str) {

        Stack<Character> stack = new Stack<>();
        int answer = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                stack.push(str.charAt(i));
            }
            else {
                if (str.charAt(i - 1) == '(') {
                    stack.pop();
                    answer += stack.size();
                }
                else {
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

        String str = sc.nextLine();
        System.out.println(T.solution(str));
    }
}
