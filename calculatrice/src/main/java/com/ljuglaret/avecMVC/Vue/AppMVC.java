package com.ljuglaret.avecMVC.Vue;

import com.ljuglaret.avecMVC.Vue.VueMvc;
import com.ljuglaret.avecMVC.ControleurP.Controleur;
import com.ljuglaret.avecMVC.ControleurP.ControleurClavier;


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
       //Controleur controller = new Controleur(mainView);

        ControleurClavier controllercl = new ControleurClavier(mainView);

        // Show stage
        primaryStage.setTitle("Calculatrice");
        primaryStage.setScene(new Scene(mainView.getVue()));
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}