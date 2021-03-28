package baekjon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 숫자 할리갈리 게임
public class boj20923 {

    static Deque<Integer> dodo = new ArrayDeque<>();
    static Deque<Integer> suyeon = new ArrayDeque<>();
    static Deque<Integer> dodoGround = new ArrayDeque<>();
    static Deque<Integer> suyeonGround = new ArrayDeque<>();
    static String winner = "dosu";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputNM = br.readLine().split(" ");
        int n = Integer.parseInt(inputNM[0]);
        int m = Integer.parseInt(inputNM[1]);

        for (int i=0; i<n; i++) {
            String[] card = br.readLine().split(" ");
            dodo.addFirst(Integer.parseInt(card[0]));
            suyeon.addFirst(Integer.parseInt(card[1]));
        }
        // 입력 끝

        int dodoCard;
        int suyeonCard;
        for (int game=0; game<m; game++) {

            if (game % 2 == 0) { // 도도가 카드를 낼 차례

                dodoCard = dodo.removeFirst(); // 맨위 카드를 내고
                dodoGround.add(dodoCard); // 그라운드 끝에 더한다.

                if (dodo.isEmpty()) break;

                if (dodoCard == 5) dodoWin();
            } else { // 수연이 카드를 낼 차례

                suyeonCard = suyeon.removeFirst();
                suyeonGround.add(suyeonCard);

                if (suyeon.isEmpty()) break;

                if (suyeonCard == 5) dodoWin();
            }

            if (!dodoGround.isEmpty() && !suyeonGround.isEmpty()) {
                if (dodoGround.peekLast() + suyeonGround.peekLast() == 5) {
                    suyeonWin();
                }
            }
        }

        if (dodo.size() > suyeon.size()) {
            winner = "do";
        } else if (dodo.size() < suyeon.size()){
            winner = "su";
        }

        System.out.println(winner);
    }

    private static void suyeonWin() {
        suyeon.addAll(dodoGround);
        suyeon.addAll(suyeonGround);
        suyeonGround.clear();
        dodoGround.clear();
    }

    private static void dodoWin() {
        dodo.addAll(suyeonGround);
        dodo.addAll(dodoGround);
        suyeonGround.clear();
        dodoGround.clear();
    }

}
