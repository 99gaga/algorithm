package programmers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

// https://school.programmers.co.kr/learn/courses/30/lessons/154540
public class 무인도여행 {

    @Test
    void test() {
        Assertions.assertArrayEquals(
                new int[]{1, 1, 27},
                solution(new String[]{"X591X", "X1X5X", "X231X", "1XXX1"})
        );
        Assertions.assertArrayEquals(
                new int[]{-1},
                solution(new String[]{"XXX", "XXX", "XXX"})
        );
    }

    static int[][] moves = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int[] solution(String[] maps) {
        List<Integer> results = new ArrayList<>();

        boolean[][] visited = new boolean[maps.length][maps[0].length()];
        for (int row = 0; row < maps.length; row++) {
            for (int col = 0; col < maps[row].length(); col++) {
                if (maps[row].charAt(col) != 'X' && !visited[row][col]) {
                    int dayCount = dfs(row, col, maps, visited);
                    results.add(dayCount);
                }
            }
        }

        if (results.size() == 0) {
            results.add(-1);
        }
        return results.stream().sorted().mapToInt(Integer::intValue).toArray();
    }

    public int dfs(int row, int col, String[] maps, boolean[][] visited) {
        visited[row][col] = true;

        int count = maps[row].charAt(col) - '0';
        for (int[] move : moves) {
            int dx = row + move[0];
            int dy = col + move[1];

            if (dx >= 0 && dy >= 0 && dx < maps.length && dy < maps[0].length()
                    && maps[dx].charAt(dy) != 'X' && !visited[dx][dy]) {
                count += dfs(dx, dy, maps, visited);
            }
        }

        return count;
    }

}
