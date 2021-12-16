package com.company;

import java.util.Stack;
import java.util.Vector;

public class PostfixCalculator {
    public static double Calculate(Vector<Token> postfixExp) throws Exception {
        Stack<Double> stack = new Stack<Double>();
        for(Token token : postfixExp) {
            if (token.getType() == TokenTypes.NUM)
                stack.push(Double.parseDouble(token.getValue()));
            else if (token.getType() == TokenTypes.OP || token.getType() == TokenTypes.FUNC) {
                Vector<Double> argsVector = new Vector<Double>(FuncUtils.getOperandsCount(token.getValue()));
                try {
                    for (int i = 0; i < FuncUtils.getOperandsCount(token.getValue()); i++)
                        argsVector.add(stack.pop());
                } catch (Exception e) {
                    throw new Exception("Invalid expression");
                }
                stack.push(FuncUtils.Execute(token.getValue(), argsVector));
            }
        }
        if(stack.size()==1)
            return stack.pop();
        else
            throw new Exception("Invalid expression");
    }
}
