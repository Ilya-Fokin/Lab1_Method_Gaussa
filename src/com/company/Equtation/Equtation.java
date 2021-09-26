package com.company.Equtation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Equtation {
    private List<Float> variablesList;
    private Float result;

    public Equtation() {}

    public Equtation(List<Float> variablesList, Float result) {
        this.variablesList = variablesList;
        this.result = result;
    }

    public List<Float> getVariablesList() {
        return variablesList;
    }

    public void setVariablesList(List<Float> variablesList) {
        this.variablesList = variablesList;
    }

    public Float getResult() {
        return result;
    }

    public void setResult(Float result) {
        this.result = result;
    }

    public void printEqutation() {
        for (Float variable : variablesList) {
            System.out.print(variable + " ");
        }
        System.out.println(" | " + result);
    }

    public void createEqutation(int countVariables) {
        Scanner in = new Scanner(System.in);
        List<Float> variables = new ArrayList<>();

        int i = 0;
        Float variable;

        while (i < countVariables) {
            System.out.print("a" + (i+1) + ". ");
            variable = in.nextFloat();
            variables.add(variable);
            i++;
        }
        this.variablesList = variables;

        System.out.print("Введите результат: ");
        Float result = in.nextFloat();
        this.result = result;
    }
}
