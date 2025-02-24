package Section5_Stack_and_Queue.Iron_Bar;

import java.util.Scanner;
import java.util.Stack;

public class Main_7th {

    public int solution(String str) {

        Stack<Character> stack = new Stack<>();
        int sum = 0;
        int len = str.length();
        char[] strArr = str.toCharArray();
        for (int i = 0; i < len; i++) {
            if (strArr[i] == ')') {
                if (strArr[i - 1] == '(') {
                    stack.pop();
                    sum += stack.size();
                }
                else {
                    stack.pop();
                    sum += 1;
                }
            }
            else if (strArr[i] == '(') {
                stack.push(strArr[i]);
            }
        }
        return sum;
    }


    public static void main(String[] args) {

        Main_7th T = new Main_7th();
        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        System.out.println(T.solution(str));
    }
}
