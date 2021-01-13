package baekjon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

//안정적인 문자열
public class boj4889 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack = new Stack<>();
        int caseCount = 1;

        while (true) {
            String input = br.readLine();

            if (input.contains("-")) break;

            char[] strings = input.toCharArray();
            int cnt = 0;
            for (int i=0; i<strings.length; i++) {
                if (stack.isEmpty() && strings[i] == '}') {
                    stack.push('{');
                    cnt++;
                } else if (strings[i] == '{') {
                    stack.push('{');
                } else {
                    stack.pop();
                }
            }

            cnt += stack.size() / 2;
            System.out.printf("%d. %d\n", caseCount++, cnt);
            stack.clear();
        }
    }
}
