package com.ljuglaret.versionCnam.Vue;


import com.ljuglaret.versionCnam.ControleurP.MainControler;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppMVC extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Create View
        VueMvc mainView = new VueMvc();
        primaryStage.setWidth(600);
        primaryStage.setHeight(400);

        // Create Controller
        new MainControler(mainView);


        // Show stage
        primaryStage.setTitle("Calculatrice");
        primaryStage.setScene(new Scene(mainView.getVue()));
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}