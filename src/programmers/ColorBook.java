package programmers;

/**
 * 2017 카카오코드 예선
 * 카카오프렌즈컬러링북
 */
public class ColorBook {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        int m = 6;
        int n = 4;
        int[][] picture = {
                {1, 1, 1, 0},
                {1, 2, 2, 0},
                {1, 0, 0, 1},
                {0, 0, 0, 1},
                {0, 0, 0, 3},
                {0, 0, 0, 3}
        };

        int[] result = solution(m, n, picture);
        System.out.println(result[0] + " " + result[1]);
    }

    private static int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        int[][] map = new int[m][n];
        for(int i=0; i<m; i++){
            for(int k=0; k<n; k++){
                map[i][k] = picture[i][k];
            }
        }

        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (picture[i][j] != 0) {
                    numberOfArea++;
                    int cnt = search(i, j, picture, picture[i][j]);
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, cnt);
                }
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

    private static int search(int m, int n, int[][] picture, int color) {
        int cnt = 1;
        picture[m][n] = 0;

        for (int i=0; i<4; i++) {
            int tx = m + dx[i];
            int ty = n + dy[i];

            if (tx >= 0 && ty >= 0 && tx < picture.length && ty < picture[0].length) {
                if (picture[tx][ty] == color) {
                    cnt += search(tx, ty, picture, color);
                }
            }
        }

        return cnt;
    }
}
