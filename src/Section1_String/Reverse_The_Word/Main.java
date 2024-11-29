package Section1_String.Reverse_The_Word;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main {

    public List<String> solution(String[] arr) {

        List<String> list = new ArrayList<>();
        for (String word : arr) {
            int lt = 0;
            int rt = word.length() - 1;
            char[] wordArr = word.toCharArray();
            while (lt < rt) {
                char tmp = wordArr[lt];
                wordArr[lt] = wordArr[rt];
                wordArr[rt] = tmp;
                lt++;
                rt--;
            }
            list.add(String.valueOf(wordArr));
        }
        return list;
    }


    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String[] arr = new String[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.next();
        }

        for (String s : T.solution(arr)) {
            System.out.println(s);
        }
    }
}
