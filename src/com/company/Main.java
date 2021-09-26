package com.company;
import com.company.SystemEqutation.SystemEqutation;

public class Main {
    public static void main(String[] args) {
        SystemEqutation systemEqutation = new SystemEqutation();
        systemEqutation.createSystem();
        systemEqutation.printSystem();
        systemEqutation.methodGaussa();
    }
}
