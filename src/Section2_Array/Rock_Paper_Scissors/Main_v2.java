package Section2_Array.Rock_Paper_Scissors;

import java.util.Scanner;

public class Main_v2 {

    public String[] solution(int n, int[] a, int[] b) {

        String[] winner = new String[n];

        for (int i = 0; i < n; i++) {
            if (a[i] == b[i])
                winner[i] = "D";
            else if (a[i] == 1 && b[i] == 3)
                winner[i] = "A";
            else if (a[i] == 2 && b[i] == 1)
                winner[i] = "A";
            else if (a[i] == 3 && b[i] == 2)
                winner[i] = "A";
            else
                winner[i] = "B";
        }
        return winner;
    }

    public static void main(String[] args) {

        Main_v2 T = new Main_v2();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n]; 
        int[] b = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            b[i] = sc.nextInt();
        }

        for (String s : T.solution(n, a, b))
            System.out.println(s);
    }
}
