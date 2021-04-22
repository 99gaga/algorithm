package programmers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 합승택시요금 {

    @Test
    void test() {
        Assertions.assertEquals(82, solution(6,4,6,2, new int[][]{
                {4, 1, 10},
                {3, 5, 24},
                {5, 6, 2},
                {3, 1, 41},
                {5, 1, 24},
                {4, 6, 50},
                {2, 4, 66},
                {2, 3, 22},
                {1, 6, 25}
        }));
    }

    List<List<int[]>> graph = new ArrayList<>();
    static final int INF = 100001;

    // n: 지점번호 개수, s: 출발 지점, a: 목표 지점, b: 목표 지점, fares: 각 노드 소요 시간
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = Integer.MAX_VALUE;

        int[][] map = new int[n+1][n+1];
        for (int i=0; i<=n; i++) {
            Arrays.fill(map[i], INF);
            map[i][i] = 0;
        }

        for (int[] fare : fares) {
            int x = fare[0];
            int y = fare[1];
            int cost = fare[2];
            map[x][y] = map[y][x] = cost;
        }

        // 플로이드 워셜~
        for (int k=1; k<=n; k++) {
            for (int i=1; i<=n; i++) {
                for (int j=1; j<=n; j++) {
                    map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
                }
            }
        }

        // s -> i -> a, s -> i -> b
        for (int i=1; i<=n; i++) {
            answer = Math.min(answer, map[s][i] + map[i][a] + map[i][b]);
        }

        return answer;
    }

}