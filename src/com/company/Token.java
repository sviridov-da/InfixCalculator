package com.company;

public class Token {


    TokenTypes type;
    String value;
    public Token(String value){
        this.value = value;
        if(FuncUtils.isFunc(value))
            type = TokenTypes.FUNC;
        else if(value.equals(Expression.getOpenParenthesis()))
            type=TokenTypes.OPEN_PARENTHESIS;
        else if(value.equals(Expression.getClosingParenthesis()))
            type=TokenTypes.CLOSING_PARENTHESIS;
        else if(value.equals(Expression.getSplitter()))
            type=TokenTypes.SPLITTER;
        else if(FuncUtils.getOperators().contains(value))
            type=TokenTypes.OP;
        else if(FuncUtils.getFunctions().contains(value))
            type=TokenTypes.FUNC;
        else if(value.equals(Expression.getUnaryMinus()))
            type = TokenTypes.UNARY_MINUS;
        else{
            try {
                Double.parseDouble(value);
                type=TokenTypes.NUM;
            } catch (Exception e) {
                type = TokenTypes.VARIABLE;
            }
        }

    }

    public TokenTypes getType() {
        return type;
    }

    public String getValue() {
        return value;
    }
}
