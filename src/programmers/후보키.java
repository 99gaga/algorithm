package programmers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class 후보키 {

    @Test
    void test() {
        Assertions.assertEquals(2, solution(new String[][]{
                {"100", "ryan", "music", "2"},
                {"200", "apeach", "math", "2"},
                {"300", "tube", "computer", "3"},
                {"400", "con", "computer", "4"},
                {"500", "muzi", "music", "3"},
                {"600", "apeach", "music", "2"}
        }));
    }

    List<String> uniqueKeys;
    Map<String, Set<String>> map;

    public int solution(String[][] relation) {
        int answer = 0;

        uniqueKeys = new ArrayList<>();
        for (int i=1; i<=relation[0].length; i++) { // 1개부터 ~ N개 조합
            map = new HashMap<>();
            for (int j=0; j<relation.length; j++) { // 첫번째 부터 마지막까지 i개의 조합
                combination(relation[j], new boolean[relation[0].length], 0, relation[0].length, i);
            }
            for (String key : map.keySet()) {
                if (map.get(key).size() == relation.length) {
                    uniqueKeys.add(key);
                    answer++;
                }
            }
        }

        return answer;
    }

    public void combination(String[] infos, boolean[] visited, int start, int n, int r) {
        if (r == 0) {
            StringBuilder key = new StringBuilder();
            StringBuilder sb = new StringBuilder();
            for (int i=0; i<infos.length; i++) {
                if (visited[i]) {
                    sb.append(infos[i]);
                    key.append(i);
                }
            }
            String k = key.toString();
            if (!map.containsKey(k)) map.put(k, new HashSet<>());
            for (String uniqueKey : uniqueKeys) {
                int cnt = 0;
                for (String c : uniqueKey.split("")) {
                    if (k.contains(c)) cnt++;
                }
                if (uniqueKey.length() == cnt) return;
            }
            map.get(k).add(sb.toString());
            return;
        }

        for (int i=start; i<n; i++) {
            visited[i] = true;
            combination(infos, visited, i+1, n, r-1);
            visited[i] = false;
        }
    }
}
