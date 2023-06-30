package Section5_Stack_and_Queue.Remove_Characters_in_Brackets;

import java.util.Enumeration;
import java.util.Scanner;
import java.util.Stack;

public class Main_v2 {

    public void solution(String str) {

        Stack<Character> stack = new Stack<>();

        for (char x : str.toCharArray()) {
            if (x == ')') {
                while (true) {
                    char c = stack.pop();
                    if (c == '(')
                        break;
                }
            }
            else {
                stack.push(x);
            }
        }

        for (Enumeration<Character> enu = stack.elements(); enu.hasMoreElements();) {
            char c = enu.nextElement();
            System.out.print(c);
        }
    }

    public static void main(String[] args) {

        Main_v2 T = new Main_v2();
        Scanner sc = new Scanner(System.in);

        String str = sc.next();

        T.solution(str);
    }
}
