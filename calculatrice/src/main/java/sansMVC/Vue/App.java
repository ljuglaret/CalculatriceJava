/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package sansMVC.Vue;

import sansMVC.Modele.Calculer;

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

import java.util.List;

import java.util.ArrayList;

public class App extends Application {

    private String chaineAEvaluer = "";
    private String chaineEvaluee = "";
    final String styleB = "-fx-font-size: 20px; -fx-border-radius: 10px;   -fx-padding: 40px;-fx-background-color: #f0f8ff; -fx-background-radius: 10px;  -fx-border-width: 1px;-fx-border-color: black; ";
    final String styleOperateur = "-fx-font-size: 20px; -fx-border-radius: 10px;   -fx-padding: 40px;-fx-background-color: #f7e2e2; -fx-background-radius: 10px;  -fx-border-width: 1px;-fx-border-color: black; ";
    final String styleEgal = "-fx-font-size: 20px; -fx-border-radius: 10px;   -fx-padding: 40px;-fx-background-color: #7e75f7; -fx-background-radius: 10px;  -fx-border-width: 1px;-fx-border-color: black; ";

    public void onClick(Button button, TextField saisieEnCours) {
        button.setOnMouseClicked((MouseEvent event) -> {
            chaineAEvaluer += button.getText();
            String aLecran = chaineAEvaluer.replaceAll(" ", "");
            saisieEnCours.setText(aLecran);
        });
    }

    public void onClickVirgule(Button button, TextField saisieEnCours) {
        button.setOnMouseClicked((MouseEvent event) -> {
            chaineAEvaluer += ".";
            String aLecran = chaineAEvaluer.replaceAll(" ", "");
            saisieEnCours.setText(aLecran);
        });
    }

    public void onClickRetour(Button button, TextField saisieEnCours) {
        button.setOnMouseClicked((MouseEvent event) -> {
            if (chaineAEvaluer.charAt(chaineAEvaluer.length() - 1) == ' ') {
                chaineAEvaluer = chaineAEvaluer.substring(0, chaineAEvaluer.length() - 2);
            } else {
                chaineAEvaluer = chaineAEvaluer.substring(0, chaineAEvaluer.length() - 1);
            }
            String aLecran = chaineAEvaluer.replaceAll(" ", "");
            saisieEnCours.setText(aLecran);
        });
    }

    public void onClickEgal(Button buttonEg, TextField result) {
        buttonEg.setOnMouseClicked((MouseEvent event) -> {
            Calculer calcul = new Calculer(chaineAEvaluer);
            chaineEvaluee = String.valueOf(calcul.evaluer());
            result.setText(chaineEvaluee);
            // Possibilité de continuer le calcul
            chaineAEvaluer = chaineEvaluee;
        });
    }

    public void onClickEffacer(Button buttonEg, TextField saisieEnCours) {
        buttonEg.setOnMouseClicked((MouseEvent event) -> {
            chaineAEvaluer = "";
            chaineEvaluee = "";
            saisieEnCours.setText(chaineEvaluee);
        });
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        VBox root = new VBox();
        primaryStage.setTitle("Calculatrice");
        TextField result = new TextField();
        result.setFont(Font.font("Verdana", FontWeight.BOLD, 25));
        TextField saisieEnCours = new TextField();
        saisieEnCours.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
        List<Button> numbersButtons = new ArrayList<Button>();

        for (int i = 0; i <= 9; i++) {
            Button button = new Button(String.valueOf(i));
            button.setStyle(styleB);
            onClick(button, saisieEnCours);
            numbersButtons.add(button);
        }

        Button buttonRetour = new Button("<=");
        buttonRetour.setStyle(styleOperateur);
        onClickRetour(buttonRetour, saisieEnCours);

        Button buttonParOuvr = new Button(" ( ");
        buttonParOuvr.setStyle(styleOperateur);
        onClick(buttonParOuvr, saisieEnCours);

        Button buttonParFerm = new Button(" ) ");
        buttonParFerm.setStyle(styleOperateur);
        onClick(buttonParFerm, saisieEnCours);

        Button buttonDiv = new Button(" / ");
        buttonDiv.setStyle(styleOperateur);
        onClick(buttonDiv, saisieEnCours);

        Button buttonFois = new Button(" * ");
        buttonFois.setStyle(styleOperateur);
        onClick(buttonFois, saisieEnCours);

        Button buttonMoins = new Button(" -");
        buttonMoins.setStyle(styleOperateur);
        onClick(buttonMoins, saisieEnCours);

        Button buttonPlus = new Button(" + ");
        buttonPlus.setStyle(styleOperateur);
        onClick(buttonPlus, saisieEnCours);

        Button buttonEffacer = new Button("C");
        buttonEffacer.setStyle(styleOperateur);
        onClickEffacer(buttonEffacer, saisieEnCours);

        Button buttonEgal = new Button("=");
        buttonEgal.setStyle(styleEgal);
        onClickEgal(buttonEgal, result);

        Button buttonVirgule = new Button(",");
        buttonVirgule.setStyle(styleB);
        onClickVirgule(buttonVirgule, saisieEnCours);

        HBox hbox1 = new HBox(10, buttonParOuvr, buttonParFerm, buttonRetour, buttonDiv);
        hbox1.setAlignment(Pos.BASELINE_CENTER);
        HBox hbox2 = new HBox(10, numbersButtons.get(7), numbersButtons.get(8), numbersButtons.get(9), buttonFois);
        hbox2.setAlignment(Pos.BASELINE_CENTER);
        HBox hbox3 = new HBox(10, numbersButtons.get(4), numbersButtons.get(5), numbersButtons.get(6), buttonMoins);
        hbox3.setAlignment(Pos.BASELINE_CENTER);
        HBox hbox4 = new HBox(10, numbersButtons.get(1), numbersButtons.get(2), numbersButtons.get(3), buttonPlus);
        hbox4.setAlignment(Pos.BASELINE_CENTER);
        HBox hbox5 = new HBox(10, numbersButtons.get(0), buttonVirgule, buttonEgal, buttonEffacer);
        hbox5.setAlignment(Pos.BASELINE_CENTER);

        root.getChildren().add(result);
        root.getChildren().add(saisieEnCours);
        root.getChildren().add(hbox1);
        root.getChildren().add(hbox2);
        root.getChildren().add(hbox3);
        root.getChildren().add(hbox4);
        root.getChildren().add(hbox5);

        Scene scene1 = new Scene(root, 500, 700);
        primaryStage.setScene(scene1);
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
