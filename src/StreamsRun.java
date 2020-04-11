import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamsRun {
    public static void main(String[] args) {

        var myList = new ArrayList<Integer>(Arrays.asList(7,18,10,24,17,5));
        System.out.println("original List " + myList);

        //obtain a ream from the arrayList
        Stream<Integer> myStream = myList.stream();
        //obtain mininmum and maximum values by use of min() and max() , ifPresent and get
        Optional<Integer> minVal = myStream.min(Integer::compareTo);
        if (minVal.isPresent()) System.out.println("minVal :" + minVal.get());
        //must obtain an new stream because prev 1 is terminated by calling min() method
        myStream = myList.stream();
        Optional<Integer> maxVal = myStream.max(Integer::compareTo);
        if (maxVal.isPresent()) System.out.println("maxVal :" + maxVal.get());

        //sort a stream by use of sorted;
        Stream<Integer> sortedStream = myList.stream().sorted();
        //display the sorted stream by use of forEach
        System.out.print("sorted stream : ");
        sortedStream.forEach(n -> System.out.print(n + " "));
        System.out.println();

        //display only the odds values by use of filter
        Stream<Integer> oddVals = myList.stream().sorted()
                .filter(n -> n % 2 == 1);
        System.out.print("odd values : ");
        oddVals.forEach(n-> System.out.print(n + " "));
        System.out.println();
        //odds numbers that are greater that 5
        myList.stream().sorted()
                .filter(n -> n % 2 == 1)
                .filter(n -> n > 5)
                .reduce(0,(a,b)-> a > 5 ? a : b);
        //collecting to linkedList
        LinkedList<Integer> linkedList = myList.stream()
                .collect(LinkedList::new, LinkedList::add, LinkedList::addAll);
        System.out.println("LinkedList : " + linkedList);
    }
}
