package Stream.Stream_Api.HomeWork;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamHW {


    public static List<Integer> returnSquareRoot(List<Integer> num) {
        List<Integer> numbers = Arrays.asList(1, 4, 16, 256);
        return numbers
                .stream()
                .map(Math::sqrt)
                .map(Double::intValue)
                .collect(Collectors.toList());
    }

    public static List<Integer> getAgeFromUsers(List<User> user) {
        List<User> users = User.getUsersWithAge(18, 20);
        return users
                .stream()
                .map(User::getAge)
                .collect(Collectors.toList());
    }

    public static List<Integer> getDistinctAges(List<User> users) {
        return users
                .stream()
                .map(User::getAge)
                .distinct()
                .collect(Collectors.toList());
    }

    public static List<User> getLimitedUserList(List<User> users, int limit) {
        return users
                .stream()
                .limit(limit)
                .collect(Collectors.toList());
    }

    public static Integer countUsersOlderThen25(List<User> users) {
        return Math.toIntExact(users
                .stream()
                .filter(s -> s.getAge() > 25).count());
    }

    public static List<String> mapToUpperCase(List<String> strings) {
        List<String> input = Arrays.asList("This", "is", "java", "8");
        return input
                .stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
    }

    public static Integer sum(List<Integer> integers) {
        return integers
                .stream()
                .mapToInt(Integer::intValue)
                .sum();

    }

    public static List<Integer> skip(List<Integer> integers, Integer toSkip) {
        return integers
                .stream()
                .skip(toSkip)
                .collect(Collectors.toList());
    }

    public static List<String> getFirstNames(List<String> names) {
        return names
                .stream()
                .map(s -> s.split(" ")[0])
                .collect(Collectors.toList());
    }

    public static List<String> getDistinctLetters(List<String> names) {

        return names
                .stream()
                .flatMap(p -> Arrays.stream(p.split("")))
                .distinct()
                .collect(Collectors.toList());
    }


    public static String separateNamesByComma(List<User> users) {
        return users
                .stream().map(s -> s + "")
                .collect(Collectors.joining(","));


    }

    public static double getAverageAge(List<User> users) {
        return users
                .stream()
                .mapToDouble(User::getAge).average().getAsDouble();
    }

    public static Integer getMaxAge(List<User> users) {
        return users
                .stream()
                .max(Comparator.comparing(User::getAge))
                .get()
                .getAge();
    }

    public static Integer getMinAge(List<User> users) {
        return users
                .stream()
                .min(Comparator.comparing(User::getAge))
                .get()
                .getAge();

    }

    public static Map<Boolean, List<User>> partionUsersByGender(List<User> users) {
        return users
                .stream()
                .collect(Collectors.groupingBy(User::isMale));
    }

    public static Map<Integer, List<User>> groupByAge(List<User> users) {
        return users
                .stream()
                .collect(Collectors.groupingBy(User::getAge));
    }

    public static Map<Boolean, Map<Integer, List<User>>> groupByGenderAndAge(List<User> users) {
        return users
                .stream()
                .collect(Collectors.groupingBy(User::isMale,Collectors
                        .groupingBy(User::getAge)));
    }

    public static Map<Boolean, Long> countGender(List<User> users) {
        Map<Boolean, Long> map = users
                .stream()
                .collect(Collectors.groupingBy(User::isMale, Collectors.counting()));

        return map;
    }

    public static boolean anyMatch(List<User> users, int age) {
        return users
                .stream()
                .anyMatch((s) -> s.getAge() == age);
    }

    public static boolean noneMatch(List<User> users, int age) {
        return users
                .stream()
                .allMatch((s) -> s.getAge() != age);
    }

    public static Optional<User> findAny(List<User> users, String name) {
        return users
                .stream()
                .filter(s -> s.getName().equals(name))
                .findFirst();
    }

    public static List<User> sortByAge(List<User> users) {
        return users
                .stream()
                .sorted(Comparator.comparing(User::getAge))
                .collect(Collectors.toList());
    }

    public static Stream<Integer> getBoxedStream(IntStream stream) {
        return stream.boxed();
    }

    public static List<Integer> generateFirst10PrimeNumbers() {
        return IntStream.range(2, 30)
                .filter(StreamHW::isPrime)
                .boxed()
                .collect(Collectors.toCollection(() -> new ArrayList<>()));
    }

    public static boolean isPrime(int number) {
        return IntStream.rangeClosed(2, number / 2).noneMatch(i -> number % i == 0);
    }

    public static List<Integer> generate10RandomNumbers() {
        return IntStream
                .generate(() -> (int) (Math.random() * 100))
                .limit(100).boxed()
                .collect(Collectors.toList());
    }

    public static User findOldest(List<User> users) {
        return users
                .stream()
                .max(Comparator.comparing(User::getAge))
                .get();
    }

    public static int sumAge(List<User> users) {
        return users
                .stream()
                .mapToInt(User::getAge)
                .sum();
    }

    public static IntSummaryStatistics ageSummaryStatistics(List<User> users) {
        return users
                .stream()
                .mapToInt(User::getAge)
                .summaryStatistics();
    }
}


