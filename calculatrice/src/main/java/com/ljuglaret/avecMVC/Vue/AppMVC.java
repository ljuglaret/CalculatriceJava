package com.ljuglaret.avecMVC.Vue;

import com.ljuglaret.avecMVC.Vue.VueMvc;
import com.ljuglaret.avecMVC.ControleurP.ControleurBouton;
import com.ljuglaret.avecMVC.ControleurP.ControleurClavier;
import com.ljuglaret.avecMVC.ControleurP.MainControler;

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
        MainControler ctrl = new MainControler(mainView);


        // Show stage
        primaryStage.setTitle("Calculatrice");
        primaryStage.setScene(new Scene(mainView.getVue()));
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}