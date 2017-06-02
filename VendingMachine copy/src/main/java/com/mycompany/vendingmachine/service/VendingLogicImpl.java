/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.vendingmachine.service;

import com.mycompany.vendingmachine.dao.VendingMachineDao;
import com.mycompany.vendingmachine.dao.VendingMachineDaoImpl;
import com.mycompany.vendingmachine.dao.VendingMachinePersistenceException;
import com.mycompany.vendingmachine.dto.CoinReturn;
import com.mycompany.vendingmachine.dto.Inventory;
import java.math.BigDecimal;
import java.util.ArrayList;

/**
 *
 * @author jenniferbliss
 */
public class VendingLogicImpl implements VendingLogic {

    VendingMachineDao dao;

    public VendingLogicImpl(VendingMachineDao dao) {
        this.dao = dao;
    }

    BigDecimal currentMoney = BigDecimal.valueOf(0.00);
    Inventory inventoryItem = new Inventory();
    CoinReturn coinReturn = new CoinReturn();
    BigDecimal price = BigDecimal.valueOf(0);
    int stockQuantity;
    int itemIndex = -1;
    @Override
    public BigDecimal getMoney() {
        return currentMoney;
    }

    public void setMoney(BigDecimal money) {
        this.currentMoney = money;
    }

    @Override
    public ArrayList getInventory() throws VendingMachinePersistenceException {
        return dao.getInventory();
    }

    @Override
    public void saveMoney(BigDecimal moneyInput) {
        this.currentMoney = currentMoney.add(moneyInput);
    }

    @Override
    public void getInventoryItem(int index) throws VendingMachinePersistenceException{
        
        itemIndex = index;
        inventoryItem = dao.getInventoryItem(index);       
        
    }

    @Override
    public boolean sufficentFunds() {
        price = inventoryItem.getPricePerUnit();

        int compare = currentMoney.compareTo(price);
        return compare != -1;

    }

    @Override
    public CoinReturn returnChange() {

        return getCoins();
    }

    @Override
    public void resetMoney() {
       currentMoney = BigDecimal.valueOf(0.00);
    }
    
    @Override
    public void resetPrice(){
        price = BigDecimal.valueOf(0.0);
    }

    private CoinReturn getCoins() {
        BigDecimal moneyForCoins;
        moneyForCoins = currentMoney.subtract(price);
        CoinReturn coins = new CoinReturn();
        while (moneyForCoins.compareTo(BigDecimal.valueOf(0)) > 0) {
            if (moneyForCoins.compareTo(BigDecimal.valueOf(.25)) != -1) {
                coins.addQuarter();
                moneyForCoins = moneyForCoins.subtract(BigDecimal.valueOf(.25));
            } else if (moneyForCoins.compareTo(BigDecimal.valueOf(.10)) != -1) {
                coins.addDime();
                moneyForCoins = moneyForCoins.subtract(BigDecimal.valueOf(.10));
            } else if (moneyForCoins.compareTo(BigDecimal.valueOf(.05)) != -1) {
                coins.addNickel();
                moneyForCoins = moneyForCoins.subtract(BigDecimal.valueOf(.05));
            } else {
                coins.addPennie();
                moneyForCoins = moneyForCoins.subtract(BigDecimal.valueOf(.01));
            }

        }

        return coins;
    }
    @Override
    public BigDecimal currentMoney(){
        return currentMoney;
    }
    
    @Override
    public boolean sufficientStock(){
        
         stockQuantity = inventoryItem.getStockQuantity();
         if (stockQuantity > 0){
             return true;
         }
         else {
             return false;
         }
        
    }
    @Override
    public void updateInventory() throws VendingMachinePersistenceException{
        dao.updateInventoryByOne(itemIndex);       
    }
    
    @Override
    public void getUserSelection(int answer) throws VendingMachinePersistenceException{
        if (answer != -1){
        getInventoryItem(answer);
        }
        else{
            itemIndex = -1;
        }
    }
         
    @Override
    public int getIndex(){
        return itemIndex;
    }
    
    
    //Methods for testing
    
    @Override
    public Inventory returnInventoryItem(){
        return inventoryItem;
    }
    
    @Override 
    public void setPrice(BigDecimal price){
        this.price = price;
    }
    
    @Override
    public BigDecimal getPrice(){
        return price;
    }
        
    }

    
   

