package com.ljuglaret.avecMVC.ControleurP;

import com.ljuglaret.avecMVC.Vue.VueMvc;
import com.ljuglaret.avecMVC.Modele.ModeleMvc;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.KeyCode;
//https://docs.oracle.com/javafx/2/api/javafx/scene/input/KeyCode.html
public class ControleurClavier  {
    ModeleMvc modele= new ModeleMvc("");
    VueMvc vue = new VueMvc();
    
    public  void suite ( String symbole){
        vue.getSaisieEnCours().setText("");
        modele.ajoutSymbole(symbole);
        vue.getSaisieEnCours().setText(modele.getExpression().get());   
    }

    public ControleurClavier(VueMvc vue) {
     
        this.vue = vue;
       // modele = new ModeleMvc("");

  
        vue.getSaisieEnCours().setOnKeyTyped(event -> {
            vue.getSaisieEnCours().positionCaret(( vue.getSaisieEnCours().getText()).length());


        /***********************************
         * 
         * Contrôle Chifffres *
         * 
         ***********************************
         */
            if (event.getCharacter().equals("0")) {
               suite("0");
            }
            else if (event.getCharacter().equals("1")) {
               suite("1");
            }
            else if (event.getCharacter().equals("2")) {
                suite("2");
            }
            else if (event.getCharacter().equals("3")) {
                suite("3");
            }
            else if (event.getCharacter().equals("4")) {
                suite("4");
            }
            else if (event.getCharacter().equals("5")) {
                suite("5");
            }
            else if (event.getCharacter().equals("6")) {
                vue.getSaisieEnCours().setText("");
                modele.ajoutSymbole("6");
                vue.getSaisieEnCours().setText(modele.getExpression().get());

            }
            else if (event.getCharacter().equals("7")) {
                suite("7");
            }
            else if (event.getCharacter().equals("8")) {
                suite("8");
            }
            else if (event.getCharacter().equals("9")) {
                suite("9");
            }
            /***********************************
             * 
             * Contrôle virgule
             * 
             ***********************************
            */
            else if (event.getCharacter().equals(".")) {
                suite(".");
            }
            /***********************************
             * 
             * Contrôle des opérateurs
             * 
             ***********************************
            */
            else if (event.getCharacter().equals("+")) {
                suite(" + ");
            }
            else if (event.getCharacter().equals("-")) {
                suite(" -");
            }
            else if (event.getCharacter().equals("*")) {
                suite(" * ");
            }
            else if (event.getCharacter().equals("/")) {
                suite(" / ");
            }

            /***********************************
             * 
             * Contrôle des bouttons parenthèses
             * 
             ***********************************
            */
            else if (event.getCharacter().equals("(")){
                suite(" ( ");
            }
            else if (event.getCharacter().equals(")")) {
                suite(" ) ");
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
            else if (event.getCharacter().equals("=")) { 
                ModeleMvc calcul = new ModeleMvc(modele.getExpression().get());
                String chaineEvaluee = String.valueOf(calcul.evaluer().get());
                vue.getResult().setText(chaineEvaluee);
                vue.getSaisieEnCours().setText("");
                modele = calcul;
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

           
                System.out.println(modele.getExpression().get());
            
         
            event.consume();

        });
        vue.getSaisieEnCours().setOnKeyPressed(event -> {
            vue.getSaisieEnCours().positionCaret(( vue.getSaisieEnCours().getText()).length());

     
           /***********************************
             * 
             * Contrôle retour
             * 
             ***********************************
            */
             if (event.getCode() == KeyCode.BACK_SPACE){
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
            else if ( event.getCode() == KeyCode.ENTER){
                ModeleMvc calcul = new ModeleMvc(modele.getExpression().get());
                String chaineEvaluee = String.valueOf(calcul.evaluer().get());
                vue.getResult().setText(chaineEvaluee);
                vue.getSaisieEnCours().setText(modele.getExpression().get());
                modele = new ModeleMvc(chaineEvaluee);
                //modele = calcul;
               // modele.setExpression(chaineEvaluee);
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

           
                System.out.println(modele.getExpression().get());
            
         
            event.consume();

        });
    }
}