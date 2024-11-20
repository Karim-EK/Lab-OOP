package it.unibo.mvc.api;

import java.util.List;

/**
 * Defines the common operations for needed controller.
 */
public interface Controller {
    /**
     * prepare a string to be printed via {@link #print()}.
     * @param text the desired text
     */

    void setToPrint(String text);
    /**
     * Print the previusly setted string with {@link #setToPrint(String)}.
     * @throws IllegalStateException if the string is not set
     */
    void print();

    /**
     * @return in order from last to first all the Strings printed before
     */
    List<String> getPrintLog();
}
