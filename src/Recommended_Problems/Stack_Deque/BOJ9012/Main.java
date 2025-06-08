package Recommended_Problems.Stack_Deque.BOJ9012;

import java.util.Scanner;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class Main {

    public List<String> solution(int T, String[] arr) {

        List<String> answer = new ArrayList<>();
        for (String str: arr) {
            Stack<Character> stack = new Stack<>();
            boolean findAnswer = false;
            for (char c : str.toCharArray()) {
                if (c == '(') {
                    stack.push(c);
                }
                else {
                    if (stack.isEmpty()) {
                        answer.add("NO");
                        findAnswer = true;
                        break;
                    }
                    else {
                        stack.pop();
                    }
                }
            }
            if (!findAnswer) {
                if (!stack.isEmpty()) {
                    answer.add("NO");
                }
                else {
                    answer.add("YES");
                }
            }
        }
        return answer;
    }


    public static void main(String[] args) {

        Main main = new Main();
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        sc.nextLine();
        String[] arr = new String[T];
        for (int i = 0; i < T; i++) {
            arr[i] = sc.nextLine();
        }
        for (String s : main.solution(T, arr)) {
            System.out.println(s);
        }
    }
}
