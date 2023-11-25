package Section6_Sorting_and_Searching.Mischievous_Boy;

import java.util.Scanner;
import java.util.ArrayList;

public class Main_1st {

    public ArrayList<Integer> solution(int n, int[] arr) {
        ArrayList<Integer> answer = new ArrayList<>();
        int[] tmp = arr.clone();
        for (int i=0; i<n-1; i++) {
           int idx = i, j;
           for (j=i+1; j<n; j++) {
               if (arr[idx] > arr[j]) {
                   idx = j;
               }
            }
           int t = arr[i];
           arr[i] = arr[idx];
           arr[idx] = t;
        }
        for (int i=0; i<n; i++) {
            if (arr[i] != tmp[i]) answer.add(i+1);
        }
        return answer;
    }

    public static void main(String[] args) {
        Main_1st T = new Main_1st();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }
        for (int x : T.solution(n, arr)) {
            System.out.print(x + " ");
        }
    }
}
