package Section4_HashMap_and_TreeSet.Types_of_Sales;

import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;

// My solution
public class Main2 {

    public ArrayList<Integer> solution(int n, int k, int[] arr) {
        int rt = k - 1;
        ArrayList<Integer> answer = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n - k + 1; i++) {
            if (i == 0) {
                for (int j = 0; j < k; j++) {
                    map.put(arr[j], map.getOrDefault(arr[j], 0) + 1);
                }
            } else {
                map.put(arr[i-1], map.getOrDefault(arr[i-1], 0) - 1);
                if (map.get(arr[i-1]) == 0) {
                    map.remove(arr[i-1]);
                }
                rt++;
                map.put(arr[rt], map.getOrDefault(arr[rt], 0) + 1);
            }
            answer.add(map.size());
        }
        return answer;
    }

    public static void main(String[] args) {
        Main2 T = new Main2();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        for (int x : T.solution(n, k, arr)) {
            System.out.print(x + " ");
        }
    }
}
