package diebold.chris.code;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class GenerateRandomNumber {

    public static List<Long> generate(long N) {
        // There is no random access so a linked list has better performance when lists are large.
        List<Long> numbers = new LinkedList<>();
        Random rand = new Random();
        // generate a pseudo-random uniformly random long.
        for(int  i = 0; i < N; i++) {
            numbers.add(rand.nextLong());
        }
        return numbers;
    }
}
