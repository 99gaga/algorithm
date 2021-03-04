package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    public static void main(String[] args) {
        int n = 3;

        List<String> result = generateParenthesis(n);

        for (String brackets : result) {
            System.out.println(brackets);
        }
    }

    /**
     * backtracking
     * recursion + termination check
     * @param n 괄호 쌍 갯수
     * @return n개의 올바른 괄호 쌍 경우의 수를 List에 담아 반환하라.
     */
    public static List<String> generateParenthesis(int n) {
        List<String> ret = new ArrayList<>();
        process(n, 0, 0, "", ret); // recurse
        return ret;
    }

    // numClosed > numOpen -> invalid
    public static void process(int n, int numOpen, int numClosed, String str, List<String> ret) {
        //termination check
        if (numOpen == n && numClosed == n) {
            ret.add(str);
            return;
        }

        // recurse next
        if (numOpen < n) {
            process(n, numOpen+1, numClosed, str+"(", ret); // add open bracket
        }
        if (numOpen > numClosed) {
            process(n, numOpen, numClosed+1, str+")", ret); // add closed bracket
        }
    }
}
