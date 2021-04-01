package programmers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class 순위 {

    @Test
    void test() {
        Assertions.assertEquals(2, solution(5, new int[][]{{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}}));
    }

    public int solution(int n, int[][] results) {
        int answer = 0;

        int[][] games = new int[n][n];
        for (int i=0; i<results.length; i++) {
            games[results[i][0] - 1][results[i][1] - 1] = 1;
        }

        for (int k=0; k<n; k++) {
            for (int i=0; i<n; i++) {
                for (int j=0; j<n; j++) {
                    if (games[i][k] == 1 && games[k][j] == 1) games[i][j] = 1;
                }
            }
        }

        for (int i=0; i<n; i++) {
            int reulst = 0;
            for (int j=0; j<n; j++) {
                if (games[i][j] == 1 || games[j][i] == 1) reulst++;
            }
            if (reulst == n - 1) answer++;
        }

        return answer;
    }
}
