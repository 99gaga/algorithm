package programmers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Stack;

// https://school.programmers.co.kr/learn/courses/30/lessons/154539
public class 뒤에있는큰수찾기 {

    @Test
    void test() {
        Assertions.assertArrayEquals(
                new int[]{3, 5, 5, -1},
                solution(new int[]{2, 3, 3, 5})
        );
        Assertions.assertArrayEquals(
                new int[]{-1, 5, 6, 6, -1, -1},
                solution(new int[]{9, 1, 5, 3, 6, 2})
        );
    }

    public int[] solution(int[] numbers) {
        int[] results = new int[numbers.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < numbers.length; i++) {
            while (!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) {
                results[stack.pop()] = numbers[i];
            }
            stack.add(i);
        }

        while (!stack.isEmpty()) {
            results[stack.pop()] = -1;
        }

        return results;
    }

}