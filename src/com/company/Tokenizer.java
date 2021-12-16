package com.company;

import java.util.Vector;

public class Tokenizer {
    public static Vector<Token> Tokenize(String strExp)
    {
        Vector<Token> res = new Vector<Token>();
        StringBuilder currentStr = new StringBuilder();
        Token currentToken;
        for(int i = 0; i<strExp.length(); i++)
        {
            if(FuncUtils.getOperators().contains(Character.toString(strExp.charAt(i)))
                    || (Character.toString(strExp.charAt(i)).equals(Expression.getOpenParenthesis()))
                    || (Character.toString(strExp.charAt(i)).equals(Expression.getClosingParenthesis()))
                    || (Character.toString(strExp.charAt(i)).equals(Expression.getSplitter()))) {
                if(!currentStr.toString().equals("")){
                    res.add(new Token(currentStr.toString()));
                    currentStr = new StringBuilder();
                }
                res.add(new Token(Character.toString(strExp.charAt(i))));

            }
            else
                currentStr.append(Character.toString(strExp.charAt(i)));
        }
        if(!currentStr.isEmpty())
            res.add(new Token(currentStr.toString()));
        return res;
    }
}
