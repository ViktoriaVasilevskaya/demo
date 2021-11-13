package com.ifmo.lesson11;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;


public class TopWords {
    public static void main(String[] args) throws IOException {
        // Создаем файл, указывая путь к текстовому файлу на диске
        File text = new File("wap.txt");

        // Вычитываем все строки из файла
        List<String> lines = Files.readAllLines(text.toPath());

        // Создаем пустую коллекцию для слов.
        List<String> words = new ArrayList<>();

        for (String line : lines) {
            // Для каждой строки
            String[] wordSplit =
                    line.toLowerCase() // Переводим в нижний регистр
                            .replaceAll("(\\p{Punct}|”|“)", " ") // Заменяем все знаки на пробел
                            .replace("\"", "")
                            .trim() // Убираем пробелы в начале и конце строки.
                            .split("\\s"); // Разбиваем строки на слова

            for (String s : wordSplit) {
                // Выбираем только непустые слова.
                if (s.length() > 0)
                    words.add(s.trim());
            }
        }

        System.out.println(top10Words(words));
        System.out.println(top10Phrases(words));
        System.out.println(charactersFrequency(words));
    }

    /**
     * Возвращает 10 наиболее часто встречающихся слов с их
     * счётчиками.
     *
     * @param words Список слов.
     * @return Map, где ключ - слово, а значение - сколько раз встретилось.
     */
    public static Map<String, Integer> top10Words(List<String> words) {

        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
//            if (wordCount.containsKey(word)) {
//                Integer count = wordCount.get(word);
//                wordCount.put(word, count + 1);
//            } else {
//                wordCount.put(word, 1);
//            }
            wordCount.merge(word, 1, Integer :: sum);
        }


        List<Map.Entry<String, Integer>> entries = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            entries.add(entry);
        }
        entries.sort((e1, e2) -> Integer.compare(e2.getValue(), e1.getValue()));

        Map<String, Integer> top10 = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            final Map.Entry<String, Integer> entry = entries.get(i);
            top10.put(entry.getKey(), entry.getValue());
        }
        return top10;

    }

    /**
     * Возвращает 10 наиболее часто встречающихся фраз и соответствующие счётчики.
     * Фраза - два подряд идущих слова.
     *
     * @param words Список слов.
     * @return Топ 10 фраз.
     */
    public static Map<String, Integer> top10Phrases(List<String> words) {
        // todo implement
        List<String> phrases = new ArrayList<>();
        for (int i = 1; i < words.size(); i++) {
            phrases.add(words.get(i - 1) + " " + words.get(i));
        }
        Map<String, Integer> phrasesCount = new HashMap<>();
        for (String phrase : phrases) {
            phrasesCount.merge(phrase, 1, Integer::sum);
        }

        List<Map.Entry<String, Integer>> entries = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : phrasesCount.entrySet()) {
            entries.add(entry);
        }
        entries.sort((e1, e2) -> Integer.compare(e2.getValue(), e1.getValue()));

        Map<String, Integer> top10phrases = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            final Map.Entry<String, Integer> entry = entries.get(i);
            top10phrases.put(entry.getKey(), entry.getValue());
        }
        return top10phrases;
    }

    /**
     * Возвращает символы и частоту их встречаемости.
     *
     * @param words Список слов.
     * @return Map где ключ - символ, а значение - сколько раз он встретился в списке слов.
     */
    public static Map<Character, Integer> charactersFrequency(List<String> words) {

        Map<Character, Integer> charsCount = new HashMap<>();

        for (String word : words) {
            for (int i = 0; i < word.length() ; i++) {
                charsCount.merge(word.charAt(i), 1, Integer :: sum);
            }
        }

        return charsCount;
    }
}
