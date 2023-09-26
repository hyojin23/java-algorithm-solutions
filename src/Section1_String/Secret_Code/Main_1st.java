package Section1_String.Secret_Code;

import java.util.Scanner;

public class Main_1st {

    public String solution(int c, String str) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<c; i++) {
             String tmp = str.substring(0, 7).replace("#", "1").replace("*", "0");
             int num =  Integer.parseInt(tmp, 2);
             char alp = (char) num;
             sb.append(alp);
             str = str.substring(7);
        }
        answer = sb.toString();
        return answer;
    }

    public static void main(String[] args) {
        Main_1st T = new Main_1st();
        Scanner sc = new Scanner(System.in);
        int c = sc.nextInt();
        String str = sc.next();
        System.out.println(T.solution(c, str));
    }
}