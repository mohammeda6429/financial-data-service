package edu.citytech.financial.service;

import edu.citytech.financial.functions.TaxRule;
import edu.citytech.financial.model.MarginalTaxRule;
import edu.citytech.financial.utility.ReadFileUtility;

import java.util.List;
import java.util.function.Consumer;
public class MarginalTaxCalculatorService {
    public static float calculate(final String code, float salary, Consumer<Object> consumer){
        List<MarginalTaxRule> list = ReadFileUtility.process("/Users/emranamin/CST3613/data/TaxRules.csv", TaxRule::getTaxRule);

        List<MarginalTaxRule> filterList = list.stream().filter(e -> e.range1() < salary)
                .filter(e -> e.code().equals(code))
                .map(e -> e.range2() > salary ? new MarginalTaxRule(e.rule(), e.taxRate(), e.code(), e.range1(), salary, e.year()) : e )
                .peek(consumer).toList();

        double taxPaid = filterList.stream().mapToDouble(MarginalTaxRule::calculateTaxPaid).sum();

        return (float)taxPaid;
    }

    public static float calculate(final String code, float salary){
        return calculate(code, salary, e -> {});
    }
}
