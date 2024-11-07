package Section5_Stack_and_Queue.Remove_Characters_in_Brackets;

import java.util.Scanner;
import java.util.Stack;

public class Main_5th {

    public Stack<Character> solution(String str) {

        Stack<Character> stack = new Stack<>();

        for (char c : str.toCharArray()) {
            if (c == ')') {
                while (stack.pop() != '(') {
                    continue;
                }
            }
            else {
                stack.push(c);
            }
        }
        return stack;
    }


    public static void main(String[] args) {

        Main_5th T = new Main_5th();
        Scanner sc = new Scanner(System.in);

        String str = sc.next();

        for (char c : T.solution(str)) {
            System.out.print(c);
        }
    }
}
