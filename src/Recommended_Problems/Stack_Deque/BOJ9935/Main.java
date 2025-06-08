package Recommended_Problems.Stack_Deque.BOJ9935;

import java.util.Stack;
import java.util.Scanner;

public class Main {

    public void solution(String s, String t) {

        Stack<Character> stack = new Stack<>();
        int len = t.length();
        for (char c : s.toCharArray()) {
            stack.push(c);
            if (stack.size() >= len) {
                boolean isSame = true;
                for (int i = 0; i < len; i++) {
                    if (stack.get(stack.size() - len + i) != t.charAt(i)) {
                        isSame = false;
                        break;
                    }
                }
                if (isSame) {
                    for (int i = 0; i < len; i++) {
                        stack.pop();
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char c : stack) {
            sb.append(c);
        }
        if (stack.isEmpty()) {
            System.out.println("FRULA");
        }
        else {
            System.out.println(sb);
        }
    }


    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        String t = sc.nextLine();
        T.solution(s, t);
    }
}
