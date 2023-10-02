package com.techelevator;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class Displays {

    private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
    private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
    private static final String MAIN_MENU_OPTION_EXIT = "Exit";
    private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_EXIT };
    private static final String PURCHASE_MENU_OPTION_FEED_MONEY = "Feed Money";
    private static final String PURCHASE_MENU_OPTION_SELECT_PRODUCT = "Select Product";
    private static final String PURCHASE_MENU_OPTION_FINISH_TRANSACTION = "Finish Transaction";
    private static final String[] PURCHASE_MENU_OPTIONS = { PURCHASE_MENU_OPTION_FEED_MONEY, PURCHASE_MENU_OPTION_SELECT_PRODUCT, PURCHASE_MENU_OPTION_FINISH_TRANSACTION };

    // Display Item Name and Item Quantity
    public void displayAllVendingMachineItems(List<String[]> listOfItemArrays, Map<String, Integer> slotAndQty)
    {

        System.out.println("#####################################################");
        for (String[] item: listOfItemArrays)
        {
            System.out.println(item[1]  + ": " + slotAndQty.get(item[0]) + " Qty");
        }
        System.out.println();
    }
    // Display Slot and Item Name
    public void displaySlotAndItem(List<String[]> listOfItemArrays)
    {

        System.out.println("#####################################################");
        for (String[] item: listOfItemArrays)
        {
            System.out.println(item[0] + ": " + item[1]);
        }
        System.out.println();
    }

    public void displayMainMenu(){

        System.out.println("#####################################################");
        for (int i  = 0; i < MAIN_MENU_OPTIONS.length; i++)
        {

            int displayNumber = i + 1;
            System.out.println("(" + displayNumber + ") " + MAIN_MENU_OPTIONS[i]);

        }

    }

    public void displayPurchaseMenu(BigDecimal currentMoney){
        System.out.println("#####################################################");
        System.out.println("Current Money Provided: $" + currentMoney);
        System.out.println();
        for (int i  = 0; i < PURCHASE_MENU_OPTIONS.length; i++)
        {
            int displayNumber = i + 1;
            System.out.println("(" + displayNumber + ") " + PURCHASE_MENU_OPTIONS[i]);
        }
    }

    public void displaySlotChoicePrompt(){
        System.out.println("#####################################################");
        System.out.println("Please enter code: ");
    }

    public void displayDispensedItem(String item, BigDecimal finalCost, BigDecimal currentMoney){
        System.out.println("#####################################################");
        System.out.println("Item Dispensed below:");
        System.out.println(item + ": " + finalCost + " " + currentMoney);
        System.out.println();
    }

    public void displayCategoryMessage(String category){

        switch (category){
            case "Munchy":
                System.out.println("Crunch Crunch, Yum!");
                break;
            case "Candy":
                System.out.println("Yummy Yummy, So Sweet!");
                break;
            case "Drink":
                System.out.println("Glug Glug, Yum!");
                break;
            case "Gum":
                System.out.println("Chew Chew, Yum!");
                break;
        }

    }

    public void displaySoldOut(){
        System.out.println("#####################################################");
        System.out.println("SOLD OUT");
        System.out.println();
    }

    public void displayInvalidSlotCode(){
        System.out.println("#####################################################");
        System.out.println("Invalid Slot Code");
        System.out.println();
    }

    public void displayInsufficientFunds(){
        System.out.println("#####################################################");
        System.out.println("Insufficient Funds");
        System.out.println();
    }

    // Print Change to Finish Transaction
    public void displayChange(Map<String, Integer> change) {
        System.out.println("Change returned:");
        for (Map.Entry<String, Integer> entry : change.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        System.out.println();
    }

}
