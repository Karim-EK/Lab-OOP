package it.unibo.mvc.view;

import it.unibo.mvc.api.DrawNumberView;
import it.unibo.mvc.api.DrawNumberController;
import it.unibo.mvc.api.DrawResult;

public class ConsoleView implements DrawNumberView {

    public ConsoleView() {
        
    }

    @Override
    public void setController(DrawNumberController observer) {
    }

    @Override
    public void start() {
        System.out.println("Ready to print results on STDOUT:");
    }

    @Override
    public void result(DrawResult res) {
        System.out.println(res.getDescription());
    }
    
}
