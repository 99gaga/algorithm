package programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 2021 KAKAO BLIND RECRUITMENT
 * 순위 검색
 */
public class SearchRank {

    public static void main(String[] args) {
        String[] info = {"java backend junior pizza 150",
                "python frontend senior chicken 210",
                "python frontend senior chicken 150",
                "cpp backend senior pizza 260",
                "java backend junior chicken 80",
                "python backend senior chicken 50"};

        String[] query = {"java and backend and junior and pizza 100", "python and frontend and senior and chicken 200",
                "cpp and - and senior and pizza 250",
                "- and backend and senior and - 150",
                "- and - and - and chicken 100",
                "- and - and - and - 150"};

        int[] result = solution(info, query);
        System.out.println(result);
    }

    static Map<String, List<Integer>> infos = new HashMap<>();
    static List<List<Integer>> scoreList = new ArrayList<>();

    private static int[] solution(String[] info, String[] query) {

        // 모든 경우의 수를 등록
        for (String in : info) {
            String[] man = in.split(" ");
            int score = Integer.parseInt(man[4]);

            // 이진수를 이용해서 0000 ~ 1111 모든 경우의 수의 조합을 key로 저장
            for (int i = 0; i < (1 << 4); i++) {
                StringBuilder key = new StringBuilder();

                for (int j = 0; j < 4; j++) {
                    if ((i & (1 << j)) > 0) {
                        key.append(man[j]);
                    }
                }
                // 등록되지 않은 key는 ArrayList 생성후 add(score)
                infos.computeIfAbsent(key.toString(), s -> new ArrayList<>()).add(score);
            }
        }

        // 정렬
        for (Map.Entry<String, List<Integer>> entry : infos.entrySet()) {
            entry.getValue().sort(null);
        }

        int[] answer = new int[query.length];
        List<Integer> empty = new ArrayList<>();
        for (int i = 0; i < query.length; i++) {
            String[] split = query[i].replace("and ", "").split(" ");
            int score = Integer.parseInt(split[4]);
            String key = String.join("", split[0], split[1], split[2], split[3]).replace("-", "");

            List<Integer> list = infos.getOrDefault(key, empty);

            int s = 0, e = list.size();

            while (s < e) {
                int mid = (s + e) / 2;

                if (list.get(mid) < score) s = mid + 1;
                else e = mid;
            }

            answer[i] = list.size() - s;
        }

        return answer;
    }

}
