package com.company;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Vector;

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
    public static void setProperties(char openParenthesis, char closingParenthesis, char splitter){
        Expression.openParenthesis = Character.toString(openParenthesis);
        Expression.closingParenthesis = Character.toString(closingParenthesis);
        Expression.splitter = Character.toString(splitter);
    }

    HashMap<String, Double> variables;
    public Expression() {
        variables = new HashMap<String,Double>();
    }
    public void initializeVariablesByConsole(Vector<Token> tokens){
        Scanner in = new Scanner(System.in);
        for(Token token : tokens){
            if(token.getType()==TokenTypes.VARIABLE && !hasVariable(token.getValue())){
                System.out.print("Enter a value of " + token.getValue()+":");
                addVariable(token.getValue(),in.nextDouble());
            }
        }
    }

    double getVariableValue(String variable){
        return  variables.get(variable);
    }
    boolean hasVariable(String var){
        return variables.containsKey(var);
    }

    void addVariable(String var, Double value){
        variables.put(var, value);
    }

}
