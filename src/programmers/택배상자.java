package programmers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Stack;

// https://school.programmers.co.kr/learn/courses/30/lessons/131704
public class 택배상자 {

    @Test
    void test() {
        Assertions.assertEquals(5, solution(new int[]{3, 5, 4, 2, 1}));
        Assertions.assertEquals(2, solution(new int[]{4, 3, 1, 2, 5}));
        Assertions.assertEquals(5, solution(new int[]{5, 4, 3, 2, 1}));
    }

    public int solution(int[] order) {
        Stack<Integer> stack = new Stack<>();
        int idx = 0;

        for(int i = 1; i < order.length + 1; i++) {
            boolean flag = false;

            while (idx < order.length
                    && (i == order[idx] || (!stack.isEmpty() && order[idx] == stack.peek()))
            ) {
                if (i == order[idx]) {
                    flag = true;
                } else if (!stack.isEmpty() && order[idx] == stack.peek()) {
                    stack.pop();
                }
                idx = Math.min(++idx, order.length);
            }
            if (!flag) {
                stack.push(i);
            }
        }

        return idx;
    }
}
