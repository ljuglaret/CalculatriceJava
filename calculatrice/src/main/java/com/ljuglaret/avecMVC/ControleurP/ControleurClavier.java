package com.ljuglaret.avecMVC.ControleurP;

import com.ljuglaret.avecMVC.Vue.VueMvc;
import com.ljuglaret.avecMVC.Modele.ModeleMvc;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.control.Button;
import javafx.beans.property.*;
import  javafx.scene.input.KeyCode;
import java.awt.*;    
import java.awt.event.*;    
import com.ljuglaret.avecMVC.observeObservateur.*;

public class ControleurClavier implements IObservateur  {
    private int lastClickedIndex = -1; 
    VueMvc vue;
    String modif="";
    public ControleurClavier(VueMvc vue) {
        this.vue = vue;
      
        }
    

    public void actualiser(IObservable modele){


        vue.getSaisieEnCours().setOnKeyTyped(event -> {
            vue.getSaisieEnCours().positionCaret(( vue.getSaisieEnCours().getText()).length());



        /***********************************
         * 
         * Contrôle Chifffres *
         * 
         ***********************************
         */
            if (event.getCharacter().equals("0")) {
               suite(modele,vue,"0");
            }
            else if (event.getCharacter().equals("1")) {
               suite(modele,vue,"1");
            }
            else if (event.getCharacter().equals("2")) {
                suite(modele,vue,"2");
            }
            else if (event.getCharacter().equals("3")) {
                suite(modele,vue,"3");
            }
            else if (event.getCharacter().equals("4")) {
                suite(modele,vue,"4");
            }
            else if (event.getCharacter().equals("5")) {
                suite(modele,vue,"5");
            }
            else if (event.getCharacter().equals("6")) {
                suite(modele,vue,"6");

            }
            else if (event.getCharacter().equals("7")) {
                suite(modele,vue,"7");
            }
            else if (event.getCharacter().equals("8")) {
                suite(modele,vue,"8");
            }
            else if (event.getCharacter().equals("9")) {
                suite(modele,vue,"9");
            }
            /***********************************
             * 
             * Contrôle virgule
             * 
             ***********************************
            */
            else if (event.getCharacter().equals(".")) {
                suite(modele,vue,".");
            }
            /***********************************
             * 
             * Contrôle des opérateurs
             * 
             ***********************************
            */
            else if (event.getCharacter().equals("+")) {
                suite(modele,vue," + ");
            }
            else if (event.getCharacter().equals("-")) {
                suite(modele,vue," -");
            }
            else if (event.getCharacter().equals("*")) {
                suite(modele,vue," * ");
            }
            else if (event.getCharacter().equals("/")) {
                suite(modele,vue," / ");
            }

            /***********************************
             * 
             * Contrôle des bouttons parenthèses
             * 
             ***********************************
            */
            else if (event.getCharacter().equals("(")){
                suite(modele,vue," ( ");
            }
            else if (event.getCharacter().equals(")")) {
                suite(modele,vue," ) ");
            }
            /***********************************
             * 
             * Contrôle retour
             * 
             ***********************************
            */
            else if (event.getCode() == KeyCode.BACK_SPACE){
                String chaineAEvaluer = modele.getValeur();
                if (chaineAEvaluer.charAt(chaineAEvaluer.length() - 1) == ' ') {
                    modele.setValeur(chaineAEvaluer.substring(0, chaineAEvaluer.length() - 2));
                } else {
                    modele.setValeur(chaineAEvaluer.substring(0, chaineAEvaluer.length() - 1));
                }
            

            }

            /***********************************
             * 
             * Contrôle égalité
             * 
             ***********************************
            */      
            else if (event.getCharacter().equals("=")) { 

                ModeleMvc calcul = new ModeleMvc(modele.getValeur());
                SimpleDoubleProperty calculProp =  new SimpleDoubleProperty();
                calculProp.set(calcul.evaluer());
                String chaineEvaluee = String.valueOf(calculProp.get()); 
                vue.getResult().setText(chaineEvaluee);
                vue.getSaisieEnCours().setText(modele.getValeur());
                modele.setValeur(chaineEvaluee);
            }

 
        });

            /***********************************
             * 
             * Contrôle Effacer Dernier caractere
             * 
             ***********************************
            */
        vue.getSaisieEnCours().setOnKeyPressed(event -> {
            vue.getSaisieEnCours().positionCaret(( vue.getSaisieEnCours().getText()).length());
             if (event.getCode() == KeyCode.BACK_SPACE){
                String chaineAEvaluer = modele.getValeur();
                if (chaineAEvaluer.charAt(chaineAEvaluer.length() - 1) == ' ') {
                    modele.setValeur(chaineAEvaluer.substring(0, chaineAEvaluer.length() - 2));
                } else {
                    modele.setValeur(chaineAEvaluer.substring(0, chaineAEvaluer.length() - 1));
                }
            }

            /***********************************
             * 
             * Contrôle égalité
             * 
             ***********************************
            */
            else if ( event.getCode() == KeyCode.ENTER){  
                ModeleMvc calcul = new ModeleMvc(modele.getValeur());
                SimpleDoubleProperty calculProp =  new SimpleDoubleProperty();
                calculProp.set(calcul.evaluer());
                String chaineEvaluee = String.valueOf(calculProp.get());
                vue.getResult().setText(chaineEvaluee);
                vue.getSaisieEnCours().setText(modele.getValeur());
                modele.setValeur(chaineEvaluee);
                modele.setValeur(chaineEvaluee);
            }
            
            /***********************************
             * 
             * Tout effacer
             * 
             ***********************************
            */
            else if (event.getCode() == KeyCode.DELETE){
                modele.setValeur("");
                vue.getResult().setText("");
                vue.getSaisieEnCours().setText(modele.getValeur()); 

            }
         
            vue.getSaisieEnCours().positionCaret(( vue.getSaisieEnCours().getText()).length());
        });
    }
   
    public static void suite (IObservable modele, VueMvc vue, String symbole){
        StringProperty s = new SimpleStringProperty();
        s.set(modele.getValeur()+ symbole);
        vue.getSaisieEnCours().setText(s.get());
        modele.setValeur(s.get());  
    }

}