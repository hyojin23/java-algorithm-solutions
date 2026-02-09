package BOJ.BOJ1613;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        boolean[][] isBefore = new boolean[n + 1][n + 1];

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            isBefore[a][b] = true;
        }

        for (int l = 1; l <= n; l++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (isBefore[i][l] && isBefore[l][j]) {
                        isBefore[i][j] = true;
                    }
                }
            }
        }

        int s = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (isBefore[a][b]) {
                sb.append(-1).append("\n");
            }
            else if (isBefore[b][a]) {
                sb.append(1).append("\n");
            }
            else {
                sb.append(0).append("\n");
            }
        }

        System.out.println(sb.toString().trim());
    }
}
