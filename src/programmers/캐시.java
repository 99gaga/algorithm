package programmers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

public class 캐시 {

    @Test
    void test() {
        Assertions.assertEquals(50, solution(3, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"}));
        Assertions.assertEquals(21, solution(3, new String[]{"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"}));
        Assertions.assertEquals(60, solution(3, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"}));
        Assertions.assertEquals(25, solution(0, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA"}));
    }

    public int solution(int cacheSize, String[] cities) {
        int answer = 0;

        if (cacheSize == 0) {
            return cities.length * 5;
        }

        List<String> cache = new LinkedList<>();
        for (int i=0; i< cities.length; i++) {

            String city = cities[i].toLowerCase();
            if (cache.contains(city)) { // 캐시 히트라면 맨뒤로
                cache.remove(city);
                cache.add(city);
                answer += 1;

            } else { // 캐시 미스라면
                if (cache.size() == cacheSize) { // 캐시가 꽉찬 경우 LRU 알고리즘을 적용하여 맨앞 요소를 삭제
                    cache.remove(0);
                }
                cache.add(city);
                answer += 5;
            }
        }

        return answer;
    }
}
