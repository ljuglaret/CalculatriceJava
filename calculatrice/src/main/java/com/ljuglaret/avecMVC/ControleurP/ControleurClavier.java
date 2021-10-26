package com.ljuglaret.avecMVC.ControleurP;

import com.ljuglaret.avecMVC.Vue.VueMvc;
import com.ljuglaret.avecMVC.Modele.ModeleMvc;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
//https://docs.oracle.com/javafx/2/api/javafx/scene/input/KeyCode.html
public class ControleurClavier  {
    ModeleMvc modele;

    public ControleurClavier(VueMvc vue) {

        modele = new ModeleMvc("");
        vue.getSaisieEnCours().setOnKeyPressed(event -> {
            
        /***********************************
         * 
         * Contrôle Chifffres *
         * 
         ***********************************
         */
            if (event.getCode() == KeyCode.NUMPAD0){
                modele.ajoutSymbole("0");
            }
            else if (event.getCode() == KeyCode.NUMPAD1){
                modele.ajoutSymbole("1");

            }
            else if (event.getCode() == KeyCode.NUMPAD2){
                modele.ajoutSymbole("2");
            }
            else if (event.getCode() == KeyCode.NUMPAD3){
                modele.ajoutSymbole("3");
            }
            else if (event.getCode() == KeyCode.NUMPAD4){
                modele.ajoutSymbole("4");

            }
            else if (event.getCode() == KeyCode.NUMPAD5){
                modele.ajoutSymbole("5");

            }
            else if (event.getCode() == KeyCode.NUMPAD6){
                modele.ajoutSymbole("6");

            }
            else if (event.getCode() == KeyCode.NUMPAD7){
                modele.ajoutSymbole("7");

            }
            else if (event.getCode() == KeyCode.NUMPAD8){
                modele.ajoutSymbole("8");

            }
            else if (event.getCode() == KeyCode.NUMPAD9){
                modele.ajoutSymbole("9");
                vue.getSaisieEnCours().textProperty().bind(modele.getExpression());

                

            }
            /***********************************
             * 
             * Contrôle virgule
             * 
             ***********************************
            */
            else if (event.getCode() == KeyCode.PERIOD){
                modele.ajoutSymbole(".");

            }
            /***********************************
             * 
             * Contrôle des opérateurs
             * 
             ***********************************
            */
            else if (event.getCode() == KeyCode.PLUS){
                modele.ajoutSymbole(" + ");

            }
            else if (event.getCode() == KeyCode.MINUS){
                modele.ajoutSymbole(" -");

            }
            else if (event.getCode() == KeyCode.MULTIPLY){
                modele.ajoutSymbole(" * ");
               // vue.getSaisieEnCours().textProperty().bind(modele.getExpression());

            }
            else if (event.getCode() == KeyCode.DIVIDE){
                modele.ajoutSymbole(" / ");

            }

            /***********************************
             * 
             * Contrôle des bouttons parenthèses
             * 
             ***********************************
            */
            else if (event.getCode() == KeyCode.LEFT_PARENTHESIS){
                modele.ajoutSymbole(" ( ");

            }
            else if (event.getCode() == KeyCode.RIGHT_PARENTHESIS){
                modele.ajoutSymbole(" ) ");

            }
            /***********************************
             * 
             * Contrôle retour
             * 
             ***********************************
            */
            else if (event.getCode() == KeyCode.BACK_SPACE){
                String chaineAEvaluer = modele.getExpression().get();
                if (chaineAEvaluer.charAt(chaineAEvaluer.length() - 1) == ' ') {
                    modele.setExpression(chaineAEvaluer.substring(0, chaineAEvaluer.length() - 2));
                } else {
                    modele.setExpression(chaineAEvaluer.substring(0, chaineAEvaluer.length() - 1));
                }
            

            }

            /***********************************
             * 
             * Contrôle égalité
             * 
             ***********************************
            */
            else if (event.getCode() == KeyCode.EQUALS || event.getCode() == KeyCode.ENTER){
                ModeleMvc calcul = new ModeleMvc(modele.getExpression().get());
                String chaineEvaluee = String.valueOf(calcul.evaluer().get());
                vue.getResult().setText(chaineEvaluee);
                vue.getSaisieEnCours().setText(modele.getExpression().get());
                modele.setExpression(chaineEvaluee);
            }

            /***********************************
             * 
             * Contrôle tout effacer
             * 
             ***********************************
            */
            else if (event.getCode() == KeyCode.DELETE){
                modele.setExpression("");
                vue.getResult().setText("");
                vue.getSaisieEnCours().setText(modele.getExpression().get()); 
                //vue.getSaisieEnCours().textProperty().bind(modele.getExpression());

            }

            event.consume();

        });
       


    }
}