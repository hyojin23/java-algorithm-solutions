package Section5_Stack_and_Queue.Postfix_Expression;

import java.util.Scanner;
import java.util.Stack;

public class Main_1st {

    public int solution(String str) {
        int answer;
        Stack<Integer> stack = new Stack<>();
        for (char x : str.toCharArray()) {
            if (Character.isDigit(x)) {
                stack.push(x-48);
            } else {
                int rt = stack.pop();
                int lt = stack.pop();
                if (x == '+')  {
                    stack.push(lt+rt);
                } else if (x == '-') {
                    stack.push(lt-rt);
                } else if (x == '*') {
                    stack.push(lt*rt);
                } else {
                    stack.push(lt/rt);
                }
            }
        }
        answer = stack.get(0);
        return answer;
    }

    public static void main(String[] args) {
        Main_1st T = new Main_1st();
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(T.solution(str));
    }
}
