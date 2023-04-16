package programmers;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.Arrays;

// https://school.programmers.co.kr/learn/courses/30/lessons/181188
public class 요격시스템 {

    @Test
    public void test() {
        Assertions.assertEquals(
                3,
                solution(new int[][]{{4, 5}, {4, 8}, {10, 14}, {11, 13}, {5, 12}, {3, 7}, {1, 4}})
        );
    }

    public int solution(int[][] targets) {
        Arrays.sort(targets, (a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);
        int answer = 1;
        int end = targets[0][1];

        for(int[] t : targets) {
            if (t[0] >= end) {
                end = t[1];
                answer++;
            }
        }

        return answer;
    }

}
