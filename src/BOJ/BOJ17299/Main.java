package BOJ.BOJ17299;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Stack;

public class Main {

    public static int[] solution(int N, int[] arr, int[] freq) {

        Stack<Integer> stack = new Stack<>();
        int[] result = new int[N];

        for (int i = 0; i < N; i++) {
            while(!stack.isEmpty() && freq[arr[i]] > freq[arr[stack.peek()]]) {
                result[stack.pop()] = arr[i];
            }
            stack.push(i);
        }

        while(!stack.isEmpty()) {
            result[stack.pop()] = -1;
        }

        return result;
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] freq = new int[1_000_001];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
            freq[num]++;
        }

        int[] answer = solution(N, arr, freq);

        StringBuilder sb = new StringBuilder();
        for (int num : answer) {
            sb.append(num).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}
