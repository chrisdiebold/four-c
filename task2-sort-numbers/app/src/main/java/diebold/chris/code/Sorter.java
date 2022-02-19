package diebold.chris.code;

import java.util.Collections;
import java.util.List;

public class Sorter {
    public static void sort(List<Long> numbers, boolean asc, boolean desc) {
        if(asc && desc || asc) {
            // judgement call: sort ascending
            Collections.sort(numbers);
        } else {
            Collections.sort(numbers, Collections.reverseOrder());
        }
    }
}
