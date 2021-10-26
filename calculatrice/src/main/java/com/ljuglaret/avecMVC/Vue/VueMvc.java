/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package com.ljuglaret.avecMVC.Vue;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import java.util.*;
import com.ljuglaret.avecMVC.Modele.ModeleMvc;

public class VueMvc {

    VBox root = new VBox();
    Label result = new Label("");
    TextField saisieEnCours = new TextField("");
    Button button0 = new Button("0");
    Button button1 = new Button("1");
    Button button2 = new Button("2");
    Button button3 = new Button("3");
    Button button4 = new Button("4");
    Button button5 = new Button("5");
    Button button6 = new Button("6");
    Button button7 = new Button("7");
    Button button8 = new Button("8");
    Button button9 = new Button("9");

    Button buttonRetour = new Button("<=");
    Button buttonParOuvr = new Button(" ( ");
    Button buttonParFerm = new Button(" ) ");
    Button buttonDiv = new Button(" / ");
    Button buttonFois = new Button(" * ");
    Button buttonMoins = new Button(" -");
    Button buttonPlus = new Button(" + ");
    Button buttonEffacer = new Button("C");
    Button buttonEgal = new Button("=");
    Button buttonVirgule = new Button(",");

    Parent vue;

    public VueMvc() {
        vue = creerVue();
    }

    public Button getButton0() {
        return button0;
    }

    public Button getButton1() {
        return button1;
    }

    public Button getButton2() {
        return button2;
    }

    public Button getButton3() {
        return button3;
    }

    public Button getButton4() {
        return button4;
    }

    public Button getButton5() {
        return button5;
    }

    public Button getButton6() {
        return button6;
    }

    public Button getButton7() {
        return button7;
    }

    public Button getButton8() {
        return button8;
    }

    public Button getButton9() {
        return button9;
    }

    public Button getButtonRetour() {
        return buttonRetour;
    }

    public Button getButtonParOuvr() {
        return buttonParOuvr;
    }

    public Button getButtonParFerm() {
        return buttonParFerm;
    }

    public Button getButtonDiv() {
        return buttonDiv;
    }

    public Button getButtonFois() {
        return buttonFois;
    }

    public Button getButtonPlus() {
        return buttonPlus;
    }

    public Button getButtonMoins() {
        return buttonMoins;
    }

    public Button getButtonEffacer() {
        return buttonEffacer;
    }

    public Button getButtonEgal() {
        return buttonEgal;
    }

    public Button getButtonVirgule() {
        return buttonVirgule;
    }

    public TextField getSaisieEnCours() {
        return saisieEnCours;
    }

    public Label getResult() {
        return result;
    }

    private VBox creerVue() {

        String styleB = "-fx-font-size: 20px; -fx-border-radius: 10px;   -fx-padding: 40px;-fx-background-color: #f0f8ff; -fx-background-radius: 10px;  -fx-border-width: 1px;-fx-border-color: black; ";
        final String styleOperateur = "-fx-font-size: 20px; -fx-border-radius: 10px;   -fx-padding: 40px;-fx-background-color: #f7e2e2; -fx-background-radius: 10px;  -fx-border-width: 1px;-fx-border-color: black; ";
        final String styleEgal = "-fx-font-size: 20px; -fx-border-radius: 10px;   -fx-padding: 40px;-fx-background-color: #7e75f7; -fx-background-radius: 10px;  -fx-border-width: 1px;-fx-border-color: black; ";

        result.setFont(Font.font("Verdana", FontWeight.BOLD, 25));
        saisieEnCours.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
        button0.setStyle(styleB);
        button1.setStyle(styleB);
        button2.setStyle(styleB);
        button3.setStyle(styleB);
        button4.setStyle(styleB);
        button5.setStyle(styleB);
        button6.setStyle(styleB);
        button7.setStyle(styleB);
        button8.setStyle(styleB);
        button9.setStyle(styleB);

        buttonRetour.setStyle(styleOperateur);
        buttonParOuvr.setStyle(styleOperateur);
        buttonParFerm.setStyle(styleOperateur);
        buttonDiv.setStyle(styleOperateur);
        buttonFois.setStyle(styleOperateur);
        buttonMoins.setStyle(styleOperateur);
        buttonPlus.setStyle(styleOperateur);
        buttonEffacer.setStyle(styleOperateur);
        buttonEgal.setStyle(styleEgal);
        buttonVirgule.setStyle(styleB);

        HBox hbox1 = new HBox(10, buttonParOuvr, buttonParFerm, buttonRetour, buttonDiv);
        hbox1.setAlignment(Pos.BASELINE_CENTER);
        HBox hbox2 = new HBox(10, button7, button8, button9, buttonFois);
        hbox2.setAlignment(Pos.BASELINE_CENTER);
        HBox hbox3 = new HBox(10, button4, button5, button6, buttonMoins);
        hbox3.setAlignment(Pos.BASELINE_CENTER);
        HBox hbox4 = new HBox(10, button1, button2, button3, buttonPlus);
        hbox4.setAlignment(Pos.BASELINE_CENTER);
        HBox hbox5 = new HBox(10, button0, buttonVirgule, buttonEgal, buttonEffacer);
        hbox5.setAlignment(Pos.BASELINE_CENTER);

        root.getChildren().add(result);
        root.getChildren().add(saisieEnCours);
        root.getChildren().add(hbox1);
        root.getChildren().add(hbox2);
        root.getChildren().add(hbox3);
        root.getChildren().add(hbox4);
        root.getChildren().add(hbox5);

        return root;

    }

    public Parent getVue() {
        return vue;
    }

}