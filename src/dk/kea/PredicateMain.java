package dk.kea;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PredicateMain {
    public static void main(String[] args) {
        List<Soldier> soldiers = new ArrayList<>();
        soldiers.add(new Soldier(4,"Jens"));
        soldiers.add(new Soldier(4,"Jens1"));
        soldiers.add(new Soldier(3,"Jens2"));
        soldiers.add(new Soldier(1,"Ole"));
        soldiers.add(new Soldier(5,"Kurt"));

        soldiers.forEach(s -> System.out.println(s));

        System.out.println("High Ranked:");
        Predicate<Soldier> isHighRanked = soldier -> soldier.getRank() > 3;
        Stream<Soldier> highSoldiers = soldiers.stream().filter(isHighRanked);
        highSoldiers.forEach(s -> System.out.println(s));

        System.out.println("High and StartsWithJ");
        Predicate<Soldier> startsWithJ = s -> s.getName().startsWith("J");
        Stream<Soldier> highAndJ = soldiers.stream().filter(isHighRanked).filter(startsWithJ);
        highAndJ.forEach(s -> System.out.println(s));

        System.out.println(soldiers.stream().filter(startsWithJ).collect(Collectors.toList()));
    }
}
