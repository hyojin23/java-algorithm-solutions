package Section1_String.Extract_Numbers_Only;

import java.util.Scanner;

public class Main_4th {

    public int solution(String str) {

        int answer = 0;
        StringBuilder sb = new StringBuilder();

        for (char c : str.toCharArray()) {

            if (Character.isDigit(c)) {
                sb.append(c);
            }
        }

        answer = Integer.parseInt(sb.toString());

        return answer;
    }

    public static void main(String[] args) {

        Main_4th T = new Main_4th();
        Scanner sc = new Scanner(System.in);

        String str = sc.next();

        System.out.println(T.solution(str));
    }
}
