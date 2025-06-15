package Recommended_Problems.Stack_Deque.BOJ2493;

import java.util.Stack;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

class Tower {

    int o, h;

    Tower(int o, int h) {
        this.o = o;
        this.h = h;
    }
}

public class Main {

    public void solution(int N, int[] heights) {

        Stack<Tower> stack = new Stack<>();
        int[] answer = new int[N];
        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty()) {
                if (stack.peek().h > heights[i]) {
                    answer[i] = stack.peek().o;
                    break;
                }
                else {
                    stack.pop();
                }
            }
            if (stack.isEmpty()) {
                answer[i] = 0;
            }
            stack.push(new Tower(i + 1, heights[i]));
        }
        for (int x : answer) {
            System.out.print(x + " ");
        }
    }


    public static void main(String[] args) throws IOException {

        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] heights = new int[N];
        for (int i = 0; i < N; i++) {
            heights[i] = Integer.parseInt(st.nextToken());
        }
        T.solution(N, heights);
    }
}
