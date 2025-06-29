package BOJ.BOJ17298;

import java.util.Scanner;
import java.util.Stack;

public class Main {

    public void solution(int N, int[] arr) {

        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int[] answer = new int[N];
        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty()) {
                if (arr[i] > arr[stack.peek()]) {
                    answer[stack.pop()] = arr[i];
                }
                else {
                    break;
                }
            }
            stack.add(i);
        }
        while (!stack.isEmpty()) {
            answer[stack.pop()] = -1;
        }
        for (int x : answer) {
            sb.append(x + " ");
        }
        System.out.println(sb);
    }


    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        T.solution(N, arr);
    }
}
