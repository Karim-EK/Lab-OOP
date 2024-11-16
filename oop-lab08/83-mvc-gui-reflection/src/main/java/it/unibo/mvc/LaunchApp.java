package it.unibo.mvc;

<<<<<<< HEAD
import java.lang.reflect.InvocationTargetException;

import it.unibo.mvc.api.DrawNumberController;
import it.unibo.mvc.api.DrawNumberView;
import it.unibo.mvc.controller.DrawNumberControllerImpl;
import it.unibo.mvc.model.DrawNumberImpl;
=======
import it.unibo.mvc.api.DrawNumberController;
import it.unibo.mvc.controller.DrawNumberControllerImpl;
import it.unibo.mvc.model.DrawNumberImpl;
import it.unibo.mvc.view.DrawNumberSwingView;
>>>>>>> cad967d33059882af678708569ecd6aea47ffd76

/**
 * Application entry-point.
 */
public final class LaunchApp {

    private LaunchApp() { }

    /**
     * Runs the application.
     *
     * @param args ignored
     * @throws ClassNotFoundException if the fetches class does not exist
     * @throws NoSuchMethodException if the 0-ary constructor do not exist
     * @throws InvocationTargetException if the constructor throws exceptions
     * @throws InstantiationException if the constructor throws exceptions
     * @throws IllegalAccessException in case of reflection issues
     * @throws IllegalArgumentException in case of reflection issues
     */
<<<<<<< HEAD
    public static void main(final String... args) throws Exception {
        final var model = new DrawNumberImpl();
        final DrawNumberController app = new DrawNumberControllerImpl(model);

        var swingViewClass = Class.forName("it.unibo.mvc.view.DrawNumberSwingView");
        var consoleViewClass = Class.forName("it.unibo.mvc.view.ConsoleView");

        for (int i = 0; i <= 3; i++) {
            app.addViews((DrawNumberView)swingViewClass.getDeclaredConstructor().newInstance());
            app.addViews((DrawNumberView)consoleViewClass.getConstructor().newInstance());
            //La differenza del secondo metodo è che il costruttore deve essere pubblico
        }
=======
    public static void main(final String... args) {
        final var model = new DrawNumberImpl();
        final DrawNumberController app = new DrawNumberControllerImpl(model);
        app.addView(new DrawNumberSwingView());
>>>>>>> cad967d33059882af678708569ecd6aea47ffd76
    }
}
