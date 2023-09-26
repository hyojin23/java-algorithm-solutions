package Section2_Array.Mountain_Top;

import java.util.Scanner;

public class Main_1st {
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};
    public int solution(int n, int[][] arr) {
        int answer = 0;
        for (int i=1; i<n+1; i++) {
            for (int j =1; j<n+1; j++) {
                boolean flag = true;
                for (int k=0; k<4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if (arr[nx][ny] >= arr[i][j]) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    answer++;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Main_1st T = new Main_1st();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n+2][n+2];
        for (int i=1; i<n+1; i++) {
            for (int j=1; j<n+1; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println(T.solution(n, arr));
    }
}
