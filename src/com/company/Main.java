package com.company;

import java.util.Locale;
import java.util.Scanner;
import java.util.Vector;

public class Main {

    public static void main(String[] args) throws Exception {
        String exp;
        Expression.setProperties('(',')',',');
        Expression expression = new Expression();
        Scanner in = new Scanner(System.in);
        System.out.println("Enter infix expression:");
        exp=in.nextLine().toLowerCase(Locale.ROOT).replaceAll(" ", "");
        Vector<Token> infixExp = Tokenizer.Tokenize(exp);
        expression.initializeVariablesByConsole(infixExp);
        Vector<Token> postfixExp = SortStation.getPostfixExpression(infixExp);
        double res = PostfixCalculator.Calculate(postfixExp);
        System.out.println(exp+"="+ res);
    }
}
