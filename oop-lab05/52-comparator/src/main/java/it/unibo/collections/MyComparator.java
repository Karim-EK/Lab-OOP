package it.unibo.collections;

import java.util.Comparator;

public class MyComparator implements Comparator<String>{

    @Override
    public int compare(String o1, String o2) {
        Double d1 = Double.parseDouble(o1);
        Double d2 = Double.parseDouble(o2);
        if (d1.equals(d2)) {
            return 0;
            //return (int)(d1 - d2);
        } else {
            return d1.compareTo(d2);
        }
    }
}
