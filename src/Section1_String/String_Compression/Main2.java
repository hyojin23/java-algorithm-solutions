package Section1_String.String_Compression;

import java.util.Scanner;
// My solution
public class Main2 {

    public String solution(String str) {
        String answer = "";
        char[] arr = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        boolean[] isChecked = new boolean[str.length()];

        for (int i = 0; i < str.length(); i++) {
            if (isChecked[i]) {
                continue;
            }
            int count = 0;
            for (int j = 0; j < str.length(); j++) {
                if (isChecked[j]) {
                    continue;
                }
                if (arr[i] == arr[j]) {
                    isChecked[j] = true;
                    count += 1;
                } else {
                    break;
                }
            }
            sb.append(arr[i]);
            if (count != 1) {
                sb.append(count);
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
