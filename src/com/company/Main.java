package com.company;

import com.company.Controller.ExpressionsResolver;
import com.company.Model.*;

import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        Variable A = new Variable();
        A.setName("A");
        A.setPower(1);
        A.setValueParam(5d);

        Variable B = new Variable();
        B.setName("B");
        B.setPower(2);
        B.setValueParam(4d);

        Variable C = new Variable();
        C.setValueParam(6d);
        C.setPower(1);
        C.setName("C");
        Variable D = new Variable();
        D.setName("D");
        D.setPower(1);
        D.setValueParam(5d);

        Block left = new Summary();
        left.addVariable(A);
        left.addVariable(B);

        Block right = new Multiplication();
        right.addVariable(C);
        right.addVariable(D);

        Expression expression = new Expression(3, left, right);

        Variable E = new Variable();
        E.setName("E");
        E.setPower(3);
        E.setValueParam(13d);
        right.addVariable(E);
        Expression expression1 = new Expression(4,right,left);
        Set<Expression> expressions = new HashSet<>();
        expressions.add(expression);
        expressions.add(expression1);

        ExpressionsResolver expressionsResolver = new ExpressionsResolver(expressions);

        System.out.println("In expression: " + expression);
        System.out.println("In expression 2: " + expression1);
        expressionsResolver.buildExpressionsByValues();


    }
}
