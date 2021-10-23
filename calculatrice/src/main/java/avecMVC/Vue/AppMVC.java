package avecMVC.Vue;

import avecMVC.Vue.VueMvc;
import avecMVC.ControleurP.Controleur;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class AppMVC extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Create View
        VueMvc mainView = new VueMvc();

        // Create Controller
        Controleur controller = new Controleur(mainView);

        // Show stage
        primaryStage.setTitle("Calculatrice");
        primaryStage.setScene(new Scene(mainView.getVue()));
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}