package programmers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class 징검다리 {

    @Test
    void test() {
        Assertions.assertEquals(4, solution(25, new int[]{2, 14, 11, 21, 17}, 2));
    }

    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;

        Arrays.sort(rocks);
        int left = 1, right = distance, mid;

        while (left <= right) {
            int cnt = 0;
            int prev = 0;
            mid = (left + right) / 2;

            for (int i=0; i<rocks.length; i++) {
                if (rocks[i] - prev < mid) {
                    cnt++;
                } else {
                    prev = rocks[i];
                }
            }

            if (distance - prev < mid) cnt++;

            if (cnt <= n) {
                answer = Math.max(answer, mid);
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return answer;
    }

}
