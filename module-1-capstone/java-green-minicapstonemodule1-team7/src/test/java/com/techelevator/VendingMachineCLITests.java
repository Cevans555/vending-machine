package com.techelevator;

import org.junit.Assert;
import org.junit.Test;
import java.io.File;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class VendingMachineCLITests {

    File altPath = new File ("alternate.csv");
    File mainPath = new File ("main.csv");

    @Test
    public void getListOfItemArrays_main_file_test_returns_expected_list() {

        // Arrange
        Inventory inventory = new Inventory(mainPath);

        // Act

        List<String[]> expectedList = new ArrayList<>();
        expectedList.add(new String[] {"A1","U-Chews","1.65","Gum"});
        expectedList.add(new String[] {"A2","Ginger Ayle","1.85","Drink"});
        expectedList.add(new String[] {"A3","Snykkers","4.25","Candy"});
        expectedList.add(new String[] {"A4","Chippos","3.85","Munchy"});
        expectedList.add(new String[] {"B1","Stackers","2.65","Munchy"});
        expectedList.add(new String[] {"B2","Papsi","3.45","Drink"});
        expectedList.add(new String[] {"B3","Mountain Melter","3.55","Drink"});
        expectedList.add(new String[] {"B4","Wonka Bar","2.35","Candy"});
        expectedList.add(new String[] {"C1","Caramel Bar","2.25","Candy"});
        expectedList.add(new String[] {"C2","7Down","3.25","Drink"});
        expectedList.add(new String[] {"C3","Moonpie","2.95","Candy"});
        expectedList.add(new String[] {"C4","Popcorn","1.75","Munchy"});
        expectedList.add(new String[] {"D1","Teaberry","1.65","Gum"});
        expectedList.add(new String[] {"D2","Preengles","2.35","Munchy"});
        expectedList.add(new String[] {"D3","Singlemint Gum","2.35","Gum"});
        expectedList.add(new String[] {"D4","Chiclets","1.35","Gum"});

        List<String[]> actualList = inventory.getListOfItemArrays();

        // Assert

        Assert.assertArrayEquals(expectedList.toArray(), actualList.toArray());


    }

    @Test
    public void getListOfItemArrays_alt_file_test_returns_expected_list() {

        // Arrange
        Inventory inventory = new Inventory(altPath);

        // Act

        List<String[]> expectedList = new ArrayList<>();
        expectedList.add(new String[] {"A1","U-Chews","1.65","Gum"});
        expectedList.add(new String[] {"B1","Ginger Ayle","1.85","Drink"});
        expectedList.add(new String[] {"C1","Snykkers","4.25","Candy"});
        expectedList.add(new String[] {"D1","Chippos","3.85","Munchy"});
        expectedList.add(new String[] {"A2","Stackers","2.65","Munchy"});
        expectedList.add(new String[] {"B2","Papsi","3.45","Drink"});
        expectedList.add(new String[] {"C2","Mountain Melter","3.55","Drink"});
        expectedList.add(new String[] {"D2","Wonka Bar","2.35","Candy"});
        expectedList.add(new String[] {"A3","Caramel Bar","2.25","Candy"});
        expectedList.add(new String[] {"B3","7Down","3.25","Drink"});
        expectedList.add(new String[] {"C3","Moonpie","2.95","Candy"});
        expectedList.add(new String[] {"D3","Popcorn","1.75","Munchy"});
        expectedList.add(new String[] {"A4","Teaberry","1.65","Gum"});
        expectedList.add(new String[] {"B4","Preengles","2.35","Munchy"});
        expectedList.add(new String[] {"C4","Singlemint Gum","2.35","Gum"});
        expectedList.add(new String[] {"D4","Chiclets","1.35","Gum"});

        // Assert

        Assert.assertArrayEquals(expectedList.toArray(), inventory.getListOfItemArrays().toArray());


    }


    @Test
    public void getSlotAndQty_main_file_test_returns_expected_map() {

        // Arrange
        Inventory inventory = new Inventory(mainPath);
        int originalStock = 5;

        // Act

        Map<String, Integer> expectedSlotAndQty = new HashMap<>();
        expectedSlotAndQty.put("A1", originalStock);
        expectedSlotAndQty.put("A2", originalStock);
        expectedSlotAndQty.put("A3", originalStock);
        expectedSlotAndQty.put("A4", originalStock);
        expectedSlotAndQty.put("B1", originalStock);
        expectedSlotAndQty.put("B2", originalStock);
        expectedSlotAndQty.put("B3", originalStock);
        expectedSlotAndQty.put("B4", originalStock);
        expectedSlotAndQty.put("C1", originalStock);
        expectedSlotAndQty.put("C2", originalStock);
        expectedSlotAndQty.put("C3", originalStock);
        expectedSlotAndQty.put("C4", originalStock);
        expectedSlotAndQty.put("D1", originalStock);
        expectedSlotAndQty.put("D2", originalStock);
        expectedSlotAndQty.put("D3", originalStock);
        expectedSlotAndQty.put("D4", originalStock);



        // Assert

        Assert.assertEquals(expectedSlotAndQty, inventory.getSlotAndQty());


    }


    @Test
    public void getSlotAndQty_alt_file_test_returns_expected_map() {

        // Arrange
        Inventory inventory = new Inventory(altPath);
        int originalStock = 5;

        // Act

        Map<String, Integer> expectedSlotAndQty = new HashMap<>();
        expectedSlotAndQty.put("A1", originalStock);
        expectedSlotAndQty.put("B1", originalStock);
        expectedSlotAndQty.put("C1", originalStock);
        expectedSlotAndQty.put("D1", originalStock);
        expectedSlotAndQty.put("A2", originalStock);
        expectedSlotAndQty.put("B2", originalStock);
        expectedSlotAndQty.put("C2", originalStock);
        expectedSlotAndQty.put("D2", originalStock);
        expectedSlotAndQty.put("A3", originalStock);
        expectedSlotAndQty.put("B3", originalStock);
        expectedSlotAndQty.put("C3", originalStock);
        expectedSlotAndQty.put("D3", originalStock);
        expectedSlotAndQty.put("A4", originalStock);
        expectedSlotAndQty.put("B4", originalStock);
        expectedSlotAndQty.put("C4", originalStock);
        expectedSlotAndQty.put("D4", originalStock);



        // Assert

        Assert.assertEquals(expectedSlotAndQty, inventory.getSlotAndQty());


    }

    @Test
    public void calculateChange_returns_change_of_amount_entered() {

        // Arrange + Act
        Account account = new Account();

        BigDecimal testAmount1 = new BigDecimal(1.50).setScale(2, RoundingMode.HALF_UP);
        BigDecimal testAmount2 = new BigDecimal(1.70).setScale(2, RoundingMode.HALF_UP);
        BigDecimal testAmount3 = new BigDecimal(1.65).setScale(2, RoundingMode.HALF_UP);
        BigDecimal testAmount4 = new BigDecimal(0.99).setScale(2, RoundingMode.HALF_UP);
        BigDecimal testAmount5 = new BigDecimal(0.00).setScale(2, RoundingMode.HALF_UP);


        Map<String, Integer> expectedChangeTest1 = new HashMap<>();
        expectedChangeTest1.put("quarters", 6);
        expectedChangeTest1.put("dimes", 0);
        expectedChangeTest1.put("nickels", 0);
        expectedChangeTest1.put("pennies", 0);

        Map<String, Integer> expectedChangeTest2 = new HashMap<>();
        expectedChangeTest2.put("quarters", 6);
        expectedChangeTest2.put("dimes", 2);
        expectedChangeTest2.put("nickels", 0);
        expectedChangeTest2.put("pennies", 0);

        Map<String, Integer> expectedChangeTest3 = new HashMap<>();
        expectedChangeTest3.put("quarters", 6);
        expectedChangeTest3.put("dimes", 1);
        expectedChangeTest3.put("nickels", 1);
        expectedChangeTest3.put("pennies", 0);

        Map<String, Integer> expectedChangeTest4 = new HashMap<>();
        expectedChangeTest4.put("quarters", 3);
        expectedChangeTest4.put("dimes", 2);
        expectedChangeTest4.put("nickels", 0);
        expectedChangeTest4.put("pennies", 4);

        Map<String, Integer> expectedChangeTest5 = new HashMap<>();
        expectedChangeTest5.put("quarters", 0);
        expectedChangeTest5.put("dimes", 0);
        expectedChangeTest5.put("nickels", 0);
        expectedChangeTest5.put("pennies", 0);


        //Assert
        Assert.assertEquals(expectedChangeTest1, account.calculateChange(testAmount1));
        Assert.assertEquals(expectedChangeTest2, account.calculateChange(testAmount2));
        Assert.assertEquals(expectedChangeTest3, account.calculateChange(testAmount3));
        Assert.assertEquals(expectedChangeTest4, account.calculateChange(testAmount4));
        Assert.assertEquals(expectedChangeTest5, account.calculateChange(testAmount5));


    }

    @Test
    public void bogodoCheck_returns_either_1_or_0_for_discount() {

        // Arrange + Act
        Account account = new Account();
        int testCounter1 = 1;
        int testCounter2 = 2;
        int testCounter3 = 5;
        int testCounter4 = 16;
        int testCounter5 = 0;

        BigDecimal testResult0 = new BigDecimal(0);
        BigDecimal testResult1 = new BigDecimal(1);

        Assert.assertEquals(testResult0, account.bogodoCheck(testCounter1));
        Assert.assertEquals(testResult1, account.bogodoCheck(testCounter2));
        Assert.assertEquals(testResult0, account.bogodoCheck(testCounter3));
        Assert.assertEquals(testResult1, account.bogodoCheck(testCounter4));
        Assert.assertEquals(testResult1, account.bogodoCheck(testCounter5));

    }



}
