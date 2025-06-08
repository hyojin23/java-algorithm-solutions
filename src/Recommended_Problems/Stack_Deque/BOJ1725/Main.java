package Recommended_Problems.Stack_Deque.BOJ1725;

import java.util.Scanner;
import java.util.Stack;

public class Main {

    public long solution(int N, int[] heights) {

        Stack<Integer> stack = new Stack<>();
        long maxArea = 0;
        for (int i = 0; i <= N; i++) {
            while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int width;
                if (stack.isEmpty()) {
                    width = i;
                }
                else {
                    width = i - stack.peek() - 1;
                }
                maxArea = Math.max(maxArea, ((long) width * height));
            }
            stack.push(i);
        }

        return maxArea;
    }


    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] heights = new int[N + 1];
        for (int i = 0; i < N; i++) {
            heights[i] = sc.nextInt();
        }
        System.out.println(T.solution(N, heights));
    }
}
