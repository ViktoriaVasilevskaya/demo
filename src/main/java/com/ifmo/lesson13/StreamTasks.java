package com.ifmo.lesson13;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.Random;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toMap;

public class StreamTasks {

    static class Person {
        final String name;
        final int age;
        final String country;

        public Person(String name, int age, String country) {
            this.name = name;
            this.age = age;
            this.country = country;
        }

        public String getCountry() { return country;}
        public int getAge() { return age;}
        public String getName() {return name;}
    }

    public static void main(String[] args) {
        List<Person> people = generatePeople(30).collect(Collectors.toList());

        List<String> countries = countriesSortedByTheirPopulationDescending(people.stream());
        String countryThatHasMostKids = countryThatHasMostKids(people.stream());
        Map<String, Long> populationByCountry = populationByCountry(people.stream());

        //System.out.println(people);
        System.out.println(countries);
        System.out.println(countryThatHasMostKids);
        System.out.println(populationByCountry);

        List<String> words = List.of("the", "hello", "approximation", "greetings", "java", "war");

        Map<Integer, Set<String>> wordsByLength = groupWordsByLength(words);
        int averageWordLength = averageWordLength(words);
        Set<String> longestWords = longestWords(words);

        System.out.println(wordsByLength);
        System.out.println(averageWordLength);
        System.out.println(longestWords);
    }

    // Метод возвращает страны в порядке убывания их населения.
    public static List<String> countriesSortedByTheirPopulationDescending(Stream<Person> people) {

       return people
               .parallel()
               .collect(Collectors.groupingBy(Person::getCountry,Collectors.counting()))
               .entrySet().parallelStream()
               .sorted((e1,e2) -> e2.getValue().compareTo(e1.getValue()))
               .map(e -> e.getKey())
               .collect(Collectors.toList());
    }

    // Метод находит страну (или одну из стран), в которых больше всего человек в возрасте
    // до 18 лет.
    public static String countryThatHasMostKids(Stream<Person> people) {
        return people
                .parallel()
                .filter(x -> x.getAge() > 18)
                .collect(groupingBy(Person::getCountry,Collectors.counting()))
                .entrySet().parallelStream()
                .sorted((a1,a2) -> a2.getValue().compareTo(a1.getValue()))
                .limit(1)
                .map(Map.Entry::getKey)
                .findAny()
                .orElse("Not found");

    }

    // Метод возвращает карту стран их населения.
    public static Map<String, Long> populationByCountry(Stream<Person> people) {
        return people
                .parallel()
                .collect(Collectors.groupingBy(Person::getCountry,Collectors.counting()))
                .entrySet().parallelStream()
                .collect(toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    private final static String [] NAMES = {"Ivan", "Kate", "Mark", "Alexey", "Veronica"};
    private final static String [] COUNTRIES = {"Russia", "Italy", "UK"};
    // Метод генерирует случайных людей в ограниченном наборе стран.
    // number - число желаемых людей.
    public static Stream<Person> generatePeople(int number) {
        var rand = new Random();

        return IntStream.range(0,number)
                .boxed()
                .map(i -> new Person(
                        NAMES[rand.nextInt(NAMES.length)],
                        rand.nextInt(75),
                        COUNTRIES[rand.nextInt(COUNTRIES.length)]
                ));
    }

    // Метод возвращает карту сгруппированных слов по их длине. Например, для
    // трёхбуквенных слов будет:
    // 3 -> "the", "map", "got", "war"...
    public static Map<Integer, Set<String>> groupWordsByLength(List<String> words) {

        return words.stream()
                        .parallel()
                        .collect(groupingBy(String :: length, Collectors.toSet()));

    }

    // Метод находит среднюю длину слов в списке.
    public static int averageWordLength(List<String> words) {
        int totalLen = words.stream()
                .map(w -> w.length())
                .reduce(0, (i1,i2) -> i1 + i2);

//        int average = (int) words.stream()
//                .mapToInt(w -> w.length())
//                .average().orElse(0.0);
//
//        int av2 = words.stream()
//                .map(w -> w.length())
//                .collect(Collectors.averagingInt(i -> i))
//                .intValue();

        return totalLen / words.size();
    }

    // Метод находит самое длинное слово или слова, если таких несколько.
    public static Set<String> longestWords(List<String> words) {
        return words.stream()
                .parallel()
                .collect(groupingBy(String :: length))
                .entrySet().parallelStream()
                .sorted((w1,w2) -> w2.getKey().compareTo(w1.getKey()))
                .limit(1)
                .flatMap(e -> e.getValue().stream())
                .collect(Collectors.toSet());


    }


}
