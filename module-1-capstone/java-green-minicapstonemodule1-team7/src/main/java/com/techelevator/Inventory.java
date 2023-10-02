package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Inventory {

    private int originalStock = 5;
    private Map<String, Integer> slotAndQty = new HashMap<>();
    private List<String[]> listOfItemArrays = new ArrayList<>();

    public Inventory(File filePath)
    {
        setListOfItemArrays(filePath);
        setSlotAndQty();
    }

    // Decreases the amount of stock when called as long as stock is above 0
    public void decreaseStock(String choice)
    {
        this.slotAndQty.put(choice.toUpperCase(), this.slotAndQty.get(choice.toUpperCase()) - 1);
    }

    // Getters
    public Map<String, Integer> getSlotAndQty()
    {
        return slotAndQty;
    }



    public List<String[]> getListOfItemArrays()
    {
        return listOfItemArrays;
    }

    // Setters
    public void setSlotAndQty()
    {
        for (String[] item: listOfItemArrays)
        {
            slotAndQty.put(item[0], originalStock);
        }
    }



    // Move items from file into list of arrays
    public void setListOfItemArrays(File filePath)
    {
        try (Scanner fileScanner = new Scanner (filePath))
        {
            while (fileScanner.hasNextLine())
            {
                String lineText = fileScanner.nextLine();
                String[] splitLineText = lineText.split(",");
                listOfItemArrays.add(splitLineText);
            }
            System.out.println();
        }
        catch (FileNotFoundException e)
        {
            throw new RuntimeException(e);
        }
    }

}
