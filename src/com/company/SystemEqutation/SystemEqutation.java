package com.company.SystemEqutation;

import com.company.Equtation.Equtation;

import java.security.spec.ECField;
import java.security.spec.EllipticCurve;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SystemEqutation {
    private List<Equtation> equtations;

    public SystemEqutation() {}
    public SystemEqutation(List<Equtation> equtations) {
        this.equtations = equtations;
    }

    public List<Equtation> getEqutations() {
        return equtations;
    }

    public void setEqutations(List<Equtation> equtations) {
        this.equtations = equtations;
    }

    public void createSystem() {
        Scanner in = new Scanner(System.in);
        List<Equtation> equtationList = new ArrayList<>();
        boolean creating = false;

        while (creating == false) {
            System.out.print("Введите количество уравнений: ");
            int countEqutations = in.nextInt();

            System.out.print("Введите количество переменных: ");
            int countVariables = in.nextInt();

            if (checkSystem(countEqutations, countVariables)) {
                int i = 0;

                while (i < countEqutations) {
                    Equtation equtation = new Equtation();
                    equtation.createEqutation(countVariables);
                    equtationList.add(equtation);
                    i++;
                }
                this.equtations = equtationList;
                creating = true;
            }  else System.out.println("!!!!Неверно введена матрица!!!!");
        }
    }

    public void printSystem() {
        System.out.println("-----------------------------");
        for (Equtation equtation : equtations) {
            equtation.printEqutation();
        }
        System.out.println("-----------------------------");
    }

    public void methodGaussa() {
        for (int i = 0; i < equtations.size() - 1; i++) {
            for (int j = i + 1; j < equtations.size(); j++) {
                Float a = equtations.get(i).getVariablesList().get(i);
                Float b = equtations.get(j).getVariablesList().get(i);

                Float q = b/a;

                System.out.println("q" + j + ") " + b + " / " + a + " = " + q);

                equtations.set(j, changeEcutation(equtations.get(i), equtations.get(j), q));
                printSystem();
            }
        }
        printX(findX(equtations));
    }

    public Equtation changeEcutation(Equtation equtation1, Equtation equtation, Float coefficient) {
        List<Float> variableList1 = equtation1.getVariablesList();
        List<Float> variableList = equtation.getVariablesList();

        Float newResult = equtation.getResult() - equtation1.getResult() * coefficient;

        for (int i = 0; i < variableList1.size(); i++) {
            Float variable2 = variableList.get(i);
            variableList.set(i, variable2 - variableList1.get(i) * coefficient);
        }
        equtation.setVariablesList(variableList);
        equtation.setResult(newResult);

        return equtation;
    }

    public Float[] findX(List<Equtation> equtations) {
        Float[] xList = new Float[equtations.size()];
        Float x;
        int j;
        int i;

        for (i = equtations.size() - 1; i >= 0; i--) {
            Float sum = 0.0f;
            for (j = equtations.size() - 1; j > i; j--) {
                sum += equtations.get(i).getVariablesList().get(j) * xList[j];
            }
            x = (equtations.get(i).getResult() - sum) / equtations.get(i).getVariablesList().get(j);
            xList[i] = x;
        }
        return xList;
    }

    public void printX(Float[] xArray) {
        for (int i = 0; i < xArray.length; i++) {
            String result = String.format("%.3f", xArray[i]);
            System.out.println("| X" + (i+1) + " = " + result + " |");
        }
    }

    public boolean checkSystem(int countEqutations, int countVariables) {
        if ((countEqutations == countVariables) && countEqutations > 2 && countVariables > 2) {
            return true;
        } else return false;
    }
}

