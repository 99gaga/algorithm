package programmers;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.Arrays;

public class 테이블해시함수 {

    @Test
    public void test() {
        Assertions.assertEquals(
                4,
                solution(new int[][]{{2, 2, 6}, {1, 5, 10}, {4, 2, 9}, {3, 8, 3}}, 2, 2, 3)
        );
    }

    // col 번째 컬럼의 값을 기준으로 오름차순

    /**
     * col 번째 컬럼을 기준으로 오름차순 정렬
     * 기본키인 첫 번째 컬럼의 값을 기준으로 내림차순 정렬
     * 정렬된 데이터에서 S_i를 (i 번째 행의 튜플에 대해 각 컬럼의 값을 i 로 나눈 나머지들의 합으로 정의합니다.
     * row_begin <= i <= row_end 인 모든 S_i를 누적하여 bitwise XOR 한 값을 해시 값으로 반환 합니다.
     */
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;

        // col 번째 칼럼을 기준으로 오름차순, 같을 경우 첫 번쨰 칼럼의 값을 기준으로 내림차순
        int idx = col - 1;
        Arrays.sort(data, (o1, o2) -> {
            if (o1[idx] == o2[idx]) {
                return o2[1] - o1[0];
            }
            return o1[idx] - o2[idx];
        });

        for (int i = row_begin - 1; i < row_end; i++) {
            int finalI = i + 1;
            // S_i = i 번째 행의 튜플에 대해 각 컬럼의 값을 i로 나눈 나머지들의 합
            int S_i = Arrays.stream(data[i])
                    .map(j -> j % finalI)
                    .sum();

            answer ^= S_i; // 모든 S_i를 누적 및 XOR
        }

        return answer;
    }

}
