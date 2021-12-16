package com.company;

import java.util.Arrays;
import java.util.Collection;
import java.util.Locale;
import java.util.Vector;

public class FuncUtils {
    static String[] functions = {"sin", "cos", "sqr", "sqrt", "pow"};
    static String[] operators = {"+", "-", "/", "*"};
    public static Collection<String> getOperators(){
        return Arrays.asList(operators);
    }
    public static Collection<String> getFunctions(){
        return Arrays.asList(functions);
    }
    public static boolean isFunc(String value)
    {
        return (Arrays.asList(functions).contains(value.toLowerCase(Locale.ROOT)));
    }
    public static boolean isOp(String value)
    {
        return (Arrays.asList(operators).contains(value.toLowerCase(Locale.ROOT)));
    }

    public static int getOperandsCount(String op){
        switch (op){
            case "sin":
            case "cos":
            case "sqr":
            case "sqrt":
                return 1;
            case "pow":
            case "+":
            case "-":
            case "/":
            case "*":
                return 2;
            default:
                return 0;
        }
    }

    public static double Execute(String op, Vector<Double> args) throws Exception {
        if(!isFunc(op) && !isOp(op)){
            throw new Exception("Invalid token");
        }
        switch (op.toLowerCase(Locale.ROOT)){
            case ("sin"):
                return Math.sin(Math.toRadians(args.get(0)));
            case ("cos"):
                return Math.cos(Math.toRadians(args.get(0)));
            case ("sqr"):
                return args.get(0)*args.get(0);
            case ("sqrt"):
                return Math.sqrt(args.get(0));
            case ("pow"):
                return Math.pow(args.get(0), args.get(1));
            case "+":
                return args.get(0)+args.get(1);
            case "-":
                return args.get(0)-args.get(1);
            case "/":
                return args.get(0)/args.get(1);
            case "*":
                return args.get(0)*args.get(1);
            default:
                throw new Exception(op + " not implemented");
        }
    }
}
