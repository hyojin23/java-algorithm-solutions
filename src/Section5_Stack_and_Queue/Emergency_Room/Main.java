package Section5_Stack_and_Queue.Emergency_Room;

import java.util.Scanner;

public class Main {

    public int solution(int n, int m, int[] arr) {

        


    }


    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc =  new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(T.solution(n, m, arr));
    }
}
