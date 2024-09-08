package Section1_String.Reverse_Specific_Text;

import java.util.Scanner;

public class Main_4th {

    public String solution(String str) {

        String answer = "";
        char[] charArr = str.toCharArray();

        int lt = 0;
        int rt = str.length() - 1;

        while (lt < rt) {

            if (Character.isAlphabetic(charArr[lt]) && Character.isAlphabetic(charArr[rt])) {
                char tmp = charArr[lt];
                charArr[lt] = charArr[rt];
                charArr[rt] = tmp;
                lt++;
                rt--;
            }
            else if (Character.isAlphabetic(charArr[lt])) {
                rt--;
            }
            else {
                lt++;
            }
        }

        answer = String.valueOf(charArr);

        return answer;
    }

    public static void main(String[] args) {

        Main_4th T = new Main_4th();
        Scanner sc = new Scanner(System.in);

        String str = sc.next();

        System.out.println(T.solution(str));
    }
}

