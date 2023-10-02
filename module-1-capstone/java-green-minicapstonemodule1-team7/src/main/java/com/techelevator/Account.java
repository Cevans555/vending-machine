package com.techelevator;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Account {

    // 7.

    public Account(){}

    // Calculate Change
    public Map<String, Integer> calculateChange(BigDecimal amountInDollars) {
        BigDecimal totalCents = amountInDollars.multiply(new BigDecimal("100"));

        int quarters = totalCents.divide(new BigDecimal("25"), 0, BigDecimal.ROUND_DOWN).intValue();
        totalCents = totalCents.remainder(new BigDecimal("25"));

        int dimes = totalCents.divide(new BigDecimal("10"), 0, BigDecimal.ROUND_DOWN).intValue();
        totalCents = totalCents.remainder(new BigDecimal("10"));

        int nickels = totalCents.divide(new BigDecimal("5"), 0, BigDecimal.ROUND_DOWN).intValue();
        totalCents = totalCents.remainder(new BigDecimal("5"));

        int pennies = totalCents.intValue();

        Map<String, Integer> change = new HashMap<>();
        change.put("quarters", quarters);
        change.put("dimes", dimes);
        change.put("nickels", nickels);
        change.put("pennies", pennies);

        return change;
    }


    public BigDecimal bogodoCheck(int counter){
        BigDecimal bogodo;
        if (counter % 2 == 0){
            bogodo = new BigDecimal(1);
        }
        else {
            bogodo = new BigDecimal(0);
        }
        return bogodo;
    }



}
