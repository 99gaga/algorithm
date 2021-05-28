package programmers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class 베스트앨범 {

    @Test
    void test() {
        Assertions.assertArrayEquals(new int[]{4, 1, 3, 0},
                solution(new String[]{"classic", "pop", "classic", "classic", "pop"}, new int[]{500, 600, 150, 800, 2500}));
    }

    class Song {
        int id, cnt;
        String genre;

        public Song(int id, int cnt, String genre) {
            this.id = id;
            this.cnt = cnt;
            this.genre = genre;
        }
    }

    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> genrePlays = new HashMap<>();
        List<Song> list = new LinkedList<>();

        for (int i=0; i<genres.length; i++) {
            genrePlays.put(genres[i], genrePlays.getOrDefault(genres[i], 0) + plays[i]);
            list.add(new Song(i, plays[i], genres[i]));
        }
        list.sort((a, b) ->
        {
            if (!a.genre.equals(b.genre)) {
                return genrePlays.get(b.genre) - genrePlays.get(a.genre);
            } else if (a.cnt != b.cnt) { // 같은 장르안에서 플레이 횟수 큰거부터
                return b.cnt - a.cnt;
            } else { // 같은 장르의 같은 플레이 횟수라면 id가 작은거 부터
                return a.id - b.id;
            }
        });

        List<Integer> results = new ArrayList<>();
        String str = ""; int cnt = 0;
        for (Song song : list) {
            if (!str.equals(song.genre)) {
                str = song.genre;
                cnt = 0;
            }

            cnt++;
            if (cnt <= 2) {
                results.add(song.id);
            }
        }

        return results.stream().mapToInt(Integer::intValue).toArray();
    }
}
