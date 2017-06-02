/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.vendingmachine.view;

import com.mycompany.vendingmachine.dao.VendingMachinePersistenceException;
import com.mycompany.vendingmachine.dto.CoinReturn;
import com.mycompany.vendingmachine.dto.Inventory;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.ArrayList;

/**
 *
 * @author KylePackard
 */
public class View {

    int min = 1;
    int max = 1;
    private UserIO IO;

    public View(UserIO IO) {
        this.IO = IO;
    }

    public void prinTopMenu() {
        IO.print("=====================");
        IO.print("-- Vending Machine --");
    }

    public void printBottomLine() {
        IO.print("=====================");
    }

    public void printInventory(ArrayList<Inventory> inventory) {
        int i = 1;
        
        NumberFormat nf= NumberFormat.getInstance();
        nf.setMaximumFractionDigits(2);
        nf.setMinimumFractionDigits(2);
        nf.setRoundingMode(RoundingMode.HALF_UP);

        for (Inventory item : inventory) {
            if (item.getStockQuantity() > 0) {
                IO.print(i + ". " + item.getItemName() + " $" + nf.format(item.getPricePerUnit()));
                i++;
            } else {
                IO.print(i + ". OUT OF STOCK");
                i++;
            }

        }

        IO.print("---------------------");
        IO.print(i + ". Return Money");

        max = i;

    }

    public int getUserSelection() throws VendingMachinePersistenceException {
        //Subtract one to return the index of the item
        int selection = IO.readInt("What is your selection...", min, max + 1);
        if (selection != max) {
            return selection - 1;
        } else {
            return -1;
        }
    }

    public BigDecimal getInsertedMoney() {
        boolean again = false;
        String moneyStr;
        do {
            moneyStr = IO.readString("-- Please Insert Money --");

            // #$%#$^#$T Insert More Logic for proper input @$%$#%$@#
            if (moneyStr.length() <= 0 || moneyStr.length() > 4) {
                again = true;
            } else {
                again = false;
            }
        } while (again);
        BigDecimal money = new BigDecimal(moneyStr);
        return money;

    }

    public void printChange(CoinReturn coins) {
        IO.print("=====================");
        IO.print("- Change Dispensed  -");
        IO.print("Quarters = " + coins.getQuarters());
        IO.print("Dimes = " + coins.getDimes());
        IO.print("Nickels = " + coins.getNickels());
        IO.print("Pennies = " + coins.getPennies());

    }

    public void printInsufficientFunds() {
        IO.print("Error - Not Enough Money");
    }

    public void printCurrentMoney(BigDecimal money) {
        IO.print("Inserted Money = $" + money.toPlainString());
    }

    public void printSelectionOutOfStock() {
        IO.print("-- Selection is Out Of Stock --\n"
                + "----        Try Again       ---");
    }

    public void printEnjoyItem() {
        IO.print("=====================");
        IO.print("Enjoy your Snack!");
    }

    public void displayErrorMessage(String errorMsg) {
        IO.print("======= ERROR =======");
        IO.print(errorMsg);
    }
    public void printExit(){
        int option = max + 1;
        IO.print(option + ". Exit the program");
    }
    public int getMax(){
        return max;
    }
}
