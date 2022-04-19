package com.ljuglaret.versionCnam.observeObservateur;
public interface IObservable
{
      
    String getValeur();
    
    void setValeur(String s);


    void ajoutObservateur(  IObservateur o);

    void suppressionObservateur(  IObservateur o);

    void notifierObservateurs( );
}


