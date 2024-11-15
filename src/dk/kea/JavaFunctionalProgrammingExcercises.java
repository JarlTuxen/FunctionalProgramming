package dk.kea;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

public class JavaFunctionalProgrammingExcercises {
    public static void main(String[] args) {
        System.out.println("Exercise 1");
        BiFunction<Integer, Integer, Integer> add = (a, b) -> a + b;
        System.out.println(add.apply(2, 3)); // Output: 5

        interface Adder {
            int add(int a, int b);
        }
        Adder adder = (a, b) -> a + b;

        System.out.println(adder.add(2, 3));

        System.out.println("Exercise 2");
        //@FunctionalInterface
        interface Converter {
            String convert(int i);
        }
        Converter myConverter = (i) -> Integer.toString(i);
        System.out.println(myConverter.convert(5)); // Output: "5"
        String number = myConverter.convert(7);
        System.out.println(number);

        System.out.println("Exercise 3");
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        numbers.stream()
                .filter(n -> n % 2 == 0)
                .forEach(System.out::println); // Output: 2 4 6 8 10

        System.out.println("Exercise 4");
        List<String> strings = Arrays.asList("Hello", "World", "Functional", "Programming", "Java");
        strings.forEach(System.out::println);
        strings.forEach(s -> System.out.println(s));

        System.out.println("Exercise 5");
        Optional<String> optional = Optional.of("Hello World");
        optional.ifPresent(System.out::println); // Output: Hello World
        if (optional.isPresent()) {
            System.out.println(optional.get());
        }
        System.out.println(optional);

        Optional<String> empty = Optional.empty();
        empty.ifPresent(System.out::println);
        System.out.println(empty);

        System.out.println("Exercise 1");
        square();
        System.out.println("Exercise 2");
        filterAndMap();
        System.out.println("Exercise 3");
        composition();
        System.out.println("Exercise 4");
        reduce();
        System.out.println("Exercise 5");
        recursion();
    }

    public static void square() {
        Function<Integer, Integer> square = x -> x * x;
        int result = square.apply(5);
        System.out.println("Square of 5 is: " + result);
    }

    public static void filterAndMap() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        List<Integer> result = numbers.stream()
                .filter(n -> n % 2 != 0)
                .map(n -> n * 2)
                .collect(Collectors.toList());

        System.out.println("Filtered and doubled numbers: " + result);
    }

    public static void composition() {
        Function<Integer, Integer> square = x -> x * x;
        Function<Integer, Integer> addTen = x -> x + 10;

        Function<Integer, Integer> composedFunction = square.andThen(addTen);

        int result = composedFunction.apply(5);
        System.out.println("Square of 5 plus 10 is: " + result);
    }

    public static void reduce() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        int result = numbers.stream()
                .reduce(1, (a, b) -> a * b);

        System.out.println("Product of the numbers is: " + result);

        int sumOfNumbers = numbers.stream()
                .reduce(0, (a, b) -> a + b);

        System.out.println("Sum of the numbers is: " + sumOfNumbers);
    }

    public static void recursion() {
            int number = 5;
            int result = factorial(number);
            System.out.println("Factorial of " + number + " is: " + result);

            result = sumRec(number);
            System.out.println("Sum of recursive factorial of " + number + " is: " + result);
        }

    public static int factorial(int n) {
        if (n <= 1) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }

    public static int sumRec(int n) {
        if (n == 0) {
            return 0;
        } else {
            return n + sumRec(n-1);
        }
    }

}
