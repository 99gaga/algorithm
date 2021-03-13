package programmers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class 숫자게임 {

    @Test
    public void test() {
        Assertions.assertEquals(3, solution(new int[]{5, 1, 3, 7}, new int[]{2, 2, 6, 8}));
        Assertions.assertEquals(0, solution(new int[]{2, 2, 2, 2}, new int[]{1, 1, 1, 1}));
    }

    public int solution(int[] A, int[] B) {
        int answer = 0;

        //A팀과 B의을 정렬
        Arrays.sort(A);
        Arrays.sort(B);

        //A팀과 B팀을 차례대로 비교
        //만약 B팀원이 진다면 B의 다음 팀원을 선택하여 승리
        for (int i=0; i<B.length; i++) {
            if (A[answer] < B[i]) {
                answer++;
            }
        }

        return answer;
    }
}
