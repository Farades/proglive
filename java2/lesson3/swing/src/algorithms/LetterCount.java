package algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Артем on 07.01.2015.
 */
public class LetterCount {
    public static void main(String[] args) {
        String test = "The string to test function frequency counting occurrences of letters in the string";
        Map<String, Integer> countLetter = countingLetter(test);
        System.out.println(countLetter);
    }

    public static Map<String, Integer> countingLetter(String str) {
        Map<String, Integer> res = new HashMap<>();

        if (str == null)
            return res;

        char[] chars = str.toCharArray();
        //Цикл по всем символам строки
        //Если ключ(символ) содержится в HashMap, то увеличиваем ключ на единицу
        //Если ключ(символ) отсутствует в HashMap, то заносим его в HashMap с ключом, равным 1
        for (int i = 0; i < chars.length; i++) {
            String letter = String.valueOf(chars[i]);
            if (res.containsKey(letter)) {
                int count = res.get(letter);
                res.put(letter, ++count);
            } else {
                res.put(letter, 1);
            }
        }
        return res;
    }
}
