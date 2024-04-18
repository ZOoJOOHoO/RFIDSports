package data;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ZJH$$$
 * @date 2024/4/15 19:45
 **/
public class EPCSet {

    public static Set<String> epcSet;

    static {
        epcSet = new HashSet<>();
        epcSet.add("3008 33B2 DDD9 2000 0415 1111");
        epcSet.add("3008 33B2 DDD9 2000 0415 2222");
        epcSet.add("3008 33B2 DDD9 2000 0415 3333");
        epcSet.add("3008 33B2 DDD9 2000 0415 4444");
        epcSet.add("3008 33B2 DDD9 2000 0415 5555");
        epcSet.add("3008 33B2 DDD9 2000 0415 6666");
        epcSet.add("3008 33B2 DDD9 2000 0415 7777");
        epcSet.add("3008 33B2 DDD9 2000 0415 8888");

    }
}
