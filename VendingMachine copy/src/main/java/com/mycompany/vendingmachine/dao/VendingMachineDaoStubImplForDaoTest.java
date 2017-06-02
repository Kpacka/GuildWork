/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.vendingmachine.dao;

import com.mycompany.vendingmachine.dto.Inventory;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author jenniferbliss
 */
public class VendingMachineDaoStubImplForDaoTest implements VendingMachineDao{

    public static final String INVENTORY_FILE = "inventoryForTest.txt";
    public static final String DELIMITER = "::";
    ArrayList<Inventory> currentInventory = new ArrayList();
    
    @Override
    public ArrayList getInventory() throws VendingMachinePersistenceException{
 
        loadInventoryFromFile();
  
        return currentInventory;

    }

    @Override
    public Inventory getInventoryItem(int index) throws VendingMachinePersistenceException {
        return currentInventory.get(index);
        
    }

    @Override
    public void updateInventoryByOne(int index) throws VendingMachinePersistenceException{
        currentInventory.get(index).reduceInventoryByOne();
        //taken out for stub impl
        //writeInventory();
    }
    
    @Override
    public void createInventory(Inventory item){
        currentInventory.add(item);
    }

    private void loadInventoryFromFile() throws VendingMachinePersistenceException {
        Scanner scanner;
        ArrayList<Inventory> listFromFile = new ArrayList();

        try {
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(INVENTORY_FILE)));
        } catch (FileNotFoundException e) {
            throw new VendingMachinePersistenceException(
                    "-_- Could not load roster data into memory.", e);
        }
        String currentLine;
        String[] currentTokens;
        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            currentTokens = currentLine.split(DELIMITER);
            Inventory currentInventoryFromFile = new Inventory();
            currentInventoryFromFile.setItemName(currentTokens[0]);
                    currentInventoryFromFile.setPricePerUnit(new BigDecimal(currentTokens[1]));
                        currentInventoryFromFile.setStockQuantity(Integer.parseInt(currentTokens[2]));
            listFromFile.add(currentInventoryFromFile);           
        }
        scanner.close();
        currentInventory = listFromFile;
    }
    private void writeInventory() throws VendingMachinePersistenceException {

        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(INVENTORY_FILE));
        } catch (IOException e) {
            throw new VendingMachinePersistenceException(
                    "Could not save student data.", e);
        }

        List<Inventory> inventoryList = this.currentInventory;
        for (Inventory Item : inventoryList) {

            out.println(Item.getItemName()+ DELIMITER
                    + Item.getPricePerUnit()+ DELIMITER
                    + Item.getStockQuantity());

            out.flush();
        }
        out.close();
    }   
}