package programmers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class 인사고과 {

    @Test
    void test() {
        Assertions.assertEquals(4, solution(new int[][]{{2, 2}, {1, 4}, {3, 2}, {3, 2}, {2, 1}}));
    }

    public int solution(int[][] scores) {
        int answer = 1;
        int[] target = scores[0];
        int targetSum = target[0] + target[1];

        // a: 근무 태도 점수, b: 동료 평가 점수
        // a 기준으로 내림차순 정렬, b 기준으로 오름차순 정렬
        // 배열을 순회하며 `이전 b 가 현재 b 값보다 작은 경우`는 현재 a도 이전 a보다 작게 된다. -> 둘 다 작다
        Arrays.sort(scores, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);

        int beforeScore = scores[0][1];
        for (int i = 0; i < scores.length; i++) {
            if (scores[i][1] >= beforeScore) { // b가 작아졌는가?, a 또한 작아졌음을 유추 가능
                if (targetSum < scores[i][0] + scores[i][1]) { // 총 점수의 합이 targetSum보다 큰 가?
                    answer++;
                }
                beforeScore= scores[i][1];
            } else {
                // 둘 다 점수가 작은 경우 target 인지 확인하여 -1을 return
                if (target.equals(scores[i])) {
                    return -1;
                }
            }
        }
        return answer;
    }

}
