package com.ljuglaret.avecMVC.Modele;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;
import java.util.Vector;
import java.util.Iterator;
import java.util.EmptyStackException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javafx.beans.property.*;

public class ModeleMvc {

    private static Logger logger = LoggerFactory.getLogger(Evaluation.class);

    private StringProperty expression;

    public ModeleMvc(String expression) {
        this.expression = new SimpleStringProperty(expression);
    }

    public StringProperty getExpression() {
        return expression;
    }

    public void ajoutSymbole(String chaine) {
        this.expression.set(expression.get() + chaine);
    }

    public void setExpression(String expression) {
        this.expression.set(expression);
    }

    public static String agrandit(String str) {
        String espaces = "";
        for (int i = 0; i < str.length() * str.length(); i++) {
            espaces += " ";
        }
        return str.replaceAll("  ", " ") + espaces;
    }

    // "1 -2" => "1 + -2"
    // 1 -2456 -38 -4 => "1 + -2456 + -38 + -4"
    // 2 * -4 =>2 * -4
    // 2 * -4 -2 => 2* -4 + -2
    // replace pattern :Digit -Digit par Digit + -Digit

    public static String ajoutePlus(String expr) {
        expr = expr.replaceAll(" - \\( ", " -1 * ( ");
        expr = agrandit(expr);
        String strARetourner = "";
        for (int i = 0; i < expr.length() - 2; i++) {
            boolean gaucheParentheseFermeOuDigit = estUnEntier(expr.charAt(i)) || (expr.charAt(i) == ')');
            if (gaucheParentheseFermeOuDigit && (expr.charAt(i + 1) == ' ') && (expr.charAt(i + 2) == '-')) {
                String nouvelleChaine = String.valueOf(expr.charAt(i)) + " + " + String.valueOf(expr.charAt(i + 2));
                strARetourner += nouvelleChaine;

                i = i + 2;
            } else {
                strARetourner += String.valueOf(expr.charAt(i));
            }
        }
        return strARetourner;
    }

    public static void nouvelEtatDesPiles(Stack<Double> pileExpression, Stack<Character> ops) {
        logger.info("Pile Expression  " + pileExpression.toString());
        logger.info("Pile des opérateurs" + ops.toString() + "\n");
    }
    /*
     */
    /*
     * Initialiser une pile P et se placer au début de la chaîne représentant
     * l’expression •Parcourir l’expression caractère par caractère – si c’est une
     * variable Var 2, empiler sa valeur sur P – si c’est un opérateur Op 3, dépiler
     * Val2, dépiler Val1 et empiler (Val1 Op Val2) •Le parcours fini, le résultat
     * final se trouve au sommet de P.
     * 
     * https://homepages.laas.fr/huguet/drupal/sites/homepages.laas.fr.huguet/files/
     * u78/tp1.pdf
     */

    public static boolean estUneVirgule(char c) {
        return c == '.';
    }

    public static boolean estUnEntier(char c) {
        return c >= '0' && c <= '9';
    }

    public DoubleProperty evaluer() {

        String expressionCalcul = ajoutePlus(expression.get());
        logger.info("Chaîne à evaluer : " + expressionCalcul);

        char[] tokens = expressionCalcul.toCharArray();

        // Initialiser une pile P et se placer au début de la chaîne représentant
        // l’expression
        Stack<Double> pileExpression = new Stack<Double>();
        Stack<Character> ops = new Stack<Character>();
        nouvelEtatDesPiles(pileExpression, ops);

        // Parcourir l’expression caractère par caractère
        for (int i = 0; i < tokens.length; i++) {

            // si c’est une variable Var 2, empiler sa valeur sur P
            if (estUnEntier(tokens[i]) || (tokens[i] == '-')) {

                StringBuffer sbuf = new StringBuffer();
                while (i < tokens.length
                        && (estUnEntier(tokens[i]) || estUneVirgule(tokens[i]) || (tokens[i] == '-'))) {
                    sbuf.append(tokens[i++]);
                    continue;
                }

                pileExpression.push(Double.parseDouble(sbuf.toString()));
                nouvelEtatDesPiles(pileExpression, ops);
            }

            // Calcul du contenu de la parenthèse
            else if (tokens[i] == '(') {
                ops.push(tokens[i]);
                nouvelEtatDesPiles(pileExpression, ops);
                continue;
            }

            else if (tokens[i] == ')') {
                while (ops.peek() != '(') {
                    Evaluation.effectuerCalcul(ops, pileExpression);
                }
                ops.pop();
                nouvelEtatDesPiles(pileExpression, ops);
                continue;
            }
            // Fin calcul parenthèses

            // Si tokens[i] est un opérateur qui n'a pas la priorité par rapport à
            // l'opérateur du
            // sommet de la pile OpSommet, dépiler Val2, dépiler Val1 et empiler
            // (Val1 OpSommet Val2)
            else if (Evaluation.estUneOperation(tokens[i])) {
                while (!ops.empty() && Evaluation.aLaPriorite(ops.peek(), tokens[i])) {
                    Evaluation.effectuerCalcul(ops, pileExpression);
                    continue;
                }
                ops.push(tokens[i]);
                nouvelEtatDesPiles(pileExpression, ops);
                continue;
            }
        }
        // tant qu'il reste des opérateurs
        // calcul (sommet ) (token[i]) (sommet - 1)
        while (!ops.empty()) {
            Evaluation.effectuerCalcul(ops, pileExpression);
        }

        // Le parcours fini, le résultat final se trouve au sommet de P
        logger.info("Résultat de l'évaluation : " + pileExpression.peek() + "\n\n");
        return new SimpleDoubleProperty(pileExpression.pop());
    }

}
