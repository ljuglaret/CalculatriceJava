package com.ljuglaret.avecMVC.ControleurP;

import com.ljuglaret.avecMVC.Vue.VueMvc;
import com.ljuglaret.avecMVC.Modele.ModeleMvc;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;

import java.awt.*;    
import java.awt.event.*;    

public class Controleur  {
    ModeleMvc modele;

    public Controleur(VueMvc vue) {

        modele = new ModeleMvc("");

        /***********************************
         * 
         * Contrôle Chifffres *
         * 
         ***********************************
         */


        vue.getButton0().setOnAction(event -> {
            modele.ajoutSymbole("0");
            vue.getSaisieEnCours().setText(modele.getExpression().get());
            event.consume();
        });
        vue.getButton1().setOnAction(event -> {
            modele.ajoutSymbole("1");
            vue.getSaisieEnCours().setText(modele.getExpression().get());
            event.consume();
        });
        vue.getButton2().setOnAction(event -> {
            modele.ajoutSymbole("2");
            vue.getSaisieEnCours().setText(modele.getExpression().get());
            event.consume();
        });
        vue.getButton3().setOnAction(event -> {
            modele.ajoutSymbole("3");
            vue.getSaisieEnCours().setText(modele.getExpression().get());
            event.consume();
        });
        vue.getButton4().setOnAction(event -> {
            modele.ajoutSymbole("4");
            vue.getSaisieEnCours().setText(modele.getExpression().get());
            event.consume();
        });
        vue.getButton5().setOnAction(event -> {
            modele.ajoutSymbole("5");
            vue.getSaisieEnCours().setText(modele.getExpression().get());
            event.consume();
        });
        vue.getButton6().setOnAction(event -> {
            modele.ajoutSymbole("6");
            vue.getSaisieEnCours().setText(modele.getExpression().get());
            event.consume();
        });
        vue.getButton7().setOnAction(event -> {
            modele.ajoutSymbole("7");
            vue.getSaisieEnCours().setText(modele.getExpression().get());
            event.consume();
        });
        vue.getButton8().setOnAction(event -> {
            modele.ajoutSymbole("8");
            vue.getSaisieEnCours().setText(modele.getExpression().get());
            event.consume();
        });
        vue.getButton9().setOnAction(event -> {
            modele.ajoutSymbole("9");
            vue.getSaisieEnCours().setText(modele.getExpression().get());
            event.consume();
        });

        /***********************************
         * 
         * Contrôle virgule
         * 
         ***********************************
         */

        vue.getButtonVirgule().setOnAction(event -> {
            modele.ajoutSymbole(".");
            vue.getSaisieEnCours().setText(modele.getExpression().get());
            event.consume();
        });

        /***********************************
         * 
         * Contrôle des opérateurs
         * 
         ***********************************
         */
        vue.getButtonPlus().setOnAction(event -> {
            modele.ajoutSymbole(" + ");
            vue.getSaisieEnCours().setText(modele.getExpression().get());
            event.consume();
        });
        vue.getButtonMoins().setOnAction(event -> {
            modele.ajoutSymbole(" -");
            vue.getSaisieEnCours().setText(modele.getExpression().get());
            event.consume();
        });
        vue.getButtonFois().setOnAction(event -> {
            modele.ajoutSymbole(" * ");
            vue.getSaisieEnCours().setText(modele.getExpression().get());
            event.consume();
        });
        vue.getButtonDiv().setOnAction(event -> {
            modele.ajoutSymbole(" / ");
            vue.getSaisieEnCours().setText(modele.getExpression().get());
            event.consume();
        });

        /***********************************
         * 
         * Contrôle des bouttons parenthèses
         * 
         ***********************************
         */
        vue.getButtonParOuvr().setOnAction(event -> {
            modele.ajoutSymbole(" ( ");
            vue.getSaisieEnCours().setText(modele.getExpression().get());
            event.consume();
        });
        vue.getButtonParFerm().setOnAction(event -> {
            modele.ajoutSymbole(" ) ");
            vue.getSaisieEnCours().setText(modele.getExpression().get());
            event.consume();
        });
        /***********************************
         * 
         * Contrôle retour
         * 
         ***********************************
         */
        vue.getButtonRetour().setOnAction(event -> {
            String chaineAEvaluer = modele.getExpression().get();
            if (chaineAEvaluer.charAt(chaineAEvaluer.length() - 1) == ' ') {
                modele.setExpression(chaineAEvaluer.substring(0, chaineAEvaluer.length() - 2));
            } else {
                modele.setExpression(chaineAEvaluer.substring(0, chaineAEvaluer.length() - 1));
            }
            vue.getSaisieEnCours().setText(modele.getExpression().get());
            event.consume();
        });

        /***********************************
         * 
         * Contrôle égalité
         * 
         ***********************************
         */
        vue.getButtonEgal().setOnAction(event -> {
            ModeleMvc calcul = new ModeleMvc(modele.getExpression().get());
            String chaineEvaluee = String.valueOf(calcul.evaluer().get());
            vue.getResult().setText(chaineEvaluee);
            vue.getSaisieEnCours().setText(modele.getExpression().get());
            modele.setExpression(chaineEvaluee);
            event.consume();
        });

        /***********************************
         * 
         * Contrôle tout effacer
         * 
         ***********************************
         */
        vue.getButtonEffacer().setOnAction(event -> {
            modele.setExpression("");
            vue.getResult().setText("");
            vue.getSaisieEnCours().setText(modele.getExpression().get());
            event.consume();
        });

        // vue.getSaisieEnCours().textProperty().bind(modele.getExpression());

        // vue.getResult().textProperty().bind(modele.evaluer().asString());

    }

}