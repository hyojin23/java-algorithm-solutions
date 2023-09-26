package Section1_String.String_Compression;

import java.util.Scanner;

public class Main_1st {
    public String solution(String str) {
        String answer = "";
        str = str + " ";
        StringBuilder sb = new StringBuilder();
        int count = 1;
        for (int i=0; i<str.length()-1; i++) {
            if (str.charAt(i) == str.charAt(i+1)) {
                count++;
            } else {
                sb.append(str.charAt(i));
                if (count>1) {
                    sb.append(count);
                }
                count = 1;
            }
        }
        answer = sb.toString();
        return answer;
    }
    public static void main(String[] args) {
        Main_1st T = new Main_1st();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(T.solution(str));

    }
}
