package it.unibo.mvc;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import it.unibo.mvc.api.Controller;

/**
 * Controller implementation that prints on stdout.
 */
public class ControllerImpl implements Controller {

    private String toPrint;
    private final List<String> printedItems;

    /**
     * Setups an ArrayList for the logs.
     */
    public ControllerImpl() {
        this.printedItems = new ArrayList<>();
    }

    /**
     * Gets the next string that will be printed with {@link #print()}.
     * @return the string
     */
    public String getNextString() {
        return this.toPrint;
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public void setToPrint(final String toBePrinted) {
        this.toPrint = toBePrinted;
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public void print() {
        if (this.toPrint == null) {
            throw new IllegalArgumentException("String has not been setted");
        } else {
            System.out.println(this.toPrint); // NOPMD suppressed as it is a false positive
            this.printedItems.add(this.toPrint);
        }
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public List<String> getPrintLog() {
        return Collections.unmodifiableList(this.printedItems);
    }
}
