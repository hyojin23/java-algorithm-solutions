package BOJ.BOJ16637;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

    static int N;
    static int[] nums;
    static char[] ops;
    static int answer = Integer.MIN_VALUE;

    public static int solution(int N, String line) {

        int numCount = (N + 1) / 2;
        nums = new int[numCount];
        ops = new char[numCount - 1];

        for (int i = 0; i < N; i++) {
            if (i % 2 == 0) {
                nums[i / 2] = line.charAt(i) - '0';
            }
            else {
                ops[i / 2] = line.charAt(i);
            }
        }

        dfs(1, nums[0]);

        return answer;
    }

    public static void dfs(int index, int current) {

        if (index >= nums.length) {
            answer = Math.max(answer, current);
            return;
        }

        int val = calc(current, nums[index], ops[index - 1]);
        dfs(index + 1, val);

        if (index + 1 < nums.length) {
            int bracket = calc(nums[index], nums[index + 1], ops[index]);
            val = calc(current, bracket, ops[index - 1]);
            dfs(index + 2, val);
        }
    }

    public static int calc(int a, int b, char op) {
        switch (op) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            default:
                return 0;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        String line = br.readLine();

        System.out.println(solution(N, line));
    }
}
