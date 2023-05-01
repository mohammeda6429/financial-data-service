package edu.citytech.financial;

import edu.citytech.financial.service.MarginalTaxCalculatorService;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class T3_ScratchPad {

    @Test
    @DisplayName("tax t1")
    public void t1(){
        float taxPaid = MarginalTaxCalculatorService.calculate("S", 30_000, System.out::println);

        System.out.println("taxPaid: " + taxPaid);

    }
}

//  List<MarginalTaxRule> list = new ArrayList<>();
//
//        float salary = 150_000;
//
//        list.add(new MarginalTaxRule(29,0.1,"S",0,10275,2022));
//        list.add(new MarginalTaxRule(30,0.12,"S",10275,41775,2022));
//        list.add(new MarginalTaxRule(31,0.22,"S",41775,89075,2022));
//        list.add(new MarginalTaxRule(32,0.24,"S",89075,170050,2022));
//        list.add(new MarginalTaxRule(33,0.32,"S",170050,215950,2022));
//        list.add(new MarginalTaxRule(34,0.35,"S",215950,539900,2022));
//        list.add(new MarginalTaxRule(35,0.37,"S",539900,999999999.99,2022));
//
//        List<MarginalTaxRule> filterList = list.stream().filter(e -> e.range1() <= salary)
//                .map(e -> e.range2() > salary ? new MarginalTaxRule(e.rule(), e.taxRate(), e.code(), e.range1(), salary, e.year()) : e )
//                .peek(System.out::println).toList();
//
//        var taxPaid = filterList.stream().mapToDouble(MarginalTaxRule::calculateTaxPaid).sum();
//        System.out.println("taxPaid: " + taxPaid);
//
//    }
//
//    @Test
//    @DisplayName("tax read this file")
//    public void t2(){
//        List<String> list = ReadFileUtility.process("/Users/emranamin/CST3613/data/TaxRules.csv");
//        list.forEach(System.out::println);
//    }
//
//    @Test
//    @DisplayName("tax read this file")
//    public void t3(){
//        var list = ReadFileUtility.process("/Users/emranamin/CST3613/data/TaxRules.csv", TaxRule::getTaxRule);
//        list.forEach(System.out::println);
//    }
//
//    @Test
//    public void t4(){
//
//        List<MarginalTaxRule> list = ReadFileUtility.process("/Users/emranamin/CST3613/data/TaxRules.csv", TaxRule::getTaxRule);
//
//        float salary = 150_000;
//
//
//        List<MarginalTaxRule> filterList = list.stream().filter(e -> e.range1() <= salary)
//                .filter(e -> e.code().equals("S"))
//                .filter(e -> e.year() == 2022)
//                .map(e -> e.range2() > salary ? new MarginalTaxRule(e.rule(), e.taxRate(), e.code(), e.range1(), salary, e.year()) : e )
//                .peek(System.out::println).toList();
//
//        var taxPaid = filterList.stream().mapToDouble(MarginalTaxRule::calculateTaxPaid).sum();
//        System.out.println("taxPaid: " + taxPaid);