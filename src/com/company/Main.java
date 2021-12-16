package com.company;

import java.util.Scanner;
import java.util.Vector;

public class Main {

    public static void main(String[] args) throws Exception {
        String exp;
        Scanner in = new Scanner(System.in);
        exp=in.nextLine();
        Vector<Token> infixExp = Tokenizer.Tokenize(exp);
        Vector<Token> postfixExp = SortStation.getPostfixExpression(infixExp);
    }
}
