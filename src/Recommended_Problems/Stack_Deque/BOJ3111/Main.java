package Recommended_Problems.Stack_Deque.BOJ3111;

import java.util.Scanner;
import java.util.Stack;

public class Main {

    public void solution(String A, String T) {

        Stack<Character> left = new Stack<>();
        Stack<Character> right = new Stack<>();
        int lt = 0;
        int rt = T.length() - 1;
        int dir = 0;
        int aLen = A.length();
        while (lt <= rt) {
            if (dir == 0) {
                left.push(T.charAt(lt++));
                if (left.size() >= aLen && endsWith(left, A)) {
                    for (int i = 0; i < aLen; i++) {
                        left.pop();
                    }
                dir = 1;
                }
            }
            else {
                right.push(T.charAt(rt--));
                if (right.size() >= aLen && endsWith(right, new StringBuilder(A).reverse().toString())) {
                    for (int i = 0; i < aLen; i++) {
                        right.pop();
                    }
                dir = 0;
                }
            }
        }
        while (!right.isEmpty()) {
            left.push(right.pop());
        }
        StringBuilder sb = new StringBuilder();
        for (char c : left) {
            sb.append(c);
        }
        while (true) {
            int idx = sb.indexOf(A);
            if (idx < 0) {
                break;
            }
            sb.delete(idx, idx + aLen);
        }
        System.out.println(sb);
    }

    public boolean endsWith(Stack<Character> stack, String pattern) {
        int n = pattern.length();
        int idx = stack.size() - n;
        for (int i = 0; i < n; i++) {
            if (stack.get(idx + i) != pattern.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        Main main = new Main();
        Scanner sc = new Scanner(System.in);

        String A = sc.nextLine();
        String T = sc.nextLine();
        main.solution(A, T);
    }
}
