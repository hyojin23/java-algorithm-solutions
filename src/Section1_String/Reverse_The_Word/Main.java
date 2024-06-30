package Section1_String.Reverse_The_Word;

import java.util.Scanner;

public class Main {

    public String[] solution(int n, String[] arr) {

        String[] newArr = new String[n];

        for (int i = 0; i < n; i++) {

            char[] charArr = arr[i].toCharArray();
            int lt = 0;
            int rt = arr[i].length() - 1;

            while (lt < rt) {
                char tmp = charArr[lt];
                charArr[lt] = charArr[rt];
                charArr[rt] = tmp;
                lt++;
                rt--;
            }

            newArr[i] = String.valueOf(charArr);
        }

        return newArr;
    }


    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String[] arr = new String[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.next();
        }

        for (String s : T.solution(n, arr)) {
            System.out.println(s);
        }
    }
}
