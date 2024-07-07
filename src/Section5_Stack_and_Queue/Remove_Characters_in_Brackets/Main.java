package Section5_Stack_and_Queue.Remove_Characters_in_Brackets;

import java.util.Scanner;
import java.util.Stack;

public class Main {

    public void solution(String str) {

        Stack<Character> stack = new Stack<>();

        for (char c : str.toCharArray()) {
            if (c == ')') {
                while (stack.pop() != '(') {

                }
            }
            else {
                stack.push(c);
            }
        }

        for (char c : stack) {
            System.out.print(c);
        }
    }

    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        T.solution(str);
    }
}