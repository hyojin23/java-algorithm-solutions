package Section1_String.Remove_Duplicate_Characters;

import java.util.Scanner;
// My solution
public class Main2 {

    public String solution(String str) {
        String answer = "";
        char[] arr = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        boolean[] isChecked = new boolean[arr.length];

        for (int i = 0; i < arr.length; i++) {
            int isSame = 0;
            if (isChecked[i]) {
                continue;
            }
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    isSame++;
                    isChecked[j] = true;
                }
            }
            if (isSame >= 1) {
                sb.append(arr[i]);
            }
        }
        answer = sb.toString();
        return answer;
    }

    public static void main(String[] args) {
        Main2 T = new Main2();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(T.solution(str));

    }
}
