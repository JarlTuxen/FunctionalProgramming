package dk.kea;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SoldiersMain {
    public static void main(String[] args) {
        List<Soldier> soldiers = new ArrayList<>();
        soldiers.add(new Soldier(4,"Jens"));
        soldiers.add(new Soldier(4,"Jens1"));
        soldiers.add(new Soldier(3,"Jens2"));
        soldiers.add(new Soldier(1,"Ole"));
        soldiers.add(new Soldier(5,"Kurt"));

        soldiers.forEach(s -> System.out.println(s));
        //for (Soldier soldier : soldiers) {
        //    System.out.println(soldier);
        //}

        System.out.println("High Ranked:");
        Predicate<Soldier> isHighRanked = soldier -> soldier.getRank() > 3;
        Stream<Soldier> highSoldiers = soldiers.stream().filter(isHighRanked);
        highSoldiers.forEach(s -> System.out.println(s));
        //soldiers.stream()
        //        .filter(s -> s.getRank() > 3)
        //        .forEach(s -> System.out.println(s));


        System.out.println("High and StartsWithJ");
        Predicate<Soldier> startsWithJ = s -> s.getName().startsWith("J");
        Stream<Soldier> highAndJ = soldiers.stream().filter(isHighRanked).filter(startsWithJ);
        //highAndJ.forEach(s -> System.out.println(s));
        List<Soldier> highAndJList = highAndJ.collect(Collectors.toList());
        System.out.println(highAndJList);

        System.out.println("Map");
        Function<Soldier, String> getNames = soldier -> soldier.getName();
        List<String> names = highAndJList.stream().map(getNames).collect(Collectors.toList());
        highAndJList.stream().map(getNames).collect(Collectors.toList()).forEach(System.out::println);
    }
}
