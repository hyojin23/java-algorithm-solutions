package Section1_String.Extract_Numbers_Only;

import java.util.Scanner;
// My solution
public class Main2 {

    public int solution(String str) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        char[] arr = str.toCharArray();
        for (char x : arr) {
            if (Character.isDigit(x)) {
                sb.append(x);
            }
        }

       answer = Integer.parseInt(sb.toString());
       return answer;
    }
    public static void main(String[] args) {
        Main2 T = new Main2();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(T.solution(str));
    }
}
