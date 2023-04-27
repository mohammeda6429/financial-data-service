package edu.citytech.financial.service;

import org.springframework.stereotype.Service;

@Service
public class MarginalTaxCalculator {
    public static float calculate(Object string, float salary) {
        double total = 0;
        float[] brackets;
        if (string.equals("S")) {
            brackets = new float[]{0, 10275, 41775, 89075, 170050, 215950, 539900};
        } else if (string.equals("MFJ")) {
            brackets = new float[]{0, 20550, 83550, 178150, 340100, 431900, 647850};
        } else if (string.equals("HH")) {
            brackets = new float[]{0, 14650, 55900, 89050, 170000, 215950, 539900};
        } else {
            throw new IllegalArgumentException("Invalid tax code");
        }

        int b = 1;

        for (int i = 0; i < brackets.length; i++) {
            double tax = 0;

            if (b < 7 && salary > brackets[b]) {
                tax = (brackets[b] - brackets[i]) * getTaxRate(i);
                total += tax;
                b += 1;
            } else {
                total += (salary - brackets[i]) * getTaxRate(i);
                break;
            }
        }
        return (float) total;
    }

    private static float getTaxRate(int a) {
         {
            switch (a) {
                case 0:
                    return 0.1f;
                case 1:
                    return 0.12f;
                case 2:
                    return 0.22f;
                case 3:
                    return 0.24f;
                case 4:
                    return 0.32f;
                case 5:
                    return 0.35f;
                case 6:
                    return 0.37f;
                default:
                    return 0;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(calculate("S",150000));
    }

}
