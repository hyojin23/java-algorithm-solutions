package BOJ.BOJ1874;

import java.util.Scanner;
import java.util.Stack;

public class Main {

    public void solution(int[] arr) {

        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int s = 1;
        for (int num : arr) {
            if (stack.isEmpty() || stack.peek() != num) {
                for (int i = s; i <= num; i++) {
                    stack.push(i);
                    sb.append('+').append('\n');
                }
                s = num + 1;
            }
            if (stack.peek() == num) {
                stack.pop();
                sb.append('-').append('\n');
            }
            else if (stack.peek() > num) {
                sb.setLength(0);
                sb.append("NO");
                break;
            }
        }
        System.out.println(sb);
    }


    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        T.solution(arr);
    }
}
