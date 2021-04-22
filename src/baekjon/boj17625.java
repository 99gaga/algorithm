package baekjon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 나의 인생에는 수학과 함께
 */
public class boj17625 {

    static int[] dx = {1, 0};
    static int[] dy = {0, 1};
    static int n, minValue = Integer.MAX_VALUE, maxValue = Integer.MIN_VALUE;
    static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        map = new char[n][n];
        for (int i=0; i<n; i++) {
            map[i] = br.readLine().replaceAll(" ", "").toCharArray();
        }

        dfs(0, 0, map[0][0] - '0', map[0][0]);

        System.out.println(maxValue + " " + minValue);
    }

    private static void dfs(int x, int y, int value, char op) {

        if (x == n-1 && y == n-1) { // 마지막 칸이라면
            maxValue = Math.max(maxValue, value);
            minValue = Math.min(minValue, value);
            return;
        }

        for (int i=0; i<2; i++) { // 위 아래
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (nextX>=0 && nextX<n && nextY<n && nextY>=0) {

                if (!Character.isDigit(map[nextX][nextY])) { // 연산자라면
                    dfs(nextX, nextY, value, map[nextX][nextY]);
                } else { // 숫자라면
                    int result = calc(value, map[nextX][nextY] - '0', op);
                    dfs(nextX, nextY, result, op);
                }

            }
        }
    }

    private static int calc(int x, int y, char op) {
        switch (op) {
            case '+': return x + y;
            case '-': return x - y;
            default: return x * y;
        }
    }

}
