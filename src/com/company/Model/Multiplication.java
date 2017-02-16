package com.company.Model;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by MakeMeSm1Le- on 16.02.2017.
 */
public class Multiplication implements Block {

    private Map<String, Variable> variables;
    private Double result;

    public Multiplication(){
        variables = new HashMap<>();
        result = null;
    }

    @Override
    public void addVariable(Variable variable) {
        variables.put(variable.getName(),variable);
    }

    @Override
    public Variable getVariableByName(String name) {
        return variables.get(name);
    }

    @Override
    public boolean isSummary() {
        return false;
    }

    @Override
    public boolean isMultiplication() {
        return true;
    }

    @Override
    public Double resolve() {
        result = 0D;
        if (variables.size() != 0) {
            variables.values().forEach((variable -> result *= variable.getValue()));
            return result;
        }
        return null;
    }

    @Override
    public List<Variable> getVariablesList() {
        return new LinkedList<>(variables.values());
    }

    @Override
    public String toString() {
        String result = "";
        String plus = " * ";
        String cofitient;

        for (Map.Entry<String,Variable> entry: variables.entrySet()){
            cofitient = String.valueOf(entry.getValue().getPower());
            cofitient = (cofitient.equals("1")) ? "" : cofitient;

            result +=  cofitient + entry.getKey() + plus ;
        }
        return result.substring(0,result.length()-plus.length());
    }
}
