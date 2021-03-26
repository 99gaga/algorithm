package baekjon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

// 보이저 1호
public class boj3987 {

    // 명령어
    static Map<Character, int[]> command = new HashMap<>(){{
        put('L', new int[]{0, -1});
        put('R', new int[]{0, 1});
        put('U', new int[]{-1, 0});
        put('D', new int[]{1, 0});
    }};

    // 우선순위
    static Map<Character, Integer> order = new HashMap<>(){{
        put('L', 0);
        put('R', 2);
        put('U', 3);
        put('D', 1);
    }};

    static int n, m;
    static char[][] grid;

    // 위치와 방향을 저장할 클래스
    static class Position {

        int x;
        int y;
        char direct;

        public Position(int x, int y, char direct) {
            this.x = x;
            this.y = y;
            this.direct = direct;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        grid = new char[n][m];
        for (int row = 0; row < n; row++) {
            grid[row] = br.readLine().toCharArray();
        }

        String[] position = br.readLine().split(" ");
        int x = Integer.parseInt(position[0]) - 1;
        int y = Integer.parseInt(position[1]) - 1;

        int max = -1; // 초기화
        char maxDirect = 'L'; // 제일 작은 우선순위로 초기화
        boolean flag = false; // 무한루프라면 true 후 다르게 출력하기 위함
        for (char direct : command.keySet()) {
            int cnt = signal(x, y, direct); // signal time 구하기

            if (cnt == Integer.MAX_VALUE) { // 무한 루프
                if (order.get(maxDirect) <= order.get(direct)) { // 우선순위가 높은 방향인지?
                    max = cnt;
                    maxDirect = direct;
                    flag = true;
                }
            } else {
                if (max < cnt || (max == cnt && order.get(maxDirect) <= order.get(direct))) { // max < cnt 이거나 같을 때는 우선순위가 더 높은지?
                    max = cnt;
                    maxDirect = direct;
                }
            }
        }

        if (flag) {
            System.out.println(maxDirect + "\n" + "Voyager");
        } else {
            System.out.println(maxDirect + "\n" + max);
        }
    }

    private static int signal(int x, int y, char direct) {
        Queue<Position> q = new LinkedList<>();
        q.offer(new Position(x, y, direct));

        int cnt = 1;
        while (!q.isEmpty()) {
            Position position = q.poll();
            int[] dir = command.get(position.direct);
            int tempX = position.x + dir[0];
            int tempY = position.y + dir[1];

            if (tempX >= 0 && tempY >= 0 && tempX < n && tempY < m) { // 범위 안에 있고

                if (grid[tempX][tempY] != 'C') { // 블랙홀이 아니라면 이동이 가능하다.

                    char tempDirect = getDirect(grid[tempX][tempY], position.direct); // 다음 위치의 방향을 구한다.

                    if (cnt > n * m) return Integer.MAX_VALUE; // cnt가 n*m 보다 크면 순환이라고 판단 Integer.MAX_VALUE 반환

                    // 순환이 아니라면 넣고 그 위치의 방향을 방문 처리한다.
                     q.offer(new Position(tempX, tempY, tempDirect));
                    cnt++; // time 증가
                }
            }
        }

        return cnt; // 총 시간 반환
    }

    // 다음위치의 방향을 구한다.
    private static char getDirect(char nextPosition, char direct) {

        if (nextPosition == '/') {
            switch (direct) {
                case 'U':
                    return 'R';
                case 'L':
                    return 'D';
                case 'R':
                    return 'U';
                case 'D':
                    return 'L';
            }
        } else if (nextPosition == '\\') {
            switch (direct) {
                case 'U':
                    return 'L';
                case 'L':
                    return 'U';
                case 'R':
                    return 'D';
                case 'D':
                    return 'R';
            }
        }

        return direct; // '.'이라서 방향을 그대로 간다.
    }

}
