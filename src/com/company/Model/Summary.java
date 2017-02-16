package com.company.Model;

import java.util.*;

/**
 * Created by MakeMeSm1Le- on 16.02.2017.
 */
public class Summary implements Block {

    private Map<String, Variable> variables;
    private Double result;

    public Summary() {
        variables = new HashMap<>();
        result = null;
    }

    public void addVariable(Variable variable) {
        variables.put(variable.getName(), variable);
    }

    @Override
    public Double resolve() {
        result = 0D;
        if (variables.size() != 0) {
            variables.values().forEach((variable -> result += variable.getValue()));
            return result;
        }
        return null;
    }

    @Override
    public Variable getVariableByName(String name) {
        return variables.get(name);
    }

    @Override
    public boolean isSummary() {
        return true;
    }

    @Override
    public boolean isMultiplication() {
        return false;
    }

    @Override
    public List<Variable> getVariablesList() {
        return new LinkedList<>(variables.values());
    }

    @Override
    public String toString() {
        String result = "";
        String plus = " + ";
        String cofitient;

        for (Map.Entry<String,Variable> entry: variables.entrySet()){
            cofitient = String.valueOf(entry.getValue().getPower());
            cofitient = (cofitient.equals("1")) ? "" : cofitient;

            result +=  cofitient + entry.getKey() + plus ;
        }
        return result.substring(0,result.length()-plus.length());
    }
}
