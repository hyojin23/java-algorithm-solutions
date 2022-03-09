package Section2_Array.Print_Big_Number;

import java.util.Scanner;
import java.util.ArrayList;
// My solution
public class Main2 {

    public ArrayList<Integer> solution(int n, String str) {
        ArrayList<Integer> answer = new ArrayList<>();
        String[] arr = str.split(" ");

        for (int i = 0; i < n; i++) {
            if (i == 0) {
                answer.add(Integer.parseInt(arr[i]));
            } else if (Integer.parseInt(arr[i]) > Integer.parseInt(arr[i - 1])) {
                answer.add(Integer.parseInt(arr[i]));
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Main2 T = new Main2();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String str = sc.nextLine();
        for (int x : T.solution(n, str)) {
            System.out.print(x + " ");
        }
    }
}
