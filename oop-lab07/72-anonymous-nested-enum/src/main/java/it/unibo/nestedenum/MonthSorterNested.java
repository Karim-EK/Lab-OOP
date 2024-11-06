package it.unibo.nestedenum;

import java.util.Comparator;
import java.util.NoSuchElementException;

/**
 * Implementation of {@link MonthSorter}.
 */
public final class MonthSorterNested implements MonthSorter {

    @Override
    public Comparator<String> sortByDays() {
        return new SortByMonthOrder();
    }

    @Override
    public Comparator<String> sortByOrder() {
        return new SortByDate();
    }

    private enum Month {
        JANUARY(31), FEBRUARY(28), MARCH(31), APRIL(30), MAY(31), JUNE(30), 
        JULY(31), AUGUST(31), SEPTEMBER(30), OCTOBER(31), NOVEMBER(30), DICEMBER(31);
        
        private final int numberOfDays;

        Month(int i) {
            this.numberOfDays = i;
        }

        private static Month fromString(String string) {
            string = string.toLowerCase();
            int charsToCheck = 0;
            var firstChars = string.substring(0,charsToCheck);
            int monthsFound = 0;
            Month lastFound = null;
            do {
                for (var month : Month.values()) {
                    if (month.name().startsWith(firstChars)) {
                        monthsFound++;
                        lastFound = month;
                    }
                }
                if (monthsFound == 1) {
                    return lastFound;
                } else {
                    charsToCheck++;
                    firstChars = string.substring(0, charsToCheck);
                }
            } while (charsToCheck < string.length());
            throw new NoSuchElementException();
        }
    }
    private static class SortByMonthOrder implements Comparator<String>{

        @Override
        public int compare(String o1, String o2) {
            var m1 = Month.fromString(o1); 
            var m2 = Month.fromString(o2);
            return Integer.compare(m1.ordinal(), m2.ordinal());
        }
        
    }

    private static class SortByDate implements Comparator<String> {

        @Override
        public int compare(String o1, String o2) {
            var m1 = Month.fromString(o1); 
            var m2 = Month.fromString(o2);
            return Integer.compare(m1.numberOfDays, m2.numberOfDays);        
        }

    }
}
