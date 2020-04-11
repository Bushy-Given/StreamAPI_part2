import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.IntStream;

public class Run {
    public static void main(String[] args) throws Exception{
        int[] numbers = {1,2,3,4,5};

        IntSummaryStatistics intSummaryStatistics = IntStream.of(numbers)
                .filter(n -> n % 2 != 0)
                .peek(System.out::println)
                .summaryStatistics();
        System.out.println("count :" + intSummaryStatistics.getCount());


    }
}
