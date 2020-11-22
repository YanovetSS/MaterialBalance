package com.company.Controller;

import com.company.Model.Block;
import com.company.Model.Expression;
import com.company.Model.Multiplication;
import com.company.Model.Variable;

import java.util.*;

//tested git pull request
public class ExpressionsResolver {

    private Set<Expression> expressions;

    public ExpressionsResolver(Set<Expression> expressionSet) {
        expressions = expressionSet;
    }

    public void buildExpressionsByValues() {

        Map<Variable, Double> result = new HashMap<>();

        Iterator<Expression> itExpression = expressions.iterator();
        Expression expression;
        Block block;
        Double singleResult;
//one more test hehe
        while (itExpression.hasNext()) {
            expression = itExpression.next();
            block = expression.getLeftBlock();
            Iterator<Variable> var = toMultiplyBlock(block).getVariablesList().iterator();
            while (var.hasNext()) {
                Variable variable = var.next();
                singleResult = (result.get(variable) == null) ? 0D : result.get(variable);
//jejejjejejeje
                singleResult += expression.getCofitient() * variable.getValue() * variable.getPower();
                result.put(variable, singleResult);
            }
        }

        System.out.println(result);
    }
//qwe
    private Block toMultiplyBlock(Block block) {
        if (block.isMultiplication())
            return block;

        Multiplication result = new Multiplication();

        Iterator<Variable> variableIterator = block.getVariablesList().iterator();
        while (variableIterator.hasNext()) {
            result.addVariable(variableIterator.next());
        }

        return result;
    }


//    private Map<Variable,Set<Block>> findBlockForVariables(){
//        Map<Variable,Set<Block>> variablesMapping = new TreeMap<>();
//
//        Iterator<Expression> iterator = expressions.iterator();
//        Expression expression;
//        Block block;
//
//        while (iterator.hasNext()){
//            expression = iterator.next();
//            block =  expression.getLeftBlock();
//            addIfAbsent(block,variablesMapping);
//            block = expression.getRightBlock();
//            addIfAbsent(block,variablesMapping);
//        }
//
//        return variablesMapping;
//    }
//
//    private void addIfAbsent(Block block, Map<Variable,Set<Block>> variableSetMap){
//        Iterator<Variable> variableIterator;
//
//        Variable var;
//        variableIterator = block.getVariablesList().iterator();
//        while (variableIterator.hasNext()){
//            var = variableIterator.next();
//            Set<Block> blocks = variableSetMap.get(var);
//            if (blocks == null) {
//                blocks = new HashSet<>();
//            }
//            blocks.add(block);
//        }
//    }
//
//    private Block buildMultiplicationFromBlock(Block block){
//        return block
//    }

}
