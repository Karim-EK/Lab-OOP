package it.unibo.collections;

import java.util.Comparator;
import static java.lang.Double.parseDouble;

public class MyComparator implements Comparator<String>{

    @Override
    public int compare(final String o1, final String o2) {
        return Double.compare(parseDouble(o1), parseDouble(o2));
        // if (d1.equals(d2)) {
        //     return 0;
        //     //return (int)(d1 - d2);
        // } else {
        //     return d1.compareTo(d2);
        // }
    }
}
