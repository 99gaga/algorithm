package programmers;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class 방금그곡 {
    @Test
    public void test() {
        Assertions.assertEquals(
                "HELLO",
                solution(
                        "ABCDEFG",
                        new String[]{"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"}
                )
        );
        Assertions.assertEquals(
                "FOO",
                solution(
                        "CC#BCC#BCC#BCC#B",
                        new String[]{"03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"}
                )
        );
        Assertions.assertEquals(
                "WORLD",
                solution(
                        "ABC",
                        new String[]{"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"}
                )
        );
        Assertions.assertEquals(
                "HELLO",
                solution(
                        "ABCDEFG",
                        new String[]{"11:50,12:04,HELLO,CDEFGAB", "12:57,13:11,BYE,CDEFGAB"}
                )
        );
    }


    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        String melody = parseMusic(m);
        int maxPlayTime = 0;

        for (String musicinfo : musicinfos) {
            String[] info = musicinfo.split(",");
            String title = info[2];
            String music = parseMusic(info[3]);
            int diff = getTimeDiff(info[0], info[1]);
            int musicLength = music.length();

            String totalPlayMusic = music.repeat(diff / musicLength)
                    + music.substring(0, diff % musicLength);

            if (totalPlayMusic.contains(melody) && maxPlayTime < diff) {
                answer = title;
                maxPlayTime = diff;
            }
        }

        return answer;
    }

    private String parseMusic(String music) {
        return music.replace("C#", "c")
                .replace("D#", "d")
                .replace("F#", "f")
                .replace("G#", "g")
                .replace("A#", "a");
    }

    private int getTimeDiff(String time1, String time2) {
        String[] t1 = time1.split(":");
        String[] t2 = time2.split(":");
        int t1Minute = Integer.parseInt(t1[0]) * 60 + Integer.parseInt(t1[1]);
        int t2Minute = Integer.parseInt(t2[0]) * 60 + Integer.parseInt(t2[1]);

        return Math.abs(t1Minute - t2Minute);
    }

}