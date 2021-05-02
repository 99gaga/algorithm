import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 보스몬스터 전리품
 */
public class boj20005 {

    static char[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static Map<Character, Integer> dps = new HashMap<>();
    static Map<Character, Integer> arriveTime = new HashMap<>();
    static int N, M, P;
    static int boss_HP;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken()); // 지도의 세로길이
        N = Integer.parseInt(st.nextToken()); // 지도의 가로 길이
        P = Integer.parseInt(st.nextToken()); // 플레이어의 수

        map = new char[M][N]; // 지도
        for (int i=0; i<M; i++) {
            map[i] = br.readLine().toCharArray();
        }

        for (int i=0; i<P; i++) {
            st = new StringTokenizer(br.readLine());
            dps.put(st.nextToken().charAt(0), Integer.parseInt(st.nextToken())); // 플레이어별 공격력
        }
        boss_HP = Integer.parseInt(br.readLine()); // 보스 체력

        // 도착하는 최단 시간을 플레이어별로 구해서 시간을 증가하며 뺀다.
        for (int i=0; i<M; i++) {
            for (int j=0; j<N; j++) {
                if (dps.containsKey(map[i][j])) {
                    bfs(i, j, map[i][j], copy());
                }
            }
        }

        int cnt = 0, totalDamage = 0;
        Set<Character> arrive = new HashSet<>();
        while (boss_HP >= 0) {

            if (!arriveTime.isEmpty()) {
                Set<Character> key = arriveTime.keySet();
                for (char player : key) {
                    if (arrive.contains(player)) continue;

                    if (arriveTime.get(player) > 0) {
                        arriveTime.put(player, arriveTime.get(player) - 1);
                    } else {
                        totalDamage += dps.get(player);
                        arrive.add(player);
                        cnt++;
                    }
                }
            }

            boss_HP -= totalDamage;
        }

        System.out.println(cnt);

    }

    private static char[][] copy() {
        char[][] copy = new char[M][N];
        for (int i=0; i<M; i++) {
            copy[i] = Arrays.copyOf(map[i], map[i].length);
        }
        return copy;
    }

    private static void bfs(int x, int y, char player, char[][] cloneMap) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y, 0});
        cloneMap[x][y] = '~';

        while (!q.isEmpty()) {
            int[] pos = q.poll();

            for (int i=0; i<4; i++) {
                int nx = pos[0] + dx[i];
                int ny = pos[1] + dy[i];

                if (nx >= 0 && ny >= 0 && nx < M && ny < N) {
                    if (cloneMap[nx][ny] != '~' && cloneMap[nx][ny] != 'X') {
                        if (cloneMap[nx][ny] == 'B') {
                            arriveTime.put(player, pos[2] + 1);
                            return;
                        }
                        cloneMap[nx][ny] = '~';
                        q.offer(new int[]{nx, ny, pos[2] + 1});
                    }
                }
            }
        }

    }

}
