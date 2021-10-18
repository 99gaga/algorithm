package programmers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class 음양더하기 {

    @Test
    void test() {
        Assertions.assertEquals(solution(new int[]{4, 7, 12}, new boolean[]{true, false, true}),
                9);
        Assertions.assertEquals(solution(new int[]{1, 2, 3}, new boolean[]{false, false, true}),
                0);
    }

    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;

        for (int i=0; i<absolutes.length; i++) {
            answer += signs[i] ? absolutes[i] : absolutes[i] * -1;
        }

        return answer;
    }
}
