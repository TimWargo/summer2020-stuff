package summer2020.stuff;

import javafx.application.Application;

/**
 * This class is the driving class for the {@link CancerApp} class.
 */
public class Driver {

    /**
     * Main method that calls the Cancer Application.
     *
     * @param args the command-line arguments.
     */
    public static void main(String[] args) {
        try {
            Application.launch(CancerApp.class, args);
        } catch (UnsupportedOperationException e) {
            System.out.println(e);
            System.err.println("If this is a DISPLAY problem, then your X server connection");
            System.err.println("has likely timed out. This can generally be fixed by logging");
            System.err.println("out and logging back in.");
            System.exit(1);
        } // try
    } // main
} // Driver
