package com.ljuglaret.versionCnam.ControleurP;

import com.ljuglaret.versionCnam.Vue.VueMvc;

import org.checkerframework.checker.units.qual.s;

import com.ljuglaret.versionCnam.Modele.ModeleMvc;
import javafx.beans.property.*;
 
import com.ljuglaret.avecMVC.observeObservateur.*;

public class ControleurBouton implements IObservateur  {
    VueMvc vue;
    String modif="";
    public ControleurBouton(VueMvc vue) {
        this.vue = vue;
      
        }
    

    public void actualiser(IObservable modele){
        StringProperty s = new SimpleStringProperty();
        javafx.scene.control.Button[] digitButtons = {
            vue.getButton0(), vue.getButton1(), vue.getButton2(), vue.getButton3(),
            vue.getButton4(),vue.getButton5(),vue.getButton6(),vue.getButton7(),
            vue.getButton8(),vue.getButton9(), 
            vue.getButtonVirgule(),
            vue.getButtonPlus(),vue.getButtonMoins(),vue.getButtonFois(),vue.getButtonDiv(),
             vue.getButtonParOuvr(),vue.getButtonParFerm(), 
             vue.getButtonEgal(),
             vue.getButtonEffacer(),vue.getButtonRetour()
        };
        for(int i = 0; i < digitButtons.length; i++) {
            final int buttonInd = i;
        digitButtons[i].setOnAction(e -> {
            int lastClickedIndex = buttonInd; 
            System.out.println(modele.getValeur()); 
            switch(lastClickedIndex){
                case 0 :  s.set(modele.getValeur()+ "0"); vue.getSaisieEnCours().setText(s.get()); modele.setValeur(s.get()); break;
                case 1  : s.set(modele.getValeur()+ "1"); vue.getSaisieEnCours().setText(s.get()); modele.setValeur(s.get()); break;
                case 2  :   s.set(modele.getValeur()+ "2"); vue.getSaisieEnCours().setText(s.get()); modele.setValeur(s.get()); break;
                case 3  :   s.set(modele.getValeur()+ "3"); vue.getSaisieEnCours().setText(s.get()); modele.setValeur(s.get()); break;
                case 4  :   s.set(modele.getValeur()+ "4"); vue.getSaisieEnCours().setText(s.get()); modele.setValeur(s.get()); break;
                case 5  :   s.set(modele.getValeur()+ "5"); vue.getSaisieEnCours().setText(s.get()); modele.setValeur(s.get()); break;
                case 6  :   s.set(modele.getValeur()+ "6"); vue.getSaisieEnCours().setText(s.get()); modele.setValeur(s.get()); break;
                case 7  :   s.set(modele.getValeur()+ "7"); vue.getSaisieEnCours().setText(s.get()); modele.setValeur(s.get()); break;
                case 8  :   s.set(modele.getValeur()+ "8"); vue.getSaisieEnCours().setText(s.get()); modele.setValeur(s.get()); break;
                case 9  :   s.set(modele.getValeur()+ "9"); vue.getSaisieEnCours().setText(s.get()); modele.setValeur(s.get()); break;

                case 10  :   s.set(modele.getValeur()+ "."); vue.getSaisieEnCours().setText(s.get()); modele.setValeur(s.get()); break;
                case 11  :   s.set(modele.getValeur()+ " + "); vue.getSaisieEnCours().setText(s.get()); modele.setValeur(s.get()); break;
                case 12  :   s.set(modele.getValeur()+ " -"); vue.getSaisieEnCours().setText(s.get()); modele.setValeur(s.get()); break;
                case 13  :   s.set(modele.getValeur()+ " * "); vue.getSaisieEnCours().setText(s.get()); modele.setValeur(s.get()); break;
                case 14  :   s.set(modele.getValeur()+ " /"); vue.getSaisieEnCours().setText(s.get()); modele.setValeur(s.get()); break;
                case 15  :   s.set(modele.getValeur()+ " ("); vue.getSaisieEnCours().setText(s.get()); modele.setValeur(s.get()); break;
                case 16  :   s.set(modele.getValeur()+ " )"); vue.getSaisieEnCours().setText(s.get()); modele.setValeur(s.get()); break;

                case 17 :    ModeleMvc calcul = new ModeleMvc(modele.getValeur());
                            SimpleDoubleProperty calculProp =  new SimpleDoubleProperty();
                            calculProp.set(calcul.evaluer());
                            String chaineEvaluee = String.valueOf(calculProp.get());
                            vue.getResult().setText(chaineEvaluee);
                            vue.getSaisieEnCours().setText(modele.getValeur());
                            modele.setValeur(chaineEvaluee);
                            break;

                case 18 :   s.set("");
                            modele.setValeur(s.get());
                            vue.getResult().setText(s.get());
                            vue.getSaisieEnCours().setText(s.get());
                            break;

                case 19 :
                        String sansDernierCaracSaisi = "";
                        char[] temp = s.get().toCharArray();
                        if (temp[temp.length - 2] == '-'){
                            for (int j =0 ; j < temp.length - 1 ; j++){
                                sansDernierCaracSaisi+=temp[j];
                            }
                        }
                        else{
                            for (int j =0 ; j < temp.length - 2 ; j++){
                                sansDernierCaracSaisi+=temp[j];
                            }
                        }
                       
                        s.set(sansDernierCaracSaisi);
                        modele.setValeur(sansDernierCaracSaisi);
                        vue.getSaisieEnCours().setText(sansDernierCaracSaisi);
                        
                        break;
                default : break;
            }
 
        });  
    }    
    };
}
/*
modele.setExpression("");
        vue.getResult().setText("");
        vue.getSaisieEnCours().setText(modele.getExpression().get());


*/ 

/*
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



    vue.getButtonEffacer().setOnAction(event -> {
        modele.setExpression("");
        vue.getResult().setText("");
        vue.getSaisieEnCours().setText(modele.getExpression().get());
        event.consume();
    });


*/