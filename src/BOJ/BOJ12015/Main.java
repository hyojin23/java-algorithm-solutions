package BOJ.BOJ12015;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;

public class Main {

    public int lowerBound(int target, List<Integer> dp) {

        int lt = 0;
        int rt = dp.size();
        while (lt < rt) {
            int mid = (lt + rt) / 2;
            if (target > dp.get(mid)) {
                lt = mid + 1;
            }
            else {
                rt = mid;
            }
        }
        return lt;
    }

    public int solution(int N, int[] arr) {

        List<Integer> dp = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int size = dp.size();
            if (dp.isEmpty()) {
                dp.add(arr[i]);
            }
            else {
                if (arr[i] > dp.get(size - 1)) {
                    dp.add(arr[i]);
                }
                else {
                    int idx = lowerBound(arr[i], dp);
                    dp.set(idx, arr[i]);
                }
            }
        }
        return dp.size();
    }


    public static void main(String[] args) throws IOException {

        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(T.solution(N, arr));
    }
}
