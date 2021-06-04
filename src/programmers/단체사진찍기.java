package programmers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class 단체사진찍기 {

    @Test
    void test() {
        Assertions.assertEquals(3648, solution(2, new String[]{"N~F=0", "R~T>2"}));
    }

    char[] c = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    String[] conditions;
    int result = 0;

    public int solution(int n, String[] data) {
        conditions = data;
        permutation(c, 0);
        return result;
    }

    void permutation(char[] c, int depth) {
        if (depth == 8) {
            if (checkValid(c)) result++;
            return;
        }

        for (int i=depth; i<8; i++) {
            swap(c, depth, i);
            permutation(c, depth + 1);
            swap(c, depth, i);
        }
    }

    void swap(char[] c, int depth, int i) {
        char temp = c[depth];
        c[depth] = c[i];
        c[i] = temp;
    }

    boolean checkValid(char[] c) {

        for (String condition : conditions) {
            char x = condition.charAt(0);
            char y = condition.charAt(2);
            char op = condition.charAt(3);
            int diff = condition.charAt(4) - '0' + 1;

            int xx = 0, yy = 0;
            for (int i=0; i<8; i++) {
                if (x == c[i]) xx = i;
                if (y == c[i]) yy = i;
            }

            if (op == '=') {
                if (Math.abs(xx-yy) != diff) return false;
            } else if (op == '>') {
                if (Math.abs(xx-yy) <= diff) return false;
            } else {
                if (Math.abs(xx-yy) >= diff) return false;
            }
        }

        return true;
    }
}
