package Section1_String.Reverse_The_Word;

import java.util.ArrayList;
import java.util.Scanner;

public class Main_v2 {

    public ArrayList<String> solution(String[] arr) {

        ArrayList<String> answer = new ArrayList<>();
        for (String s : arr) {
            char[] wordArr = s.toCharArray();
            int lt = 0, rt = wordArr.length - 1;
            char tmp;
            while (lt < rt) {
                tmp = wordArr[lt];
                wordArr[lt] = wordArr[rt];
                wordArr[rt] = tmp;
                lt++;
                rt--;
            }
            answer.add(String.valueOf(wordArr));
        }
        return answer;
    }

    public static void main(String[] args) {

        Main_v2 T = new Main_v2();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.next();
        }
        for (String s : T.solution(arr))
            System.out.println(s);
    }
}
