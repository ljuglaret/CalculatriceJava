package com.ljuglaret.avecMVC.ControleurP;

import com.ljuglaret.avecMVC.Vue.VueMvc;
import com.ljuglaret.avecMVC.Modele.ModeleMvc;


//https://docs.oracle.com/javafx/2/api/javafx/scene/input/KeyCode.html
public class MainControler  {
    VueMvc vue;// = new VueMvc();

    ModeleMvc modele = new ModeleMvc("0");

    private ControleurClavier cl;
    private ControleurBouton cb;
   
    public MainControler(VueMvc vue) {
     
        this.vue = vue;
        

        cl = new ControleurClavier(vue);
        cb =  new ControleurBouton(vue);

        modele.ajoutObservateur(cl);
       
        modele.ajoutObservateur(cb);
        modele.notifierObservateurs();


    }
}
