package com.company;

import java.util.Arrays;
import java.util.Collection;
import java.util.Locale;

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

    public static double ExecuteFunc(String func, double[] args) throws Exception {
        if(!isFunc(func)){
            throw new Exception("Invalid function");
        }
        switch (func.toLowerCase(Locale.ROOT)){
            case ("sin"):
                return Math.sin(Math.toRadians(args[0]));
            case ("cos"):
                return Math.cos(Math.toRadians(args[0]));
            case ("sqr"):
                return args[0]*args[0];
            case ("sqrt"):
                return Math.sqrt(args[0]);
            case ("pow"):
                return Math.pow(args[0], args[1]);
            default:
                throw new Exception("Function " + func + " not implemented");
        }
    }
}
