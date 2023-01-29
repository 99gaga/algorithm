package programmers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class 숫자변환하기 {

    @Test
    void test() {
        Assertions.assertEquals(2, solution(10, 40, 5));
        Assertions.assertEquals(1, solution(10, 40, 30));
        Assertions.assertEquals(-1, solution(2, 5, 4));
    }

    static final int plusN = 0;
    static final int multiply2 = 1;
    static final int multiply3 = 2;

    public int solution(int x, int y, int n) {
        Queue<int[]> q = new LinkedList<>();
        Set<Integer> numbers = new HashSet<>();
        q.add(new int[]{x, 0}); // number, count
        numbers.add(x);

        while (!q.isEmpty()) {
            int[] info =  q.poll();
            int number = info[0];
            int count = info[1];

            if (number == y) {
                return count;
            }

            for (int command = 0; command < 3; command++) {
                int calcResult = calculate(command, number, n);
                if (calcResult <= y && !numbers.contains(calcResult)) {
                    q.add(new int[]{calcResult, count + 1});
                    numbers.add(calcResult);
                }
            }
        }

        return -1;
    }

    private int calculate(int command, int x, int n) {
        switch (command) {
            case plusN:
                return (x + n);
            case multiply2:
                return (x * 2);
            case multiply3:
                return (x * 3);
            default:
                throw new IllegalStateException("Unexpected value: " + command);
        }
    }
}
