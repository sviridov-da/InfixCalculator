package com.company;

import java.util.HashMap;

public class Expression {
    static String openParenthesis = "(";
    static String closingParenthesis = ")";
    static String splitter = ",";
    public static String getOpenParenthesis(){
        return openParenthesis;
    }
    public static String getClosingParenthesis() {
        return closingParenthesis;
    }
    public static String getSplitter() {
        return splitter;
    }
    public static int getOperatorPriority(String op){
        switch (op){
            case "+":
            case "-":
                return 0;
            case "*":
            case "/":
                return 1;
            default:
                return -1;
        }
    }

    HashMap<String, Double> variables;

    public double getVariableValue(String variable){
        return  variables.get(variable);
    }
}
