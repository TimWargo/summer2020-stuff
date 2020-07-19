package summer2020.stuff.projects.profile;

import javafx.application.Application;

public class ProfileDriver {

    /**
     * Main method that calls the Profile Application.
     *
     * @param args the command-line arguments.
     */
    public static void main(String[] args) {
        try {
            Application.launch(ProfileApp.class, args);
        } catch (UnsupportedOperationException e) {
            System.out.println(e);
            System.exit(1);
        } // try
    } // main
} // ProfileDriver