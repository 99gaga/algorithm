package programmers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class 기지국설치 {

    @Test
    public void test() {
        Assertions.assertEquals(3, solution(11, new int[]{4, 11}, 1));
        Assertions.assertEquals(3, solution(16, new int[]{9}, 2));
    }

    public int solution(int n, int[] stations, int w) {
        int answer = 0;

        int start = 0;
        int effect = w * 2 + 1;

        for (int i=0; i<stations.length; i++) {
            if ((i == stations.length - 1) && (stations[i] + w < n)) {
                answer += ceil((n - stations[i] - w), effect);
            }

            answer += ceil((stations[i] - w - start - 1), effect);
            start = stations[i] + w;
        }

        return answer;
    }

    public int ceil(int a, int b) {
        if(a < 0) {
            return 0;
        }

        if (a % b == 0) {
            return a / b;
        }

        return a / b + 1;
    }
}
