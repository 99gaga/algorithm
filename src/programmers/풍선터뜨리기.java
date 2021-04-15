package programmers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class 풍선터뜨리기 {

    @Test
    void test() {
        Assertions.assertEquals(3, solution(new int[]{9, -1, -5}));
        Assertions.assertEquals(6, solution(new int[]{-16, 27, 65, -2, 58, -92, -71, -68, -61, -33}));
    }

    // 번호가 큰것을 터뜨려야 하며, 작은 것을 터뜨리는 행위는 한번만 가능하다.

    public int solution(int[] a) {
        int answer = 0;

        int[] leftValue = new int[a.length];
        int[] rightValue = new int[a.length];
        int left = a[0], right = a[a.length - 1];

        // 왼쪽의 최솟값을 저장
        for (int i=1; i<a.length-1; i++) {
            left = Math.min(left, a[i - 1]);
            leftValue[i] = left;
        }

        // 오른쪽의 최솟값을 저장
        for (int i=a.length-2; i>=0; i--) {
            right = Math.min(right, a[i + 1]);
            rightValue[i] = right;
        }

        for (int i=1; i<a.length-1; i++) {
            int value = a[i];

            int cnt = 0;
            if (value > leftValue[i]) cnt++;
            if (value > rightValue[i]) cnt++;

            if (cnt != 2) answer++;
        }

        return answer + 2; // 맨처음 것과 맨 마지막 것 플러스
    }

}
