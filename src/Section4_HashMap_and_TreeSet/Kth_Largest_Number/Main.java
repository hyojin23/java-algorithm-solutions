package Section4_HashMap_and_TreeSet.Kth_Largest_Number;

import java.util.Scanner;
import java.util.TreeSet;
import java.util.Collections;

public class Main {

    public int solution(int n, int k, int[] arr) {
        int answer = -1;
        TreeSet<Integer> Tset = new TreeSet<>(Collections.reverseOrder());
        for (int i=0; i<n; i++) {
            for (int j=i+1; j<n; j++) {
                for (int l=j+1; l<n; l++) {
                    Tset.add(arr[i]+arr[j]+arr[l]);
                }
            }
        }
//        Tset.remove(143);
//        System.out.println(Tset.size());
//        System.out.println(Tset.first());
//        System.out.println(Tset.last());
        int count = 0;
        for (int x : Tset) {
            count++;
            if (count == k) {
                return x;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(T.solution(n, k, arr));
    }
}
