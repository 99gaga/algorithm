package programmers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class N으로표현 {

    @Test
    void test() {
        Assertions.assertEquals(4, solution(5, 12));
        Assertions.assertEquals(3, solution(2, 11));
    }

    public int answer = Integer.MAX_VALUE;

    public int solution(int N, int number) {
        dfs(0, 0, N, number);

        return answer > 8 ? -1 : answer;
    }

    public void dfs(int cnt, int prev, int N, int number) {
        if (cnt > 8) {
            return;
        }

        if (prev == number) {
            answer = Math.min(answer, cnt);
            return;
        }

        int nextN = N;
        for (int i=1; i<=8-cnt; i++) {
            dfs(cnt + i, prev + nextN, N, number);
            dfs(cnt + i, prev / nextN, N, number);
            dfs(cnt + i, prev * nextN, N, number);
            dfs(cnt + i, prev - nextN, N, number);
            nextN = nextN * 10 + N;
        }
    }

}
