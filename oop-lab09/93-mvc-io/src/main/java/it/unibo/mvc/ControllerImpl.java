package it.unibo.mvc;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import it.unibo.mvc.api.Controller;

public class ControllerImpl implements Controller {

    private String toPrint;
    private List<String> printedItems;

    public ControllerImpl() {
        this.printedItems = new ArrayList<>();
    }

    public String getNextString() {
        return this.toPrint;
    }

    @Override
    public void setToPrint(String toBePrinted) {
        this.toPrint = toBePrinted;
    }

    @Override
    public void print() {
        if (this.toPrint == null) {
            throw new IllegalArgumentException("String has not been setted");
        } else {
            System.out.println(this.toPrint);
            this.printedItems.add(this.toPrint);
        }
    }

    @Override
    public List<String> getPrintLog() {
        return Collections.unmodifiableList(this.printedItems);
    }
    
}