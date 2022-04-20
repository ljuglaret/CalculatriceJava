package com.ljuglaret.versionCnam.ControleurP;

import com.ljuglaret.versionCnam.Vue.VueMvc;
import com.ljuglaret.versionCnam.Modele.ModeleMvc;


//https://docs.oracle.com/javafx/2/api/javafx/scene/input/KeyCode.html
public class MainControler  {
    VueMvc vue;// = new VueMvc();

    ModeleMvc modele = new ModeleMvc("");

    private ControleurBouton cb;
   
    public MainControler(VueMvc vue) {
     
        this.vue = vue;
        

        cb =  new ControleurBouton(vue);

       
        modele.ajoutObservateur(cb);
        modele.notifierObservateurs();


    }
}
