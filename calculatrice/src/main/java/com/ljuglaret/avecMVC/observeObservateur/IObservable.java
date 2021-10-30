package com.ljuglaret.avecMVC.observeObservateur;
public interface IObservable<T>
{
      
    String getValeur();
    
    void setValeur(String s);


    void ajoutObservateur(  IObservateur o);

    void suppressionObservateur(  IObservateur o);

    void notifierObservateurs( );
}


