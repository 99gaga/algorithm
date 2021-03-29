package programmers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class 입국심사 {

    @Test
    void test() {
        Assertions.assertEquals(2, solution(2, new int[]{1, 2}));
        Assertions.assertEquals(28, solution(6, new int[]{7, 10}));
        Assertions.assertEquals(24, solution(6, new int[]{6, 10}));
        Assertions.assertEquals(30, solution(6, new int[]{8, 10}));
    }

    public long solution(int n, int[] times) {
        long answer = 0;

        Arrays.sort(times);
        long end = (long) times[times.length - 1] * n;
        long start = 0;
        long mid;
        long cnt;

        while (end  >= start) {

            mid = (end + start) / 2;
            cnt = 0;

            boolean isMin = false;
            for (int time : times) {
                if (!isMin && mid % time == 0) { // 나누어 딱 떨어지는 것이 있다면 그것은 최소 시간
                    isMin = true;
                }
                cnt += mid / time;
            }

            if (cnt == n) {

                if (!isMin) { // 나누어 딱 떨어지는 것이 없어 isMin이 false라면 최소 값이 아니다. 탐색 지속
                    end = mid - 1;
                    continue;
                }
                answer = mid;
                break;
            } else if (cnt < n) {
                start = mid + 1;
            } else {
                end = mid - 1;
                answer = mid; // 조건과 맞지않아서 1을 줄였지만 찾지 못할경우 그것이 답이기 때문에 저장!
            }
        }

        return answer;
    }

}
