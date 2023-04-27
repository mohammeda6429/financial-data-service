package edu.citytech.financial;

import edu.citytech.financial.service.MarginalTaxCalculator;
import edu.citytech.marginaltax.checker.GradeMarginalTax;

public class T2_Test {
    public static void main(String[] args){
        GradeMarginalTax.calculate(MarginalTaxCalculator::calculate,
                "/Users/emranamin/CST3613/data/amin,mohammed.answer.ser");

    }

}
