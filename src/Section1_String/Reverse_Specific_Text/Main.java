package Section1_String.Reverse_Specific_Text;

import java.util.Scanner;

public class Main {

    public String solution(String str) {
        String answer = "";
        int lt = 0;
        int rt = str.length() - 1;
        char[] s = str.toCharArray();

        while(lt<rt) {
            if (!Character.isAlphabetic(s[lt])) {
                lt++;
            } else if (!Character.isAlphabetic(s[rt])) {
                rt--;
            } else {
                char tmp = s[lt];
                s[lt] = s[rt];
                s[rt] = tmp;
                lt++;
                rt--;
            }
        }
        answer = String.valueOf(s);
        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(T.solution(str));

    }
}
