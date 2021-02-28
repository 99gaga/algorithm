package programmers;

/**
 * 네트워크
 */
public class Network {

    public static void main(String[] args) {
        int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        int n = 3;

        int result = solution(computers, n);
        System.out.println(result);
    }

    private static int solution(int[][] computers, int n) {
        int answer = 0;

        boolean[] visit = new boolean[n];

        for (int i=0; i<n; i++) {
            if (visit[i] == false) {
                dfs(computers, visit, i);
                answer++;
            }
        }

        return answer;
    }

    private static void dfs(int[][] computers, boolean[] visit, int k) {

        visit[k] = true;

        for (int i=0; i<visit.length; i++) {
            if (computers[k][i] == 1 && visit[i] == false) {
                dfs(computers, visit, i);
            }
        }
    }
}
