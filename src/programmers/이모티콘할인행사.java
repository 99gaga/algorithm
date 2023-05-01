package programmers;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.List;

public class 이모티콘할인행사 {

    @Test
    public void test() {
        Assertions.assertArrayEquals(
                new int[]{1, 5400},
                solution(
                        new int[][]{{40, 10000}, {25, 10000}},
                        new int[]{7000, 9000}
                )
        );
        Assertions.assertArrayEquals(
                new int[]{4, 13860},
                solution(
                        new int[][]{{40, 2900}, {23, 10000}, {11, 5200}, {5, 5900}, {40, 3100}, {27, 9200}, {32, 6900}},
                        new int[]{1300, 1500, 1600, 4900}
                )
        );
    }

    final private int[] discounts = {10, 20, 30, 40};

    static class Emoticon {
        int price;
        int discount;

        public Emoticon(int price, int discount) {
            this.price = price;
            this.discount = discount;
        }
    }

    public int[] solution(int[][] users, int[] emoticons) {
        List<Emoticon> emoticonPrices = new ArrayList<>();
        return search(users, emoticons, emoticonPrices);
    }

    private int[] search(int[][] users, int[] emoticons, List<Emoticon> emoticonPrices) {
        if (emoticonPrices.size() == emoticons.length) {
            int count = 0;
            int totalPrice = 0;
            for (int[] user : users) {
                int baseDiscount = user[0];
                int basePrice = user[1];
                int price = emoticonPrices.stream()
                        .filter((e) -> e.discount >= baseDiscount)
                        .mapToInt((e) -> e.price)
                        .sum();

                if (basePrice <= price) {
                    count++;
                } else {
                    totalPrice += price;
                }
            }

            return new int[]{count, totalPrice};
        }

        int[] result = new int[2];
        for (int discount : discounts) {
            int idx = emoticonPrices.size();
            int price = emoticons[idx] * (100 - discount) / 100;
            emoticonPrices.add(new Emoticon(price, discount));
            int[] temp = search(users, emoticons, emoticonPrices);
            emoticonPrices.remove(idx);


            if (temp[0] > result[0]
                    || (temp[0] == result[0] && temp[1] > result[1])) {
                result = temp;
            }
        }

        return result;
    }

}
