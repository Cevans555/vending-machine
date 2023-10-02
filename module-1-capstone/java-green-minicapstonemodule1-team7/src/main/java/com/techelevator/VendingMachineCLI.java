package com.techelevator;

import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

/*
 * This class is provided to you as a *suggested* class to start
 * your project. Feel free to refactor this code as you see fit.
 */
public class VendingMachineCLI {

	private final Account account = new Account();
	private BigDecimal currentMoney = new BigDecimal(0);
	private DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy");
	private DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("h:mm:ss a");
	private LocalDate localDate = LocalDate.now();
	private LocalTime localTime = LocalTime.now();
	private String currentDate = localDate.format(dateFormat);
	private String currentTime = localTime.format(timeFormat);
	private NumberFormat currency = NumberFormat.getCurrencyInstance();
	private String inputPath = "main.csv";
	private File inputFile = new File(inputPath);
	private Inventory inventory = new Inventory(inputFile);
	private String destinationPath = "Log.txt";
	private File destinationFile = new File (destinationPath);
	private Displays displays = new Displays();



	public static void main(String[] args)
	{
		VendingMachineCLI cli = new VendingMachineCLI();
		cli.run();
	}

	public void fileCheck(File destinationFile){

		if (!destinationFile.exists())
		{
			try
			{
				destinationFile.createNewFile();
			} catch (IOException e)
			{
				throw new RuntimeException(e);
			}
		}
	}


	public void run()
	{
		int counter = 1;
		fileCheck(destinationFile);
		List<String[]> listOfItemArrays = inventory.getListOfItemArrays();
		Map<String, Integer> slotAndQty = inventory.getSlotAndQty();

		while (true)
		{
			try (FileWriter  fileWriter = new FileWriter(destinationFile, true);
				 PrintWriter writer = new PrintWriter(fileWriter))
			{
				// Display MAIN_MENU_OPTIONS
				displays.displayMainMenu();
				System.out.print("> ");
				// Set choice equal to userInput
				String choice = ScannerInput.userInput();
				System.out.println();


				if (choice.equals("1"))
				{
					// Display Items and Quantity
					displays.displayAllVendingMachineItems(listOfItemArrays, slotAndQty);
				}
				else if (choice.equals("2"))
				{

					while (true)
					{
						// Display PURCHASE_MENU_OPTIONS
						displays.displayPurchaseMenu(this.currentMoney);
						// Set choice equal to userInput
						System.out.print("> ");
						String purchaseMenuChoice = ScannerInput.userInput();
						System.out.println();

						if (purchaseMenuChoice.equals("1"))
						{
							System.out.println("Please enter money to insert (only whole dollars accepted): ");
							String moneyString = ScannerInput.userInput();
							System.out.println();
							BigDecimal addMoney = new BigDecimal(moneyString);
							//Checks if money entered is negative
							int comparisonResult = addMoney.compareTo(new BigDecimal(0));
							if( comparisonResult < 0){
								System.out.println("Invalid amount. Please try again.");
								System.out.println();
								continue;
							}
							this.currentMoney = currentMoney.add(addMoney.setScale(2, RoundingMode.HALF_UP));


							// Write in Log
							writer.println(currentDate + " " + currentTime + " Feed Money " + currency.format(addMoney) + " " + currency.format(this.currentMoney));
						}

						else if (purchaseMenuChoice.equals("2"))
						{
							//Displays items and their corresponding slot codes
							displays.displaySlotAndItem(listOfItemArrays);
							BigDecimal bogodo = account.bogodoCheck(counter);

							//Displays prompt
							displays.displaySlotChoicePrompt();
							System.out.print("> ");
							String slotChoice = ScannerInput.userInput().toUpperCase();
							System.out.println();

							boolean codeFound = false;
							boolean sufficientFunds = false;
							boolean soldOut = false;

							for (Map.Entry<String, Integer> item: slotAndQty.entrySet())
							{
								String code = item.getKey();

								if (slotChoice.equals(code) && item.getValue() > 0)
								{
									// Remove Money, Update Balance, Dispense Message, Decreases Stock
									for (String[] nameCost : listOfItemArrays)
									{
										codeFound = true;
										BigDecimal originalCost = new BigDecimal(nameCost[2]);
										BigDecimal finalCost = originalCost.subtract(bogodo);
										int comparisonResult = this.currentMoney.compareTo(finalCost);

										if(slotChoice.equals(nameCost[0]) && comparisonResult >= 0)
										{
											sufficientFunds = true;
											this.currentMoney = this.currentMoney.subtract(finalCost);

											//Displays dispensed item and its corresponding category message
											displays.displayDispensedItem(nameCost[1], finalCost, this.currentMoney);
											displays.displayCategoryMessage(nameCost[3]);

											//Decreases the amount of stock
											inventory.decreaseStock(slotChoice);

											// Write in Log
											writer.println(currentDate + " " + currentTime + " " + nameCost[1] + " " + nameCost[0] + " " + currency.format(finalCost) + " " + currency.format(this.currentMoney));

											counter++;
											break;
										}
									}
									System.out.println();
								}

								else if (slotChoice.equals(code) && item.getValue() == 0)
								{
									soldOut = true;
									displays.displaySoldOut();
								}

							}

							// Displays error if user enters incorrect slot number or insufficient funds
							if (!codeFound && !soldOut)
							{
								displays.displayInvalidSlotCode();
							}
							else if (codeFound && !sufficientFunds)
							{
								displays.displayInsufficientFunds();
							}
						}

						else if (purchaseMenuChoice.equals("3"))
						{
							// Call calculateChange method and printChange method
							Map<String, Integer> change = account.calculateChange(this.currentMoney);
							displays.displayChange(change);
							BigDecimal changeReturned = this.currentMoney;
							// Return currentMoney to 0
							this.currentMoney = new BigDecimal(0);
							// Write to Log
							writer.println(currentDate + " " + currentTime + " Change Given " + currency.format(changeReturned) + " " + currency.format(this.currentMoney));

							break;
						}

					}

				}

				else if (choice.equals("3"))
				{
					System.exit(1);
				}

				else if (choice.equals("4"))
				{

				}

			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}


	}

}
