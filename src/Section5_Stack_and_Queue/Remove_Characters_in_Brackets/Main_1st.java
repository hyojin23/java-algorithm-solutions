package Section5_Stack_and_Queue.Remove_Characters_in_Brackets;

import java.util.Scanner;
import java.util.Stack;

public class Main_1st {

    public Stack<Character> solution(String str) {
        Stack<Character> answer = new Stack<>();
        for (char x : str.toCharArray()) {
            if (x == ')') {
                while (answer.pop() != '(');
            } else {
                answer.push(x);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Main_1st T = new Main_1st();
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        for (char x : T.solution(str)) {
            System.out.print(x);
        }
    }
}
