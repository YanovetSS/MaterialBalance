package com.company.Model;

import java.util.List;

/**
 * Created by MakeMeSm1Le- on 16.02.2017.
 */
public interface Block {

    Variable getVariableByName(String name);
    default boolean isSummary(){return false;};
    default boolean isMultiplication(){return false;};
    Double resolve();
    List<Variable> getVariablesList();
    void addVariable(Variable variable);
}
