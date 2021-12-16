package com.company;

import java.util.EmptyStackException;
import java.util.Stack;
import java.util.Vector;

public class SortStation {
    public static Vector<Token> getPostfixExpression(Vector<Token> infixExpression) throws Exception {
        Vector<Token> postfixExpression = new Vector<Token>();
        Stack<Token> stack = new Stack<Token>();

        for (Token token : infixExpression){
            switch (token.getType()){
                case NUM:
                case VARIABLE:
                    if(!stack.isEmpty() && stack.peek().getType()==TokenTypes.UNARY_MINUS)
                        postfixExpression.add(stack.pop());
                    postfixExpression.add(token);
                    break;
                case FUNC:
                    stack.add(token);
                    break;
                case SPLITTER:
                    try {
                        while (stack.peek().getType()!=TokenTypes.OPEN_PARENTHESIS)
                            postfixExpression.add(stack.pop());
                    } catch (EmptyStackException e)
                    {
                        throw new Exception("Argument delimiter or open parenthesis is padded");
                    }
                    break;
                case OP:
                    if(!stack.isEmpty()){
                        while(!stack.isEmpty() && stack.peek().getType()==TokenTypes.OP
                                && Expression.getOperatorPriority(stack.peek().getValue()) >= Expression.getOperatorPriority(token.getValue()))
                            postfixExpression.add(stack.pop());
                    }
                    stack.push(token);
                    break;
                case OPEN_PARENTHESIS:_PARENTHESIS:
                    stack.push(token);
                    break;
                case CLOSING_PARENTHESIS:
                    try {
                        while (stack.peek().getType()!=TokenTypes.OPEN_PARENTHESIS)
                            postfixExpression.add(stack.pop());
                    } catch (EmptyStackException e){
                        throw new Exception("Missing open parenthesis");
                    }
                    stack.pop();
                    if(!stack.isEmpty())
                        if(stack.peek().getType()==TokenTypes.FUNC)
                            postfixExpression.add(stack.pop());
                    break;
                case UNARY_MINUS:
                    stack.push(token);



            }
        }
        while (!stack.isEmpty()){
            if(stack.peek().getType()==TokenTypes.OPEN_PARENTHESIS)
                throw new Exception("Missing open parenthesis");
            postfixExpression.add(stack.pop());
        }

        return postfixExpression;
    }
}
