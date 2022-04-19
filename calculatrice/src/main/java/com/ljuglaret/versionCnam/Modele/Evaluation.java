package com.ljuglaret.versionCnam.Modele;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Stack;

public class Evaluation {

    private static Logger logger = LoggerFactory.getLogger(Evaluation.class);

    private static final char plus = '+';
    private static final char moins = '-';
    private static final char div = '/';
    private static final char mul = '*';

    // retourne vrai si op1 a la priorité sur op2
    // 1 * 2 + 3 : + priorité par rapport à * == faux
    // 1 + 2 * 3 : * prio par rapport à + == vrai

    public static boolean aLaPriorite(char op1, char op2) {
        return ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-'));

        /*
         * if (op2 == '(' || op2 == ')') return false;
         */
        /*
         * if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-')) return false;
         * else return true;
         */
    }

    public static boolean estUneOperation(char c) {
        return ((c == plus) || (c == moins) || (c == mul) || (c == div));
    }

    public static void effectuerCalcul(Stack<Character> ops, Stack<Double> pileExpression) {
        logger.info("Pile Expression   " + pileExpression.toString());
        logger.info("Pile Opérateurs   " + ops.toString() + "\n");
        char operateur = ops.pop();
        double valeur2 = pileExpression.pop();
        double valeur1 = pileExpression.pop();

        double resultat = 0;
        switch (operateur) {
        case plus:
            resultat = valeur1 + valeur2;
            break;
        case moins:
            resultat = valeur1 - valeur2;
            break;
        case mul:
            resultat = valeur1 * valeur2;
            break;
        case div:
            if (valeur2 == 0)
                throw new UnsupportedOperationException("division par zero impossible");
            resultat = (double) (valeur1 / valeur2);
            break;
        }
        logger.info("Calcul effectué : " + valeur1 + operateur + valeur2 + " = " + resultat);
        pileExpression.push(resultat);
        logger.info("Pile Expression   " + pileExpression.toString());
        logger.info("Pile Opérateurs   " + ops.toString() + "\n");
    }

}