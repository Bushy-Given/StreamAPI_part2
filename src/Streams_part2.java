import person.Person;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;

/**
 * Created by Bushy-Netshidaulu
 * on 4/10/2020
 */
public class Streams_part2 {
    public static void main(String[] args) {

        List<Person> personList = Arrays.asList(
                new Person(25,"bushy") ,
                new Person(26,"rex"),
                new Person(30,"carole"),
                new Person(17,"tommy")
        );

        personList.stream()
                .filter(person -> person.getAge() < 10)
                .findAny().ifPresentOrElse(System.out::println, ()-> System.out.print("found nothing"));

        int ageSum = personList.stream().collect(Collectors.summingInt(Person::getAge)).intValue();
        System.out.println("collector : agesum : " + ageSum);

        int sum = personList.stream().mapToInt(Person::getAge).sum();
        System.out.println("Intstream agesum :" + sum);

        Function<Person,Stream<Integer>> flatMap = p->Stream.of(p.getAge());
        List<Integer> ageCollection = personList
                .stream()
                .flatMap(flatMap::apply)
                .collect(Collectors.toList());

        List<Integer> agelist = personList
                .stream()
                .map(Person::getAge)
                .collect(Collectors.toList());

        System.out.println("age flatmap :" + ageCollection);
        System.out.println("age map     :" + agelist);


        String str = "my name is bushy given";
        //using grouping by

        String[] words = str.split(" ");
        Map<String, List<String>> groupByMap = Stream.of(words)
                .collect(Collectors.groupingBy(word -> word.substring(0, 1)));

        //grouping by and counting

        Map<String, Long> groupByAndCounting= Stream.of(words)
                .collect(Collectors.groupingBy(word -> word.substring(0, 1), counting()));
        //using to map
        Map<String, String> toMap = Stream.of(words)
                .collect(Collectors.toMap(word -> word.substring(0, 1), identity()));

        System.out.println(groupByMap);
        System.out.println(groupByAndCounting);
        System.out.println(toMap);


    }
}
