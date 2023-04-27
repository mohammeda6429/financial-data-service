package edu.citytech.financial.webapi;

import edu.citytech.financial.service.MarginalTaxCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("marginalTax") //is this mine?
public class MarginalTaxAPI {
    @Autowired
    MarginalTaxCalculator service;
    @GetMapping("taxPaid")
    public Object get(@RequestParam(value = "code", defaultValue = "S")String code,
                      @RequestParam(value = "salary", defaultValue = "0")float salary){
        Date date = new Date();
        double total = service.calculate(code, salary);
        Map<String, Object> map = new HashMap<>();
        map.put("Date: ", date);
        map.put("Developer", "Amin, Mohammed");
        map.put("Tax Paid", total);
        return map;
    }

}
