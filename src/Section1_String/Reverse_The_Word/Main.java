package Section1_String.Reverse_The_Word;

import java.util.Scanner;

public class Main {

    public String[] solution(int n, String[] arr) {
        String[] answer = new String[n];
        for (int i = 0; i < n; i++) {
            int lt = 0, rt = arr[i].length() - 1;
            char[] chArr = arr[i].toCharArray();
            while (lt < rt) {
                char tmp = chArr[lt];
                chArr[lt] = chArr[rt];
                chArr[rt] = tmp;
                lt++;
                rt--;
            }
            answer[i] = String.valueOf(chArr);
        }
        return answer;
    }


    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.next();
        }
        for (String word : T.solution(n, arr)) {
            System.out.println(word);
        }
    }
}
