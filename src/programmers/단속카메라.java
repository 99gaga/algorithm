package programmers;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.Arrays;
import java.util.Comparator;

// https://school.programmers.co.kr/learn/courses/30/lessons/42884
public class 단속카메라 {

    @Test
    public void test() {
        Assertions.assertEquals(
                2,
                solution(new int[][]{{-20, -15}, {-14, -5}, {-18, -13}, {-5, -3}})
        );
    }

    public int solution(int[][] routes) {
        Arrays.sort(routes, Comparator.comparingInt(r -> r[1]));

        int cnt = 0;
        int lastExitPoint = -30001;
        for (int[] route : routes) {
            if (lastExitPoint < route[0]) {
                cnt++;
                lastExitPoint = route[1];
            }
        }

        return cnt;
    }
}
