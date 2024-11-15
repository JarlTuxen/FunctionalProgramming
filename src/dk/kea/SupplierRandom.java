package dk.kea;

import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class SupplierRandom {
    public static void main(String[] args) {
        Supplier<Double> ran = () -> Math.random(); //Supplier er et interface i Java, et såkaldt functional interface

        Stream<Double> randomNumbers = Stream.generate(ran);

        //randomNumbers.limit(10).forEach(System.out::println);

        Function<Double, Long> dblRound = d -> Math.round(d*100); //tal 0 - 99
        Predicate<Long> longEqual = rannum -> rannum % 2 == 0;

        Stream<Long> ranLong = randomNumbers.map(dblRound).filter(longEqual).limit(12);
        //ranLong.forEach(System.out::println);
        DoubleStream randDbl = ranLong.mapToDouble(d -> d);
        //System.out.println("max = " + randDbl.max());
        System.out.println("average = " + randDbl.average());
    }
}
